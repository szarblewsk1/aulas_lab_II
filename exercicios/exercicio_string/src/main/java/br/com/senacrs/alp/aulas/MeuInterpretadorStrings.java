package br.com.senacrs.alp.aulas;

public class MeuInterpretadorStrings implements InterpretadorStrings {

	@Override
	public TIPO_STRING lerString(String str) {
		
		TIPO_STRING resultado = null;
		
		if (str == null) {
			resultado = TIPO_STRING.MAL_FORMADA;
		} else if (ehComentario(str)) {
			resultado = TIPO_STRING.COMENTARIO;
		} else if (ehBemFormada(str)) {
			resultado = TIPO_STRING.BEM_FORMADA;
		} else {
			resultado = TIPO_STRING.MAL_FORMADA;
		}
		
		return resultado;
	}

	private boolean ehComentario(String str) {
		boolean resultado = false;
		
		resultado = str.trim().startsWith(PREFIXO_COMENTARIO);
		
		return resultado;
	}
	
	private boolean ehBemFormada(String str) {
		boolean resultado = false;
		String[] strings = null;
		
		strings = str.split(SEPARADOR);
		resultado = (strings.length == 2 && existeString(strings[0]) && existeString(strings[1]));
		
		return resultado;
	}
	
	private boolean existeString(String string) {
		boolean resultado = false;
		
		resultado = (string != null && !string.trim().isEmpty());
		
		return resultado;
	}
}
