package com.apecatus.resource;

import java.io.IOException;

import com.apecatus.dao.ProfissionalDao;
import com.apecatus.model.Profissional;

public class ProfissionalResource {

	private ProfissionalDao profissionalDao;
	
	public ProfissionalResource() throws IOException {
		profissionalDao = ProfissionalDao.getInstance();
	}

	public void adicionar(Profissional object) throws IOException {
		profissionalDao.add(object);
	}
	
	public void setProfissional(Profissional object, Profissional update) {
		profissionalDao.set(object, update);
	}
	
	public void remove(int id) {
		profissionalDao.remove(id);
	}
}
