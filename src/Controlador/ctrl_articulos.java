/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Articulos;
import java.util.ArrayList;
import java.util.Iterator;
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
public class ctrl_articulos {

    private SessionFactory sf;
    private Session ss;
    private Criteria criteria;
    private List<Articulos> articulos = new ArrayList<Articulos>();
    private List<Articulos> articulos2 = new ArrayList<Articulos>();
    private List<Articulos> articulos3 = new ArrayList<Articulos>();

    public ctrl_articulos() {

        sf = NewHibernateUtil.getSessionFactory();
    }

    public List getListaArticulos() {
        articulos.removeAll(articulos);
        try {
            ss = sf.openSession();
            criteria = ss.createCriteria(Articulos.class);
            criteria.addOrder(Order.asc("referencia"));
            articulos = criteria.list();

        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, "Fallo al listar los clientes");
        } finally {
            ss.close();
        }

        return articulos;

    }

    public boolean anadirArticulos(Articulos a) {
        try {
            ss = sf.openSession();
            ss.beginTransaction();
            ss.save(a);
            ss.getTransaction().commit();
        } catch (HibernateException exception) {
            return false;
        } finally {
            ss.close();

        }
        return true;
    }

    public boolean borrarArticulos(Articulos a) {
        try {
            ss = sf.openSession();
            ss.beginTransaction();
            ss.delete(a);
            ss.getTransaction().commit();
        } catch (HibernateException exception) {
            return false;
        } finally {
            ss.close();

        }
        return true;
    }

    public Articulos obtenerArticulosId(String Referencia) {
        Articulos articulos = null;
        try {
            ss = sf.openSession();
            articulos = (Articulos) ss.get(Articulos.class, Referencia);
        } catch (HibernateException exception) {
            return articulos;
        } finally {
            ss.close();

        }
        return articulos;
    }

    public boolean actualizarArticulos(Articulos a) {
        try {
            ss = sf.openSession();
            ss.beginTransaction();
            ss.update(a);
            ss.getTransaction().commit();
        } catch (HibernateException exception) {
            return false;
        } finally {
            ss.close();
        }
        return true;
    }

    public List obtenerArticulosReferencia(String referencia) {
        articulos2.removeAll(articulos2);

        try {

            ss = sf.openSession();
            String hql = "from Articulos arti WHERE arti.referencia = :ds";
            Query query = ss.createQuery(hql);
            query.setParameter("ds", referencia);
            articulos2 = query.list();
            JOptionPane.showMessageDialog(null, "FILTRADO POR REFERENCIA");

        } catch (HibernateException he) {
        } finally {
            ss.close();
        }

        return articulos2;

    }

    public List obtenerArticuloDescripcion(String descripcion) {
        articulos3.removeAll(articulos3);

        try {

            ss = sf.openSession();

            String hql = "from Articulos arti WHERE arti.descripcion = :ds";
            Query query = ss.createQuery(hql);
            query.setParameter("ds", descripcion);
            articulos3 = query.list();
        } catch (HibernateException he) {
        } finally {
            ss.close();
        }

        return articulos3;

    }

    public Articulos obtenerArticulosDescripcion2(String descripcion) {
        Articulos art = null;

        List listaArticulos = getListaArticulos();

        for (Iterator it = listaArticulos.iterator(); it.hasNext();) {
            Articulos aux = (Articulos) it.next();
            if (aux.getDescripcion().equals(descripcion)) {
                return aux;
            }

        }

        return art;
    }

    public boolean actualizaStock(Articulos art) {
        try {
            ss = sf.openSession();
            ss.beginTransaction();
            ss.update(art);
            ss.getTransaction().commit();
        } catch (HibernateException he) {
            return false;
        } finally {
            ss.close();
        }

        return true;

    }

}
