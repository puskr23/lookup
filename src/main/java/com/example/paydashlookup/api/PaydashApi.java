package com.example.paydashlookup.api;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Component
public class PaydashApi {
	final String url = "http://api1.pareva.umelimited.com:8080/rest/UtilityServices/msisdn-lookup/paydash";
	final String username = "raj";
	final String password = "raj";
	private static final String AUTHORIZATION_TOKEN = "cmFqOnJhag==";

	public String getOperator(String msisdn) {
		Map<String, String> parameters = new HashMap();
		parameters.put("username", "red");
		parameters.put("password", "KHND-jr56-KJH");
		parameters.put("msisdn", msisdn);
		RestTemplate rest = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Basic " + AUTHORIZATION_TOKEN);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		HttpEntity<?> entity = new HttpEntity(parameters, headers);
		ResponseEntity<PaydashResponse> response = rest.exchange(builder.toUriString(), HttpMethod.POST, entity,
				PaydashResponse.class);
		PaydashResponse a = response.getBody();
		return a.getOperator();

	}

}
