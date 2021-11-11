package net.alonsoBank;

import java.util.Date;

public class Cuenta {
    private Date fechaCreacion;
    private String nombreCliente;
    private String numeroCuenta;
    private Double saldo = 0d;

    public Cuenta(String nombreCliente, String numeroCuenta) {
        fechaCreacion = new Date(); 
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

    public Double getSaldoDosDecimales() {
        /* 
         * Creo que es mejor hacer un método separado que devuelva un string
         * para que no se pueda utilizar en operaciones matemáticas.
         */
        return String.format("%.2f", saldo);
    }

    /*
     * No he puesto `setters` ni para fechaCreacion, ya que esto no tendría que
     * cambiar, ni para sueldo, ya que este tiene sus propios métodos con 
     * verificadores.
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public boolean hacerIngreso(Double importe) {
        if (importe < 0d) {
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
        /* Ya que hacerReintegro tinene verificador ambos para que la cuenta 
         * tenga suficiente saldo para retirar, y para que no se pueda
         * introducir un numero negativo, dejo que `hacerReintegro()` verifique
         * `importe`, y si es válido, hacer la operación.
         */
        if (hacerReintegro(importe)) {
            destino.hacerIngreso(importe);
            return true;
        }
        return false;
    }
}
