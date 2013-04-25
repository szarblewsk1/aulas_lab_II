package br.com.senacrs.alp.aulas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MeuLeitor implements LeitorArquivos {

	public String[] _lerArquivo(String arquivo) {
		try {
			BufferedReader arqv = new BufferedReader(new FileReader(arquivo));
			
			int i = 0;
			while (arqv.readLine() != null) {
				i++;
			}
			
			String linhas[] = new String[i];
			String linha;
			int cont = 0;
			do {
				linha = arqv.readLine();
				linhas[cont] = linha;
				
				cont++;
			} while (linha != null);
			
			arqv.close();
			return linhas;
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	
	
	public String[] lerArquivo(String arquivo) {
		
		String[] resultado = null;
		BufferedReader leitor = null;
		
		leitor = obterBufferedReader(arquivo);
		resultado = lerBufferedReader(leitor);
		
		return resultado;
	}
	
	// Obtem um BufferedReader de um arquivo
	private BufferedReader obterBufferedReader(String arquivo) {
		BufferedReader resultado = null;
		File file = null;
		FileReader reader = null;
		
		file = obterFileLeitura(arquivo);
		try {
			reader = new FileReader(file);
			resultado = new BufferedReader(reader);
		} catch (FileNotFoundException e) {
			throw new IllegalStateException(e);
		}
		
		return resultado;
	}

	private File obterFileLeitura(String arquivo) {
		File resultado = null;
		
		this.verificarNomeArquivo(arquivo);
		resultado = new File(arquivo);
		this.verificarFile(resultado);
		
		return resultado;
	}



	private String[] lerBufferedReader(BufferedReader leitor) {
		String[] resultado = null;
		String linha = null;
		List<String> lista = null;
		
		lista = new ArrayList<String>();
		try {
			linha = leitor.readLine();
			while (linha != null) {
				lista.add(linha);
				linha = leitor.readLine();
			}
			
			resultado = converterListaArray(lista);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
		
		return resultado;
	}

	// Faz todas as verificações para saber se pode manipular/trabalhar com um arquivo
	private void verificarFile(File file) {
		// Se não é nulo
		if (file == null) {
			throw new IllegalArgumentException();
		}
		
		// Se o arquivo existe
		if (!file.exists()) {
			throw new IllegalArgumentException();
		}
		
		// Se é um arquivo de fato
		if (!file.isFile()) {
			throw new IllegalArgumentException();
		}
		
		// Se tem permissão pra ler
		if (!file.canRead()) {
			throw new IllegalArgumentException();
		}
	}

	private void verificarNomeArquivo(String arquivo) {
		if (arquivo != null) {
			throw new IllegalArgumentException();
		}
		
		arquivo = arquivo.trim();
		if (arquivo.isEmpty()) {
			throw new IllegalArgumentException();
		}
	}
	
	private String[] converterListaArray(List<String> lista) {
		String[] resultado = null;
		
		resultado = new String[lista.size()];
		resultado = lista.toArray(resultado);
		
		return resultado;
	}

	@Override
	public String[] lerArquivoComSubstituicao(String arquivo, String busca,	String substituicao) {
		String[] resultado, parcial = null;
		String linha = null;
		
		parcial = this.lerArquivo(arquivo);
		resultado = new String[parcial.length];
		for (int i = 0; i < parcial.length; i++) {
			linha = parcial[i];
			resultado[i] = linha.replace(busca, substituicao);
		}
		
		return resultado;
	}

}
