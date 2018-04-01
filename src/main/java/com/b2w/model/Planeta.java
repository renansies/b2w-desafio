package com.b2w.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.ResourceSupport;

import com.querydsl.core.annotations.QueryEntity;

@QueryEntity
@Document
public class Planeta extends ResourceSupport{

	@Id
	private String id;
	private String nome;
	private String clima;
	private String terreno;
	
	@Transient
	private Integer aparicoesEmFilmes;
	
	public Planeta(String nome, String clima, String terreno) {
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
	}
	
	public Planeta() {
		
	}

	public String getItemId() {
		return id;
	}

	public void setItemId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Integer getAparicoesEmFilmes() {
		return aparicoesEmFilmes;
	}

	public void setAparicoesEmFilmes(Integer aparicoesEmFilmes) {
		this.aparicoesEmFilmes = aparicoesEmFilmes;
	}
}
