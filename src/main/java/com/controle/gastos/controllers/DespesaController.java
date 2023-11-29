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

import com.controle.gastos.entities.Despesa;
import com.controle.gastos.repositories.DespesaRepository;

@RestController
@RequestMapping(value = "/despesas")
public class DespesaController {
	
	@Autowired
	private DespesaRepository repository;

	@GetMapping
	public List<Despesa> findAll() {
		List<Despesa> result = repository.findAll();
		return result;
	}

	@PostMapping()
	public Despesa salvar(@RequestBody Despesa despesa){
		return repository.save(despesa);
	}

	@CrossOrigin
	@GetMapping(value = "/{id}")
	public Despesa findById(@PathVariable (value = "id")Long id){
		return repository.findById(id).orElse(null);
	}

	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable(value = "id")Long id){
		repository.deleteById(id);
	}

	@PutMapping(value = "{id}")
	public void atualizar(@RequestBody Despesa despesa, @PathVariable("id") Long id){
		despesa.setId(id);
		repository.save(despesa);
	}
}
