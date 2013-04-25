package br.com.senacrs.alp.aulas;

public class MeuInterpretadorStrings implements InterpretadorStrings {

	@Override
	public TIPO_STRING lerString(String str) {
		
		TIPO_STRING resultado = null;
		
		if (ehComentario(str)) {
			resultado = TIPO_STRING.COMENTARIO;
		} else if (ehBemFormada(str)) {
			resultado = TIPO_STRING.BEM_FORMADA;
		} else {
			resultado = TIPO_STRING.MAL_FORMADA;
		}
		
		return null;
	}

	private boolean ehComentario(String str) {
		boolean resultado = false;
		
		
		
		return false;
	}
	
	private boolean ehBemFormada(String str) {
		// TODO Auto-generated method stub
		return false;
	}

}
