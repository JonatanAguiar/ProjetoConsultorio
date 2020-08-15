package com.apecatus.model;

public class Profissional extends Pessoa{
	private String departamento;
	private String especialidade;

	public Profissional(int id, String nome, String departamento, String especialidade) {
		super(id, nome);
		this.departamento = departamento;
		this.especialidade = especialidade;
	}

	public Profissional() {}

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
		return super.toString() +", Departamento: "+this.departamento+", Especialidade: "+this.especialidade+"\r\n";
	}
}
