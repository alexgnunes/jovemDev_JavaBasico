package br.com.trier.aula_1;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class MainPessoa {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		int numeroCadastro = Integer.parseInt(JOptionPane.showInputDialog("digite o numero de cadastros: "));

		for (int i = 0; i < numeroCadastro; i++) {
			String nome = JOptionPane.showInputDialog("Digite o nome: ");
			String sexo = JOptionPane.showInputDialog("Digite o sexo (M / F ): ");
			Double peso = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso: "));
			Double altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura: "));

			pessoas.add(new Pessoa(nome, sexo, peso, altura));
		}

		for (int i = 0; i < numeroCadastro; i++) {
			Pessoa pessoa = pessoas.get(i);
			sb.append("nome: ").append(pessoa.nome);
			sb.append("\t IMC = ").append(String.format("%.2f", pessoa.CalculaIMC(pessoa.peso, pessoa.altura)));
			sb.append("\t avaliação: ")
					.append(pessoa.avaliacaoIMC(pessoa.sexo, pessoa.CalculaIMC(pessoa.peso, pessoa.altura)));

			System.out.println(sb.toString());
		}
	}
}
