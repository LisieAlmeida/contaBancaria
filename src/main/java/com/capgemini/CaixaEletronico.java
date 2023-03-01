package com.capgemini;

public class CaixaEletronico {
	    private Hardware hardware;
	    private ServicoRemoto servicoRemoto;
	    private ContaCorrente conta;
	  
	    
	    public CaixaEletronico(Hardware hardware, ServicoRemoto servicoRemoto) {
	        this.hardware = hardware;
	        this.servicoRemoto = servicoRemoto;
	    }
	    
	    public String logar() throws HardwareExceptions {
	        String numeroDaConta = hardware.pegarNumeroDaContaCartao();
	        conta = servicoRemoto.recuperarConta(numeroDaConta);
	        if (conta != null) {
	            return "Usuário Autenticado";
	        } else {
	            return "Não foi possível autenticar o usuário";
	        }
	    }

	    public String sacar(double valor) throws LeitorCartaoException, SaldoInsuficienteException, DispenserDeDinheiroException {
	    	String numeroDaConta = hardware.pegarNumeroDaContaCartao();
	        conta = servicoRemoto.recuperarConta(numeroDaConta);
	        
	        if (valor > conta.getSaldo()) {
	            throw new SaldoInsuficienteException("Saldo insuficiente");
	        }
	        double novoSaldo = conta.getSaldo() - valor;
	        conta.setSaldo(novoSaldo);
	        servicoRemoto.persistirConta(conta);
	        hardware.entregarDinheiro();
	        return "Retire seu dinheiro";
	    }

		public String depositar(double valor)throws LeitorCartaoException, EnvelopeException {
			String numeroDaConta = hardware.pegarNumeroDaContaCartao();
	        conta = servicoRemoto.recuperarConta(numeroDaConta);
	        
	        double novoSaldo = conta.getSaldo() + valor;
	        conta.setSaldo(novoSaldo);
	        servicoRemoto.persistirConta(conta);
	        hardware.lerEnvelope();
	        return "Depósito recebido com sucesso";
		}

		public String saldo() throws HardwareExceptions {
		    String numeroConta = hardware.pegarNumeroDaContaCartao();
		    ContaCorrente conta = servicoRemoto.recuperarConta(numeroConta);

		    Double saldo = conta.getSaldo();

		    return "O saldo é R$ " + String.format("%.2f", saldo);
		}
	
	    
	}

	

	


