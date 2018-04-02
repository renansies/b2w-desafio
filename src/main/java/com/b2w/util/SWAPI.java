package com.b2w.util;

import java.util.Collections;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SWAPI {
	
	public static final String BASE_URL = "https://swapi.co/api/";
    public static final String USER_AGENT_NAME = "SWAPI-Java-Client/1.0";

	public static Integer getQuantidadeFilmes(String nome) {
		RestTemplate restTemplate = restTemplate();
		ParameterizedTypeReference<SWModelList<SWAPIPlanet>> responseTypeRef = new ParameterizedTypeReference<SWModelList<SWAPIPlanet>>() {
	    };
		HttpHeaders headers = new HttpHeaders();
	    headers.add("User-Agent", USER_AGENT_NAME);
	    HttpEntity<SWModelList<SWAPIPlanet>> httpEntity = new HttpEntity<SWModelList<SWAPIPlanet>>(headers);
	    
		ResponseEntity<SWModelList<SWAPIPlanet>> response = restTemplate.exchange(BASE_URL+"planets/?search="+nome, HttpMethod.GET, httpEntity, responseTypeRef);
	
		SWModelList<SWAPIPlanet> resources = response.getBody();
	    List<SWAPIPlanet> planets = resources.getResults();
	    
	    return planets.isEmpty() ? 0 : planets.get(0).getFilmsUrls().size();
	}
	
	private static RestTemplate restTemplate() {

	    ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    mapper.registerModule(new Jackson2HalModule());
	    
	    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	    converter.setSupportedMediaTypes(MediaType.parseMediaTypes(MediaType.APPLICATION_JSON_VALUE));
	    converter.setObjectMapper(mapper);

	    RestTemplate restTemplate = new RestTemplate(Collections.<HttpMessageConverter<?>> singletonList(converter));

	    return restTemplate;
	}
	
}
