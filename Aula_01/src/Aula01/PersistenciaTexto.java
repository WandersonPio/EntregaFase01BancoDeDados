package Aula01;

import java.io.FileWriter;
import java.io.IOException;

public class PersistenciaTexto {
	public static void main(String[] args) {
		String conteudo = "Este � um exemplo de persist�ncia em arquivo de texto.";
		
		try {
			FileWriter escritor = new FileWriter("arquivo.txt");
			escritor.write(conteudo);
			escritor.close();
			System.out.println("Dados gravados com sucesso");
			
		} catch (IOException e) {
			System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
			
		}
	}
}