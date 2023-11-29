package com.controle.gastos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controle.gastos.entities.Categoria;
import com.controle.gastos.repositories.CategoriaRepository;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repositoryCategoria;

	@GetMapping
	public List<Categoria> listar() {
		List<Categoria> result = repositoryCategoria.findAll();
		return result;
	}

	@PostMapping()
	public Categoria salvar(@RequestBody Categoria categoria){
		return repositoryCategoria.save(categoria);
	}

	@CrossOrigin
	@GetMapping(value = "/{id}")
	public Categoria pegarPorId(@PathVariable (value = "id")Long id){
		return repositoryCategoria.findById(id).orElse(null);
	}

	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable(value = "id")Long id){
		repositoryCategoria.deleteById(id);
	}

	@PutMapping(value = "{id}")
	public void atualizar(@RequestBody Categoria categoria, @PathVariable("id") Long id){
		categoria.setId(id);
		repositoryCategoria.save(categoria);
	}
}
