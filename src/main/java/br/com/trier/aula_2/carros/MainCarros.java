package br.com.trier.aula_2.carros;

import java.util.ArrayList;
import java.util.List;

public class MainCarros {

	public static void main(String[] args) {
		List<Carro> carros = new ArrayList<Carro>();
		
		Carro carro1 = new Carro("Toyota", 2010, Cor.AZUL);
		carros.add(carro1);

		Carro carro2 = new Carro("Honda", 2015, Cor.AZUL);
		carros.add(carro2);

		Carro carro3 = new Carro("Ford", 2012, Cor.PRATA);
		carros.add(carro3);

		Carro carro4 = new Carro("Chevrolet", 2018, Cor.PRETO);
		carros.add(carro4);

		Carro carro5 = new Carro("Volkswagen", 2019, Cor.BRANCO);
		carros.add(carro5);

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
				Util.filtrarCarrosCor(carros);				
			}
		} while (opcao != 5);
	}
}
