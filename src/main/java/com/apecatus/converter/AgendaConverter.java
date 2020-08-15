package com.apecatus.converter;

import java.time.LocalDateTime;

import com.apecatus.model.Agenda;
import com.apecatus.model.Paciente;
import com.apecatus.model.Profissional;

public class AgendaConverter {
	
	private static final String DELIMITADOR = ";";
	
	public static Agenda converterLinhaDoArquivoParaAgenda(String linha) {
		if (linha == null || linha.length() == 0) {
			return null;
		}
		String[] props = linha.split(DELIMITADOR);
		
		Paciente pac = new Paciente();
		String[] pacBreack = props[1].split(",");
		pac.setId(Integer.parseInt(pacBreack[0]));
		pac.setNome(pacBreack[1]);
		pac.setIdade(Integer.parseInt(pacBreack[2]));
		pac.setEndereco(pacBreack[3]);

		Profissional prof = new Profissional();
		String[] profBreack = props[2].split(",");
		prof.setId(Integer.parseInt(profBreack[0]));
		prof.setNome(profBreack[1]);
		prof.setDepartamento(profBreack[2]);
		prof.setEspecialidade(profBreack[3]);
		
		LocalDateTime dataHora = LocalDateTime.now();
		
		Agenda agenda = new Agenda();
		agenda.setId(Integer.parseInt(props[0]));
		agenda.setPaciente(pac);
		agenda.setProfissional(prof);
		agenda.setDataHora(dataHora);
		return agenda;
		
	}
	
	public static String converterAgendaParaLinhaDoArquivo(Agenda agenda) {
		StringBuffer lineStrAgenda = new StringBuffer();
		lineStrAgenda.append(agenda.getId());
		lineStrAgenda.append(DELIMITADOR);
		lineStrAgenda.append(agenda.getPaciente());
		lineStrAgenda.append(DELIMITADOR);
		lineStrAgenda.append(agenda.getProfissional());
		lineStrAgenda.append(DELIMITADOR);
		lineStrAgenda.append(agenda.getDataHora());

		return lineStrAgenda.toString();
	}
	
}
