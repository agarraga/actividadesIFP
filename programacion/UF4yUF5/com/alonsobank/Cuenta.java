package com.alonsobank;

import java.util.Date;

public class Cuenta {
    private String numeroCuenta;
    private String nombreCliente;
    private Double saldo;
    private Date fechaCreacion;

    public Cuenta(String numeroCuenta, String nombreCliente ) {
        this.numeroCuenta = numeroCuenta; 
        this.nombreCliente = nombreCliente; 
        saldo = 0d;
        fechaCreacion = new Date(); 
    }

    public Cuenta(String numeroCuenta, String nombreCliente, Double saldo, Date fechaCreacion){
        this.numeroCuenta = numeroCuenta; 
        this.nombreCliente = nombreCliente; 
        this.saldo = saldo; 
        this.fechaCreacion = fechaCreacion; 
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public String getSaldoDosDecimales() {
        return String.format("%.2f", saldo);
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public boolean hacerIngreso(Double importe) {
        if (importe < 0d) {
            return false;
        }
        saldo += importe;
        return true;
    }

    public boolean hacerExtraccion(Double importe) {
        if (importe < 0d || saldo - importe < 0d) {
            return false;
        }
        saldo -= importe;
        return true;
    }

    public boolean hacerTransferencia(Cuenta destino, Double importe) {
        if (hacerExtraccion(importe)) {
            destino.hacerIngreso(importe);
            return true;
        }
        return false;
    }
}