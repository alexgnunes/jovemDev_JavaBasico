package br.com.trier.aula_3.livros;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LivroTest {

	@Test
	public void verificaSeIsAutorRetornaTrue() {
		Autor autor1 = new Autor("Autor 1", 10, EnumSexo.MASCULINO);
		List<Livro> livros = new ArrayList<Livro>();
		Livro livro1 = new Livro();
		livro1.setTitulo("livro1");
		livro1.setPreco(10.00);
		livro1.getAutorLivro().add(autor1);
		livros.add(livro1);
		
		boolean b = livro1.isAutor(autor1);
		
		Assertions.assertTrue(b);
	}
	
	@Test
	public void verificaSeIsAutorRetornaFalse() {
		Autor autor1 = new Autor("Autor 1", 10, EnumSexo.MASCULINO);
		Autor autor2 = new Autor("Autor 2", 18, EnumSexo.FEMININO);
		List<Livro> livros = new ArrayList<Livro>();
		Livro livro1 = new Livro();
		livro1.setTitulo("livro1");
		livro1.setPreco(10.00);
		livro1.getAutorLivro().add(autor1);
		livros.add(livro1);
		
		boolean b = livro1.isAutor(autor2);
		
		Assertions.assertFalse(b);
	}
	
	@Test
	public void verificaSeIsCriancaRetornaTrue() {
		Autor autor1 = new Autor("Autor 1", 10, EnumSexo.MASCULINO);
		Autor autor2 = new Autor("Autor 2", 18, EnumSexo.FEMININO);
		List<Livro> livros = new ArrayList<Livro>();
		Livro livro1 = new Livro();
		livro1.setTitulo("livro1");
		livro1.setPreco(10.00);
		livro1.getAutorLivro().add(autor1);
		livros.add(livro1);
		
		boolean b = livro1.isAutorCrianca();
		
		Assertions.assertTrue(b);
	}
	
	@Test
	public void verificaSeIsCriancaRetornaFalse() {
		Autor autor1 = new Autor("Autor 1", 10, EnumSexo.MASCULINO);
		Autor autor2 = new Autor("Autor 2", 18, EnumSexo.FEMININO);
		List<Livro> livros = new ArrayList<Livro>();
		Livro livro1 = new Livro();
		livro1.setTitulo("livro1");
		livro1.setPreco(10.00);
		livro1.getAutorLivro().add(autor2);
		livros.add(livro1);
		
		boolean b = livro1.isAutorCrianca();
		
		Assertions.assertFalse(b);
	}
	
	
}
	
	
	
	
