package br.com.senacrs.alp.aulas;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MinhaEmpresa implements Empresa {
	
	ArrayList<Departamento> lista = new ArrayList<Departamento>();
	
	private String nome;
	
	public MinhaEmpresa(String nome) {
		if (nome == null) {
			throw new IllegalArgumentException();
		}
		
		this.nome = nome;
	}
	
	@Override
	public String getNome() {
		return this.nome;
	}
	
	@Override
	public List<Departamento> listaDepartamentoOrdemCrescentePorQtdFuncionarios() {
		ComparatorDepartamento compDepto = new ComparatorDepartamento();
		Collections.sort(lista, compDepto);
		return lista;
	}
	
	@Override
	public void adicionarDepartamento(Departamento departamento) {
		if (departamento == null) {
			throw new IllegalArgumentException();
		}
		
		lista.add(departamento);
	}
	
	@Override
	public int quantidadeFuncionarios() {
		int i = 0;
		int soma = 0;
		
		while (i < lista.size()) {
			soma += lista.get(i).quantidadeFuncionarios();
			i++;
		}
		
		return soma;
	}
}