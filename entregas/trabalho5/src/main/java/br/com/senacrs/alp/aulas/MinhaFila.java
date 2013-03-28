package br.com.senacrs.alp.aulas;

public class MinhaFila<T> implements Fila<T> {
	
	private Lista<T> lista = ListaFactory.getInstancia().criarLista();

	@Override
	public void insercao(T valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T obter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remocao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean vazia() {
		// TODO Auto-generated method stub
		return false;
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
