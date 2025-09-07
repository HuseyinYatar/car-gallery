package entity;

import java.util.List;


import lombok.Data;

@Data
public class CurrencyResponse {

private 	Integer totalCount;
	
private List<CurrencyItems> items;
	
	
}
