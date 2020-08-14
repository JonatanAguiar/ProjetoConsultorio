package com.apecatus.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.apecatus.model.Profissional;

public class ProfissionalDao {
	private static List<Profissional> profissionais = new ArrayList<>();
	private static ProfissionalDao instance;
	
	public static synchronized ProfissionalDao getInstance() throws IOException {
		if (instance == null) {
			instance = new ProfissionalDao();
		}
		return instance;
	}
	
	public List<Profissional> findAll() {
		return Collections.unmodifiableList(profissionais);
	}

	public boolean add(Profissional profissional) {
		return profissionais.add(profissional);
	}
}
