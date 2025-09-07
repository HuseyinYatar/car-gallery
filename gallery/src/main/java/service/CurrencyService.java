package service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import entity.CurrencyResponse;
import enums.ErrorType;
import exception.BaseException;
import exception.ErrorMessage;

@Service
public class CurrencyService {

	@Value("${API-KEY}")
	private  String API_KEY;

	public String getEndPoint(String endDate, String startDate, String type) {
		String baseURL = "https://evds2.tcmb.gov.tr/service/evds/series=TP.DK.USD.A.YTL&";
		baseURL += "startDate="+startDate;
		baseURL += "&endDate=" + endDate;
		baseURL = baseURL+"&" + "type=" + type;
		return baseURL;
	}
//https://evds2.tcmb.gov.tr/service/evds/series=TP.DK.USD.A-TP.DK.EUR.A-TP.DK.CHF.A-TP.DK.GBP.A-TP.DK.JPY.A&startDate=01-10-2017&endDate=01-11-2017&type=xml
//https://evds2.tcmb.gov.tr/service/evds/series=TP.DK.USD.A.YTL&startDate=05-09-2025endDate=05-09-2025&tpyejson
	public CurrencyResponse getCurrency(String endDate, String startDate, String type) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("key", API_KEY);

		HttpEntity<?> entity = new HttpEntity<>(httpHeaders);

		RestTemplate restTemplate = new RestTemplate();
		
		
		try {
			String url=getEndPoint(endDate, startDate, type);
			ResponseEntity<CurrencyResponse> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity,
					new ParameterizedTypeReference<CurrencyResponse>() {
					});
			if(responseEntity.getStatusCode().is2xxSuccessful())
			return responseEntity.getBody();
			
		} catch (Exception e) {
			throw new BaseException(new ErrorMessage(ErrorType.ERROR_OCCURED_IN_API_REQUEST,e.getMessage()));
		}
		return null;

	}
}
