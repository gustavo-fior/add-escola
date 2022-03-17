package br.com.somosadd.escola.controller.dto;

import br.com.somosadd.escola.model.Aluno;

public class AlunoDTO {

	private Integer id;
	private String nome;
	private String dataDeNascimento;
	private String turma;

	public AlunoDTO(Aluno aluno) {
		this.id = aluno.getId();
		this.nome = aluno.getNome();
		this.dataDeNascimento = aluno.getDataDeNascimento().toString();
		this.turma = aluno.getTurma().getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

}
