package br.com.somosadd.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.somosadd.escola.model.Escola;

public interface EscolaRepository extends JpaRepository<Escola, Integer>{

}
