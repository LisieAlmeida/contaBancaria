package com.capgemini;

public class ContaCorrente {
	    private String numero;
	    private String senha;
	    private double saldo;
	    
	    public ContaCorrente(String numero, String senha, double saldo) {
	        this.numero = numero;
	        this.senha = senha;
	        this.saldo = saldo;
	    }
	    
	    public String getNumero() {
	        return numero;
	    }
	    
	    public String getSenha() {
	        return senha;
	    }
	    
	    public double getSaldo() {
	        return saldo;
	    }
	    
	    public void setSaldo(double saldo) {
	        this.saldo = saldo;
	    }
}




