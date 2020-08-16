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
import com.apecatus.uteis.EscreverLinhaArquivo;
import com.apecatus.uteis.InterfaceUltimoId;
import com.apecatus.uteis.LerArquivo;
import com.apecatus.uteis.LerLinhaArquivo;

public class ProfissionalDao  implements LerLinhaArquivo, InterfaceUltimoId{
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
		return Collections.unmodifiableList(profissionais); // para nao deixar modificar diretamente
	}
	
	public boolean add(Profissional object) throws IOException {
		escreverLinhaDoArquivo(fileName, ProfissionalConverter.converterProfissionalParaLinhaDoArquivo(object));
		return profissionais.add(object);
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
	
	@Override
	public int getUltId() {
		return profissionais.size();
	}
	
	public void set(Profissional object, Profissional update) {
		int index = 0;	
		for (Profissional prof : profissionais) {
       		if (object == prof) {
       			profissionais.set(index, update);
       		}
       		index++;
		}	
	}
	
	public void remove(int id) {
		profissionais.remove(id);
	}
}
