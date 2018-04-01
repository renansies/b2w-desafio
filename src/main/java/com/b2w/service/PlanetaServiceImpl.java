package com.b2w.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.b2w.model.Planeta;
import com.b2w.model.QPlaneta;
import com.b2w.repository.PlanetaRepository;
import com.querydsl.core.types.Predicate;

@Service
public class PlanetaServiceImpl implements PlanetaService {

	@Autowired
	private PlanetaRepository planetaRepository;
	
	@Override
	public Planeta inserir(Planeta planeta) {
		return planetaRepository.insert(planeta);
	}

	@Override
	public Planeta buscarPorId(String id) {
		return planetaRepository.findById(id).get();
	}

	@Override
	public List<Planeta> buscar(String nome) {

		Sort sort = Sort.by(Direction.ASC, "nome");
		
		QPlaneta qPlaneta = new QPlaneta("planeta");
		Predicate predicate = qPlaneta.isNull();
		if(nome != null)
			predicate = qPlaneta.nome.startsWithIgnoreCase(nome).or(qPlaneta.nome.endsWithIgnoreCase(nome));
		List<Planeta> planetas = (List<Planeta>) planetaRepository.findAll(predicate, sort);

		return planetas;
	}

	@Override
	public void editar(Planeta planeta) {
		planetaRepository.save(planeta);
		
	}

	@Override
	public void excluir(Planeta planeta) {
		planetaRepository.delete(planeta);
		
	}

}
