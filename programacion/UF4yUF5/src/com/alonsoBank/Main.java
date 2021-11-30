package com.alonsoBank;

public class Main {

    public static void main(String[] args) {
    	/* Test métodos Banco.java */
    	Banco Banco1 = new Banco("Banco1");
    	Banco1.crearCuenta("05323755Z", "fulanito");
    	Banco1.cambiarNombre("05323755Z", "BancoA"); 
    	System.out.println(Banco1.getNombreBanco());
	} 
}
