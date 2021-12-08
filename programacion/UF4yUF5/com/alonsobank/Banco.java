package com.alonsobank;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Banco {
    private String nombreBanco;
    private List<Cuenta> cuentas;

    public Banco(String nombreBanco) {
    	this.nombreBanco = nombreBanco;
        cuentas = new ArrayList<>();
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    } 

    public void crearCuenta(String dni, String nombreCliente) {
        if (!dni.matches("\\d{8}[a-zA-Z]$")) {
            throw new IllegalArgumentException("DNI no valido");
        }  
        if(cuentas.stream().anyMatch(p -> p.getNumeroCuenta().equals(dni))) {
            throw new IllegalArgumentException("Esta cuenta ya existe");
        } else {
	    Cuenta nuevaCuenta = new Cuenta(dni, nombreCliente);
            cuentas.add(nuevaCuenta);
        }
    }
    
    public void cambiarNombre(String dni, String nuevoNombre) {
    	Cuenta cuenta = cuentas.stream()
    			.filter(c -> c.getNumeroCuenta().equals(dni)).findFirst()
    			.orElseThrow(()->new IllegalArgumentException("La cuenta no existe"));
    	cuenta.setNombreCliente(nuevoNombre);
    }

    public boolean cuentaExiste(String dni) {
        for (Cuenta cuenta : cuentas) {
            if(cuenta.getNumeroCuenta().equals(dni)) {
                return true;
            }
        } 
        return false;
    }

    public Cuenta encontrarCuenta(String dni) {
    	Cuenta cuenta = cuentas.stream()
  			.filter(c -> c.getNumeroCuenta().equals(dni)).findFirst()
  			.orElseThrow(()->new IllegalArgumentException("La cuenta no existe"));
        return cuenta;
    }

    public void exportarCSV(List<Cuenta> cuentas, String ruta) {
        String delimitador = ";";
        String nuevaLinea = "\n";
        // String cabezera = "NUMERO CUNENTA;NOMBRE CLIENTE;SALARIO;FECHA CREACIÓN";
        try {
            FileWriter fw = new FileWriter(ruta);
            BufferedWriter bw = new BufferedWriter(fw); 
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");

            // bw.write(cabezera);
            for (Cuenta cuenta : cuentas) {
                bw.append(cuenta.getNumeroCuenta());
                bw.append(delimitador);
                bw.append(cuenta.getNombreCliente());
                bw.append(delimitador);
                bw.append(cuenta.getSaldoDosDecimales());
                bw.append(delimitador);
                bw.append(df.format(cuenta.getFechaCreacion()));
                bw.append(nuevaLinea);
            }
            bw.flush();
        } catch (IOException ex) {
            System.out.println("Error de IO");
        }
    }

    public void importarCSV(String ruta) { 
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
            
            String linea; 

            while ((linea = br.readLine()) != null) {
                String[] celdas = linea.split(";");
                if(!cuentaExiste(celdas[0])){
                    String dni = celdas[0];
                    String nombreCliente = celdas[1];
                    Double saldo = Double.parseDouble(celdas[2]);
                    Date fechaCreacion;
                    try {
                        fechaCreacion = df.parse(celdas[3]);
                    } catch (ParseException ex) {
                        fechaCreacion = new Date();
                        System.out.println("No se pudo parsear fecha, hemos puesto la actual");
                    }
                    Cuenta cuenta = new Cuenta(dni, nombreCliente, saldo, fechaCreacion);
                    cuentas.add(cuenta);
                }
            }
        } catch (IOException ex) {
            System.out.println("Error de IO");
        }
    }
}