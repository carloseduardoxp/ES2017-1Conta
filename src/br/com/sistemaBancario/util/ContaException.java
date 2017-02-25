package br.com.sistemaBancario.util;

import br.com.sistemaBancario.model.domain.TipoErro;

public class ContaException extends Exception {
	
	private TipoErro tipoErro;
	
	public ContaException(TipoErro tipoErro) {
		super(tipoErro.getMensagemErro());
		this.tipoErro = tipoErro;		
	}

	public TipoErro getTipoErro() {
		return tipoErro;
	}
	
	

}
