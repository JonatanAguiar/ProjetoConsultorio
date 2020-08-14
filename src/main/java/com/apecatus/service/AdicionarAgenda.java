package com.apecatus.service;

import java.io.IOException;

import com.apecatus.dao.AgendaDao;
import com.apecatus.model.Agenda;

public class AdicionarAgenda {

	private AgendaDao agendaDao;
	
	public AdicionarAgenda() throws IOException {
		agendaDao = AgendaDao.getInstance();
	}

	public void adicionarAgenda(Agenda profissional) throws IOException {
		agendaDao.add(profissional);
	}
}
