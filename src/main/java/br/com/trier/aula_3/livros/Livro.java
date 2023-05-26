package br.com.trier.aula_3.livros;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.trier.aula_3.EnumContinua;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public void setAutorLivro(List<Autor> autorLivro) {
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
		String precoString = JOptionPane.showInputDialog(null, "Digite o preco:", "Cadatrar livro",
				JOptionPane.QUESTION_MESSAGE);
		while (precoString == null || precoString.isEmpty() || Double.parseDouble(precoString) <= 0) {
			precoString = JOptionPane.showInputDialog(null, "Preco invalido, tente novamente:", "Cadatrar livro",
					JOptionPane.ERROR_MESSAGE);
		}
		preco = Double.parseDouble(precoString);

		boolean VerificaSeAdicionaAutor = true;
		do {
			String numeroAutorString = JOptionPane.showInputDialog(null, UtilLivros.listarAutores(autores),
					"Cadatrar livro", JOptionPane.QUESTION_MESSAGE);

			while (numeroAutorString == null || numeroAutorString.isEmpty()) {
				numeroAutorString = JOptionPane.showInputDialog(null,
						"Autor invalido, tente novamente:\n" + UtilLivros.listarAutores(autores), "Cadatrar livro",
						JOptionPane.ERROR_MESSAGE);
			}

			Integer numeroAutor = Integer.parseInt(numeroAutorString);			
			Autor autor = autores.get(numeroAutor - 1);
			autorLivro.add(autor);
			
			if (autorLivro.size() == 4) {
				System.out.println("Numero maximo de autores cadastrado");
				break;
			}

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
			if (autor.getIdade() <= 12) {
				return true;
			}
		}
		return false;
	}

	public boolean isSexo(EnumSexo sexoSelecionado, Livro livro) {
		for (Autor autor : autorLivro) {
			int count = 0;
			if (autor.getSexo().equals(sexoSelecionado)) {
				count++;
			}
			if (count == livro.autorLivro.size()) {
				return true;
			}
		}
		return false;
	}

}
