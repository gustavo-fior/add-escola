package br.com.somosadd.escola.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Escola {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;

	@Embedded
	private Endereco endereco;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Turma> turmas;

	public Integer getId() {
		return id;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public String getNome() {
		return nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
