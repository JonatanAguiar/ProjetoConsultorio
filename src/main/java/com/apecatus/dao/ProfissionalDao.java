package com.apecatus.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.apecatus.converter.ProfissionalConverter;
import com.apecatus.model.Profissional;
import com.apecatus.service.EscreverLinhaArquivo;
import com.apecatus.service.LerArquivo;
import com.apecatus.service.LerLinhaArquivo;

public class ProfissionalDao  implements LerLinhaArquivo {
	private static List<Profissional> profissionais = new ArrayList<>();
	private static ProfissionalDao instance;
	private String fileName = "profissionais.txt";
	private LerArquivo lerArquivo = new LerArquivo(this);
	private EscreverLinhaArquivo escreverLinhaArquivo = new EscreverLinhaArquivo();

	public ProfissionalDao() throws IOException {
		this.lerArquivo.readFile(fileName);
	}
	
	public static synchronized ProfissionalDao getInstance() throws IOException {
		if (instance == null) {
			instance = new ProfissionalDao();
		}
		return instance;
	}
	
	public List<Profissional> findAll() {
		return Collections.unmodifiableList(profissionais);
	}
	
	public boolean add(Profissional profissional) throws IOException {
		escreverLinhaDoArquivo(fileName, ProfissionalConverter.converterProfissionalParaLinhaDoArquivo(profissional));
		return profissionais.add(profissional);
	}
	
	public void lerLinhaDoArquivo(String linha) {
		profissionais.add(ProfissionalConverter.converterLinhaDoArquivoParaProfissional(linha));
	}
	
	public void escreverLinhaDoArquivo(String fileName, String linhaStr) throws IOException {
		boolean existeArquivo = new File(fileName).exists();
		FileWriter fileWriter = new FileWriter(fileName, true);
		PrintWriter printWriter = new PrintWriter(fileWriter, true);
		if (existeArquivo) {
			printWriter.println(linhaStr);
		} else {
			printWriter.print(linhaStr);
		}
		printWriter.close();
		fileWriter.close();
	}
}
