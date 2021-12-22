package com.alonsobank;

import java.time.LocalDate;

public class Cuenta {

    private String numeroCuenta;
    private String nombreCliente;
    private Float saldo;
    private LocalDate fechaCreacion;

    public Cuenta(String numeroCuenta, String nombreCliente) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        saldo = 0f;
        fechaCreacion = LocalDate.now();
    }

    public Cuenta(String numeroCuenta, String nombreCliente, Float saldo, LocalDate fechaCreacion) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.saldo = saldo;
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public Float getSaldo() {
        return saldo;
    }

    public String getSaldoDosDecimales() {
        return String.format("%.2f", saldo);
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public boolean hacerIngreso(Float importe) {
        if (importe < 0f) {
            return false;
        }
        saldo += importe;
        return true;
    }

    public boolean hacerExtraccion(Float importe) {
        if (importe < 0f || saldo - importe < 0f) {
            return false;
        }
        saldo -= importe;
        return true;
    }

    public boolean hacerTransferencia(Cuenta destino, Float importe) {
        if (hacerExtraccion(importe)) {
            destino.hacerIngreso(importe);
            return true;
        }
        return false;
    }
}
