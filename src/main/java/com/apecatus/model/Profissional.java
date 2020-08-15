package com.apecatus.model;

import com.apecatus.service.InterfaceUltimoId;

public class Profissional{
	private int id;
	private String nome;
	private String departamento;
	private String especialidade;

	public Profissional(int id, String nome, String departamento, String especialidade) {
		this.id = id;
		this.nome = nome;
		this.departamento = departamento;
		this.especialidade = especialidade;
	}

	public Profissional() {}

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

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getEspecialidade() {
		return especialidade;
	}
	
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	@Override
	public String toString() {
		return this.id+","+this.nome+","+this.departamento+","+this.especialidade+",";
	}
}
