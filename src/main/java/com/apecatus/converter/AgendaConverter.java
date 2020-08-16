package com.apecatus.converter;

import java.time.LocalDateTime;

import com.apecatus.model.Agenda;
import com.apecatus.model.Paciente;
import com.apecatus.model.Profissional;

public class AgendaConverter { //converte dodados salvos no txt (String)
	
	private static final String DELIMITADOR = ";";
	
	public static Agenda converterLinhaDoArquivoParaAgenda(String linha) {
		if (linha == null || linha.length() == 0) {
			return null;
		}
		String[] props = linha.split(DELIMITADOR);
		
		Paciente pac = new Paciente();
		String[] pacBreak = props[1].split(",");
		pac.setId(Integer.parseInt(pacBreak[0]));
		pac.setNome(pacBreak[1]);
		pac.setIdade(Integer.parseInt(pacBreak[2]));
		pac.setEndereco(pacBreak[3]);

		Profissional prof = new Profissional();
		String[] profBreak = props[2].split(",");
		prof.setId(Integer.parseInt(profBreak[0]));
		prof.setNome(profBreak[1]);
		prof.setDepartamento(profBreak[2]);
		prof.setEspecialidade(profBreak[3]);
		
		
		String[] dataHoraBreak = props[3].split("T");
		String[] dataBreak = dataHoraBreak[0].split("-");
		String[] horaBreak = dataHoraBreak[1].split(":");
		LocalDateTime dataHora = LocalDateTime.of(Integer.parseInt(dataBreak[0]), Integer.parseInt(dataBreak[1]), Integer.parseInt(dataBreak[2]), Integer.parseInt(horaBreak[0]), Integer.parseInt(horaBreak[1]));
		
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
