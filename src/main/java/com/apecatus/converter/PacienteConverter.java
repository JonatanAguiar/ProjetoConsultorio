package com.apecatus.converter;

import com.apecatus.model.Paciente;

public class PacienteConverter {//converte dodados salvos no txt (String)
	
	private static final String DELIMITADOR = ",";
	
	public static Paciente converterLinhaDoArquivoParaPaciente(String linha) {
		if (linha == null || linha.length() == 0) {
			return null;
		}
		
		String[] props = linha.split(DELIMITADOR);
		Paciente paciente = new Paciente();
		paciente.setId(Integer.parseInt(props[0]));
		paciente.setNome(props[1]);
		paciente.setIdade(Integer.parseInt(props[2]));
		paciente.setEndereco(props[3]);
		return paciente;
		
	}
	
	public static String converterPacienteParaLinhaDoArquivo(Paciente paciente) {
		StringBuffer lineStrPaciente = new StringBuffer();
		lineStrPaciente.append(paciente.getId());
		lineStrPaciente.append(DELIMITADOR);
		lineStrPaciente.append(paciente.getNome());
		lineStrPaciente.append(DELIMITADOR);
		lineStrPaciente.append(paciente.getIdade());
		lineStrPaciente.append(DELIMITADOR);
		lineStrPaciente.append(paciente.getEndereco());

		return lineStrPaciente.toString();
	}
	
}
