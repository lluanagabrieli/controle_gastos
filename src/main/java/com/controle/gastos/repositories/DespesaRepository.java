package com.controle.gastos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controle.gastos.entities.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{

}
