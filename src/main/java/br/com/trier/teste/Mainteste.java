package br.com.trier.teste;

public class Mainteste {
	static int i = 47;
	int j = 26 ;
	
	static void imprime(String s){
		System.out.println(s);
	}
	static void incrementaI(){	i++;}
	void incrementaJ(){	j++;}
	public static void main(String[] args) {
		Mainteste t1 = new Mainteste();
		incrementaI();
		Mainteste.incrementaI();
		t1.incrementaI();
		
		//incrementaJ(); //ERRO
		//Teste.incrementaJ(); //ERRO
		t1.incrementaJ();
		imprime(t1.i + " - " + t1.j);
	}
}
