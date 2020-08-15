package com.apecatus.service;

import java.io.IOException;
import java.util.List;

import com.apecatus.dao.ProfissionalDao;
import com.apecatus.model.Profissional;

public class ListaProfissional {
	
private ProfissionalDao profissionalDao;
	
	public ListaProfissional() throws IOException{
		profissionalDao = ProfissionalDao.getInstance();
	}
	
	public List<Profissional> buscarTodos() {
		return profissionalDao.findAll();
	}	
}
