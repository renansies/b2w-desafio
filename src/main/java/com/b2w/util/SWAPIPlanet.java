package com.b2w.util;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SWAPIPlanet {

	public String name;

    @JsonProperty("films")
    public List<String> filmsUrls;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getFilmsUrls() {
		return filmsUrls;
	}

	public void setFilmsUrls(List<String> filmsUrls) {
		this.filmsUrls = filmsUrls;
	}
    
}
