package br.com.trier.aula_3.livros;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AutorTests {

	@Test
	public void cadastraAutorNomeSobrenome() {
		String nomeAutor = "Joao Silva";
        EnumSexo sexo = EnumSexo.MASCULINO;
        int idade = 30;
        
        Autor autorTest = new Autor(nomeAutor, idade, sexo);
        Autor autor = new Autor();
        
        autor.cadastrarAutor();
        
        Assertions.assertFalse(autor.getNomeAutor().equals(autorTest.getNomeAutor()));
        
	}
}
