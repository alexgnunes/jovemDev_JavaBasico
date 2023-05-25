package br.com.trier.aula_3.livros;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Autor {
	private String nomeAutor;
	private Integer idade;
	private EnumSexo sexo;
	
	public Autor() {
	}

	public Autor(String nomeAutor, int idade, EnumSexo sexo) {
		this.nomeAutor = nomeAutor;
		this.idade = idade;
		this.sexo = sexo;
	}

	public String getNome() {
		return nomeAutor;
	}

	public void setNome(String nomeAutor) {
		this.nomeAutor = nomeAutor;
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

	public void cadastrarAutor() {
		EnumSexo[] opcoesSexo = EnumSexo.values();
		nomeAutor = JOptionPane.showInputDialog(null, "Digite o nome do autor:", "Cadatrar autor", JOptionPane.QUESTION_MESSAGE).toLowerCase();
		EnumSexo sexoSelecionado = (EnumSexo) JOptionPane.showInputDialog(null, "Selecione o sexo:", "Cadatrar autor",
				JOptionPane.QUESTION_MESSAGE, null, opcoesSexo, opcoesSexo[0]);
		sexo = sexoSelecionado;
		idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a idade do autor:", "Cadatrar autor", JOptionPane.QUESTION_MESSAGE));
		
		
	}

	@Override
	public String toString() {
		return "Autor [nome=" + nomeAutor + ", idade=" + idade + ", sexo=" + sexo + "]";
	}	
}
