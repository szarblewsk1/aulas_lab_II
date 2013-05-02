package br.com.senacrs.alp.aulas;

public class MeuEmissorMensagens implements EmissorMensagens {

	@Override
	public String formatarMensagem(String chave, Object... argumentos) {
		
		this.verificaMensagem(chave);
		//System.out.println(chave);
		
		return null;
	}

	private void verificaMensagem(String chave) {
		if (chave == null) {
			throw new IllegalArgumentException();
		}
		
		if (chave == null) {
			throw new IllegalArgumentException();
		}
		
	}

}
