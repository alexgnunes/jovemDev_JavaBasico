package br.com.trier.aula_2.carros;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Util {
	static List<Carro> carrosImprimir = new ArrayList<Carro>();

	static int escolherOpcao() {
		String menu = "1-Cadastrar \n" + "2-Listar por periodo de fabricação\n" + "3-Listar carros por marca\n"
				+ "4-Listar carros por cor\n" + "5-Sair\n";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

	public static void filtrarCarrosAnoFabricacao(List<Carro> carros) {
		int anoInicial = Integer.parseInt(JOptionPane.showInputDialog("ano inicial: "));
		int anoFinal = Integer.parseInt(JOptionPane.showInputDialog("ano final: "));
		for (Carro carro : carros) {
			if (carro.getAno() > anoInicial && carro.getAno() < anoFinal) {
				carrosImprimir.add(carro);
			}
		}
		imprimir(carrosImprimir, carros);
	}

	public static void filtrarCarrosMarca(List<Carro> carros) {
		String marcaEscolhida = JOptionPane.showInputDialog("escolha uma marca: ");
		for (Carro carro : carros) {
			if (marcaEscolhida.equalsIgnoreCase(carro.getMarca())) {
				carrosImprimir.add(carro);
			}
		}
		imprimir(carrosImprimir, carros);

	}

	public static void filtrarCarrosCor(List<Carro> carros) {

		Cor[] opcoesCores = Cor.values();
		Cor corEscolhida = (Cor) JOptionPane.showInputDialog(null, "Selecione a cor:", "Selecionar Cor",
				JOptionPane.QUESTION_MESSAGE, null, opcoesCores, opcoesCores[0]);
		for (Carro carro : carros) {
			if (carro.getCor().equals(corEscolhida)) {
				carrosImprimir.add(carro);
			}
		}
		imprimir(carrosImprimir, carros);
	}

	public static void imprimir(List<Carro> carrosImprimir, List<Carro> carros) {
		for (Carro carro : carrosImprimir) {
			System.out.println(carro.getMarca() + "\t ano: " + carro.getAno() + "\t cor: " + carro.getCor());
		}
		double porcentagem = ((double) carrosImprimir.size() / carros.size()) * 100;
		carrosImprimir.clear();

		System.out.println("o resultado representa " + porcentagem + "% dos carros existentes");
	}
}
