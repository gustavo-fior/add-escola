package br.com.somosadd.escola.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private LocalDate dataDeNascimento;

	@ManyToOne
	private Turma turma;
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	public Turma getTurma() {
		return turma;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
