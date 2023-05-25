package br.com.trier.aula_3.livros;

import java.util.List;

import javax.swing.JOptionPane;

public class UtilLivros {
	public static int escolherOpcao() {
		int opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
				"1 - Cadastrar Autor \r\n" + 
				"2 – Cadastrar Livros \r\n" + 
				"3 - Listar todos os livros cadastrados \r\n" + 
				"4 - Pesquisar por autor \r\n" + 
				"5 - Pesquisar por faixa de valor do livro \r\n" + 
				"6 - Listar todos os livros cujo autores tenham crianças (idade <=12) \r\n" + 
				"7 – Listar todos os livros que foram escritos apenas por mulheres ou por homens \r\n" +
				"8 - Sair \r\n",
				"Digite a opÃ§Ã£o:", JOptionPane.QUESTION_MESSAGE));
		
		return opcao;
	}
	
	public static String listarAutores(List<Autor> autores) {
		StringBuilder listaAutores = new StringBuilder("Escolha um autor:\n");
        for (int i = 0; i < autores.size(); i++) {
        	 listaAutores.append((i + 1)).append(". ").append(autores.get(i).getNome()).append("\n");
        }
        return listaAutores.toString();
	}
}
