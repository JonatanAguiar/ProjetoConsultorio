package com.apecatus.uteis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscreverLinhaArquivo {//classe que grava no arquivo txt
	
	public void escreverLinhaDoArquivo(String fileName, String linhaStr) throws IOException {
		boolean existeArquivo = new File(fileName).exists();
		FileWriter fileWriter = new FileWriter(fileName, true);
		PrintWriter printWriter = new PrintWriter(fileWriter, true);
		if (existeArquivo) {
			printWriter.println(linhaStr);
		} else {
			printWriter.println(linhaStr);
		}
		printWriter.close();
		fileWriter.close();
	}
	
}
