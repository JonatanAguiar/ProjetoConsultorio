package com.apecatus.service;

import java.io.IOException;

import com.apecatus.dao.ProfissionalDao;
import com.apecatus.model.Profissional;

public class AdicionarProfissional {

	private ProfissionalDao profissionalDao;
	
	public AdicionarProfissional() throws IOException {
		profissionalDao = ProfissionalDao.getInstance();
	}

	public void adicionarProfissional(Profissional profissional) throws IOException {
		profissionalDao.add(profissional);
	}
}
