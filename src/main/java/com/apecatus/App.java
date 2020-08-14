package com.apecatus;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.apecatus.dao.AgendaDao;
import com.apecatus.dao.PacienteDao;
import com.apecatus.dao.ProfissionalDao;
import com.apecatus.model.Agenda;
import com.apecatus.model.Paciente;
import com.apecatus.model.Profissional;
import com.apecatus.service.AdicionarPaciente;
import com.apecatus.service.AdicionarProfissional;
import com.apecatus.service.ListaAgendamento;

public class App {
	private static int num = 0;
	private static int ficha = 0;
	private static AdicionarPaciente adicionarPaciente;
	private static AdicionarProfissional adicionarProfissional;
	private static Scanner sc = new Scanner(System.in);
	private static ListaAgendamento listaAgendamento;
	
	public static void main(String[] args) throws IOException {
		adicionarPaciente = new AdicionarPaciente();
		adicionarProfissional = new AdicionarProfissional();
		int opcao = 0;
		
		do {
			System.out.println("Faça sua escolha...");
			System.out.println("Opção 1 - Cadastra-se");
			System.out.println("Opção 2 - Atualizar cadastro");
			System.out.println("Opção 3 - Deletar cadastro");
			System.out.println("Opção 4 - Criar agendamento");
			System.out.println("Opção 5 - Atualizar agendamento");
			System.out.println("Opção 6 - Deletar agendamento");
			System.out.println("Opção 7 - Imprime todos agendamentos");
			System.out.println("Opção 0 - Sair do programa");
			System.out.println("_______________________");

			System.out.print("Digite aqui sua opção: ");
			opcao = menu(Integer.parseInt(sc.nextLine()));
		} while (opcao != 0);

		sc.close();
	}
	
	private static int menu(int opcao) throws IOException {
		PacienteDao pacienteDao = new PacienteDao();
		ProfissionalDao profissionalDao = new ProfissionalDao();
		AgendaDao agendaDao = new AgendaDao();
		Scanner scD = new Scanner(System.in);
		int op;
		switch (opcao) {
		case 1:
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
				Paciente paciente = new Paciente(num++, nome, idade, endereco);
				pacienteDao.add(paciente);
			}else {
				System.out.println("Digite o departamento em que trabalha:");
				String departamento = scD.nextLine();
				System.out.println("Digite a sua especialidade:");
				String especialidade = scD.nextLine();
				Profissional profissional = new Profissional(num++, nome, departamento, especialidade);
				profissionalDao.add(profissional);
			}
			
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			List<Paciente> listPacientes = pacienteDao.findAll();
			int idPac, idProf, ano, mes, dia;
			String hora;
			Paciente paciente=null;
			Profissional profissional=null;
			boolean pac=false, prof=false;
			if (listPacientes.isEmpty()) {
				System.out.println("Não existem pacientes cadastrados, cadastre um antes de fazer o agendamento!\r\n");
				break;
			} else {
				System.out.println("Escolha um dos pacientes pelo Id...");
				listPacientes.forEach(x -> System.out.println(x));
				System.out.println("Informe o Id do paciente desejado: ");
				idPac = scD.nextInt();
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
				break;
			} else {
				System.out.println("Escolha um dos profissionáris pelo Id...");
				listProfissionais.forEach(x -> System.out.println(x));
				System.out.println("Informe o Id do profissional desejado: ");
				idProf = scD.nextInt();
				for (Profissional profiss : listProfissionais) {
					if(profiss.getId() == idProf) {
						prof=true;
						profissional = profiss;
					}
				}			
			}
			if(pac == true && prof == true) {
				System.out.println("informe o dia da consulta (numericamente): ");
				dia = scD.nextInt();
				System.out.println("informe o mês da consulta (numericamente): ");
				mes = scD.nextInt();
				System.out.println("informe o ano da consulta (numericamente): ");
				ano = scD.nextInt();
				System.out.println("informe a hora da consulta (ex:'20:30'): ");
				scD.nextLine();
				hora = scD.nextLine();
				String hr[] = hora.split(":");
				System.out.println(hr[0]);
				System.out.println(hr[1]);
				LocalDateTime dataHora = LocalDateTime.of(2020, mes, dia, Integer.parseInt(hr[0]), Integer.parseInt(hr[1]), 0);
				Agenda agenda = new Agenda(ficha++, paciente, profissional, dataHora);
				agendaDao.add(agenda);
			}
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		case 7:
			List<Agenda> listAgendamento = agendaDao.findAll();
			if (listAgendamento.isEmpty()) {
				System.out.println("Não existem agendamentos marcados!\r\n");
				break;
			} else {
				System.out.println("Lista Completa de Agendamentos...");
				listAgendamento.forEach(x -> System.out.println(x));
			}
			break;
		default:
			break;
		}
		return opcao;
	}

}
