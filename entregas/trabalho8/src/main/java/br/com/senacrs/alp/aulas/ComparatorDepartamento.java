package br.com.senacrs.alp.aulas;

import java.util.Comparator;

public class ComparatorDepartamento implements Comparator<Departamento> {

	@Override
	public int compare(Departamento depto1, Departamento depto2) {

		int resultado = 0;
	
		if (depto1.quantidadeFuncionarios() < depto2.quantidadeFuncionarios()) {
			resultado = 1;
		} else if (depto1.quantidadeFuncionarios() > depto2.quantidadeFuncionarios()) {
			resultado = -1;
		} else {
			resultado = 0;
		}
		
		return resultado;
	}
}