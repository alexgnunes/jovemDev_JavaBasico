package br.com.trier.aula_2.carros;

import javax.swing.JOptionPane;

public class Carro {
	private String marca;
	private Integer ano;
	private Cor cor;

	public Carro(String marca, Integer ano, Cor cor) {
		this.marca = marca;
		this.ano = ano;
		this.cor = cor;
	}

	public Carro() {
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public void cadastrar() {		
		marca = JOptionPane.showInputDialog(null, "Digite a marca:", "Marca", JOptionPane.QUESTION_MESSAGE).toUpperCase();
		while (marca == null || marca.isEmpty()) {
			marca = JOptionPane.showInputDialog(null, "Modelo invalido, tente novamente:", "Marca", JOptionPane.ERROR_MESSAGE).toUpperCase();
		}
		
		String AnoString = JOptionPane.showInputDialog(null, "Digite o ano:", "Ano de fabricação", JOptionPane.QUESTION_MESSAGE);
		while (AnoString == null|| AnoString.isEmpty()) {
			AnoString = JOptionPane.
					showInputDialog(null, "Ano invalido, tente novamente:", "Ano de fabricação", JOptionPane.ERROR_MESSAGE);
		}
		ano = Integer.parseInt(AnoString);
		
		Cor[] opcoesCores = Cor.values();
		Cor corSelecionada = (Cor) JOptionPane.showInputDialog(null, "Selecione a cor:", "Selecionar Cor",
				JOptionPane.QUESTION_MESSAGE, null, opcoesCores, opcoesCores[0]);		

		cor = corSelecionada;
	}
	
	
}
