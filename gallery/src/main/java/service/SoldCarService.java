package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dto.DtoSoldCar;
import dto.DtoSoldCarRequest;
import dto.DtoSoldCarResponse;
import entity.Car;
import entity.CurrencyResponse;
import entity.Customer;
import entity.Gallerist;
import entity.SoldCar;
import enums.CarStatusType;
import enums.ErrorType;
import exception.BaseException;
import exception.ErrorMessage;
import jakarta.persistence.EntityManager;
import mapper.SoldCarMapping;
import repository.CarRepository;
import repository.CustomerRepository;
import repository.GalleristRepository;
import repository.SoldRepository;
import utils.DateUtils;

@Service
public class SoldCarService {


	private final CustomerRepository customerRepository;

	private final CarRepository carRepository;

	private final GalleristRepository galleristRepository;

	private final CurrencyService currencyService;

	private final SoldCarMapping carMapping;

	private final SoldRepository soldRepository;

	public SoldCarService(EntityManager entityManager, CustomerRepository customerRepository,
			CarRepository carRepository, GalleristRepository galleristRepository, CurrencyService currencyService,
			SoldCarMapping carMapping, SoldRepository repository) {
		super();
		this.customerRepository = customerRepository;
		this.carRepository = carRepository;
		this.galleristRepository = galleristRepository;
		this.currencyService = currencyService;
		this.carMapping = carMapping;
		this.soldRepository = repository;
	}

	public DtoSoldCarResponse sellCar(DtoSoldCarRequest request) {

		DtoSoldCar soldcar = checkEntities(request);
		Customer customer = soldcar.getCustomer();
		Car car = soldcar.getCar();
		BigDecimal customerAmountTL = customer.getAccount().getAmount();
		BigDecimal carPrice = car.getPrice();

		BigDecimal usdVal = getCurrency();

		BigDecimal customerAmountUSD = customerAmountTL.divide(usdVal, RoundingMode.HALF_EVEN);

		if (customerAmountUSD.compareTo(carPrice) < 0)
			throw new BaseException(new ErrorMessage(ErrorType.NOT_HAVE_ENOUGH_MONEY,
					soldcar.getCustomer().getAccount().getAmount().toString()));

		customer.getAccount().setAmount(customerAmountUSD.add(carPrice.negate()));

		car.setCarStatusType(CarStatusType.SOLD);

		carRepository.save(car);
		customerRepository.save(customer);

		DtoSoldCarResponse dtoToResponse = carMapping.dtoToResponse(soldcar);
		SoldCar entity = carMapping.dtoToEntity(soldcar);
				
		soldRepository.save(entity);
		return dtoToResponse;
	}

	private BigDecimal getCurrency() {
		String currentDate = DateUtils.currentDate();
		CurrencyResponse currencyResponse = currencyService.getCurrency(currentDate, currentDate, "json");
		return new BigDecimal(currencyResponse.getItems().get(0).getCurrency());

	}

	private DtoSoldCar checkEntities(DtoSoldCarRequest request) {
		Optional<Gallerist> galleristOptional = galleristRepository.findById(request.getGalleristId());
		Optional<Customer> customerOptional = customerRepository.findById(request.getCustomerId());
		Optional<Car> carOptional = carRepository.findById(request.getCarId());

		if (galleristOptional.isEmpty())
			throw new BaseException(new ErrorMessage(ErrorType.NO_RECORD_EXISTS));

		if (customerOptional.isEmpty())
			throw new BaseException(new ErrorMessage(ErrorType.NO_RECORD_EXISTS));

		if (carOptional.isEmpty())
			throw new BaseException(new ErrorMessage(ErrorType.NO_RECORD_EXISTS));

		DtoSoldCar saledCar = new DtoSoldCar();

		saledCar.setCar(carOptional.get());

		saledCar.setCustomer(customerOptional.get());

		saledCar.setGallerist(galleristOptional.get());
		return saledCar;
	}
}
