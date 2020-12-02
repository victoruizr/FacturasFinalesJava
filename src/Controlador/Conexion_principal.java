/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;

/**
 *
 * @author vmrr2
 */
public class Conexion_principal {

    private SessionFactory sf;

    public Conexion_principal() {

        try {
            sf = NewHibernateUtil.getSessionFactory();
        } catch (ExceptionInInitializerError ee) {
            JOptionPane.showMessageDialog(null, "Sin conexion");
            System.exit(0);

        }

    }
}
