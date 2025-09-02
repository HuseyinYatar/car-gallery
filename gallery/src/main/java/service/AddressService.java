package service;

import org.springframework.stereotype.Service;

import dto.DtoAddress;
import dto.DtoAddressIU;
import entity.Address;
import mapper.AddressMapping;
import repository.AddressRepository;

@Service
public class AddressService {

	private final AddressRepository addressRepository;

	private final AddressMapping addressMapping;

	public AddressService(AddressRepository addressRepository, AddressMapping addressMapping) {
		super();
		this.addressRepository = addressRepository;
		this.addressMapping = addressMapping;
	}

	public DtoAddress saveAddress(DtoAddressIU dtoAddressIU) {
		Address adress = addressMapping.AddressIUtoAdress(dtoAddressIU);

		addressRepository.save(adress);

		DtoAddress dtoAddress = addressMapping.AddressIUtoDtoAdress(dtoAddressIU);

		return dtoAddress;
	}

}
