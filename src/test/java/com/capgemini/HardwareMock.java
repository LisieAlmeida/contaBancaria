package com.capgemini;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HardwareMock implements Hardware {
	private String numeroDaConta;
    private boolean dinheiroEntregue;
    private boolean envelopeLido;
    private boolean falhaNoHardware;
    
     

	public void setNumeroDaConta(String numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
        this.falhaNoHardware = false;
    }

    public void setDinheiroEntregue(boolean dinheiroEntregue) {
        this.dinheiroEntregue = dinheiroEntregue;
    }

    public void setEnvelopeLido(boolean envelopeLido) {
        this.envelopeLido = envelopeLido;
    }

    public void setFalhaNoHardware(boolean falhaNoHardware) {
        this.falhaNoHardware = falhaNoHardware;
    }

    @Override
    public String pegarNumeroDaContaCartao() throws LeitorCartaoException {
        if (falhaNoHardware) {
            throw new LeitorCartaoException ("Falha no leitor de cartão");
        }
        return numeroDaConta;
    }

    @Override
    public void entregarDinheiro() throws DispenserDeDinheiroException {
        if (falhaNoHardware) {
            throw new DispenserDeDinheiroException("Falha na entrega de dinheiro");
        }
        dinheiroEntregue = true;
    }

    @Override
    public void lerEnvelope() throws EnvelopeException {
        if (falhaNoHardware) {
            throw new EnvelopeException("Falha na leitura do envelope");
        }
        envelopeLido = true;
    }

}

	

