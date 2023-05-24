package br.com.trier.aula_3;

import javax.swing.JOptionPane;

public class UtilTime {

	static int escolherOpcao() {
//	marca = JOptionPane.showInputDialog(null, "Digite a marca:", "Marca", JOptionPane.QUESTION_MESSAGE).toUpperCase();
		int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a marca:",
				"1 - Cadastrar times (no cadastro do time deve ser feito o cadastro de cada jogador do referido time)\r\n"
						+ "2 - Listar todos jogadores de um time\r\n" + "3 - Verificar artilheiro do campeonato.\r\n"
						+ "3 - verificar qual time fez mais gols no campeonato;\r\n",
				JOptionPane.QUESTION_MESSAGE));
		;
		return opcao;
	}
}
