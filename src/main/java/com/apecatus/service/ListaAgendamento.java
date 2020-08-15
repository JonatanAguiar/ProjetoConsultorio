package com.apecatus.service;

import java.io.IOException;
import java.util.List;

import com.apecatus.dao.AgendaDao;
import com.apecatus.model.Agenda;

public class ListaAgendamento {
	
private AgendaDao agendaDao;
	
	public ListaAgendamento() throws IOException{
		agendaDao = AgendaDao.getInstance();
	}
	
	public List<Agenda> buscarTodos() {
		return agendaDao.findAll();
	}	
}
