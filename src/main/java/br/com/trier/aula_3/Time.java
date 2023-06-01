package br.com.trier.aula_3;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Time {
	private String nomeTime;

	List<Jogador> jogadores = new ArrayList<Jogador>();
	
	public Time() {
	}	
	
	public Time(String nomeTime) {
		super();
		this.nomeTime = nomeTime; 
	}

	public Time(String nomeTime, List<Jogador> jogadores) {
		this.nomeTime = nomeTime;
		this.jogadores = jogadores;
	}
	public String getNomeTime() {
		return nomeTime;
	}
	
	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}
	
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void cadastrar() {
		nomeTime = JOptionPane
				.showInputDialog(null, "Digite o nome do time:", "Cadatrar Time", JOptionPane.QUESTION_MESSAGE)
				.toLowerCase();
		
		boolean VerificaSeCadastroContinua = true;
		do {
			Jogador.cadatrarJogador(jogadores);
			EnumContinua[] opcoesCadastro = EnumContinua.values();
			EnumContinua opcaoEscolhida = (EnumContinua) JOptionPane.showInputDialog(null,
					"Deseja cadastrar outro jogador?", "Cadastro do jogador", JOptionPane.QUESTION_MESSAGE, null,
					opcoesCadastro, opcoesCadastro[0]);
			if (opcaoEscolhida == EnumContinua.NAO) {
				VerificaSeCadastroContinua = false;
			}
		} while (VerificaSeCadastroContinua);
	}

	@Override
	public String toString() {
		return "Time [nomeTime=" + nomeTime + ", jogadores=" + jogadores + "]";
	}

}