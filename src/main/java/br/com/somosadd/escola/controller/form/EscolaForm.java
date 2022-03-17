package br.com.somosadd.escola.controller.form;

import java.util.ArrayList;

import br.com.somosadd.escola.model.Endereco;
import br.com.somosadd.escola.model.Escola;

public class EscolaForm {

	private String nome;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;

	public Escola converteParaEscola() {

		Escola escola = new Escola();
		escola.setNome(this.nome);
		escola.setTurmas(new ArrayList<>());
		escola.setEndereco(new Endereco(this.logradouro, this.complemento, this.bairro, this.cidade, this.estado));

		return escola;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
