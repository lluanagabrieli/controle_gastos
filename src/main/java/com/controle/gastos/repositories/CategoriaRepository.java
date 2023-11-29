package com.controle.gastos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controle.gastos.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
