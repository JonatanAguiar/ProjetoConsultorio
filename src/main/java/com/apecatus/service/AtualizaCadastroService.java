package com.apecatus.service;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.apecatus.model.Paciente;
import com.apecatus.model.Profissional;
import com.apecatus.resource.ListaPaciente;
import com.apecatus.resource.ListaProfissional;
import com.apecatus.resource.PacienteResource;
import com.apecatus.resource.ProfissionalResource;

public class AtualizaCadastroService { //classe que atualiza dados de cadastro do paciente e profissional
	public static boolean runAtualiza() throws IOException {
		Scanner scD = new Scanner(System.in);
		ListaPaciente listaPaciente = new ListaPaciente();
		ListaProfissional listaProf = new ListaProfissional();
		System.out.println("Deseja alterar o cadastro de um paciente ou profissional?");
		System.out.println("1-Paciente, 2-Profissional");
		int op = scD.nextInt();		
		boolean existe=false;
		if(op == 1){
			PacienteResource pacienteResource = new PacienteResource();
			System.out.println("Digite a id do paciente:");
			int id = scD.nextInt();
			List<Paciente> listPac = listaPaciente.buscarTodos();
			Paciente pac=null;
			for (Paciente paciente : listPac) {
				if(paciente.getId() == id) {
					existe = true;
					pac = paciente;
				}
			}
			if(existe==true) {
				System.out.println("Deseja alterar...\n1-Nome\n2-Idade\n3-Endereço");
				int opDesejada = scD.nextInt();
				Paciente p = null;
				switch (opDesejada) {
				case 1:
					System.out.println("Digite o novo nome: ");
					String nome = scD.nextLine();
					p = new Paciente(pac.getId(), nome, pac.getIdade(), pac.getEndereco());
					break;
				case 2:
					System.out.println("Digite a idade: ");
					int idade = scD.nextInt();
					p = new Paciente(pac.getId(), pac.getNome(), idade, pac.getEndereco());
					break;
				case 3:
					System.out.println("Digite o novo Endereço: ");
					String endereco = scD.nextLine();
					p = new Paciente(pac.getId(), pac.getNome(), pac.getIdade(), endereco);
					break;
				default:
					System.err.println("Não existe essa opção!");
					break;
				}
				if(p == null) {
					System.out.println("Falha na atualização!");
				}
				else {
					pacienteResource.set(pac,p);
				}
			}
		}else if(op==2) {
			ProfissionalResource profissionalResource = new ProfissionalResource(); 
			System.out.println("Digite a id do profissional:");
			int id = scD.nextInt();
			List<Profissional> listProf = listaProf.buscarTodos();
			Profissional profi=null;
			for (Profissional profissional : listProf) {
				if(profi.getId() == id) {
					existe = true;
					profi = profissional;
				}
			}
			if(existe==true) {
				System.out.println("Deseja alterar...\n1-Nome\n2-Departamento\n3-Especialidade");
				int opDesejada = scD.nextInt();
				Profissional p = null;
		        switch (op) {
		            case 1:
		                System.out.println("Digite o novo nome: ");
		                String nome = scD.nextLine();
		                p = new Profissional(profi.getId(), nome, profi.getDepartamento(), profi.getEspecialidade());
		                break;
		            case 2:
		            	System.out.println("Digite o novo departamento: ");
		            	String dep = scD.nextLine();
		                p = new Profissional(profi.getId(), profi.getNome(), dep, profi.getEspecialidade());
		                break;
		            case 3:
		            	System.out.println("Digite a nova Especialidade: ");
		            	String espec = scD.nextLine();
		                p = new Profissional(profi.getId(), profi.getNome(), profi.getDepartamento(), espec);
		                break;
		            default:
		                System.err.println("Não existe essa opção!");
		                break;
		        }
		        if(p == null) {
					System.out.println("Falha na atualização!");
				}
				else {
					profissionalResource.setProfissional(profi, p);
				}
				return true;
			}
		}
		return false;
	}
}
