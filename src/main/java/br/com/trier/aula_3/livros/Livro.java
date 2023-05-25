package br.com.trier.aula_3.livros;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Livro {
	private String titulo;
	private Double preco;
	
	List<Autor> autores = new ArrayList<Autor>();

	public Livro() {
	}

	public Livro(String titulo, Double preco, List<Autor> autores) {
		this.titulo = titulo;
		this.preco = preco;
		this.autores = autores;
	}

	public String getTitulo() {
		return titulo;
	}

	public Double getPreco() {
		return preco;
	}

	public List<Autor> getAutores() {
		return autores;
	}
	
	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", preco=" + preco + ", autores=" + autores + "]";
	}
	public static void cadastrarLivro(List<Autor> autores) {
		String titulo = JOptionPane.showInputDialog(null, "Digite o titulo do livro: ", "Cadatrar livro", JOptionPane.QUESTION_MESSAGE).toLowerCase();
		Integer preco = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o preço:", "Cadatrar livro", JOptionPane.QUESTION_MESSAGE));
		String autor = JOptionPane.showInputDialog(null, listarAutores(autores), "Cadatrar livro", JOptionPane.QUESTION_MESSAGE).toLowerCase();
		
	}	
	
	public static String listarAutores(List<Autor> autores) {
		StringBuilder listaAutores = new StringBuilder("Escolha um autor:\n");
        for (int i = 0; i < autores.size(); i++) {
        	 listaAutores.append((i + 1)).append(". ").append(autores.get(i).getNome()).append("\n");
        }
        return listaAutores.toString();
	}
}
