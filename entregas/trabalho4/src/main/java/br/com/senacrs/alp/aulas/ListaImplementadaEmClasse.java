package br.com.senacrs.alp.aulas;

import br.com.senacrs.alp.aulas.*;

// Lista implementada em classe
public class ListaImplementadaEmClasse<T> 
	implements Lista<T> {
	
	private Nodo<T> inicio = new Nodo<T>();
	

	@Override
	public void adicionarFinal(T valor) {
		/*T nodo = this.obterUltimo();
		nodo = valor;*/
	}

	@Override
	public void adicionarInicio(T valor) {
		T nodo = this.obterPrimeiro();
		if (valor != null) {
			nodo = valor;
		}
	}

	@Override
	public void adicionarPosicao(int posicao, T valor) {
		/*T nodo = this.obterPosicao(posicao);
		nodo = valor;*/
	}

	@Override
	public T obterPrimeiro() {
		return this.obterPosicao(0);
	}

	@Override
	public T obterUltimo() {
		return this.obterPosicao(this.obterTamanho()-1);
	}

	@Override
	public T obterPosicao(int posicao) {
		Nodo<T> nodo = null;
		
		nodo = this.obterNodoPosicao(posicao);
		
		return nodo.conteudo;
	}
	
	private Nodo<T> obterNodoPosicao(int posicao) {
		Nodo<T> nodo = this.inicio;
		
		int cont = -1;
		if (posicao == cont) {
			return nodo;
		} else {
			while (cont != posicao) {
				nodo = nodo.proximo;
				cont++;
			}
			
			return nodo;
		}
	}

	@Override
	public int obterTamanho() {
		
		int resultado = 0;
		Nodo<T> nodo = null;
		
		nodo = this.inicio;
		while (nodo.proximo != null) {
			nodo = nodo.proximo;
			resultado++;
		}
		
		return resultado;
	}

	@Override
	public T removerPosicao(int posicao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void esvaziar() {
		// TODO Auto-generated method stub
		
	}

}
