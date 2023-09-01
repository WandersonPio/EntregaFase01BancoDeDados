package aula02;


import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
	public static void main(String[] args) throws IOException{
		String url = "https://pt.wikipedia.org/wiki/Formula_1";
		String outputFilePath = "titles.txt";

		try {
			Document doc = Jsoup.connect(url).get();

			Elements titleElements = doc.select("h1, h2, h3");

			for (Element titleElement : titleElements) {
				String title = titleElement.text();

			}

			System.out.println("Arquivos salvos em " + outputFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
