package com.apecatus.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.apecatus.converter.AgendaConverter;
import com.apecatus.model.Agenda;
import com.apecatus.service.EscreverLinhaArquivo;
import com.apecatus.service.LerArquivo;
import com.apecatus.service.LerLinhaArquivo;

public class AgendaDao  implements LerLinhaArquivo {
	private static List<Agenda> agendamentos = new ArrayList<>();
	private static AgendaDao instance;
	private String fileName = "agendamentos.txt";
	private LerArquivo lerArquivo = new LerArquivo(this);
	private EscreverLinhaArquivo escreverLinhaArquivo = new EscreverLinhaArquivo();

	public AgendaDao() throws IOException {
		this.lerArquivo.readFile(fileName);
	}
	
	public static synchronized AgendaDao getInstance() throws IOException {
		if (instance == null) {
			instance = new AgendaDao();
		}
		return instance;
	}
	
	public List<Agenda> findAll() {
		return Collections.unmodifiableList(agendamentos);
	}
	
	public boolean add(Agenda agenda) throws IOException {
		escreverLinhaDoArquivo(fileName, AgendaConverter.converterAgendaParaLinhaDoArquivo(agenda));
		return agendamentos.add(agenda);
	}
	
	public void lerLinhaDoArquivo(String linha) {
		if(agendamentos.isEmpty())
			agendamentos.add(AgendaConverter.converterLinhaDoArquivoParaAgenda(linha));
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
