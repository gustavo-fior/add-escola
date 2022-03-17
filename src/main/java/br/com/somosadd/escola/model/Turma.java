package br.com.somosadd.escola.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer capacidade;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Aluno> alunos;

	@ManyToOne
	private Escola escola;

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
