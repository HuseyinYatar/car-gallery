package controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.DtoGallerist;
import dto.DtoGalleristIU;
import service.GalleristService;


@RestController
@RequestMapping("/rest")
public class GalleristController extends RestBaseController{

	private final GalleristService galleristService;

	public GalleristController(GalleristService galleristService) {
		super();
		this.galleristService = galleristService;
	}
	
	
	@PostMapping("/save-gallerist")
	public DtoGallerist saveGallerist(@RequestBody DtoGalleristIU dtoGalleristIU)
	{
		return galleristService.saveWithAddressGallerist(dtoGalleristIU);
	}
	
	
}
