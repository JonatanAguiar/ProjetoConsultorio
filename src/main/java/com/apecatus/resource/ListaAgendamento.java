package com.apecatus.resource;

import java.io.IOException;
import java.util.List;

import com.apecatus.dao.AgendaDao;
import com.apecatus.model.Agenda;

public class ListaAgendamento { //classe que se comunica com dao para pegar a lista
	
	private AgendaDao agendaDao;
	
	public ListaAgendamento() throws IOException{
		agendaDao = AgendaDao.getInstance();
	}
	
	public List<Agenda> buscarTodos() {
		List<Agenda> agends = agendaDao.findAll();
		return agends;
	}
	
	public int getUltId() {
		return agendaDao.getUltId();
	}
}
