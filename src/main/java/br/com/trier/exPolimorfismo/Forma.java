package br.com.trier.exPolimorfismo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Forma {
	private String nome;
	
	
	public String desenhar() {
		return "desenhando um: " + getNome();
	}
}
