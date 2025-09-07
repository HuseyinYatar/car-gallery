package service;

import org.springframework.stereotype.Service;

import dto.DtoGallerist;
import dto.DtoGalleristIU;
import entity.Gallerist;
import mapper.GalleristMapping;
import repository.GalleristRepository;

@Service
public class GalleristService {

	private final GalleristRepository galleristRepository;

	private final GalleristMapping galleristMapping;

	
	
	public GalleristService(GalleristRepository galleristRepository, GalleristMapping galleristMapping)
	{
		super();
		this.galleristRepository = galleristRepository;
		this.galleristMapping = galleristMapping;
	}

	public DtoGallerist saveWithAddressGallerist(DtoGalleristIU dtoGalleristIU) {
		DtoGallerist dtoGallerist = galleristMapping.IUtoDto(dtoGalleristIU);
		Gallerist gallerist = galleristMapping.DtoIUToEntity(dtoGalleristIU);

		galleristRepository.save(gallerist);
		return dtoGallerist;
	}
}
