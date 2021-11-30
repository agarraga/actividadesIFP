package com.alonsoBank;
import java.util.Set;
import java.util.HashSet;

public class Banco {
	private String nombreBanco;
    private Set<Cuenta> cuentas = new HashSet<Cuenta>();
    /* Con un Set en vez de un List, obligamos que las cuentas sean únicas*/
    public Banco(String nombreBanco) {
    	this.nombreBanco = nombreBanco;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void crearCuenta(String dni, String nombreCliente) {
        if (!dni.matches("\\d{8}[a-zA-Z]$")) {
            throw new IllegalArgumentException("DNI no valido");
        }  
        if(cuentas.stream().anyMatch(p -> p.getNumeroCuenta().equals(dni))) {
            throw new IllegalArgumentException("Esta cuenta ya existe");
        } else {
			Cuenta nuevaCuenta = new Cuenta(dni, nombreBanco);
            cuentas.add(nuevaCuenta);
        }
    }
    
    public void cambiarNombre(String dni, String nuevoNombre) {
    	Cuenta cuenta = cuentas.stream()
    			.filter(c -> c.getNumeroCuenta().equals(dni)).findAny()
    			.orElseThrow(()->new IllegalArgumentException("La cuenta no existe"));
    	cuenta.setNombreCliente(nuevoNombre);
    }
}