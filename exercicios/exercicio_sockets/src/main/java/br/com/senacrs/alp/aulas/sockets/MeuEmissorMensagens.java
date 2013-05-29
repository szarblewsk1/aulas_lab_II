package br.com.senacrs.alp.aulas.sockets;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MeuEmissorMensagens implements EmissorMensagens {
	String arquivoEntrada;
	
	@Override
	public String formatarMensagem(String chave, Object... argumentos) {
		
		String resultado = null;
		
		try {
			FileReader file = new FileReader(arquivoEntrada);
			BufferedReader bfReader = new BufferedReader(file);
			
			boolean temLinha = false;
			String linha = bfReader.readLine();
			
			while (linha != null) {
				String l[] = linha.split("=");
				if (l[0].trim().equals(chave)) {
					resultado = String.format(l[1].trim(), argumentos);
					temLinha = true;
				}
				
				linha = bfReader.readLine();
			}
			
			if (temLinha == false) {
				throw new IllegalArgumentException();
			}
			
			file.close();
			bfReader.close();
		} catch (IOException ex) {
			ex.printStackTrace(); // Coloca o possível erro de try na exceção
		}
		
		return resultado;
	}
	
	public MeuEmissorMensagens(String arquivoEntrada) {
		
		this.arquivoEntrada = arquivoEntrada;
		File arquivo = obterArquivo(arquivoEntrada);
		
		verificaFormato(arquivo);
	}
	
	private File obterArquivo(String arquivo) {
		
		File resultado = null;
		
		if (arquivo == null) {
			throw new IllegalArgumentException();
		} else {
			resultado = new File(arquivo);
			verificarArquivo(resultado);
		}
		
		return resultado;
	}

	private void verificarArquivo(File arquivo) {
		
		if (arquivo == null) {
			throw new IllegalArgumentException();
		}
		if (!arquivo.exists()) {
			throw new IllegalArgumentException();
		}
		if (!arquivo.isFile()) {
			throw new IllegalArgumentException();
		}
		if (!arquivo.canRead()) {
			throw new IllegalArgumentException();
		}
	}
	
	private void verificaFormato(File arquivo) {
		try {
			FileReader file = new FileReader(arquivo);
			BufferedReader bfReader = new BufferedReader(file);
			
			String a[] = bfReader.readLine().split("=");
			if (a.length != 2) {
				throw new IllegalArgumentException();
			}
		} catch (IOException e) {
			e.printStackTrace(); // Coloca o possível erro de try na exceção
		}
	}
}