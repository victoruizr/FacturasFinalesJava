/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clientes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

/**
 *
 * @author vmrr2
 */
public class ctrl_clientes {

    private SessionFactory sf;
    private Session ss;
    private Criteria criteria;
    private List<Clientes> clientes = new ArrayList<Clientes>();
    private List<Clientes> clientes2 = new ArrayList<Clientes>();

    public ctrl_clientes() {
        sf = NewHibernateUtil.getSessionFactory();
    }

    public List getListaClientes() {
        clientes.removeAll(clientes);
        ss = sf.openSession();
        criteria = ss.createCriteria(Clientes.class);
        criteria.addOrder(Order.asc("dnicif"));
        clientes = criteria.list();

        return clientes;

    }

    public boolean anadirCliente(Clientes c) {
        try {
            ss = sf.openSession();
            ss.beginTransaction();
            ss.save(c);
            ss.getTransaction().commit();
        } catch (HibernateException exception) {
            return false;
        } finally {
            ss.close();

        }
        return true;
    }

    public boolean borrarCliente(Clientes c) {
        try {
            ss = sf.openSession();
            ss.beginTransaction();
            ss.delete(c);
            ss.getTransaction().commit();
        } catch (HibernateException exception) {
            return false;
        } finally {
            ss.close();

        }
        return true;
    }

    public Clientes obtenerClienteId(String DNICIF) {
        Clientes clientes = null;
        try {
            ss = sf.openSession();
            clientes = (Clientes) ss.get(Clientes.class, DNICIF);
        } catch (HibernateException exception) {
            return clientes;
        } finally {
            ss.close();

        }
        return clientes;
    }

    public boolean actualizarCliente(Clientes cliente) {
        try {
            ss = sf.openSession();
            ss.beginTransaction();
            ss.update(cliente);
            ss.getTransaction().commit();
        } catch (HibernateException exception) {
            return false;
        } finally {
            ss.close();
        }
        return true;
    }

    public List obtenerClientes(String nombre, String DNI) {
        clientes2.removeAll(clientes2);

        try {

            if (nombre.equals("")) {
                ss = sf.openSession();
                String hql = "from Clientes cli WHERE cli.dnicif = :ds";
                Query query = ss.createQuery(hql);
                query.setParameter("ds", DNI);
                clientes2 = query.list();
                JOptionPane.showMessageDialog(null, "Filtrado por DNICIF");
            } else if (DNI.equals("")) {
                ss = sf.openSession();
                String hql = "from Clientes cli WHERE cli.nombrecli = :ds";
                Query query = ss.createQuery(hql);
                query.setParameter("ds", nombre);
                clientes2 = query.list();
                JOptionPane.showMessageDialog(null, "Filtrado por nombre");
            } else {
                ss = sf.openSession();
                String hql = "from Clientes cl WHERE cl.nombrecli = :ds and cl.dnicif = :ds2";
                Query query = ss.createQuery(hql);
                query.setParameter("ds", nombre);
                query.setParameter("ds2", DNI);
                clientes2 = query.list();
                JOptionPane.showMessageDialog(null, "Filtrado por nombre y dni");
            }

        } catch (HibernateException he) {
        } finally {
            ss.close();
        }

        return clientes2;

    }

}
