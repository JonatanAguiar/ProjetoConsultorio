package com.apecatus;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.apecatus.dao.AgendaDao;
import com.apecatus.model.Agenda;
import com.apecatus.service.AgendamentoService;
import com.apecatus.service.CadastroService;

public class App{
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		
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
		switch (opcao) {
		case 1:
			if(CadastroService.runCadastro() == true) 
				System.out.println("Cadastro Concluido!");
			else 
				System.out.println("Falha no Cadastro!");
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			if(AgendamentoService.runAgendamento() == true) 
				System.out.println("Agendamento Concluido!");
			else 
				System.out.println("Falha no agendamento!");
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		case 7:
			AgendaDao agendaDao = new AgendaDao();
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
