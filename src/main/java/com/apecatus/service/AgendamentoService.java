package com.apecatus.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.apecatus.dao.PacienteDao;
import com.apecatus.dao.ProfissionalDao;
import com.apecatus.model.Agenda;
import com.apecatus.model.Paciente;
import com.apecatus.model.Profissional;

public class AgendamentoService {
	private static int ficha = 0;
	public static boolean runAgendamento() throws IOException {
		Scanner sc = new Scanner(System.in);
		PacienteDao pacienteDao = new PacienteDao();
		ProfissionalDao profissionalDao = new ProfissionalDao();
		AdicionarAgenda adicionarAgenda = new AdicionarAgenda();
		List<Paciente> listPacientes = pacienteDao.findAll(); 
		int idPac, idProf, ano, mes, dia;
		String hora;
		Paciente paciente=null;
		Profissional profissional=null;
		boolean pac=false, prof=false;
		if (listPacientes.isEmpty()) {
			System.out.println("Não existem pacientes cadastrados, cadastre um antes de fazer o agendamento!\r\n");
			return false;
		} else {
			System.out.println("Escolha um dos pacientes pelo Id...");
			listPacientes.forEach(x -> System.out.println(x));
			System.out.println("Informe o Id do paciente desejado: ");
			idPac = sc.nextInt();
			for (Paciente pacient : listPacientes) {
				if(pacient.getId() == idPac) {
					pac=true;
					paciente = pacient;
				}
			}
		}
		List<Profissional> listProfissionais = profissionalDao.findAll();
		if (listProfissionais.isEmpty()) {
			System.out.println("Não existem profissionais cadastrados, cadastre um antes de fazer o agendamento!\r\n");
			return false;
		} else {
			System.out.println("Escolha um dos profissionáris pelo Id...");
			listProfissionais.forEach(x -> System.out.println(x));
			System.out.println("Informe o Id do profissional desejado: ");
			idProf = sc.nextInt();
			for (Profissional profiss : listProfissionais) {
				if(profiss.getId() == idProf) {
					prof=true;
					profissional = profiss;
				}
			}			
		}
		if(pac == true && prof == true) {
			System.out.println("informe o dia da consulta (numericamente): ");
			dia = sc.nextInt();
			System.out.println("informe o mês da consulta (numericamente): ");
			mes = sc.nextInt();
			System.out.println("informe o ano da consulta (numericamente): ");
			ano = sc.nextInt();
			System.out.println("informe a hora da consulta (ex:'20:30'): ");
			sc.nextLine();
			hora = sc.nextLine();
			String hr[] = hora.split(":");
			LocalDateTime dataHora = LocalDateTime.of(2020, mes, dia, Integer.parseInt(hr[0]), Integer.parseInt(hr[1]), 0);
			Agenda agenda = new Agenda(ficha++, paciente, profissional, dataHora);
			adicionarAgenda.adicionarAgenda(agenda);
			return true;
		}
		return false;
	}
}
