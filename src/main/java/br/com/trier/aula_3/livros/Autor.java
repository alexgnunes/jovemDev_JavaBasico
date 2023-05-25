package br.com.trier.aula_3.livros;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.trier.aula_2.carros.Cor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Autor {
	private String nome;
	private int idade;
	private EnumSexo sexo;
	
	public Autor() {
	}

	public Autor(String nome, int idade, EnumSexo sexo) {
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nom) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public EnumSexo getSexo() {
		return sexo;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}

	public void cadastrarAutor(List<Autor> autores) {
		EnumSexo[] opcoesSexo = EnumSexo.values();
		String nomeAutor = JOptionPane.showInputDialog(null, "Digite o nome do autor:", "Cadatrar autor", JOptionPane.QUESTION_MESSAGE).toLowerCase();
		EnumSexo sexoSelecionado = (EnumSexo) JOptionPane.showInputDialog(null, "Selecione o sexo:", "Cadatrar autor",
				JOptionPane.QUESTION_MESSAGE, null, opcoesSexo, opcoesSexo[0]);
		sexo = sexoSelecionado;
		Integer idadeAutor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a idade do autor:", "Cadatrar autor", JOptionPane.QUESTION_MESSAGE));
		
		autores.add(new Autor(nomeAutor, idadeAutor, sexo));
		System.out.println(autores.get(0).toString());
	}

	@Override
	public String toString() {
		return "Autor [nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + "]";
	}

	
}
