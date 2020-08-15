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
import com.apecatus.service.EscreverLinhaArquivo;
import com.apecatus.service.LerArquivo;
import com.apecatus.service.LerLinhaArquivo;

public class PacienteDao  implements LerLinhaArquivo {
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
	
	public boolean add(Paciente paciente) throws IOException {
		escreverLinhaDoArquivo(fileName, PacienteConverter.converterPacienteParaLinhaDoArquivo(paciente));
		return pacientes.add(paciente);
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
}
