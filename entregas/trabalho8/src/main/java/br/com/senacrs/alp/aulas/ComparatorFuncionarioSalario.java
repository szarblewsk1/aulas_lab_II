package br.com.senacrs.alp.aulas;

import java.util.Comparator;

public class ComparatorFuncionarioSalario implements Comparator<Funcionario> {

	@Override
	public int compare(Funcionario salario1, Funcionario salario2) {
		int resultado = 0;
		
		if (salario1.getSalario() < salario2.getSalario()) {
			resultado = 1;
		} else if (salario1.getSalario() > salario2.getSalario()) {
			resultado = -1;
		} else {
			resultado = 0;
		}
		
		return resultado;
	}
}