package com.capgemini;

public interface ServicoRemoto {
	ContaCorrente recuperarConta(String numeroDaConta);
    void persistirConta(ContaCorrente contaCorrente);
}
