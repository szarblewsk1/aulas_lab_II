package br.com.senacrs.alp.aulas.sockets;

public class Factory {
	
	private static final Factory instancia = new Factory();
	
	private Factory() {
	}
	
	public EmissorMensagens criarEmissor(String arquivoEntrada) {
	
		if (arquivoEntrada == null) {
			throw new IllegalArgumentException();
		}
		
		EmissorMensagens resultado = null;
		
		resultado = new MeuEmissorMensagens(arquivoEntrada);
		
		return resultado;
	}
	
	public static Factory getInstancia() {
		return instancia;
	}
}
