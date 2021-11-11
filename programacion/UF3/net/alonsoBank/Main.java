package net.alonsoBank;

public class Main {

    public static void main(String[] args) {
        /* Tests de instaciar cuentas */
        Cuenta c001 = new Cuenta("fulanito", "c001");
        Cuenta c002 = new Cuenta("fulanita", "c002");
        /* Tests de getters y setters */
        System.out.println(c001.getNumeroCuenta());
        System.out.println(c001.getNombreCliente());
        System.out.println(c001.getSaldo());
        System.out.println(c001.getSaldoDosDecimales());
        System.out.println(c001.getFechaCreacion());
        c002.setNumeroCuenta("c003");
        c002.setNombreCliente("fulanite");
        System.out.println(c002.getNumeroCuenta());
        System.out.println(c002.getNombreCliente());
        /* Tests de métodos */
        boolean test1 = c001.hacerIngreso(100_000d);
        boolean test2 = c001.hacerIngreso(-10d);
        boolean test3 = c001.hacerReintegro(10_000d);
        boolean test4 = c001.hacerReintegro(999_999d);
        boolean test5 = c001.hacerTransferencia(c002, 50_000d);
        boolean test6 = c002.hacerTransferencia(c001, 1_000_000d);
        System.out.println("true = " + test1);
        System.out.println("false = " + test2);
        System.out.println("true = " + test3);
        System.out.println("false = " + test4);
        System.out.println("true = " + test5);
        System.out.println("false = " + test6);
        System.out.println("40000.00 = " + c001.getSaldoDosDecimales());
        System.out.println("50000.00 = " + c002.getSaldoDosDecimales());
    }
}
