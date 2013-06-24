package br.com.senacrs.alp.aulas;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

public class ObterCaminhoAbsoluto implements ObterPathRequisicaoGet {

	private static final String ESPACO_BRANCO = " ";
	private static String PWD = System.getProperty("user.dir");
	private static String PATH = "/";
	private static final String GET = "GET " + PATH;

	@Override
	public String caminhoAbsoluto(Reader requisicao) {

		String resultado = null;
		String texto = null;

		if (requisicao == null) {

			throw new IllegalArgumentException();
		}

		try {

			texto = lerReader(requisicao);

		} catch (IOException e) {

			throw new IllegalArgumentException(e);
		}

		String[] linhas = texto.split(NOVA_LINHA);

		resultado = testarGet(linhas[0]);

		return resultado;
	}

	private String testarGet(String get) {

		String resultado = null;
		String aux = null;

		if (get.startsWith(GET)) {

			resultado = PWD + PATH.replace("/", File.separator);

			aux = get.substring(GET.length());

			String[] res = aux.split(ESPACO_BRANCO);

			resultado += res[0];

		}

		else {

			resultado = null;

		}

		return resultado;
	}

	private String lerReader(Reader requisicao) throws IOException {

		StringBuilder res = new StringBuilder();
		String resultado = null;
		int i = requisicao.read();
		Character c;

		while (i != -1) {

			c = (char) i;
			res.append(c);
			i = requisicao.read();
		}

		if (res.toString().endsWith(NOVA_LINHA)) {

			resultado = res.toString();

		} else {

			resultado = "erro";
		}

		return resultado;
	}

}