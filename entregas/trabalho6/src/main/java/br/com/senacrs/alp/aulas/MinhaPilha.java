package br.com.senacrs.alp.aulas;

public class MinhaPilha<T> implements Pilha<T> {
	
	private Lista<T> lista = ListaFactory.getInstancia().criarLista();

	@Override
	public void insercao(T valor) {
		lista.adicionarInicio(valor);
	}

	@Override
	public T obter() {
		return lista.obterPosicao(0);
	}

	@Override
	public T remocao() {
		return lista.removerPosicao(0);
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
