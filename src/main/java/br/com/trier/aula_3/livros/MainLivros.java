package br.com.trier.aula_3.livros;

import java.util.ArrayList;
import java.util.List;

public class MainLivros {

	public static void main(String[] args) {
		List<Autor> autores = new ArrayList<Autor>();
		autores.add(new Autor("Autor 1", 10, EnumSexo.MASCULINO));
		autores.add(new Autor("Autor 2", 25, EnumSexo.FEMININO));
		autores.add(new Autor("Autor 3", 5, EnumSexo.FEMININO));
		
		List<Livro> livros = new ArrayList<Livro>();
		Livro livro1 = new Livro();
		livro1.setTitulo("t1");
		livro1.getautorLivro().add(autores.get(0));
		livros.add(livro1);
		Livro livro2 = new Livro();
		livro2.setTitulo("t2");
		livro2.getautorLivro().add(autores.get(1));
		livros.add(livro2);
		
		int opcao = 0;
		do {
			opcao = UtilLivros.escolherOpcao();
			if (opcao == 1) {
				Autor autor = new Autor();
				autor.cadastrarAutor();
				autores.add(autor);		
				System.out.println(autor.toString());
			}else if (opcao == 2) {
				Livro livro = new Livro();
				livro.cadastrarLivro(autores);
				livros.add(livro);
			}else if (opcao == 3) {
				UtilLivros.listarLivros(livros);
			}else if (opcao == 4) {
				UtilLivros.pesquisarAutor(autores, livros);
			}else if (opcao == 5) {
				UtilLivros.pesquisarPreco(livros);
			}else if (opcao == 6) {
				UtilLivros.pesquisarAutorInfantil( livros);
			}else if (opcao == 7) {
				UtilLivros.listarLivrosGenero(livros);
			}			
		} while (opcao != 8);
		
	}
}
