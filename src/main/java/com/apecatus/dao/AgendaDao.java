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
import com.apecatus.uteis.EscreverLinhaArquivo;
import com.apecatus.uteis.InterfaceUltimoId;
import com.apecatus.uteis.LerArquivo;
import com.apecatus.uteis.LerLinhaArquivo;

public class AgendaDao implements LerLinhaArquivo, InterfaceUltimoId{
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
	
	public boolean add(Agenda object) throws IOException {
		escreverLinhaDoArquivo(fileName, AgendaConverter.converterAgendaParaLinhaDoArquivo(object));
		return agendamentos.add(object);
	}
	
	public void lerLinhaDoArquivo(String linha) {
		String[] props = linha.split(";"); 
		for (Agenda agenda : agendamentos) {
			if(Integer.parseInt(props[0]) == agenda.getId()) { //para evitar re-gravar os agendamentos na memoria
				return;
			}
		}
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
	
	@Override
	public int getUltId() {
		return agendamentos.size();
	}
	
	public void set(Agenda object, Agenda update) {
		int index=0;
		for (Agenda agen : agendamentos) {
  			if (object == agen) {
      			agendamentos.set(index, update);
       		}
  			index++;
       	}
	}
	
	public void remove(int id) {
		agendamentos.remove(id);
	}


}
