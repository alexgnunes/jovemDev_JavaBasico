package br.com.trier.aula_3.livros;

import java.util.ArrayList;
import java.util.List;

public class MainLivros {

	public static void main(String[] args) {
		List<Autor> autores = new ArrayList<Autor>();
		autores.add(new Autor("Autor 1", 30, EnumSexo.MASCULINO));
		autores.add(new Autor("Autor 2", 25, EnumSexo.FEMININO));
		autores.add(new Autor("Autor 3", 35, EnumSexo.FEMININO));
		
		List<Livro> livros = new ArrayList<Livro>();
		
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
				UtilLivros.pesquisarAutor(autores);
			}
			
			
		} while (opcao != 8);
		
	}
}
