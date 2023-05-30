package br.com.trier.medicamento.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.medicamento.Pessoa;
import br.com.trier.medicamento.Medicamento;

public class BancoDadosPrescricao {

	List<Pessoa> pessoas = new ArrayList<>();
	List<Medicamento> medicamentos = new ArrayList<>();
	
	public List<Medicamento> cadastraMedicamento(Medicamento medicamento) {
		medicamento.setIdMedicamento(medicamentos.size() + 1);
		medicamentos.add(medicamento);	
		return medicamentos;
	}
	
	public void cadastraPessoa(Pessoa pessoa) {
		pessoa.setIdPessoa(pessoas.size() + 1);
		pessoas.add(pessoa);		
	}
}
