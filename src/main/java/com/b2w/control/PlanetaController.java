package com.b2w.control;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.b2w.model.Planeta;
import com.b2w.service.PlanetaService;

@RestController
@RequestMapping("planetas")
public class PlanetaController {

	@Autowired
	private PlanetaService planetaService;
	
	@GetMapping
	@ResponseBody
	public List<Planeta> buscar(@RequestParam(required=false) String nome) {
		Iterable<Planeta> list = planetaService.buscar(nome);
		List<Planeta> planetas = new ArrayList<Planeta>();
		
		for (Planeta planeta : list) {
			planeta.add(linkTo(methodOn(PlanetaController.class).buscarPorId(planeta.getItemId())).withSelfRel());
			planetas.add(planeta);
		}
		return planetas;
	}
	
	@GetMapping("{id}")
	@ResponseBody
	public Planeta buscarPorId(@PathVariable String id) {
		Planeta planeta = planetaService.buscarPorId(id);
		planeta.add(linkTo(methodOn(PlanetaController.class).buscar("")).withRel("Todos os Planetas"));

		return planeta;
	}
	
	@PostMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public Planeta inserir(@RequestBody Planeta planeta) {
		Planeta planetaCriado = planetaService.inserir(planeta);
		planetaCriado.add(linkTo(methodOn(PlanetaController.class).buscar("")).withRel("Todos os Planetas"));
		
		return planetaCriado;
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void editar(@PathVariable String id, @RequestBody Planeta planeta) {
		Planeta planetaExists = planetaService.buscarPorId(id);
		if(planetaExists != null)
			planeta.setItemId(id);
		planetaService.editar(planeta);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable String id, @RequestBody Planeta planeta) {
		Planeta planetaExists = planetaService.buscarPorId(id);
		if(planetaExists != null)
			planeta.setItemId(id);
		planetaService.excluir(planeta);
	}
}
