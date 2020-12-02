/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EstadisticasClientes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author vmrr2
 */
public class ctrl_estadisticas {

    private SessionFactory sf;
    private Session ss;
    private Criteria criteria;
    private List<EstadisticasClientes> estadis = new ArrayList<EstadisticasClientes>();

    public ctrl_estadisticas() {
        sf = NewHibernateUtil.getSessionFactory();
    }

    public List getEstadisticas() {
        estadis.removeAll(estadis);
        try {
            ss = sf.openSession();
            criteria = ss.createCriteria(EstadisticasClientes.class);
            estadis = criteria.list();

        } catch (HibernateException exception) {

            JOptionPane.showMessageDialog(null, "Fallo al listar las estadisticas");
        } finally {
            ss.close();
        }
        return estadis;

    }

    public boolean borrarEstadisticas(String dniCli) {
        boolean estado = false;
        try {

            // String hql = "from Articulos arti WHERE arti.descripcion = :ds";
            //Query query = ss.createQuery(hql);
            //query.setParameter("ds", descripcion);
//            articulos3 = query.list();
            ss = sf.openSession();
            String hql = "delete from EstadisticasClientes where clientes.dnicif = :ID";
            Query query = ss.createQuery(hql);
            query.setParameter("ID", dniCli);
            query.executeUpdate();
            estado = true;
        } catch (HibernateException exception) {
            estado = false;
            JOptionPane.showMessageDialog(null, "No se pudo borrar al cliente");
        } finally {
            ss.close();
        }
        return estado;
    }

}
