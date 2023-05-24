package br.com.trier.aula_3;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Time {
	private String nome;
	
	List<Jogador> jogadores = new ArrayList<Jogador>();
}
