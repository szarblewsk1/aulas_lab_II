package br.com.senacrs.alp.aulas;

import java.net.Socket;

public class Factory {
	
	private static final Factory instancia = new Factory();
	
	private Factory() {
	}
	
	public ManipuladorSocket criarManipulador(Socket socket) {
		
		ManipuladorSocket resultado = null;
		
		resultado = new ManipuladorSocket(socket);
		
		return resultado;
	}
	
	public ArquivoConfiguracao criarConfiguracao(String arquivoConfiguracao) {
		
		ArquivoConfiguracao resultado = new MeuArquivoConfiguracao(arquivoConfiguracao);
		
		return resultado;
	}

	public ResponderRequisicaoGet criarValidacao(ArquivoConfiguracao config) {
	
		ResponderRequisicaoGet resultado = new MeuResponderRequisicaoGet(config);
		
		return resultado;
	}
	
	public static Factory getInstancia() {
		
		return instancia;
	}
}
