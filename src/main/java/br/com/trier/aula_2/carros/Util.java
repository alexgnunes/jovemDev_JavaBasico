package br.com.trier.aula_2.carros;

import javax.swing.JOptionPane;

public class Util {

	static int escolherOpcao() {
		String menu = "1-Cadastrar \n"
				+ "2-Listar por periodo de fabricação\n"
				+ "3-Listar carros por marca\n"
				+ "4-Listar carros por cor\n"
				+ "5-Sair\n";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
}
