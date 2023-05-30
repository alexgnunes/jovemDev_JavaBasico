package br.com.trier.medicamento;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.medicamento.enuns.EnumAdministracao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Medicamento {
	private Integer idMedicamento;
	private String nomeMedicamento;
	private EnumAdministracao administracao;

	List<String> alergias = new ArrayList<>();
	List<String> indicacoes = new ArrayList<>();

	public Medicamento(String nomeMedicamento, EnumAdministracao administracao, List<String> alergias,
			List<String> indicacoes) {
		this.nomeMedicamento = nomeMedicamento;
		this.administracao = administracao;
		this.alergias = alergias;
		this.indicacoes = indicacoes;
	}

}
