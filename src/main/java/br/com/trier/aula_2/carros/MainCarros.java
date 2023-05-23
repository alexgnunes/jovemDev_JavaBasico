package br.com.trier.aula_2.carros;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class MainCarros {

	public static void main(String[] args) {
		List<Carro> carros = new ArrayList<Carro>();

		int opcao = 0;

		do {
			opcao = Util.escolherOpcao();
			if (opcao == 1) {
				Carro carro = new Carro();
				carro.cadastrar();
				carros.add(carro);
			} else if (opcao == 2) {
				Util.filtrarCarrosAnoFabricacao(carros);
			} else if (opcao == 3) {
				Util.filtrarCarrosMarca(carros);
				
			} else if (opcao == 4) {
				Cor[] opcoesCores = Cor.values();
				Cor corEscolhida = (Cor) JOptionPane.showInputDialog(null, "Selecione a cor:", "Selecionar Cor",
						JOptionPane.QUESTION_MESSAGE, null, opcoesCores, opcoesCores[0]);
				for (Carro carro : carros) {
					if (carro.getCor().equals(corEscolhida)) {
						System.out.println(carro.getMarca());
					}
				}
			}

		} while (opcao != 5);
	}

}
