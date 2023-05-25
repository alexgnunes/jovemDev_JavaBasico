package br.com.trier.teste;

public class Main {
	
		public static void main(String[] args) {
			Teste t1 = new Teste();
			Teste t2 = new Teste();
			t1.incrementaI();
			Teste.incrementaI();
			t1.incrementaI();
			
			//incrementaJ(); //ERRO
			//Teste.incrementaJ(); //ERRO
			t1.incrementaJ();
			t1.imprime(t1.i + " - " + t1.j);
			t2.imprime(t1.i + " - " + t2.j);
		}
	}


