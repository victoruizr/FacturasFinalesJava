/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.FacturasCab;
import Modelo.FacturasLin;
import Modelo.FacturasLinId;
import Modelo.FacturasTot;
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
public class ctrl_facturas {

    private SessionFactory sf;
    private Session ss;
    private Criteria criteria;
    private List<FacturasCab> facturas = new ArrayList<FacturasCab>();
    private List<FacturasCab> facturas2 = new ArrayList<FacturasCab>();
    private List<FacturasCab> facturas3 = new ArrayList<FacturasCab>();

    public ctrl_facturas() {
        sf = NewHibernateUtil.getSessionFactory();
    }

    public List getListaFacturas() {
        facturas.removeAll(facturas);
        try {
            ss = sf.openSession();
            criteria = ss.createCriteria(FacturasCab.class);
            criteria.addOrder(Order.asc("numfac"));
            facturas = criteria.list();

        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, "Fallo al listar los clientes");
        } finally {
            ss.close();
        }

        return facturas;

    }

    public FacturasCab getListaFacturasID(long numFac) {
        FacturasCab fcCab = null;
        try {
            ss = sf.openSession();
            fcCab = (FacturasCab) ss.get(FacturasCab.class, numFac);

        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, "Fallo al listar las Lin fact");
        } finally {
            ss.close();
        }

        return fcCab;

    }

    public boolean crearFactura(FacturasCab fc) {
        try {
            ss = sf.openSession();
            ss.beginTransaction();
            ss.save(fc);
            ss.getTransaction().commit();
        } catch (HibernateException exception) {
            return false;
        } finally {
            ss.close();
        }
        return true;
    }

    public FacturasLinId obtenerFacturasID(long numfact) {
        FacturasLinId fi = null;
        try {
            ss = sf.openSession();
            fi = (FacturasLinId) ss.get(FacturasLinId.class, numfact);

        } catch (HibernateException exception) {
            return fi;
        } finally {
            ss.close();
        }
        return fi;
    }

    public List obtenerArticuloDescripcion(String descripcion) {
        facturas2.removeAll(facturas2);

        try {

            ss = sf.openSession();
            String hql = "from F arti WHERE arti.descripcion = :ds";
            Query query = ss.createQuery(hql);
            query.setParameter("ds", descripcion);
            facturas2 = query.list();
        } catch (HibernateException he) {
        } finally {
            ss.close();
        }

        return facturas2;

    }

    public boolean crearFacturaLinea(FacturasLin fl) {
        try {
            ss = sf.openSession();
            ss.beginTransaction();
            ss.save(fl);
            ss.getTransaction().commit();
            System.out.println(fl.toString());
        } catch (HibernateException exception) {
            return false;
        } finally {
            ss.close();
        }
        return true;
    }

    public boolean creaModifica(boolean a, FacturasTot ft) {
        try {

            ss = sf.openSession();
            ss.beginTransaction();
            if (a) {
                ss.update(ft);
            } else {
                ss.save(ft);
            }

        } catch (HibernateException exception) {
            return false;
        } finally {
            ss.getTransaction().commit();
            ss.close();
        }
        return true;
    }

    public boolean borrarLineaFactura(FacturasLin fl) {

        try {
            ss = sf.openSession();
            ss.beginTransaction();
            ss.delete(fl);
        } catch (HibernateException exception) {
            return false;
        } finally {
            ss.getTransaction().commit();
            ss.close();
        }
        return true;

    }

    public boolean borrarCabecera(FacturasCab fcas) {

        try {
            ss = sf.openSession();
            ss.beginTransaction();
            ss.delete(fcas);
        } catch (HibernateException exception) {
            return false;
        } finally {
            ss.getTransaction().commit();
            ss.close();
        }
        return true;

    }

    public boolean modificarLinea(FacturasLin fl) {
        try {

            ss = sf.openSession();
            ss.beginTransaction();
            ss.update(fl);

        } catch (HibernateException exception) {
            return false;
        } finally {
            ss.getTransaction().commit();
            ss.close();
        }
        return true;
    }

    public boolean actualizarLinea(FacturasCab cb) {
        try {

            ss = sf.openSession();
            ss.beginTransaction();
            ss.update(cb);

        } catch (HibernateException exception) {
            return false;
        } finally {
            ss.getTransaction().commit();
            ss.close();
        }
        return true;
    }

    public List buscarporDniCif(String dnicif) {
        facturas3.remove(facturas3);
        try {

            ss = sf.openSession();;
            String hql = "from FacturasCab fc WHERE fc.clientes.dnicif = :ds";
            Query query = ss.createQuery(hql);
            query.setParameter("ds", dnicif);
            facturas3 = query.list();
            JOptionPane.showMessageDialog(null, "Filtrado por DNICIF");

        } catch (HibernateException exception) {
            return facturas3;
        } finally {;
            ss.close();
        }
        return facturas3;
    }

}
