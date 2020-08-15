package com.apecatus.service;

import java.io.IOException;
import java.util.Scanner;

import com.apecatus.dao.PacienteDao;
import com.apecatus.dao.ProfissionalDao;
import com.apecatus.model.Paciente;
import com.apecatus.model.Profissional;

public class CadastroService {
	public static boolean runCadastro() throws IOException {
		AdicionarPaciente adicionarPaciente = new AdicionarPaciente();
		AdicionarProfissional adicionarProfissional = new AdicionarProfissional();
		AdicionarAgenda adicionarAgenda = new AdicionarAgenda();
		
		PacienteDao pacienteDao = new PacienteDao();
		ProfissionalDao profissionalDao = new ProfissionalDao();
		int op;
		Scanner scD = new Scanner(System.in);
		System.out.println("Digite:\r\n1-Paciente\r\n2-Profissional");
		op = scD.nextInt();
		scD.nextLine();
		System.out.println("Digite seu nome:");
		String nome = scD.nextLine();
		if(op == 1) {
			System.out.println("Digite a idade do Paciente:");
			int idade = scD.nextInt();
			System.out.println("Digite o endereço do Paciente:");
			scD.nextLine();
			String endereco = scD.nextLine();
			Paciente paciente = new Paciente(pacienteDao.getUltId(), nome, idade, endereco);
			adicionarPaciente.adicionarPaciente(paciente);
			return true;
		}else if(op == 2){
			System.out.println("Digite o departamento em que trabalha:");
			String departamento = scD.nextLine();
			System.out.println("Digite a sua especialidade:");
			String especialidade = scD.nextLine();
			Profissional profissional = new Profissional(profissionalDao.getUltId(),nome, departamento, especialidade);
			adicionarProfissional.adicionarProfissional(profissional);
			return true;
		}
		return false;
	}
}
