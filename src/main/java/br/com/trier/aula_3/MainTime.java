package br.com.trier.aula_3;

import java.util.ArrayList;
import java.util.List;

public class MainTime {

	public static void main(String[] args) {
		List<Time> times = new ArrayList<Time>();		

		int opcao = 0;
		do {
			opcao = UtilTime.escolherOpcao();
			if (opcao == 1) {
				Time time = new Time();
				time.cadastrar();
				times.add(time);
			} else if (opcao == 2) {
				UtilTime.listarJogadores(times);
			} // else if (opcao == 3) {
//				Util.filtrarCarrosMarca(carros);
//				
//			} else if (opcao == 4) {
//				Util.filtrarCarrosCor(carros);				
//			}
		} while (opcao != 5);
		System.out.println(times.get(0).toString());
	}

}
