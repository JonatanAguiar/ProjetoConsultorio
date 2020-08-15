package com.apecatus.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Agenda {
	private int id;
	private Paciente paciente;
	private Profissional profissional;
	private LocalDateTime dataHora;
	
	public Agenda(int id, Paciente paciente, Profissional profissional, LocalDateTime dataHora) {
		this.id = id;
		this.paciente = paciente;
		this.profissional = profissional;
		this.dataHora = dataHora;
	}
	public Agenda() {}
	
	public int getId() {
		return id;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public Profissional getProfissional() {
		return profissional;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	@Override
	public String toString() {
		return "Ficha: "+this.id+", Paciente: "+this.paciente+", Profissional: "+this.profissional+", Data e Hora: "+this.dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm"))+"\r\n";
	}
}
