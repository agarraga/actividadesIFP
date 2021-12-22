package com.alonsobank;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.time.LocalDate;

public class DAO {

    private String rutaBBDD;

    public DAO() {}

    public DAO(String rutaBBDD) {
        this.rutaBBDD = "jdbc:sqlite:" + rutaBBDD;
    }

    public void setRutaBBDD(String rutaBBDD) {
        this.rutaBBDD = "jdbc:sqlite:" + rutaBBDD;
    }

    public String getRutaBBDD() {
        return rutaBBDD;
    }

    public void addRow(String numero, String nombre, Float saldo, LocalDate fecha) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(rutaBBDD);
            String statement = "INSERT INTO cuenta (numero, nombre, saldo, fecha) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            Date fechaSQL = Date.valueOf(fecha);
            preparedStatement.setString(1, numero);
            preparedStatement.setString(2, nombre);
            preparedStatement.setFloat(3, saldo);
            preparedStatement.setDate(4, fechaSQL);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException exception) {
            System.err.println("Fallo SQL al intentar insertar una fila");
            // TODO agregar mensaje
        }
    }

    private List<Cuenta> getCuentas(String query){
        /*
         * Este método es privado para que solo esta clase decida el query, y ya
         * con overloads las otras clases pueden pedir específicos.
         */
        List<Cuenta> cuentas = new ArrayList<>();    
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(rutaBBDD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                Cuenta cuenta = new Cuenta(
                    resultSet.getString("numero"),
                    resultSet.getString("nombre"),
                    resultSet.getFloat("saldo"),
                    resultSet.getDate("fecha").toLocalDate()
                );
                cuentas.add(cuenta);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println("Fallo SQL al intentar crear una lista de Cuentas");
            // TODO agregar mensaje
        }
        return cuentas;
    }

    public List<Cuenta> getCuentas() {
        String selectAll = "SELECT * FROM cuenta;";
        return getCuentas(selectAll);
    }

    public List<Cuenta> getCuentas(String numero, String nombre) {
        String query = "SELECT * FROM cuenta WHERE numero LIKE '%" + numero +
                "%' AND nombre LIKE '%" + nombre + "%';";
        return getCuentas(query);
    }

    public Cuenta getCuenta(String numero) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(rutaBBDD);
            String query = "SELECT * FROM cuenta WHERE numero = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, numero);
            ResultSet resultSet = statement.executeQuery();
            Cuenta cuenta = new Cuenta(
                resultSet.getString("numero"),
                resultSet.getString("nombre"),
                resultSet.getFloat("saldo"),
                resultSet.getDate("fecha").toLocalDate()  
            );
            resultSet.close();
            statement.close();
            connection.close();
            return cuenta;
        } catch (ClassNotFoundException | SQLException exception) {
            System.err.println("Fallo SQL al intentar obtener una Cuenta");
        }
        return null;
    }

    public void modificarNombre(String numero, String nuevoNombre) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(rutaBBDD);
            String statement = "UPDATE cuenta SET nombre = ? WHERE numero = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, nuevoNombre);
            preparedStatement.setString(2, numero);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException exception) {
            System.err.println("Fallo SQL al intentar cambiar nombre");
        }
    }

    public void eliminarCuenta(String numero) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(rutaBBDD);
            String statement = "DELETE FROM cuenta WHERE numero = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, numero);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException exception) {
            System.err.println("Fallo SQL al intentar eliminar cuenta");
        }
    }

    public void modificarSaldo(String numero, Float cantidad) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(rutaBBDD);
            String statement = "UPDATE cuenta SET saldo = saldo + ? WHERE numero = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setFloat(1, cantidad);
            preparedStatement.setString(2, numero);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException exception) {
            System.err.println("Fallo SQL al intentar modificar saldo");
        }
    }
}