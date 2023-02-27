package com.capgemini;

public interface Hardware {
	String pegarNumeroDaContaCartao() throws LeitorCartaoException;
    void entregarDinheiro() throws DispenserDeDinheiroException;
    void lerEnvelope() throws EnvelopeException;
}
