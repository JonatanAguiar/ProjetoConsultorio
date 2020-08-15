package com.apecatus.converter;

import com.apecatus.model.Profissional;

public class ProfissionalConverter {
	
	private static final String DELIMITADOR = ",";
	
	public static Profissional converterLinhaDoArquivoParaProfissional(String linha) {
		if (linha == null || linha.length() == 0) {
			return null;
		}
		
		String[] props = linha.split(DELIMITADOR);
		Profissional profissional = new Profissional();
		profissional.setId(Integer.parseInt(props[0]));
		profissional.setNome(props[1]);
		profissional.setDepartamento(props[2]);
		profissional.setEspecialidade(props[3]);
		return profissional;
		
	}
	
	public static String converterProfissionalParaLinhaDoArquivo(Profissional profissional) {
		StringBuffer lineStrProfissional = new StringBuffer();
		lineStrProfissional.append(profissional.getId());
		lineStrProfissional.append(DELIMITADOR);
		lineStrProfissional.append(profissional.getNome());
		lineStrProfissional.append(DELIMITADOR);
		lineStrProfissional.append(profissional.getDepartamento());
		lineStrProfissional.append(DELIMITADOR);
		lineStrProfissional.append(profissional.getEspecialidade());

		return lineStrProfissional.toString();
	}
	
}
