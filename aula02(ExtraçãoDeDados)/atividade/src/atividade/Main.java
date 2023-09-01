package atividade;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
	public static void main(String[] args) {
		String url = "https://pt.wikipedia.org/wiki/Fórmula_1";
		String outputFilePath = "titles.txt";

		try {
			Document doc = Jsoup.connect(url).get();

			// Seleciona todos os elementos de título (h1, h2, h3)
			Elements titleElements = doc.select("h1, h2, h3");

			// Itera sobre os elementos de título e escreve no arquivo
			for (Element titleElement : titleElements) {
				String title = titleElement.text();

			}

			System.out.println("Títulos extraídos e salvos em " + outputFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
