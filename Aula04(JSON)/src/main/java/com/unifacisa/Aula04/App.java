package com.unifacisa.Aula04;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App 
{
	public static void main( String[] args ) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Serialize
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, getPessoas());
        System.out.println(writer);
        FileWriter item = new FileWriter("JSON.json");
        
        // Deserialize
        String jsonInput = "[{\"id\":1,\"nome\":\"Lucas\"},{\"id\":2,\"nome\":\"Maria\"},{\"id\":3,\"nome\":\"Jose\"}]";
        List<Pessoa> p = mapper.readValue(jsonInput, new TypeReference<List<Pessoa>>(){});
        System.out.println("Pessoa: " + p);

    }
    private static List<Pessoa> getPessoas() {

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        Pessoa p1 = new Pessoa();
        p1.setId(1);
        p1.setNome("Lucas");

        Pessoa p2 = new Pessoa();
        p2.setId(2);
        p2.setNome("Maria");

        Pessoa p3 = new Pessoa();
        p3.setId(3);
        p3.setNome("Jose");
        
        Pessoa p4 = new Pessoa();
        p4.setId(4);
        p4.setNome("Anderson");
        
        Pessoa p5 = new Pessoa();
        p5.setId(5);
        p5.setNome("Pedro");
        
        Pessoa p6 = new Pessoa();
        p6.setId(6);
        p6.setNome("Ayrton");
        
        Pessoa p7 = new Pessoa();
        p7.setId(7);
        p7.setNome("Wanderson");
        
        Pessoa p8 = new Pessoa();
        p8.setId(8);
        p8.setNome("Ivo");

        pessoas.add(p1);
        pessoas.add(p2);
        pessoas.add(p3);
        pessoas.add(p4);
        pessoas.add(p5);
        pessoas.add(p6);
        pessoas.add(p7);
        pessoas.add(p8);

        return pessoas;

    }
}