package com.apecatus.resource;

import java.io.IOException;

import com.apecatus.dao.AgendaDao;
import com.apecatus.model.Agenda;

public class AgendaResource {

	private AgendaDao agendaDao;
	
	public AgendaResource() throws IOException {
		agendaDao = AgendaDao.getInstance();
	}

	public void adicionar(Agenda object) throws IOException {
		agendaDao.add(object);
	}
	
	public void set(Agenda object, Agenda update) throws IOException {
		agendaDao.set(object, update);
	}
	
	public void remove(int id) {
		agendaDao.remove(id);
	}
}
