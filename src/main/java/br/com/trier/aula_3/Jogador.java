package br.com.trier.aula_3;

import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jogador {
	
	private String nomeJogador;
	private Integer numeroCamisa;
	private Integer qtdGols;
	
	public Jogador(String nomeJogador, Integer numeroCamisa, Integer qtdGols) {
		this.nomeJogador = nomeJogador;
		this.numeroCamisa = numeroCamisa;
		this.qtdGols = qtdGols;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public Integer getNumeroCamisa() {
		return numeroCamisa;
	}

	public void setNumeroCamisa(Integer numeroCamisa) {
		this.numeroCamisa = numeroCamisa;
	}

	public Integer getQtdGols() {
		return qtdGols;
	}

	public void setQtdGols(Integer qtdGols) {
		this.qtdGols = qtdGols;
	}

	@Override
	public String toString() {
		return "Jogador [nomeJogador=" + nomeJogador + ", numeroCamisa=" + numeroCamisa + ", qtdGols=" + qtdGols + "]";
	}

	public static void cadatrarJogador(List<Jogador> jogadores) {
		String nomeJogador = JOptionPane.showInputDialog(null, "Digite o nome do jogador:", "Cadatrar jogador", JOptionPane.QUESTION_MESSAGE).toLowerCase();
		Integer numeroJogador = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do jogador:", "Cadatrar jogador", JOptionPane.QUESTION_MESSAGE));
		Integer qtdGols = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero de gols do jogador:", "Cadatrar jogador", JOptionPane.QUESTION_MESSAGE));

		jogadores.add(new Jogador(nomeJogador, numeroJogador, qtdGols));
	}
}
