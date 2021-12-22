package com.alonsobank;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.time.LocalDate;

public class Banco {
    private String nombreBanco;
    private DAO dao;

    public Banco(String nombreBanco, DAO dao) {
    	this.nombreBanco = nombreBanco;
        this.dao = dao;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public List<Cuenta> getCuentas() {
        return dao.getCuentas();
    }

    public List<Cuenta> getCuentas(String dni, String nombre) {
        return dao.getCuentas(dni, nombre);
    }

    public Cuenta getCuenta(String dni) {
        return dao.getCuenta(dni);
    }

    public void crearCuenta(String dni, String nombreCliente) {
        if (!dni.matches("\\d{8}[a-zA-Z]$")) {
            throw new IllegalArgumentException("DNI no valido");
        }  
        if(dao.getCuenta(dni) != null) {
            throw new IllegalArgumentException("Esta cuenta ya existe");
        } else {
            LocalDate fecha = LocalDate.now();
            dao.addRow(dni, nombreCliente, 0f, fecha);
        }
    }

    public void eliminarCuenta(String dni) {
        dao.eliminarCuenta(dni);
    }
    
    public void cambiarNombre(String dni, String nuevoNombre) {
        dao.modificarNombre(dni, nuevoNombre);
    }

    public void hacerTransferencia(String dniRemitente, String dniDestinatario, Float importe) {
        Cuenta remitente = dao.getCuenta(dniRemitente);
        Cuenta destinatario = dao.getCuenta(dniDestinatario);
        if (remitente.hacerTransferencia(destinatario, importe)) {
            dao.modificarSaldo(dniRemitente, -importe);
            dao.modificarSaldo(dniDestinatario, importe);
        } else { 
            System.err.println("No es posible hacer la transferencia");
        }
    }

    public void ingresar(String dni, Float cantidad) {
        if (cantidad > 0) {
            dao.modificarSaldo(dni, cantidad);
        } else {
            System.err.println("La cantidad ha de ser un numero positivo");
        }
    }
    
    public void retirar(String dni, Float cantidad) {
        if (getCuenta(dni).hacerExtraccion(cantidad)) {
            dao.modificarSaldo(dni, -cantidad);
        } else {
            System.err.println("La cuenta no tiene saldo para extraccion");
        }

    }

    public void exportarCSV(List<Cuenta> cuentas, String ruta) {
        String delimitador = ";";
        String nuevaLinea = "\n";
        // String cabezera = "NUMERO CUNENTA;NOMBRE CLIENTE;SALARIO;FECHA CREACIÓN";
        try {
            FileWriter fw = new FileWriter(ruta);
            BufferedWriter bw = new BufferedWriter(fw); 

            // bw.write(cabezera);
            for (Cuenta cuenta : cuentas) {
                bw.append(cuenta.getNumeroCuenta());
                bw.append(delimitador);
                bw.append(cuenta.getNombreCliente());
                bw.append(delimitador);
                bw.append(cuenta.getSaldoDosDecimales());
                bw.append(delimitador);
                bw.append(cuenta.getFechaCreacion().toString());
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
            String linea; 

            while ((linea = br.readLine()) != null) {
                String[] celdas = linea.split(";");
                if(dao.getCuenta(celdas[0]) == null){
                    String dni = celdas[0];
                    String nombreCliente = celdas[1];
                    Float saldo = Float.parseFloat(celdas[2]);
                    LocalDate fechaCreacion = LocalDate.parse(celdas[3]);
                    dao.addRow(dni, nombreCliente, saldo, fechaCreacion);
                }
            }
        } catch (IOException ex) {
            System.out.println("Error de IO");
        }
    }
}