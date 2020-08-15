package com.apecatus.model;

public class Paciente extends Pessoa{
	private int idade;
	private String endereco;

	public Paciente(int id, String nome, int idade, String endereco) {
		super(id, nome);
		this.idade = idade;
		this.endereco = endereco;
	}

	public Paciente() {}

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
		return super.toString() +", Idade: "+this.idade+", Endereço: "+this.endereco+"\r\n";
	}
}
