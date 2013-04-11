package br.com.senacrs.alp.aulas;

import java.util.Comparator;

import br.com.senacrs.alp.aulas.Lista;
import br.com.senacrs.alp.aulas.ListaImplementadaEmClasse;

public class ComparatorFactory {
	
	private static final ComparatorFactory instancia = new ComparatorFactory();
	
	private ComparatorFactory() {
	}
	
	public Comparator<Integer> criarComparatorParesAntesDeImparesCrescente() {
		
		Comparator<Integer> resultado = null;
		
		resultado = new ComparatorInteiros<T>();
		
		return resultado;
	}
	
	public Comparator<String> criarComparatorOrdemAlfabeticaReversa() {
		
		Comparator<String> resultado = null;
		
		//implementar
		
		return resultado;
	}
	
	public static ComparatorFactory getInstancia() {
		return instancia;
	}
}
