package br.com.somosadd.escola.controller.form;

import java.time.LocalDate;

import br.com.somosadd.escola.model.Aluno;
import br.com.somosadd.escola.model.Turma;
import br.com.somosadd.escola.repository.TurmaRepository;

public class AlunoForm {

	private String nome;
	private String dataDeNascimento;
	private Integer idTurma;

	public String getNome() {
		return nome;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public Integer getIdTurma() {
		return idTurma;
	}

	public Aluno converteParaAluno(TurmaRepository turmaRepository) {
		
		Turma turma = turmaRepository.findById(idTurma).get();

		Aluno aluno = new Aluno();
		aluno.setNome(this.nome);
		aluno.setTurma(turma);
		aluno.setDataDeNascimento(LocalDate.parse(this.dataDeNascimento));

		return aluno;

	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}

}
