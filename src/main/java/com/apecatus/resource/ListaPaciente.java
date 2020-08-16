package com.apecatus.resource;

import java.io.IOException;
import java.util.List;

import com.apecatus.dao.PacienteDao;
import com.apecatus.model.Paciente;

public class ListaPaciente {

	private PacienteDao pacienteDao;
	
	public ListaPaciente() throws IOException {
		pacienteDao = PacienteDao.getInstance();
	}
	
	public List<Paciente> buscarTodos() {
		List<Paciente> pacs = pacienteDao.findAll();
		return pacs;
	}
	
	public int getUltId() {
		return pacienteDao.getUltId();
	}
}
