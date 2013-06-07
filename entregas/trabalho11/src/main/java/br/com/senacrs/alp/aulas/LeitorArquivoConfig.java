package br.com.senacrs.alp.aulas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LeitorArquivoConfig implements ArquivoConfiguracao {
	
	private static int QTD_PARAMS = 3;

	private String arquivoEntrada = null;
	private Map<String, String> mapa = new HashMap<String, String>();

	// Construtor: define arquivo de entrada e realiza inicializações
	public LeitorArquivoConfig(String arquivoEntrada) {
		this.arquivoEntrada = arquivoEntrada;
		verificarArquivo();
		lerArquivo();
	}

	// Realiza a leitura do arquivo de entrada
	private void lerArquivo() {
		File arquivo = new File(this.arquivoEntrada);
		FileReader fReader = null;
		BufferedReader bfReader = null;
		
		String linha, chave, valor = null;
		String[] chaveValor = new String[2];

		try {

			fReader = new FileReader(arquivo);
			bfReader = new BufferedReader(fReader);
			linha = bfReader.readLine();
			while (linha != null) {
				while (linha.contains("#")) {
					linha = tratarComentario(linha);
				}
				
				if (linha.contains("=")) {
					
					chaveValor = linha.split("=");
					if (chaveValor.length == 2) {
						chave = chaveValor[0].trim();
						valor = chaveValor[1].trim();
						mapa.put(chave, valor);
						verificarFormato();
					}
				}
				
				linha = bfReader.readLine();
			}

			verificaParametros();
			
			bfReader.close();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(e);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	// Verifica se a quantidade de parâmetros do arquivo está correto
	private void verificaParametros() {
		if (mapa.size() < QTD_PARAMS) {
			throw new IllegalArgumentException();
		}
	}

	// Verifica se a linha está no formato correto
	private void verificarFormato() {
		if (mapa.containsKey("root_dir")) {
			if (!mapa.get("root_dir").startsWith("./")) {
				throw new IllegalArgumentException();
			}
		}
		
		if (mapa.containsKey("port")) {
			if (Integer.parseInt(mapa.get("port")) < 1000) {
				throw new IllegalArgumentException();
			}
		}
	}

	private String tratarComentario(String linha) {
		String resultado = null;
		
		if (linha.startsWith("#")) {
			resultado = "";
		} else {
			String[] aux = linha.split("#");
			
			if (aux.length >= 2) {
				resultado = aux[0].trim();
			} else {
				throw new IllegalArgumentException();
			}
		}
		
		return resultado;
	}

	// Realiza verificações no arquivo.
	private void verificarArquivo() {
		File arquivo = new File(this.arquivoEntrada);
		
		if (!arquivo.exists()) {
			throw new IllegalArgumentException();
		}

		if (!arquivo.isFile()) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String getRootDir() {
		String resultado = null;
		
		if (mapa.containsKey("root_dir")) {
			if (mapa.get("root_dir").startsWith("./")) {
				resultado = mapa.get("root_dir");
			} else {
				throw new IllegalArgumentException();
			}
		}
		
		return resultado;
	}

	@Override
	public String getErrorDir() {
		String resultado = null;
		
		if (mapa.containsKey("error_dir")) {
			resultado = mapa.get("error_dir");
		}
		
		return resultado;
	}

	@Override
	public int getPort() {
		int resultado = 0;
		
		if (mapa.containsKey("port")) {
			resultado = Integer.parseInt(mapa.get("port"));
		}
		
		return resultado;
	}
}