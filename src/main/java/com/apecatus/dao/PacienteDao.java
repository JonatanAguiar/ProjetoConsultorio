package com.apecatus.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.apecatus.converter.PacienteConverter;
import com.apecatus.model.Paciente;
import com.apecatus.uteis.EscreverLinhaArquivo;
import com.apecatus.uteis.InterfaceUltimoId;
import com.apecatus.uteis.LerArquivo;
import com.apecatus.uteis.LerLinhaArquivo;

public class PacienteDao  implements LerLinhaArquivo, InterfaceUltimoId{
	private static List<Paciente> pacientes = new ArrayList<>();
	private static PacienteDao instance;
	private String fileName = "pacientes.txt";
	private LerArquivo lerArquivo = new LerArquivo(this);
	private EscreverLinhaArquivo escreverLinhaArquivo = new EscreverLinhaArquivo();

	public PacienteDao() throws IOException {
		this.lerArquivo.readFile(fileName);
	}
	
	public static synchronized PacienteDao getInstance() throws IOException {
		if (instance == null) {
			instance = new PacienteDao();
		}
		return instance;
	}
	
	public List<Paciente> findAll() {
		return Collections.unmodifiableList(pacientes);
	}
	
	public boolean add(Paciente object) throws IOException {
		escreverLinhaDoArquivo(fileName, PacienteConverter.converterPacienteParaLinhaDoArquivo(object));
		return pacientes.add(object);
	}
	
	public void lerLinhaDoArquivo(String linha) {
		pacientes.add(PacienteConverter.converterLinhaDoArquivoParaPaciente(linha));
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
		return pacientes.size();
	}
	
	public void set(Paciente object, Paciente update) {
		int index=0;
		for (Paciente pac : pacientes) {
  			if (object == pac) {
      			pacientes.set(index, update);
       		}
  			index++;
       	}
	}
	
	public void remove(int id) {
		pacientes.remove(id);
	}
}
