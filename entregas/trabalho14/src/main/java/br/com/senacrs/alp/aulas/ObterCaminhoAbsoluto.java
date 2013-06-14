package br.com.senacrs.alp.aulas;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

public class ObterCaminhoAbsoluto implements ObterPathRequisicaoGet {

	@Override
	public String caminhoAbsoluto(Reader requisicao) {
		String resultado = null;
		
		if (requisicao == null) {
			throw new IllegalArgumentException();
		}

		return resultado;
	}

}