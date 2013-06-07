package br.com.senacrs.alp.aulas;

public class Factory {
	
	private static final Factory instancia = new Factory();
	
	private Factory() {
	}
	
	public ArquivoConfiguracao criarArquivoConfiguracao(String arquivoEntrada) {
	
		if (arquivoEntrada == null) {
			throw new IllegalArgumentException();
		}
		
		ArquivoConfiguracao resultado = null;
		
		resultado = new LeitorArquivoConfig(arquivoEntrada);
		
		return resultado;
	}
	
	public static Factory getInstancia() {
		return instancia;
	}
}
