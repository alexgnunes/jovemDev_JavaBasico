package br.com.trier.aula_1;

public class Pessoa {
	String nome;
	String sexo;
	Double peso;
	Double altura;
	

	public Pessoa() {
	}

	public double CalculaIMC(Double peso, Double altura) {
		Double valorIMC = peso / (altura * altura);
		return valorIMC;
	}

	public String avaliacaoIMC(String sexo, Double valorIMC) {
		if (sexo == "M") {
			if (valorIMC <= 20.7) {
				return "Abaixo do peso";
			} else if (valorIMC <= 26.4) {
				return "Peso ideal";
			} else if (valorIMC <= 27.8) {
				return "Pouco acima do peso";
			} else if (valorIMC <= 31.2) {
				return "Acima do peso";
			} else {
				return "Obesidade";
			}
		} else {
			if (valorIMC <= 19.1) {
				return "Abaixo do peso";
			} else if (valorIMC <= 25.8) {
				return "Peso ideal";
			} else if (valorIMC <= 27.3) {
				return "Pouco acima do peso";
			} else if (valorIMC <= 32.3) {
				return "Acima do peso";
			} else {
				return "Obesidade";
			}
		}
	}
}
