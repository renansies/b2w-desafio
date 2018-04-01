package com.b2w.util;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SWAPIPlanet {

	private String name;
	private List<String> filmes;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getFilmes() {
		return filmes;
	}
	public void setFilmes(List<String> filmes) {
		this.filmes = filmes;
	}
}
