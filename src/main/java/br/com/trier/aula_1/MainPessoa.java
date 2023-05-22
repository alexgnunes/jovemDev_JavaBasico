package br.com.trier.aula_1;

import javax.swing.JOptionPane;

public class MainPessoa {

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		
		pessoa.nome = JOptionPane.showInputDialog("Digite o nome: ");
		pessoa.sexo = JOptionPane.showInputDialog("Digite o sexo (M / F ): ");
		pessoa.peso = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso: "));
		pessoa.altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura: "));
		
//		
		System.out.println("Nome = " + pessoa.nome + "\t IMC = " + String.format("%.2f", pessoa.CalculaIMC(pessoa.peso, pessoa.altura))  + "\t avaliação = " + pessoa.avaliacaoIMC(null, pessoa.CalculaIMC(pessoa.peso, pessoa.altura))); 
	}

}
