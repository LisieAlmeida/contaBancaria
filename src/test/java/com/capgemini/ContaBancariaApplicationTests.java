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

}
