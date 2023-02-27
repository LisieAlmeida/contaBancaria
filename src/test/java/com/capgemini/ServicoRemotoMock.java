package com.capgemini;

import java.util.HashMap;
import java.util.Map;

public class ServicoRemotoMock implements ServicoRemoto {
	private Map<String, ContaCorrente> contas;

    public ServicoRemotoMock() {
        contas = new HashMap<>();
        ContaCorrente conta1 = new ContaCorrente("11111-1", "senha", 1000.0);
        ContaCorrente conta2 = new ContaCorrente("22222-2", "outrasenha", 500.0);
        contas.put(conta1.getNumero(), conta1);
        contas.put(conta2.getNumero(), conta2);
    }

    @Override
    public ContaCorrente recuperarConta(String numero) {
        return contas.get(numero);
    }

    @Override
    public void persistirConta(ContaCorrente conta) {
        contas.put(conta.getNumero(), conta);
    }

}
