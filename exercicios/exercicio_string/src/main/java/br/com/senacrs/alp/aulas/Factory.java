package br.com.senacrs.alp.aulas;

public class Factory {
	
	private static final Factory instancia = new Factory();
	
	private Factory() {
	}
	
	public InterpretadorStrings criarInterpretador() {
	
		InterpretadorStrings resultado = null;
		
		resultado = new MeuInterpretadorStrings();
		
		return resultado;
	}
	
	public static Factory getInstancia() {
		return instancia;
	}
}
