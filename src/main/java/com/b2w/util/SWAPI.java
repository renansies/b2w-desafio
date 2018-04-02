package com.b2w.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class SWAPI {

	public static Integer getQuantidadeFilmes(String nome) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpHeaders headers = new HttpHeaders();
	    headers.add("User-Agent", "swapi-Java-SWAPI-JAVA");
	    HttpEntity<List<SWAPIPlanet>> httpEntity = new HttpEntity<List<SWAPIPlanet>>(headers);
		ResponseEntity<SWAPIPlanet[]> response = restTemplate.exchange("https://swapi.co/api/planets/", HttpMethod.GET, httpEntity, SWAPIPlanet[].class, new HashMap<String, String>());
		//SWAPIPlanet planet = response.getBody();
		List<SWAPIPlanet> planets = new ArrayList<SWAPIPlanet>();
		for (SWAPIPlanet swapiPlanet : response.getBody()) {
			planets.add(swapiPlanet);
		}
		System.out.println(planets.get(0).getName());
	    return null;
	}
}
