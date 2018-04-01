package com.b2w.util;

import org.springframework.web.client.RestTemplate;

public class SWAPI {

	public static Integer getQuantidadeFilmes(String nome) {
	RestTemplate restTemplate = new RestTemplate();
    SWAPIPlanet planet = restTemplate.getForObject("http://swapi.co/api/planets/?name="+nome, SWAPIPlanet.class);
    return planet.getFilmes().size();
	}
}
