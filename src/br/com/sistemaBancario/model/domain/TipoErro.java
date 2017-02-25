package br.com.sistemaBancario.model.domain;

public enum TipoErro {
	
	SALDO_INSUFICIENTE(1,"saldo insuficiente"),
	LIMITE_EXCEDIDO(2,"limite excedido");
	
	private Integer codigoErro;
	
	private String mensagemErro;

	private TipoErro(Integer codigoErro, String mensagemErro) {
		this.codigoErro = codigoErro;
		this.mensagemErro = mensagemErro;
	}

	public Integer getCodigoErro() {
		return codigoErro;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}
	
	
	
}
