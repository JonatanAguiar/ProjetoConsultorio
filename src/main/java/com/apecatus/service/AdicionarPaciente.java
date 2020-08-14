package com.apecatus.service;

import java.io.IOException;

import com.apecatus.dao.PacienteDao;
import com.apecatus.model.Paciente;

public class AdicionarPaciente {
private PacienteDao pacienteDao;
	
	public AdicionarPaciente() throws IOException {
		pacienteDao = PacienteDao.getInstance();
	}

	public void adicionarPaciente(Paciente paciente) throws IOException {
		pacienteDao.add(paciente);
	}
}
