package br.com.trier.aula_3.livros;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class UtilLivros {
	public static int escolherOpcao() {
		int opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
				"1 - Cadastrar Autor \r\n" + "2 - Cadastrar Livros \r\n" + "3 - Listar todos os livros cadastrados \r\n"
						+ "4 - Pesquisar por autor \r\n" + "5 - Pesquisar por faixa de valor do livro \r\n"
						+ "6 - Listar todos os livros cujo autores tenham crian�as (idade <=12) \r\n"
						+ "7 - Listar todos os livros que foram escritos apenas por mulheres ou por homens \r\n"
						+ "8 - Sair \r\n",
				"Digite a opção:", JOptionPane.QUESTION_MESSAGE));

		return opcao;
	}

	public static String listarAutores(List<Autor> autores) {
		String listaAutores = "";
		for (int i = 0; i < autores.size(); i++) {
			listaAutores += (i + 1) + " - " + autores.get(i).getNome() + "\n";
		}

		return listaAutores;
	}

	public static Livro escolherLivro(List<Livro> livros) {
		String menu = "Escolha um livro: \n";
		int posicao = 0;
		for (Livro livro : livros) {
			menu += posicao + " - " + livro.getTitulo() + "\n";
			posicao++;
		}
		int escolha = Integer
				.parseInt(JOptionPane.showInputDialog(null, "menu", "Escolher livro", JOptionPane.QUESTION_MESSAGE));
		return livros.get(posicao - 1);
	}

	public static void listarLivros(List<Livro> livros) {
		for (Livro livro : livros) {
			System.out.print("Titulo: " + livro.getTitulo() + "\tpreço R$" + livro.getPreco() + "\tautor(es): "
					+ listarAutores(livro.autorLivro));
			System.out.println("------------------");
		}
	}

	public static void pesquisarAutor(List<Autor> autores, List<Livro> livros) {
		Integer numeroAutor = Integer.parseInt(JOptionPane.showInputDialog(null, UtilLivros.listarAutores(autores),
				"Cadatrar livro", JOptionPane.QUESTION_MESSAGE));
		Autor autor = null;
		for (int i = 0; i < autores.size(); i++) {
			if (i + 1 == numeroAutor) {
				autor = autores.get(i);
				for (Livro livro : livros) {
					if (livro.isAutor(autor)) {
						System.out.println(livro.getTitulo());
					}
				}

			}
		}
	}

	public static void pesquisarPreco(List<Livro> livros) {
		Double precoInicial = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor inicial: ",
				"Filtra por preço", JOptionPane.QUESTION_MESSAGE));
		Double precoFinal = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor final: ",
				"Filtra por preço", JOptionPane.QUESTION_MESSAGE));

		for (Livro livro : livros) {
			if (precoInicial < livro.getPreco() && livro.getPreco() < precoFinal) {
				System.out.println(livro.getTitulo());
			}

		}
	}

	public static void pesquisarAutorInfantil(List<Livro> livros) {
		List<Livro> livroAutorInfantil = new ArrayList<Livro>();

		for (Livro livro : livros) {
			if (livro.isAutorCrianca()) {
				livroAutorInfantil.add(livro);
			}
		}
		for (Livro livro : livroAutorInfantil) {
			System.out.println(livro.getTitulo());
		}
	}

	public static void listarLivrosGenero(List<Livro> livros) {
		List<Livro> livroGenero = new ArrayList<Livro>();
		EnumSexo[] opcoesSexo = EnumSexo.values();
		EnumSexo sexoSelecionado = (EnumSexo) JOptionPane.showInputDialog(null, "Selecione o sexo:", "Cadatrar autor",
				JOptionPane.QUESTION_MESSAGE, null, opcoesSexo, opcoesSexo[0]);
		for (Livro livro : livros) {
			if (livro.isSexo(sexoSelecionado)) {
				livroGenero.add(livro);
			}
		}
		for (Livro livro : livroGenero) {
			System.out.println(livro.getTitulo());
		}
	}
}
