/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ctrl_procedure {

    /*Parte JDBC*/
    private Connection conexion;
    private Statement st;
    private boolean resultado;

    public boolean conectarServidor() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            resultado = true;
        } catch (ClassNotFoundException ex) {
            resultado = false;
        }
        return resultado;
    }

    public boolean conectarBD() {
        try {
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "AD_TEMA_03_FACTURAS", "AD_TEMA_03_FACTURAS");
            resultado = true;
        } catch (SQLException ex) {
            resultado = false;
        }
        return resultado;
    }

    public boolean ejecutaProcedure(String fecha1, String fecha2, String dnicif1, String dnicif2) {
        resultado = conectarBD();
        try {
            if (resultado) {
                CallableStatement cst = conexion.prepareCall("{call procedimientoEstadisticas(?,?,?,?)}");

                java.sql.Date fecha1SQL = devolverFechaSQL(fecha1);
                java.sql.Date fecha2SQL = devolverFechaSQL(fecha2);
                if (fecha1SQL != null && fecha2SQL != null) {
                    System.out.println(fecha1SQL + " " + fecha2SQL + " " + dnicif1 + " " + dnicif2);
                    System.out.println("Entra");
                    cst.setDate(1, fecha1SQL);
                    cst.setDate(2, fecha2SQL);
                    cst.setString(3, dnicif1);
                    cst.setString(4, dnicif2);
                    resultado = cst.execute();
                    System.out.println(resultado);
                    if (!resultado) {
                        resultado = true;
                    } else {
                        resultado = false;
                    }
                } else {
                    resultado = false;
                }
                System.out.println(resultado);
            }

        } catch (SQLException ex) {
            System.out.println(ex.hashCode());
            resultado = false;
        }

        return resultado;
    }

    private java.sql.Date devolverFechaSQL(String fecha1) {
        String[] fechaAux = fecha1.split("/");
        fecha1 = fechaAux[2] + "-" + fechaAux[1] + "-" + fechaAux[0];
        java.sql.Date dateSQL = java.sql.Date.valueOf(fecha1);
        return dateSQL;

    }

}
