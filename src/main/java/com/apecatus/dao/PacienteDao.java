package com.apecatus.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.apecatus.model.Paciente;

public class PacienteDao {
	private static List<Paciente> pacientes = new ArrayList<>();
	private static PacienteDao instance;
	
	public static synchronized PacienteDao getInstance() throws IOException {
		if (instance == null) {
			instance = new PacienteDao();
		}
		return instance;
	}
	
	public List<Paciente> findAll() {
		return Collections.unmodifiableList(pacientes);
	}
	
	public boolean add(Paciente paciente) {
		return pacientes.add(paciente);
	}
}
