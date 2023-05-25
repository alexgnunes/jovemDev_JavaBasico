package br.com.trier.aula_3.livros;

import java.util.ArrayList;
import java.util.List;

public class MainLivros {

	public static void main(String[] args) {
		List<Autor> autores = new ArrayList<Autor>();
		int opcao = 0;
		do {
			opcao = UtilLivros.escolherOpcao();
			if (opcao == 1) {
				Autor autor = new Autor();
				autor.cadastrarAutor(autores);
				autores.add(autor);
				
			}
			
		} while (true);
		
	}
}
