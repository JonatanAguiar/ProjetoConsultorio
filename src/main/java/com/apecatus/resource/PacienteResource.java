package com.apecatus.resource;

import java.io.IOException;

import com.apecatus.dao.PacienteDao;
import com.apecatus.model.Paciente;

public class PacienteResource{
		
	private PacienteDao agendaDao;
	
	public PacienteResource() throws IOException {
		agendaDao = PacienteDao.getInstance();
	}

	public void adicionar(Paciente object) throws IOException {
		agendaDao.add(object);
	}
	
	public void set(Paciente object, Paciente update) throws IOException {
		agendaDao.set(object, update);
	}
	
	public void remove(int id) {
		agendaDao.remove(id);
	}
}
