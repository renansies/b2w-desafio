package com.b2w.service;

import java.util.List;

import com.b2w.model.Planeta;

public interface PlanetaService {

	public Planeta inserir(Planeta planeta);
	public Planeta buscarPorId(String id);
	public List<Planeta> buscar(String nome);
	public void editar(Planeta planeta);
	public void excluir(Planeta planeta);
}
