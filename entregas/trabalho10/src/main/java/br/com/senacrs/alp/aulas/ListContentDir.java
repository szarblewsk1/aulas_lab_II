package br.com.senacrs.alp.aulas;

import java.io.File;

public class ListContentDir implements ListaConteudoDiretorio {

	@Override
	public String[] listarConteudo(File diretorio) {
		File fList[] = diretorio.listFiles();
		
		System.out.println("Numero de arquivos no diretorio : " + fList.length);
		
		String[] retorno = new String();
		
		if (fList.length > 1) {
			for ( int i = 0; i < fList.length; i++ ) {
				//System.out.println(fList.getName() +" " + new Date(fList.lastModified())); 
				System.out.println(fList[i]);
				retorno[i] += fList[i];
			}
			
			retorno[0] += fList[0];
		}
		
		return retorno;
	}

}
