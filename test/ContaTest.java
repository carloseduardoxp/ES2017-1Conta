
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import br.com.sistemaBancario.model.domain.Cliente;
import br.com.sistemaBancario.model.domain.Conta;
import br.com.sistemaBancario.util.ContaException;
import org.junit.Assert;

public class ContaTest {
		
	@Test
	public void testaSaldo() {
		Long numero = 8858l;
		Integer agencia = 345;	
		Double saldo = 100d;
		Cliente cliente = null;		
		Conta conta = new Conta(numero,agencia,saldo,cliente);
		assertEquals(conta.lerSaldo(),new Double(100),0.0001);
	}
	
	@Test
	public void testaSaqueComSaldo() {
		Long numero = 8858l;
		Integer agencia = 345;	
		Double saldo = 100d;
		Cliente cliente = null;		
		Conta conta = new Conta(numero,agencia,saldo,cliente);
		try {
			conta.saque(50d);
			assertEquals(conta.lerSaldo(),50d,0.0001);	
		} catch(ContaException e) {
			Assert.fail("Gerou a exceção "+e.getMessage());
		}
		
	}
	
	@Test
	public void testaSaqueSemSaldo() {
		Long numero = 8858l;
		Integer agencia = 345;	
		Double saldo = 100d;
		Cliente cliente = null;		
		Conta conta = new Conta(numero,agencia,saldo,cliente);
		try {
			conta.saque(101d);
			Assert.fail("Efetuou o saque de "+101);				
		} catch(ContaException e) {
		}
		
	}
	
	@Test
	public void testaDeposito() {
		Long numero = 8858l;
		Integer agencia = 345;	
		Double saldo = 100d;
		Cliente cliente = null;		
		Conta conta = new Conta(numero,agencia,saldo,cliente);
		conta.deposito(1000d);
		assertEquals(conta.lerSaldo(),1100d,0.0001);					
	}
	
	@Test
	public void testaTransferenciaSucesso() {
		Long numero = 8858l;
		Integer agencia = 345;	
		Double saldo = 100d;
		Cliente cliente = null;		
		Conta contaOrigem = new Conta(numero,agencia,saldo,cliente);
		
		numero = 5665l;
		agencia = 123;	
		saldo = 500d;		
		Conta contaDestino = new Conta(numero,agencia,saldo,cliente);
		try {
			contaOrigem.transferencia(contaDestino,50d);
			assertEquals(contaOrigem.lerSaldo(),50d,0.0001);					
			assertEquals(contaDestino.lerSaldo(),550d,0.0001);	
		} catch(ContaException e) {
			Assert.fail("Gerou a exceção "+e.getMessage());
		}		
	}
	
	@Test
	public void testaTransferenciaInsucesso() {
		Long numero = 8858l;
		Integer agencia = 345;	
		Double saldo = 100d;
		Cliente cliente = null;		
		Conta contaOrigem = new Conta(numero,agencia,saldo,cliente);
		
		numero = 5665l;
		agencia = 123;	
		saldo = 500d;		
		Conta contaDestino = new Conta(numero,agencia,saldo,cliente);
		try {
			contaOrigem.transferencia(contaDestino,150d);
			Assert.fail("Efetuou a transferência de "+150);				
		} catch(ContaException e) {
		}
	}

}
