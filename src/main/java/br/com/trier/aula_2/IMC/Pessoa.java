package br.com.trier.aula_2.IMC;

import javax.swing.JOptionPane;

public class Pessoa {

	String nome;
	String sexo;
	double peso;
	double altura;

	double calculaIMC() {
		return peso / (altura * altura);
	}

	void cadastrar() {
		nome = JOptionPane.showInputDialog("nome: ");
		sexo = JOptionPane.showInputDialog("sexo: ");
		peso = Double.parseDouble(JOptionPane.showInputDialog("peso: "));
		altura = Double.parseDouble(JOptionPane.showInputDialog("altura: "));
	}

//	String imprimir() {
//		return "nome " + nome + "imc" + calculaIMC() + "(" + avaliaIMC() + ")";	
//	}

//	String avaliaIMC() {
//		String ret = "nao identificado";
//		double imc = calculaIMC();
//		if (sexo.equalsIgnoreCase("F")) {
//			imc = imc * 0.9;
//		}

//		else {
//			if (valorIMC <= 19.1) {
//				return "Abaixo do peso";
//			} else if (valorIMC <= 25.8) {
//				return "Peso ideal";
//			} else if (valorIMC <= 27.3) {
//				return "Pouco acima do peso";
//			} else if (valorIMC <= 32.3) {
//				return "Acima do peso";
//			} else {
//				return "Obesidade";
//			}
//		}
//	}
}
