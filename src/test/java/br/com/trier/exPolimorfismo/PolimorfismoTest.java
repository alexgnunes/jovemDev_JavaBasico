package br.com.trier.exPolimorfismo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PolimorfismoTest {

	private List<Forma> lista = new ArrayList<>();
	
	@BeforeEach
	public void init() {
		lista.add(new Circulo(3));
		lista.add(new Cone());
		lista.add(new Quadrado());
		lista.add(new Triangulo());
		
	}
	 
	@Test
	@DisplayName("teste desenha circo")
	public void desenharCirculo() {
		Circulo c = (Circulo) lista.get(0);
		String area = String.format("%.2f", c.calculaArea());
		String s = lista.get(0).desenhar();
		assertEquals("desenhando um: circulo", s);
		assertEquals("28,27", area);
	}
	
	@Test
	@DisplayName("teste desenha cone")
	public void desenharCone() {
		String s = lista.get(1).desenhar();
		assertEquals("desenhando um: Cone", s);
	}
	
	@Test
	@DisplayName("teste desenha quadrado")
	public void desenharQuadrado() {
		String s = lista.get(2).desenhar();
		assertEquals("desenhando um: quadrado com 4 lados", s);
	}
	
	@Test
	@DisplayName("teste desenha triangulo")
	public void desenharTriangulo() {
		String s = lista.get(3).desenhar();
		assertEquals("desenhando um: Triangulo com 3 lados", s);
	}
}
