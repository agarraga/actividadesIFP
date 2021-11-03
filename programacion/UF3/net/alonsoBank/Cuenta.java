package net.alonsoBank;

import java.util.Date;

public class Cuenta {
    private Date fechaCreacion;
    private String nombreCliente;
    private String numeroCuenta;
    private Double saldo = 0d;

    public Cuenta(String nombreCliente, String numeroCuenta) {
        this.fechaCreacion = new Date(); 
        this.nombreCliente = nombreCliente; 
        this.numeroCuenta = numeroCuenta; 
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

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public boolean hacerIngreso(Double cantidad) {
        if (cantidad < 0d) {
            return false;
        }
        this.saldo += cantidad;
        return true;
    }

    public boolean hacerReintegro(Double cantidad) {
        if (cantidad < 0d || this.saldo - cantidad < 0d) {
            return false;
        }
        this.saldo -= cantidad;
        return true;
    }

    public boolean hacerTransferencia(Cuenta destino, Double importe) {
        if (this.hacerReintegro(importe)) {
            destino.hacerIngreso(importe);
            return true;
        }
        return false;
    }
}
