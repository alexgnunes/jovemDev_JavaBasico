package br.com.trier.teste;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JUnitContaBancoTests {
	
	@Test
	public void depositoDeveriaAumentarSaldo() {
		double saldo = 200;
		JUnitContaBanco acc = new JUnitContaBanco(1, 0) ;
		
		acc.deposito(saldo);
		
		Assertions.assertEquals(saldo, acc.getSaldo());
	}
	
	@Test
	public void saqueDeveriaDiminuirSaldo() {
		double quantia = 100;
		JUnitContaBanco acc = new JUnitContaBanco(1, 200);
		
		acc.saque(quantia);
		
		Assertions.assertEquals(100, acc.getSaldo());
	}

}
