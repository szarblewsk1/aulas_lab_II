package br.com.senacrs.alp.aulas;

public class ListaImplementadaEmClasse<T> 
	implements Lista<T> { 
	
	private Nodo<T> inicio = new Nodo<T>();
	

	@Override
	public void adicionarFinal(T valor) {
		this.adicionarPosicao(this.obterTamanho(), valor);
	}

	@Override
	public void adicionarInicio(T valor) {
		this.adicionarPosicao(0, valor);
	}

	@Override
	public void adicionarPosicao(int posicao, T valor) {
		Nodo<T> anterior = null;
		Nodo<T> novo = null;
		
		if (valor == null) {
			throw new IllegalArgumentException();
		}
		
		if (posicao < 0) {
			throw new IllegalArgumentException();
		}
		
		if (posicao > this.obterTamanho()) {
			throw new IllegalArgumentException();
		}
		
		novo = new Nodo<T>();
		novo.conteudo = valor;
		anterior = this.obterNodoPosicao(posicao - 1);
		novo.proximo = anterior.proximo;
		anterior.proximo = novo;
	}

	@Override
	public T obterPrimeiro() {
		
		return this.obterPosicao(0);
	}

	@Override
	public T obterUltimo() {
		
		return this.obterPosicao(this.obterTamanho() - 1);
	}

	@Override
	public T obterPosicao(int posicao) {
		
		Nodo<T> nodo = null;
		
		if (posicao < 0) {
			throw new IllegalArgumentException();
		}
		
		if (posicao >= this.obterTamanho()) {
			throw new IllegalArgumentException();
		}
		
		nodo = this.obterNodoPosicao(posicao);
		
		return nodo.conteudo;
	}
	
	private Nodo<T> obterNodoPosicao(int posicao) {
		Nodo<T> nodo = this.inicio;
		
		int cont = -1;
		if (posicao == cont) {
			return nodo;
		} else {
			while (cont < posicao) {
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
		Nodo<T> anterior = null;
		Nodo<T> nodo = null;
		
		if (posicao < 0) {
			throw new IllegalArgumentException();
		}
		
		if (posicao >= this.obterTamanho()) {
			throw new IllegalArgumentException();
		}
		
		anterior = obterNodoPosicao(posicao - 1);
		nodo = anterior.proximo;
		anterior.proximo = nodo.proximo;
		
		return nodo.conteudo;
	}

	@Override
	public void esvaziar() {
		this.inicio.proximo = null;		
	}

}
