package com.alonsoBank;

import java.util.Date;

public class Cuenta {
    private Date fechaCreacion;
    private String nombreCliente;
    private String numeroCuenta;
    private Double saldo = 0d;

    public Cuenta(String numeroCuenta, String nombreCliente ) {
        fechaCreacion = new Date(); 
        this.numeroCuenta = numeroCuenta; 
        this.nombreCliente = nombreCliente; 
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

//    public void setNumeroCuenta(String numeroCuenta) {
//        this.numeroCuenta = numeroCuenta;
//    }

    public boolean hacerIngreso(Double importe) {
        if (importe < 0d) {
            return false;
        }
        saldo += importe;
        return true;
    }

    public boolean hacerReintegro(Double importe) {
        if (importe < 0d || saldo - importe < 0d) {
            return false;
        }
        saldo -= importe;
        return true;
    }

    public boolean hacerTransferencia(Cuenta destino, Double importe) {
        if (hacerReintegro(importe)) {
            destino.hacerIngreso(importe);
            return true;
        }
        return false;
    }
}