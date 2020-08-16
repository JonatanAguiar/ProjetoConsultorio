package com.apecatus.model;

public class Paciente{
	private int id;
	private String nome;
	private int idade;
	private String endereco;

	public Paciente(int id, String nome, int idade, String endereco) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
	}

	public Paciente() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public String getEndereco() {
		return endereco;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return this.id+","+this.nome+","+this.idade+","+this.endereco+",";
	}
}
