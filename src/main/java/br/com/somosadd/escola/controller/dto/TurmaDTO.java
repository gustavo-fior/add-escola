package br.com.somosadd.escola.controller.dto;

import br.com.somosadd.escola.model.Turma;

public class TurmaDTO {

	private Integer id;
	private String nome;
	private Integer capacidade;

	public TurmaDTO(Turma turma) {
		this.id = turma.getId();
		this.nome = turma.getNome();
		this.capacidade = turma.getCapacidade();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
