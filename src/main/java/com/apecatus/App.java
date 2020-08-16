package com.apecatus;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.apecatus.model.Agenda;
import com.apecatus.model.Paciente;
import com.apecatus.model.Profissional;
import com.apecatus.resource.AgendaResource;
import com.apecatus.resource.ListaAgendamento;
import com.apecatus.resource.ListaPaciente;
import com.apecatus.resource.ListaProfissional;
import com.apecatus.resource.PacienteResource;
import com.apecatus.resource.ProfissionalResource;
import com.apecatus.service.AgendamentoService;
import com.apecatus.service.AtualizaCadastroService;
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
			opcao = menu(Integer.parseInt(sc.nextLine())); //envia opção desejada
		} while (opcao != 0);

		sc.close();
	}
	
	private static int menu(int opcao) throws IOException {
		ListaAgendamento listaAgendamento = new ListaAgendamento(); //carregamento das listas
		List<Agenda> listAgendamento = listaAgendamento.buscarTodos();
		ListaPaciente listaPaciente = new ListaPaciente();
		List<Paciente> listPac = listaPaciente.buscarTodos();
		ListaProfissional listaProfissional = new ListaProfissional();
		List<Profissional> listProf = listaProfissional.buscarTodos();
		Scanner sc = new Scanner(System.in);
		switch (opcao) {
		case 1:
			if(CadastroService.runCadastro() == true) //chama classe que faz cadasto e ja verifica
				System.out.println("Cadastro Concluido!");
			else 
				System.out.println("Falha no Cadastro!");
			break;
		case 2:
			if(AtualizaCadastroService.runAtualiza() == true)
				System.out.println("Atualização Concluida");
			else 
				System.out.println("Falha na atualização!");
			break;
		case 3: //remover paciente ou profissional
			int idPac;
			PacienteResource pacienteResource = new PacienteResource();
			ProfissionalResource profissionalResource = new ProfissionalResource();
			System.out.println("Deseja remover um paciente ou profissional?");
			System.out.println("1-Paciente\n2-Profissional"); 
			int op = sc.nextInt();
			if(op == 1) {
				System.out.println("Digite o id do paciente:");
				idPac = sc.nextInt();
				listPac.forEach(x -> {
					if(x.getId()==idPac) { //se achar, executa!
						pacienteResource.remove(idPac);  						
						System.out.println("Deleção concluida!");
					}
				});
			}else if(op == 2){
				System.out.println("Digite o id do profissional:");
				idPac = sc.nextInt();
				listProf.forEach(x -> {
					if(x.getId()==idPac) {
						profissionalResource.remove(idPac);
						System.out.println("Deleção concluida!");
					}
				});
			}
			break;
		case 4:
			if(AgendamentoService.runAgendamento() == true) 
				System.out.println("Agendamento Concluido!");
			else 
				System.out.println("Falha no agendamento!");
			break;
		case 5: //atualiza o agendamento
			AgendaResource agendaResource = new AgendaResource();
			Agenda agenda=null;
			System.out.println("Informe o id da ficha do agendamento:");
			int id = sc.nextInt();
			for (Agenda agendaa : listAgendamento) {
				if(agendaa.getId() == id) {
					agenda = agendaa;
				}
			}
			if(agenda == null) {
				System.out.println("Id não encontrado!");
			}else {
				System.out.println("Deseja alterar...\n1-Paciente\n2-Profissional\n3-Data e hora");
				int opDesejada = sc.nextInt();
				Paciente paciente = null;
		        Profissional profissional = null;
		        Agenda a = null;
		        switch (opDesejada) {
		            case 1:
		            	System.out.println("Digite o id do novo paciente: ");
		                int idPc = sc.nextInt();
		                for (Paciente pac : listPac) {
		                	if(pac.getId()==idPc) {
		                		paciente = pac;
		                	}
		                }
		                if(paciente!=null) {
		                	a = new Agenda(agenda.getId(), paciente, agenda.getProfissional(), agenda.getDataHora());
		                }else {
		                	System.out.println("Houve uma falha!");
		                }
		               	break;
		            case 2:
		            	System.out.println("Digite o id do novo profissional: ");
		            	int idPr = sc.nextInt();
		            	for (Profissional prof : listProf) {
		                	if(prof.getId()==idPr) {
		                		profissional = prof;
		                	}
		                }
		                if(profissional!=null) {
		            		a = new Agenda(agenda.getId(), agenda.getPaciente(), profissional, agenda.getDataHora());
		        		}else {
		        			System.out.println("Houve uma falha!");
		        		}
		                break;
		            case 3:
		            	int dia,mes,ano;
		            	String hora;
		            	System.out.println("Digite a nova data e hora:... ");
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
		    			a = new Agenda(agenda.getId(), agenda.getPaciente(), agenda.getProfissional(),dataHora);
		                break;
		            default:
		                System.err.println("Não existe essa opção!");
		                break;
		        }
				agendaResource.set(agenda, a);				
			}
			break;
		case 6:
			AgendaResource agendaResource1 = new AgendaResource();
			System.out.println("Digite o id do agendamento para remove-lo:");
			int idAg = sc.nextInt();
			listAgendamento.forEach(x -> {
				if(x.getId()==idAg) {
					agendaResource1.remove(idAg);
					System.out.println("Deleção concluida!");
				}
			});
			break;
		case 7:
			if (listAgendamento.isEmpty()) {
				System.out.println("Não existem agendamentos marcados!\r\n");
				break;
			} else {
				System.out.println("Lista Completa de Agendamentos...");
				listAgendamento.forEach(x -> { //listagem personalizada de agendamentos
					System.out.println("Ficha "+x.getId()+"-> paciente: id "+x.getPaciente().getId()+" - "+x.getPaciente().getNome()+", profissional: id "+x.getProfissional().getId()+" - "+x.getProfissional().getNome()+", Data e Hora: "+x.getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
				});
				System.out.println("Pressione enter para continuar...");
				sc.nextLine();
			}
			break;
		default:
			break;
		}
		return opcao;
	}
}
