package br.com.trier.exPolimorfismo;

public class Circulo extends Forma {
	private int raio;

	public Circulo(int raio) {
		super("circulo");
		this.raio = raio;
	}
	
	public Double calculaArea() {
		return Math.PI * raio * raio;
	}
}
