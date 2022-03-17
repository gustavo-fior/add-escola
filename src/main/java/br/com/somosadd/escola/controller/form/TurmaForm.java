package br.com.somosadd.escola.controller.form;

import java.util.ArrayList;

import br.com.somosadd.escola.model.Escola;
import br.com.somosadd.escola.model.Turma;
import br.com.somosadd.escola.repository.EscolaRepository;

public class TurmaForm {

	private String nome;
	private Integer capacidade;
	private Integer idEscola;

	public Turma converteParaTurma(EscolaRepository escolaRepository) {

		Escola escola = escolaRepository.findById(idEscola).get();

		Turma turma = new Turma();
		turma.setAlunos(new ArrayList<>());
		turma.setEscola(escola);
		turma.setNome(this.nome);
		turma.setCapacidade(this.capacidade);

		return turma;
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

	public Integer getIdEscola() {
		return idEscola;
	}

	public void setIdEscola(Integer idEscola) {
		this.idEscola = idEscola;
	}
	
	

}
