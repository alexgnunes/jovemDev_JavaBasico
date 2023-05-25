package br.com.trier.aula_3;

import java.util.List;

import javax.swing.JOptionPane;

public class UtilTime {

	protected static int escolherOpcao() {
		int opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
				"1 - Cadastrar times \r\n" 
				+ "2 - Listar todos jogadores de um time\r\n"
				+ "3 - Verificar artilheiro do campeonato.\r\n"
				+ "4 - Verificar qual time fez mais gols no campeonato;\r\n" + "5 - Sair",
				"Digite a opção:", JOptionPane.QUESTION_MESSAGE));
		
		return opcao;
	}

	public static void listarJogadores(List<Time> times) {
		String timeEscolhido = JOptionPane
				.showInputDialog(null, "Digite o time:", "Listar jogadores do Time", JOptionPane.QUESTION_MESSAGE)
				.toLowerCase();
		for (Time time : times) {
			if (timeEscolhido.equals(time.getNomeTime())) {
				List<Jogador> jogadores = time.getJogadores();
				for (Jogador jogador : jogadores) {
					System.out.println(jogador.getNomeJogador());
				}
			}
		}
	}

	public static void verificaArtilheiro(List<Time> times) {
		int gols = 0;
		String artilheiro = null;
		for (Time time : times) {
			List<Jogador> jogadores = time.getJogadores();
			for (Jogador jogador : jogadores) {
				if (jogador.getQtdGols() > gols) {
					gols = jogador.getQtdGols();
					artilheiro = jogador.getNomeJogador();
				}
			}
		}
		System.out.println("o artilheiro foi: " + artilheiro);
	}

	public static void verificaTimeMaiorGols(List<Time> times) {
		int gols = 0;
		int golsTime = 0;
		String timeArtilheiro = null;
		for (Time time : times) {
			List<Jogador> jogadores = time.getJogadores();
			for (Jogador jogador : jogadores) {
				gols += jogador.getQtdGols();
			}
			if (gols > golsTime) {
				golsTime = gols;
				timeArtilheiro = time.getNomeTime();
			}
			gols = 0;
		}
		System.out.println("time com maior numero de gols: " + timeArtilheiro);
	}
}