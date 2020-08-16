package com.apecatus.service;

import java.io.IOException;
import java.util.Scanner;

import com.apecatus.model.Paciente;
import com.apecatus.model.Profissional;
import com.apecatus.resource.ListaPaciente;
import com.apecatus.resource.ListaProfissional;
import com.apecatus.resource.PacienteResource;
import com.apecatus.resource.ProfissionalResource;

public class CadastroService {
	public static boolean runCadastro() throws IOException { //classe que executa o cadastro
		PacienteResource pacienteResource = new PacienteResource();
		ProfissionalResource profissionalResource = new ProfissionalResource();
		ListaPaciente listaPaciente = new ListaPaciente();
		ListaProfissional listaProfissional = new ListaProfissional();
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
			Paciente paciente = new Paciente(listaPaciente.getUltId(), nome, idade, endereco);
			pacienteResource.adicionar(paciente);
			return true;
		}else if(op == 2){
			System.out.println("Digite o departamento em que trabalha:");
			String departamento = scD.nextLine();
			System.out.println("Digite a sua especialidade:");
			String especialidade = scD.nextLine();
			Profissional profissional = new Profissional(listaProfissional.getUltId(),nome, departamento, especialidade);
			profissionalResource.adicionar(profissional);
			return true;
		}
		return false;//se a opção não existir, retorna falso
	}
}
