package br.com.senacrs.alp.aulas;

public class MinhaFila<T> implements Fila<T> {
	
	private Lista<T> lista = ListaFactory.getInstancia().criarLista();

	@Override
	public void insercao(T valor) {
		lista.adicionarFinal(valor);
	}

	@Override
	public T obter() {
		return lista.obterPosicao(lista.obterTamanho());
	}

	@Override
	public T remocao() {
		return lista.removerPosicao(lista.obterTamanho() - 1);
	}

	@Override
	public boolean vazia() {
		if (lista.obterTamanho() > 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public int tamanho() {
		return lista.obterTamanho();
	}

	@Override
	public void esvaziar() {
		lista.esvaziar();
	}

}
