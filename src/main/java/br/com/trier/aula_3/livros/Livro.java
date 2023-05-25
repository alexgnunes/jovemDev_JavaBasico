package br.com.trier.aula_3.livros;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.trier.aula_3.EnumContinua;

public class Livro {
	private String titulo;
	private Double preco;

	List<Autor> autorLivro = new ArrayList<Autor>();

	public Livro() {
	}

	public Livro(String titulo, Double preco, List<Autor> autorLivro) {
		this.titulo = titulo;
		this.preco = preco;
		this.autorLivro = autorLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public Double getPreco() {
		return preco;
	}

	public List<Autor> getautorLivro() {
		return autorLivro;
	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", preco=" + preco + ", autorLivro=" + autorLivro + "]";
	}

	public void cadastrarLivro(List<Autor> autores) {
		titulo = JOptionPane
				.showInputDialog(null, "Digite o titulo do livro: ", "Cadatrar livro", JOptionPane.QUESTION_MESSAGE)
				.toLowerCase();
		preco = Double.parseDouble(
				JOptionPane.showInputDialog(null, "Digite o pre�o:", "Cadatrar livro", JOptionPane.QUESTION_MESSAGE));

		boolean VerificaSeAdicionaAutor = true;
		do {
			Integer numeroAutor = Integer.parseInt(JOptionPane.showInputDialog(null, UtilLivros.listarAutores(autores),
					"Cadatrar livro", JOptionPane.QUESTION_MESSAGE));

			Autor autor = autores.get(numeroAutor - 1);
			autorLivro.add(autor);

			EnumContinua[] opcoesCadastro = EnumContinua.values();
			EnumContinua opcaoEscolhida = (EnumContinua) JOptionPane.showInputDialog(null,
					"Deseja cadastrar outro autor?", "Cadastro do livro", JOptionPane.QUESTION_MESSAGE, null,
					opcoesCadastro, opcoesCadastro[0]);
			if (opcaoEscolhida == EnumContinua.NAO) {
				VerificaSeAdicionaAutor = false;
			}
		} while (VerificaSeAdicionaAutor);

	}

	public boolean isAutor(Autor autorEscolhido) {
		for (Autor autor : autorLivro) {
			if (autor.getNome().equalsIgnoreCase(autorEscolhido.getNome())) {
				return true;
			}
		}
		return false;
	}

	public boolean isAutorCrianca() {
		for (Autor autor : autorLivro) {
			if (autor.getIdade() <=12) {
				return true;
			}
		}
		return false;
	}
}
