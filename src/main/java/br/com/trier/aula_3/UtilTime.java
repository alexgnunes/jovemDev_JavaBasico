package br.com.trier.aula_3;

import javax.swing.JOptionPane;

public class UtilTime {

	protected static int escolherOpcao() {
//	marca = JOptionPane.showInputDialog(null, "Digite a marca:", "Marca", JOptionPane.QUESTION_MESSAGE).toUpperCase();
		int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Cadastrar times \r\n"
				+ "2 - Listar todos jogadores de um time\r\n"
				+ "3 - Verificar artilheiro do campeonato.\r\n"
				+ "4 - Verificar qual time fez mais gols no campeonato;\r\n"
				+ "5 - Sair",
				"Digite a opção:",
				JOptionPane.QUESTION_MESSAGE));
		;
		return opcao;
	}
}