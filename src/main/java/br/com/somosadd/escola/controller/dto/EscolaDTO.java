package br.com.somosadd.escola.controller.dto;

import br.com.somosadd.escola.model.Escola;

public class EscolaDTO {

	private String nome;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;

	public EscolaDTO(Escola escola) {
		this.nome = escola.getNome();
		this.logradouro = escola.getEndereco().getLogradouro();
		this.complemento = escola.getEndereco().getComplemento();
		this.bairro = escola.getEndereco().getBairro();
		this.cidade = escola.getEndereco().getCidade();
		this.estado = escola.getEndereco().getEstado();
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
