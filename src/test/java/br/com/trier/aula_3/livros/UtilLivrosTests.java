package br.com.trier.aula_3.livros;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilLivrosTests {
	@Test
	public void geraListaAutor() {
		List<Autor> autoresTests = new ArrayList<Autor>();
		Autor autorTest = new Autor("alex nunes", 33, EnumSexo.MASCULINO);
		autoresTests.add(autorTest);
		
		String autorRetornado = UtilLivros.listarAutores(autoresTests);
		Assertions.assertEquals("1 - alex nunes\n", autorRetornado);
	}
	
	@Test
	public void geraListaAutoresComDadosAutor() {
		List<Autor> autoresTests = new ArrayList<Autor>();
		Autor autorTest = new Autor("alex nunes", 33, EnumSexo.MASCULINO);
		autoresTests.add(autorTest);
		String autorRetornado = UtilLivros.listarAutoresDados(autoresTests);
		
		Assertions.assertEquals("alex nunes\t idade: 33\t sexo: MASCULINO\n", autorRetornado);
	}

}
