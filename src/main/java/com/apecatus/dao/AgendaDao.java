package com.apecatus.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.apecatus.model.Agenda;

public class AgendaDao {
	private static List<Agenda> agendamentos = new ArrayList<>();
	private static AgendaDao instance;
	
	public static synchronized AgendaDao getInstance() throws IOException {
		if (instance == null) {
			instance = new AgendaDao();
		}
		return instance;
	}
	
	public List<Agenda> findAll() {
		return Collections.unmodifiableList(agendamentos);
	}
	
	public boolean add(Agenda agenda) {
		return agendamentos.add(agenda);
	}
}
