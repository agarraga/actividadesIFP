package net.alonsoBank;

public class Main {

    public static void main(String[] args) {
        Cuenta c001 = new Cuenta("fulanito", "c001");
        Cuenta c002 = new Cuenta("fulanita", "c002");
        System.out.println(c001.getNumeroCuenta());
        System.out.println(c001.getNombreCliente());
        System.out.println(c001.getSaldo());
        System.out.println(c001.getFechaCreacion());
        boolean test1 = c001.hacerIngreso(100_000d);
        boolean test2 = c002.hacerTransferencia(c001, 1d);
        boolean test3 = c001.hacerTransferencia(c002, 50_001d);
        boolean test4 = c001.hacerReintegro(999_999d);
        boolean test5 = c001.hacerIngreso(-10d);
        System.out.println("true" + ">" + test1);
        System.out.println("false" + ">" + test2);
        System.out.println("true" + ">" + test3);
        System.out.println("false" + ">" + test4);
        System.out.println("false" + ">" + test5);
        System.out.println(c001.getSaldo());
        System.out.println(c002.getSaldo());
        
        
    }
}
