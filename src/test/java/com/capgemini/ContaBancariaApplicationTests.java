package com.capgemini;
import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ContaBancariaApplicationTests {

	@Test
	public void testLogarComSucesso() {
	    HardwareMock hardware = new HardwareMock();
	    hardware.setNumeroDaConta("11111-1");
	    ServicoRemoto servicoRemoto = new ServicoRemotoMock();
	    CaixaEletronico caixa = new CaixaEletronico(hardware, servicoRemoto);
	    
	    String resultado;
		try {
			resultado = caixa.logar();
			assertEquals("Usuário Autenticado", resultado);
		} catch (HardwareExceptions e) {
			assertEquals("Não foi possível autenticar o usuário", e);
		}
	    
	    
	}
	
	
	
	@Test
	public void testSacar() throws LeitorCartaoException, HardwareExceptions {
	    HardwareMock hardware = new HardwareMock();
	    hardware.setNumeroDaConta("11111-1");
	    ServicoRemoto servicoRemoto = new ServicoRemotoMock();
	    CaixaEletronico caixa = new CaixaEletronico(hardware, servicoRemoto);
	    ContaCorrente conta = servicoRemoto.recuperarConta("11111-1");
	    
	    String mensagem = caixa.sacar(200.0);

	    assertEquals("Retire seu dinheiro", mensagem);
	    assertEquals(800.0, conta.getSaldo(), 0.001);  
	}
	
	@Test
	public void testDepositar() throws EnvelopeException, LeitorCartaoException {
		HardwareMock hardware = new HardwareMock();
	    hardware.setNumeroDaConta("11111-1");
	    ServicoRemoto servicoRemoto = new ServicoRemotoMock();
	    CaixaEletronico caixa = new CaixaEletronico(hardware, servicoRemoto);
	    ContaCorrente conta = servicoRemoto.recuperarConta("11111-1");
	    
	    String mensagem = caixa.depositar(200.00);
	    
	    assertEquals("Depósito recebido com sucesso", mensagem);
	    assertEquals(1200.0, conta.getSaldo(), 0.001);
	}
	
	@Test
	public void testSaldo() throws HardwareExceptions {
		HardwareMock hardware = new HardwareMock();
	    hardware.setNumeroDaConta("11111-1");
	    ServicoRemoto servicoRemoto = new ServicoRemotoMock();
	    CaixaEletronico caixa = new CaixaEletronico(hardware, servicoRemoto);
	    ContaCorrente conta = servicoRemoto.recuperarConta("11111-1");
	    
	    String saldoAtual = caixa.saldo();
	    assertEquals("O saldo é R$ 1000,00", saldoAtual);
	    
	}


}
