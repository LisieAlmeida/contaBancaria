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
	    
	    // métodos sacar(), depositar() e saldo() serão implementados mais tarde
	}

	

	


