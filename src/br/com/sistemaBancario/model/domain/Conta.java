package br.com.sistemaBancario.model.domain;

import br.com.sistemaBancario.util.ContaException;

public class Conta {
	
	private Long numero;
	
	private Integer agencia;
	
	private Double saldo;
	
	private Cliente cliente;
	
	public Conta(Long numero, Integer agencia, Double saldo, Cliente cliente) {
		this.numero = numero;
		this.agencia = agencia;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	public void saque(Double valor) throws ContaException {
		if (saldo - valor < 0) {
			throw new ContaException(TipoErro.SALDO_INSUFICIENTE);
		}
		saldo -= valor;		
	}
	
	public Double lerSaldo() {
		return saldo;
	}
	
	public void deposito(Double valor) {
		this.saldo += valor;
	}
	
	public void transferencia(Conta conta,Double valor) throws ContaException {
		saque(valor);
		conta.deposito(valor);				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
