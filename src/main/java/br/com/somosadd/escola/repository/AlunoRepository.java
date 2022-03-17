package br.com.somosadd.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.somosadd.escola.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
