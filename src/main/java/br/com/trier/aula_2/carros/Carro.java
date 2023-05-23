package br.com.trier.aula_2.carros;

import javax.swing.JOptionPane;

public class Carro {
	private String marca;
	private int ano;
	private Cor cor;

	public Carro(String marca, int ano, Cor cor) {
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

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public void cadastrar() {
//		marca = JOptionPane.showInputDialog("marca: ");
		marca = JOptionPane.showInputDialog(null, "Digite a marca:", "Marca", JOptionPane.PLAIN_MESSAGE);
		ano = Integer.parseInt(JOptionPane.showInputDialog("ano: "));
		Cor[] opcoesCores = Cor.values();
		Cor corSelecionada = (Cor) JOptionPane.showInputDialog(null, "Selecione a cor:", "Selecionar Cor",
				JOptionPane.QUESTION_MESSAGE, null, opcoesCores, opcoesCores[0]);

		cor = corSelecionada;
	}
	
	
}
