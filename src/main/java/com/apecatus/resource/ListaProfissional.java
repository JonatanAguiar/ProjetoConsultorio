package com.apecatus.resource;

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
		List<Profissional> profs = profissionalDao.findAll();
		return profs;
	}	
	
	public int getUltId() {
		return profissionalDao.getUltId();
	}
}
