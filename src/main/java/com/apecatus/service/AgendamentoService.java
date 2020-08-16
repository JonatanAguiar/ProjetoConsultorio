package com.apecatus.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.apecatus.model.Agenda;
import com.apecatus.model.Paciente;
import com.apecatus.model.Profissional;
import com.apecatus.resource.AgendaResource;
import com.apecatus.resource.ListaAgendamento;
import com.apecatus.resource.ListaPaciente;
import com.apecatus.resource.ListaProfissional;

public class AgendamentoService{ //classe que executa o agendamento
	public static boolean runAgendamento() throws IOException {
		Scanner sc = new Scanner(System.in);
		AgendaResource agendaResource = new AgendaResource();
		ListaProfissional listaProfissional = new ListaProfissional();
		ListaPaciente listaPaciente = new ListaPaciente();
		ListaAgendamento listaAgendamento = new ListaAgendamento();
		
		List<Paciente> listPacientes = listaPaciente.buscarTodos(); 
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
			listPacientes.forEach(x -> {
				System.out.println("Dados do paciente "+x.getId()+": "+x.getNome()+", "+x.getIdade()+", "+x.getEndereco());
			});
			System.out.println("Informe o Id do paciente desejado: ");
			idPac = sc.nextInt();
			for (Paciente pacient : listPacientes) {
				if(pacient.getId() == idPac) {
					pac=true;
					paciente = pacient;
				}
			}
		}
		List<Profissional> listProfissionais = listaProfissional.buscarTodos();
		if (listProfissionais.isEmpty()) {
			System.out.println("Não existem profissionais cadastrados, cadastre um antes de fazer o agendamento!\r\n");
			return false;
		} else {
			System.out.println("Escolha um dos profissionáris pelo Id...");
			listProfissionais.forEach(x -> {
				System.out.println("Dados do profissional "+x.getId()+": "+x.getNome()+", "+x.getDepartamento()+", "+x.getEspecialidade());
			});
			System.out.println("Informe o Id do profissional desejado: ");
			idProf = sc.nextInt();
			for (Profissional profiss : listProfissionais) {
				if(profiss.getId() == idProf) {
					prof=true;
					profissional = profiss;
				}
			}			
		}
		if(pac == true && prof == true) { //se tiver paciente e profissional, pega dados de data e hora
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
			Agenda agenda = new Agenda(listaAgendamento.getUltId(), paciente, profissional, dataHora);
			agendaResource.adicionar(agenda);
			return true;
		}
		return false;
	}
}
