/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Conexion_principal;
import Controlador.ctrl_articulos;
import Controlador.ctrl_clientes;
import Controlador.ctrl_estadisticas;
import Controlador.ctrl_facturas;
import Controlador.ctrl_procedure;
import Modelo.Articulos;
import Modelo.Clientes;
import Modelo.EstadisticasClientes;
import Modelo.FacturasCab;
import Modelo.FacturasLin;
import Modelo.FacturasLinId;
import Modelo.FacturasTot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author vmrr2
 */
public class Vista extends javax.swing.JFrame {

    /**
     * Creates new form Vista
     */
    public ArrayList<Clientes> clientes;
    public ArrayList<Clientes> clientes2;
    public ArrayList<Articulos> articulos;
    public ArrayList<Articulos> articulos2;
    public ArrayList<Articulos> articulos3;
    public ArrayList<Articulos> articulos4;
    public ArrayList<FacturasCab> facturas;
    public ArrayList<FacturasCab> facturas1;
    public ArrayList<FacturasCab> facturas2;
    public ArrayList<FacturasCab> facturas3;
    public ArrayList<EstadisticasClientes> estadisticas;
    private final Conexion_principal controladorConexion = new Conexion_principal();
    private final ctrl_clientes controladorClientes = new ctrl_clientes();
    private final ctrl_articulos controladorArticulos = new ctrl_articulos();
    private final ctrl_facturas controladorFacturas = new ctrl_facturas();
    private final ctrl_estadisticas controladorEstadisticas = new ctrl_estadisticas();

    public Vista() {
        initComponents();

        cargarDatosClientes();
        cargarDatosArticulos();
        cargarDatosFacturas();
        Clientes.setLocationRelativeTo(null);
        Articulos.setLocationRelativeTo(null);
        Facturas.setLocationRelativeTo(null);

    }

    private void numerico(KeyEvent evt, JTextField a) {
        char caracter = evt.getKeyChar();
        if (Character.isLetter(caracter)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Introduzca un numero");
            a.setText(null);
            a.requestFocus();
        }

    }

    private void string(KeyEvent evt, JTextField a) {
        char caracter = evt.getKeyChar();
        if (Character.isDigit(caracter)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Introduzca un texto");
            a.setText(null);
            a.requestFocus();
        }

    }

    private void cargarDatosClientes() {

        clientes = (ArrayList<Clientes>) controladorClientes.getListaClientes();
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        jComboBoxClientes.removeAllItems();
        DefaultTableModel modelo = (DefaultTableModel) jTableClientes.getModel();
        modelo.setRowCount(0);

        clientes.forEach((client) -> {
            modelo.addRow(new Object[]{client.getDnicif(), client.getNombrecli()});
            jComboBoxClientes.addItem(client.getDnicif());
            jComboBox1.addItem(client.getDnicif());
            jComboBox2.addItem(client.getDnicif());
        });

    }

    private void cargarDatosArticulos() {

        articulos = (ArrayList<Articulos>) controladorArticulos.getListaArticulos();

        DefaultTableModel modelo = (DefaultTableModel) jTableArticulos.getModel();
        modelo.setRowCount(0);
        jComboBoxArticulos.removeAllItems();
        articulos.forEach((articulo) -> {
            modelo.addRow(new Object[]{articulo.getReferencia(), articulo.getDescripcion(), articulo.getPrecio(), articulo.getPorciva(), articulo.getStock()});
            jComboBoxArticulos.addItem(articulo.getDescripcion());
        });
    }

    private void cargarDatosFacturas() {

        facturas = (ArrayList<FacturasCab>) controladorFacturas.getListaFacturas();
        jComboBoxClientes.removeAll();
        DefaultTableModel modelo = (DefaultTableModel) jTableFacturasCab.getModel();
        modelo.setRowCount(0);

        facturas.forEach((fact) -> {
            modelo.addRow(new Object[]{fact.getNumfac(), fact.getFechafac(), fact.getClientes().getDnicif()});
        });

        articulos = (ArrayList<Articulos>) controladorArticulos.getListaArticulos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Clientes = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jBuscarClientes = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreCli = new javax.swing.JTextField();
        dnicif = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jBuscarClientes1 = new javax.swing.JButton();
        Articulos = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextField();
        referencia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        iva = new javax.swing.JTextField();
        Stock = new javax.swing.JLabel();
        stock = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableArticulos = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        Facturas = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableNumLineas = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableFacturasCab = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableNumTotal = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNFactura = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxClientes = new javax.swing.JComboBox<>();
        jButton11 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        AñadirLineaFactura = new javax.swing.JButton();
        jTextFieldNFactura3 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldPrecio = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldCantidad2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldNFactura4 = new javax.swing.JTextField();
        jComboBoxArticulos = new javax.swing.JComboBox<>();
        jButton19 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jTextFieldNFactura5 = new javax.swing.JTextField();
        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        Clientes.setMinimumSize(new java.awt.Dimension(1500, 1000));
        Clientes.setModal(true);

        jButton1.setText("Añadir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Borrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jBuscarClientes.setText("Buscar");
        jBuscarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarClientesActionPerformed(evt);
            }
        });

        jLabel1.setText("DNICIF");

        jLabel2.setText("NOMBRE");

        nombreCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreCliKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreCli, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dnicif, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dnicif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(234, Short.MAX_VALUE))
        );

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNICIF", "NOMBRECLI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);

        jButton7.setText("Actualizar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jBuscarClientes1.setText("Quitar Buscar");
        jBuscarClientes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarClientes1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(56, 56, 56)
                        .addComponent(jButton2)
                        .addGap(36, 36, 36)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jBuscarClientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBuscarClientes1)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jBuscarClientes)
                            .addComponent(jButton7)
                            .addComponent(jBuscarClientes1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(422, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ClientesLayout = new javax.swing.GroupLayout(Clientes.getContentPane());
        Clientes.getContentPane().setLayout(ClientesLayout);
        ClientesLayout.setHorizontalGroup(
            ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ClientesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        ClientesLayout.setVerticalGroup(
            ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ClientesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Articulos.setMinimumSize(new java.awt.Dimension(1500, 1000));
        Articulos.setModal(true);

        jLabel3.setText("Referencia");

        jLabel4.setText("Descripcion");

        jLabel5.setText("Precio");

        precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioKeyTyped(evt);
            }
        });

        jLabel6.setText("IVA");

        iva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ivaKeyTyped(evt);
            }
        });

        Stock.setText("STOCK");

        stock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stockKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descripcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(referencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iva, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Stock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(referencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Stock))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jTableArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "REFERENCIA", "DESCRIPCION", "PRECIO", "PORCIVA", "STOCK"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableArticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableArticulosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableArticulos);
        if (jTableArticulos.getColumnModel().getColumnCount() > 0) {
            jTableArticulos.getColumnModel().getColumn(2).setResizable(false);
        }

        jButton4.setText("Quitar buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Borrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Actualizar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setText("Añadir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Buscar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jButton8)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5)
                            .addComponent(jButton6)
                            .addComponent(jButton8)
                            .addComponent(jButton9))))
                .addContainerGap(352, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ArticulosLayout = new javax.swing.GroupLayout(Articulos.getContentPane());
        Articulos.getContentPane().setLayout(ArticulosLayout);
        ArticulosLayout.setHorizontalGroup(
            ArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1325, Short.MAX_VALUE)
            .addGroup(ArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ArticulosLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        ArticulosLayout.setVerticalGroup(
            ArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
            .addGroup(ArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ArticulosLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Facturas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Facturas.setMinimumSize(new java.awt.Dimension(1920, 1000));
        Facturas.setModal(true);

        jTableNumLineas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num Facturas", "Linea Facturas", "Referencia", "Cantidad", "Precio", "DtoLinea", "IvaLinea"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableNumLineas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableNumLineasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableNumLineas);

        jTableFacturasCab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Factura", "Fecha Factura", "Dni Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFacturasCab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFacturasCabMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableFacturasCab);

        jTableNumTotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Factura", "Base Imponible", "Imp_Dto", "Imp_Iva", "TotalFacturas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTableNumTotal);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("FACTURASCAB"));

        jLabel7.setText("Numero Factura");

        jLabel13.setText("Cliente");

        jButton11.setText("Borrar Facturas");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton14.setText("Añadir Facturas");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton17.setText("Buscar");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("Quitar busqueda");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addGap(69, 69, 69)
                            .addComponent(jComboBoxClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldNFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton14)
                        .addGap(39, 39, 39)
                        .addComponent(jButton11)
                        .addGap(35, 35, 35)
                        .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton14)
                    .addComponent(jButton17)
                    .addComponent(jButton18))
                .addGap(80, 80, 80)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldNFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBoxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("FACTURAS LIN"));

        jLabel14.setText("Numero Factura");

        jButton15.setText("Borrar Linea");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Modificar Linea");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        AñadirLineaFactura.setText("Añadir Linea");
        AñadirLineaFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirLineaFacturaActionPerformed(evt);
            }
        });

        jTextFieldNFactura3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNFactura3KeyTyped(evt);
            }
        });

        jLabel18.setText("Articulos");

        jLabel19.setText("Cantidad");

        jLabel20.setText("Precio");

        jTextFieldPrecio.setEditable(false);

        jLabel21.setText("DtoLinea");

        jTextFieldCantidad2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCantidad2KeyTyped(evt);
            }
        });

        jLabel22.setText("IvaLinea");

        jTextFieldNFactura4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNFactura4KeyTyped(evt);
            }
        });

        jComboBoxArticulos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxArticulosItemStateChanged(evt);
            }
        });

        jButton19.setText("Importar Factura xml");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton13.setText("Exportar Factura xml");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton20.setText("Exportar Factura json");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setText("Importar Factura json");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jTextFieldNFactura5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNFactura5KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(AñadirLineaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldPrecio)
                                        .addComponent(jTextFieldCantidad2)
                                        .addComponent(jTextFieldNFactura4)
                                        .addComponent(jComboBoxArticulos, 0, 347, Short.MAX_VALUE))
                                    .addComponent(jTextFieldNFactura5, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldNFactura3, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(39, 39, 39))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(jButton16)
                    .addComponent(AñadirLineaFactura))
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldNFactura3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jTextFieldNFactura5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNFactura4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13)
                    .addComponent(jButton19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton20)
                    .addComponent(jButton21))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(156, 156, 156)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane3)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FacturasLayout = new javax.swing.GroupLayout(Facturas.getContentPane());
        Facturas.getContentPane().setLayout(FacturasLayout);
        FacturasLayout.setHorizontalGroup(
            FacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        FacturasLayout.setVerticalGroup(
            FacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ANIO", "MES_NUM", "MES_NOM", "DNICIF", "NOMBRECLI", "SUMA_BASE", "SUMA_DTOS", "SUMA_IVA", "SUMA_TOTALES"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable1);

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/MM/yyyy"))));

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/MM/yyyy"))));
        jFormattedTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField2ActionPerformed(evt);
            }
        });

        jButton3.setText("Estadisticas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jFormattedTextField1)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, 127, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1000, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jButton3)))
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(106, 106, 106)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(397, Short.MAX_VALUE)))
        );

        jMenu1.setText("Clientes");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Articulos");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Facturas");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarDatosCliente() {
        String DniCif = (String) jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 0);
        String nombre = (String) jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 1);
        dnicif.setText(DniCif);
        nombreCli.setText(nombre);
    }

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        // TODO add your handling code here:

        mostrarDatosCliente();

    }//GEN-LAST:event_jTableClientesMouseClicked

    private void anadirCliente() {
        try {
            Clientes clientes = new Clientes(dnicif.getText(), nombreCli.getText());

            boolean estadoAnadir = controladorClientes.anadirCliente(clientes);

            if (estadoAnadir) {
                cargarDatosClientes();
                JOptionPane.showMessageDialog(Clientes, "AÑADIDO CON EXITO");
            } else {
                JOptionPane.showMessageDialog(Clientes, "DNICIF EXISTENTE O VACIO");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(Clientes, "DNICIF EXISTENTE O VACIO");
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        anadirCliente();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void borrarCliente() {

        try {
            Clientes cliente = controladorClientes.obtenerClienteId(dnicif.getText().toString());
            if (cliente.getFacturasCabs().size() > 0) {
                JOptionPane.showMessageDialog(Clientes, "NO SE PUEDE BORRAR EL CLIENTE YA QUE TIENE FACTURAS");
            } else {
                controladorEstadisticas.borrarEstadisticas(dnicif.getText().toString());

                boolean estadoBorrar = controladorClientes.borrarCliente(cliente);

                if (!estadoBorrar) {
                    JOptionPane.showMessageDialog(Clientes, "BORRADO SIN EXITO");
                } else {
                    nombreCli.setText(null);
                    dnicif.setText(null);
                    //cargarDatosClientes();

                }
            }
            cargarDatosClientes();
        } catch (NullPointerException Ne) {
            JOptionPane.showMessageDialog(Clientes, "CAMPOS VACIOS");
        } catch (Exception e) {
            System.out.println("ALGO FALLO");
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        borrarCliente();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void actualizarCliente() {
        try {
            Clientes cli = new Clientes(dnicif.getText(), nombreCli.getText());

            boolean estadoActualizar = controladorClientes.actualizarCliente(cli);
            if (estadoActualizar) {
                cargarDatosClientes();
                JOptionPane.showMessageDialog(Clientes, "ACTUALIZADO CON EXITO");
                nombreCli.setText(null);
                dnicif.setText(null);
            } else {
                JOptionPane.showMessageDialog(Clientes, "ACTUALIZADO SIN EXITO, NO EXISTE EL ID");
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(Clientes, "CAMPOS VACIOS");
        } catch (Exception e) {
            System.out.println("ALGO FALLO");
        }

    }

    private void buscarCliente() {

        if (nombreCli.getText().isEmpty() && dnicif.getText().isEmpty()) {
            JOptionPane.showMessageDialog(Clientes, "CAMPOS VACIOS");
        } else {

            clientes = (ArrayList<Clientes>) controladorClientes.obtenerClientes(nombreCli.getText(), dnicif.getText());
            DefaultTableModel modelo = (DefaultTableModel) jTableClientes.getModel();

            modelo.setRowCount(0);

            clientes.forEach((client) -> {
                modelo.addRow(new Object[]{client.getDnicif(), client.getNombrecli()});
            });

            nombreCli.setText(null);
            dnicif.setText(null);

        }

    }

    private void jBuscarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarClientesActionPerformed
        // TODO add your handling code here:
        buscarCliente();

    }//GEN-LAST:event_jBuscarClientesActionPerformed

    private void jTableArticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableArticulosMouseClicked
        // TODO add your handling code here:

        try {
            String Referencia = jTableArticulos.getValueAt(jTableArticulos.getSelectedRow(), 0).toString();
            String Descripcion = jTableArticulos.getValueAt(jTableArticulos.getSelectedRow(), 1).toString();
            String Precio = jTableArticulos.getValueAt(jTableArticulos.getSelectedRow(), 2).toString();
            String PORCIVA = jTableArticulos.getValueAt(jTableArticulos.getSelectedRow(), 3).toString();
            String STOCK = jTableArticulos.getValueAt(jTableArticulos.getSelectedRow(), 4).toString();

            referencia.setText(Referencia);
            descripcion.setText(Descripcion);
            precio.setText(Precio);
            iva.setText(PORCIVA);
            stock.setText(STOCK);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTableArticulosMouseClicked

    private void anadirArticulos() {
        try {
            HashSet lineas = new HashSet();
            Articulos articulo = new Articulos(referencia.getText(), descripcion.getText(), BigDecimal.valueOf(Double.parseDouble(precio.getText())), BigDecimal.valueOf(Double.parseDouble(iva.getText())), BigDecimal.valueOf(Double.parseDouble(stock.getText())), lineas);
            boolean estadoanadir = controladorArticulos.anadirArticulos(articulo);
            if (estadoanadir) {
                JOptionPane.showMessageDialog(Articulos, "AÑADIDO CON EXITO");
                cargarDatosArticulos();
            } else {
                JOptionPane.showMessageDialog(Articulos, "AÑADIDO SIN EXITO, NO PUEDE HABER UNA DESCRIPCION IGUAL"
                        + " NI UNA REFERENCIA IGUAL");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(Articulos, "CAMPOS VACIOS");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Articulos, "ALGO FALLO CAMPOS VACIOS");
        }
    }

    private void buscarArticulos() {
        DefaultTableModel modelo = (DefaultTableModel) jTableArticulos.getModel();

        if (referencia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(Articulos, "Referencia vacia");
        } else {

            System.out.println(referencia.getText());

            articulos2 = (ArrayList<Articulos>) controladorArticulos.obtenerArticulosReferencia(referencia.getText());

            modelo.setRowCount(0);

            articulos2.forEach((articulo) -> {

                modelo.addRow(new Object[]{articulo.getReferencia(), articulo.getDescripcion(), articulo.getPrecio(), articulo.getPorciva(), articulo.getStock()});
            });
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        cargarDatosArticulos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void borrarArticulos() {
        try {
            Articulos artic = controladorArticulos.obtenerArticulosId(referencia.getText());

            if (artic.getFacturasLins().size() > 0) {
                JOptionPane.showMessageDialog(Articulos, "NO SE PUEDE BORRAR EL ARTICULO, YA QUE HAY FACTURAS CON ESE ARTICULO");

            } else {

                boolean estadoBorrar = controladorArticulos.borrarArticulos(artic);
                if (estadoBorrar) {
                    JOptionPane.showMessageDialog(Articulos, "BORRADO CON EXITO");
                    referencia.setText(null);
                    descripcion.setText(null);
                    precio.setText(null);
                    iva.setText(null);
                    stock.setText(null);
                    cargarDatosArticulos();
                } else {
                    JOptionPane.showMessageDialog(Articulos, "BORRADO SIN EXITO");
                }
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(Articulos, "CAMPOS VACIOS");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Articulos, "ALGO FALLO");
        }

    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        borrarArticulos();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void actualizarArticulos() {
        try {
            HashSet lineas = new HashSet();
            Articulos articulo = new Articulos(referencia.getText(), descripcion.getText(), BigDecimal.valueOf(Double.parseDouble(precio.getText())), BigDecimal.valueOf(Double.parseDouble(iva.getText())), BigDecimal.valueOf(Double.parseDouble(stock.getText())), lineas);

            boolean estadoActualizar = controladorArticulos.actualizarArticulos(articulo);

            if (estadoActualizar) {
                JOptionPane.showMessageDialog(Articulos, "ACTUALIZADO CON EXITO");
                referencia.setText(null);
                descripcion.setText(null);
                precio.setText(null);
                iva.setText(null);
                stock.setText(null);
                cargarDatosArticulos();
            } else {
                JOptionPane.showMessageDialog(Articulos, "ACTUALIZADO SIN EXITO, REFERENCIA NO EXISTENTE/DESCRIPCION EXISTENTE");
            }
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(Articulos, "CAMPOS VACIOS");
        }

    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        actualizarArticulos();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioKeyTyped
        // TODO add your handling code here:
        numerico(evt, precio);
    }//GEN-LAST:event_precioKeyTyped

    private void ivaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ivaKeyTyped
        // TODO add your handling code here:
        numerico(evt, iva);
    }//GEN-LAST:event_ivaKeyTyped

    private void stockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockKeyTyped
        // TODO add your handling code here:
        numerico(evt, stock);
    }//GEN-LAST:event_stockKeyTyped

    private void nombreCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreCliKeyTyped
        // TODO add your handling code here:
        string(evt, nombreCli);
    }//GEN-LAST:event_nombreCliKeyTyped

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        actualizarCliente();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jBuscarClientes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarClientes1ActionPerformed
        // TODO add your handling code here:
        cargarDatosClientes();
    }//GEN-LAST:event_jBuscarClientes1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        Clientes.setVisible(true);

    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        cargarDatosArticulos();
        Articulos.setVisible(true);

    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
        cargarDatosFacturas();
        Facturas.setVisible(true);

    }//GEN-LAST:event_jMenu3MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        anadirArticulos();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        buscarArticulos();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        anadirFactura();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void actualizarFacturas() {
        try {
            Clientes cli = new Clientes(jTextFieldNFactura.getText(), (String) jComboBoxClientes.getSelectedItem());

            boolean estado = controladorClientes.actualizarCliente(cli);

            if (estado) {
                JOptionPane.showMessageDialog(this, "Modificado con exito");
            } else {
                JOptionPane.showMessageDialog(this, "Modificado sin exito");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Campos vacios");

        }
    }

    private void borrarFactura() {

        try {
            boolean estado = false;

            String nFactura = jTextFieldNFactura.getText();

            FacturasCab fc = controladorFacturas.getListaFacturasID(Long.parseLong(nFactura));

            Set datos = fc.getFacturasLins();
            if (datos.size() == 0) {

                estado = controladorFacturas.borrarCabecera(fc);
                if (!estado) {
                    JOptionPane.showMessageDialog(Facturas, "No se puede borrar la factura");
                } else {
                    cargarDatosFacturas();
                    DefaultTableModel modelo = (DefaultTableModel) jTableNumTotal.getModel();

                    modelo.setRowCount(0);

                    DefaultTableModel modelo2 = (DefaultTableModel) jTableNumLineas.getModel();

                    modelo2.setRowCount(0);
                }

            } else {
                for (Iterator it = datos.iterator(); it.hasNext();) {
                    FacturasLin fcs = (FacturasLin) it.next();

                    estado = controladorFacturas.borrarLineaFactura(fcs);

                }
                boolean estado2 = controladorFacturas.borrarCabecera(fc);
                if (!estado || !estado2) {
                    JOptionPane.showMessageDialog(Facturas, "No se puede borrar la factura");
                } else {
                    cargarDatosFacturas();
                    DefaultTableModel modelo = (DefaultTableModel) jTableNumTotal.getModel();

                    modelo.setRowCount(0);

                    DefaultTableModel modelo2 = (DefaultTableModel) jTableNumLineas.getModel();

                    modelo2.setRowCount(0);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(Facturas, "Datos no validos");
        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(Facturas, "No hay clientes validos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Facturas, "No existe la factura");
        }

    }

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        borrarFactura();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTableFacturasCabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFacturasCabMouseClicked
        // TODO add your handling code here:
        buscarNumLin();
    }//GEN-LAST:event_jTableFacturasCabMouseClicked

    private void jComboBoxArticulosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxArticulosItemStateChanged
        // TODO add your handling code here:
        cargarPrecio();
    }//GEN-LAST:event_jComboBoxArticulosItemStateChanged

    private void AñadirLineaFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirLineaFacturaActionPerformed
        // TODO add your handling code here:
        anadirLineaFacturas();
    }//GEN-LAST:event_AñadirLineaFacturaActionPerformed

    private void borrarLineaFactura() {
        try {
            if (jTableNumLineas.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(Facturas, "Selecciona una linea de factura");
            } else {
                FacturasLinId flin = new FacturasLinId(Long.parseLong(String.valueOf(jTableNumLineas.getValueAt(jTableNumLineas.getSelectedRow(), 0))), Long.parseLong(String.valueOf(jTableNumLineas.getValueAt(jTableNumLineas.getSelectedRow(), 1))));

                Articulos art = controladorArticulos.obtenerArticulosId((String) jTableNumLineas.getValueAt(jTableNumLineas.getSelectedRow(), 2));

                FacturasCab fc = controladorFacturas.getListaFacturasID(Long.parseLong(String.valueOf(jTextFieldNFactura3.getText())));

                FacturasLin flineas = new FacturasLin(flin, art, fc, BigDecimal.valueOf(Double.parseDouble(String.valueOf(jTableNumLineas.getValueAt(jTableNumLineas.getSelectedRow(), 3)))), BigDecimal.valueOf(Double.parseDouble(String.valueOf(jTableNumLineas.getValueAt(jTableNumLineas.getSelectedRow(), 4)))), BigDecimal.valueOf(Double.parseDouble(String.valueOf(jTableNumLineas.getValueAt(jTableNumLineas.getSelectedRow(), 5)))), BigDecimal.valueOf(Double.parseDouble(String.valueOf(jTableNumLineas.getValueAt(jTableNumLineas.getSelectedRow(), 6)))));

                boolean esta = controladorFacturas.borrarLineaFactura(flineas);
                int nuevo = (art.getStock().intValue() + Integer.parseInt(String.valueOf(jTableNumLineas.getValueAt(jTableNumLineas.getSelectedRow(), 3))));
                //System.out.println(restante);
                art.setStock(new BigDecimal(nuevo));
                controladorArticulos.actualizaStock(art);
                factot();
                cargarDatosFacturas();
                DefaultTableModel modelo = (DefaultTableModel) jTableNumLineas.getModel();
                DefaultTableModel modelo2 = (DefaultTableModel) jTableNumTotal.getModel();
                modelo.setRowCount(0);
                modelo2.setRowCount(0);
                if (esta) {
                    JOptionPane.showMessageDialog(Facturas, "Borrado con exito");
                    //buscarNumLin();
                    // factot();
                    cargarDatosArticulos();
                    cargarDatosFacturas();
                    //factot();

                    Facturas.revalidate();
                } else {
                    JOptionPane.showMessageDialog(Facturas, "No se pudo borrar");
                }

            }
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(Facturas, "CAMPOS VACIOS");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Facturas, "ALGO FALLO");
        }
    }

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        borrarLineaFactura();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void mostrarDatos() {

        Articulos art = controladorArticulos.obtenerArticulosId((String) jTableNumLineas.getValueAt(jTableNumLineas.getSelectedRow(), 2));
        jComboBoxArticulos.setSelectedItem(art.getDescripcion());
        // jComboBoxCantidad.setSelectedItem(jTableNumLineas.getValueAt(jTableNumLineas.getSelectedRow(), 3));
        jTextFieldNFactura3.setText(String.valueOf(jTableNumLineas.getValueAt(jTableNumLineas.getSelectedRow(), 0)));
        jTextFieldPrecio.setText(String.valueOf(jTableNumLineas.getValueAt(jTableNumLineas.getSelectedRow(), 4)));
        jTextFieldCantidad2.setText(String.valueOf(jTableNumLineas.getValueAt(jTableNumLineas.getSelectedRow(), 5)));
        jTextFieldNFactura4.setText(String.valueOf(jTableNumLineas.getValueAt(jTableNumLineas.getSelectedRow(), 6)));

    }

    private void jTableNumLineasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNumLineasMouseClicked
        // TODO add your handling code here:
        mostrarDatos();
    }//GEN-LAST:event_jTableNumLineasMouseClicked

    private void modificarLinea() {
        BigDecimal nuevo = new BigDecimal(0);
        try {
            if (jTableNumLineas.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "SELECCIONE UNA LINEA");
            } else {
                FacturasLinId flin = new FacturasLinId(Long.parseLong(jTextFieldNFactura3.getText()), Long.parseLong(String.valueOf(jTableNumLineas.getValueAt(jTableNumLineas.getSelectedRow(), 1))));

                articulos4 = (ArrayList<Articulos>) controladorArticulos.obtenerArticuloDescripcion(String.valueOf(jComboBoxArticulos.getSelectedItem()));

                Articulos arti = controladorArticulos.obtenerArticulosId(articulos4.get(0).getReferencia());
                System.out.println("EL STOCK ES DE " + arti.getStock());
                if (arti.getStock().intValue() == 0) {
                    JOptionPane.showMessageDialog(Facturas, "SIN STOCK DEL ARTICULO");
                } else if (arti.getStock().intValue() < Integer.parseInt(jTextFieldNFactura5.getText().toString())) {
                    JOptionPane.showMessageDialog(Facturas, "STOCK SUPERIOR  AL DISPONIBLE");
                } else {
                    System.out.println(arti.getStock());

                    long linea = Long.parseLong(jTableNumLineas.getValueAt(jTableNumLineas.getSelectedRow(), 3).toString());

                    BigDecimal lin = BigDecimal.valueOf(linea);

                    BigDecimal cantidad = BigDecimal.valueOf(Long.parseLong(jTextFieldNFactura5.getText().toString()));

                    if (lin.compareTo(cantidad) < 0) {
                        BigDecimal stockRestante = arti.getStock().subtract(cantidad);
                        nuevo = stockRestante;

                        //arti.setStock(stockRestante);
                    } else {
                        BigDecimal stockRestante = arti.getStock().add(lin).subtract(cantidad);
                        nuevo = stockRestante;
                    }

                    /*if (Integer.parseInt(String.valueOf(j)   {
                        nuevo = (arti.getStock().intValue() + (Integer.parseInt(jTextFieldNFactura5.getText()) - Integer.parseInt(String.valueOf(jTableNumLineas.getValueAt(jTableNumLineas.getSelectedRow(), 3)))));
                    } else if (Integer.parseInt(String.valueOf(jTableNumLineas.getValueAt(jTableNumLineas.getSelectedRow(), 3))) < Integer.parseInt(jTextFieldNFactura5.getText())) {
                        nuevo = (arti.getStock().intValue() - (Integer.parseInt(jTextFieldNFactura5.getText())  Integer.parseInt(String.valueOf(jTableNumLineas.getValueAt(jTableNumLineas.getSelectedRow(), 3)))
                    
                    
                    ));
                    }*/
                    //nuevo = (arti.getStock().intValue() + ((Integer.parseInt(String.valueOf(jTableNumLineas.getValueAt(jTableNumLineas.getSelectedRow(), 3)))) - Integer.parseInt(jTextFieldNFactura5.getText())));
                    arti.setStock(nuevo);
                    controladorArticulos.actualizaStock(arti);
                    factot();
                    cargarDatosFacturas();
                    FacturasCab fc = controladorFacturas.getListaFacturasID(flin.getNumfac());

                    FacturasLin fli = new FacturasLin(flin, arti, fc, BigDecimal.valueOf(Long.parseLong(jTextFieldNFactura5.getText())), BigDecimal.valueOf(Long.parseLong(jTextFieldPrecio.getText())), BigDecimal.valueOf(Long.parseLong(jTextFieldCantidad2.getText())), BigDecimal.valueOf(Long.parseLong(jTextFieldNFactura4.getText())));
                    controladorFacturas.modificarLinea(fli);
                    DefaultTableModel modelo = (DefaultTableModel) jTableNumLineas.getModel();
                    DefaultTableModel modelo2 = (DefaultTableModel) jTableNumTotal.getModel();
                    modelo.setRowCount(0);
                    modelo2.setRowCount(0);
                    //buscarNumLin();
                    factot();
                    Facturas.revalidate();
                }
            }

        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(Facturas, "CAMPOS VACIOS");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Facturas, "Clave no valida");
        }
    }

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        modificarLinea();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void buscarFacturas() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) jTableFacturasCab.getModel();

            facturas3 = (ArrayList<FacturasCab>) controladorFacturas.buscarporDniCif(String.valueOf(jComboBoxClientes.getSelectedItem()));
            modelo.setRowCount(0);
            if (facturas3.size() == 0) {
                JOptionPane.showMessageDialog(Facturas, "No hay facturas para dicho cliente");
            } else {

                facturas3.forEach((fact) -> {

                    modelo.addRow(new Object[]{fact.getNumfac(), fact.getFechafac(), fact.getClientes().getDnicif()});
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Facturas, "ALGO FALLO");

        }
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf("."));
        } else {
            return " ";
        }
    }

    public void escribirXML() {

        try {
            double bImp = 0.0;
            double bDescuentos = 0.0;
            double bIva = 0.0;
            double bTotal = 0.0;
            double dlin2 = 0.0;

            Clientes cli = controladorClientes.obtenerClienteId(String.valueOf(jTableFacturasCab.getValueAt(jTableFacturasCab.getSelectedRow(), 2)));
            int seleccionar = jFileChooser1.showOpenDialog(Facturas);

            File fichero = null;

            if (seleccionar == jFileChooser1.APPROVE_OPTION) {
                fichero = new File(jFileChooser1.getSelectedFile().getAbsolutePath());
            } else {
                JOptionPane.showMessageDialog(Facturas, "No selecciono ningun fichero");
            }

            //File archivo = new File("factura" + jTableFacturasCab.getValueAt(jTableFacturasCab.getSelectedRow(), 0) + ".xml");
            if (fichero.exists() && getFileExtension(fichero).equals(".xml")) {

                int opcion = JOptionPane.showConfirmDialog(Facturas, "El fichero existe, ¿Desea soobreescribirlo?", "Fichero existente", JOptionPane.YES_NO_OPTION);

                if (opcion == JOptionPane.YES_OPTION) {

                    BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
                    bw.write("");
                    bw.close();

                    FacturasCab fcl = controladorFacturas.getListaFacturasID(Long.parseLong(String.valueOf(jTableFacturasCab.getValueAt(jTableFacturasCab.getSelectedRow(), 0))));

                    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

                    // elemento raiz
                    Document doc = docBuilder.newDocument();
                    Element rootElement = doc.createElement("FACTURAS");
                    doc.appendChild(rootElement);

                    Element Clientes = doc.createElement("Clientes");
                    rootElement.appendChild(Clientes);

                    Element numFact = doc.createElement("NumFact");
                    numFact.appendChild(doc.createTextNode(String.valueOf(jTableFacturasCab.getValueAt(jTableFacturasCab.getSelectedRow(), 0))));
                    Clientes.appendChild(numFact);

                    Element dniCif = doc.createElement("dniCif");
                    dniCif.appendChild(doc.createTextNode(cli.getDnicif()));
                    Clientes.appendChild(dniCif);

                    Element nombreCli = doc.createElement("nombreCli");
                    nombreCli.appendChild(doc.createTextNode(cli.getNombrecli()));
                    Clientes.appendChild(nombreCli);

                    List lineas = new ArrayList(fcl.getFacturasLins());
                    lineas.sort(FacturasLin.ordenarLineas);
                    FacturasTot lineasTotal = fcl.getFacturasTot();

                    if (lineas.size() != 0) {

                        for (Iterator it = lineas.iterator(); it.hasNext();) {
                            FacturasLin flin = (FacturasLin) it.next();

                            Element FacturasLineas = doc.createElement("LineaFactura");
                            rootElement.appendChild(FacturasLineas);

                            Element numLine = doc.createElement("NumLin");
                            numLine.appendChild(doc.createTextNode(String.valueOf(flin.getId().getLineafac())));
                            FacturasLineas.appendChild(numLine);

                            Element referencia = doc.createElement("Referencia");
                            referencia.appendChild(doc.createTextNode(String.valueOf(flin.getArticulos().getReferencia())));
                            FacturasLineas.appendChild(referencia);

                            Element descripcion = doc.createElement("Descripcion");
                            descripcion.appendChild(doc.createTextNode(String.valueOf(flin.getArticulos().getDescripcion())));
                            FacturasLineas.appendChild(descripcion);

                            Element precio = doc.createElement("Precio");
                            precio.appendChild(doc.createTextNode(String.valueOf(flin.getPrecio())));
                            FacturasLineas.appendChild(precio);

                            Element cantidad = doc.createElement("Cantidad");
                            cantidad.appendChild(doc.createTextNode(String.valueOf(flin.getCantidad())));
                            FacturasLineas.appendChild(cantidad);

                            Element descuento = doc.createElement("Descuento");
                            descuento.appendChild(doc.createTextNode(String.valueOf(flin.getDtolinea())));
                            FacturasLineas.appendChild(descuento);

                            Element ivaLinea = doc.createElement("ivaLinea");
                            ivaLinea.appendChild(doc.createTextNode(String.valueOf(flin.getIvalinea())));
                            FacturasLineas.appendChild(ivaLinea);

                            double dlin = flin.getDtolinea().doubleValue() / 100;

                            double iva = flin.getIvalinea().doubleValue() / 100;

                            dlin2 = (100 - flin.getDtolinea().doubleValue()) / 100;

                            bImp = (flin.getCantidad().doubleValue() * flin.getPrecio().doubleValue());
                            bDescuentos = (bImp * dlin);
                            bIva = (flin.getCantidad().doubleValue() * flin.getPrecio().doubleValue() * dlin2 * iva);
                            bTotal = (bImp + bIva);
                            Element subtotal = doc.createElement("Subtotal");
                            subtotal.appendChild(doc.createTextNode(String.valueOf(bTotal)));
                            FacturasLineas.appendChild(subtotal);

                        }

                        Element FacturasTotal = doc.createElement("FcaturasTot");
                        rootElement.appendChild(FacturasTotal);

                        Element numLineFac = doc.createElement("NumFac");
                        numLineFac.appendChild(doc.createTextNode(String.valueOf(lineasTotal.getNumfac())));
                        FacturasTotal.appendChild(numLineFac);

                        Element baseImp = doc.createElement("BaseImponibleTotal");
                        baseImp.appendChild(doc.createTextNode(String.valueOf(lineasTotal.getBaseimp())));
                        FacturasTotal.appendChild(baseImp);

                        Element importDesc = doc.createElement("ImporteDescuentoTotal");
                        importDesc.appendChild(doc.createTextNode(String.valueOf(lineasTotal.getImpDto())));
                        FacturasTotal.appendChild(importDesc);

                        Element importIva = doc.createElement("ImportIvaTotal");
                        importIva.appendChild(doc.createTextNode(String.valueOf(lineasTotal.getImpIva())));
                        FacturasTotal.appendChild(importIva);

                        Element importTotal = doc.createElement("TotalFactura");
                        importTotal.appendChild(doc.createTextNode(String.valueOf(lineasTotal.getTotalfac())));
                        FacturasTotal.appendChild(importTotal);

                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
                        DOMSource source = new DOMSource(doc);
                        StreamResult result = new StreamResult(new File(fichero.getPath()));

                        transformer.transform(source, result);
                        JOptionPane.showMessageDialog(this, "Convertido a xml con exito");
                    } else {
                        JOptionPane.showMessageDialog(this, "Añde un linea, no se puede exportar una factura que no tenga lineas");

                    }

                } else {
                    JOptionPane.showMessageDialog(this, "No se ha exportado el fichero");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Fichero no valido, el fichero ha de ser xml");
            }
        } catch (ParserConfigurationException pce) {
            JOptionPane.showMessageDialog(Facturas, "Convertido a xml sin exito");
        } catch (TransformerConfigurationException ex) {
            JOptionPane.showMessageDialog(Facturas, "Convertido a xml sin exito");
        } catch (TransformerException ex) {
            JOptionPane.showMessageDialog(Facturas, "Convertido a xml sin exito");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(Facturas, "Convertido a xml sin exito");
        } catch (ArrayIndexOutOfBoundsException ae) {
            JOptionPane.showMessageDialog(Facturas, "SELECCIONA UNA FACTURA DE LA TABLA");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Facturas, "ALGO FALLO");

        }

    }

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        escribirXML();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        buscarFacturas();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        cargarDatosFacturas();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void insertarLineas() {
        long maxFact = 1;
        try {
            Clientes cli = controladorClientes.obtenerClienteId((String) jComboBoxClientes.getSelectedItem());
            Date fecha = new Date();
            FacturasCab fcag = new FacturasCab(Long.parseLong(jTextFieldNFactura3.getText()), cli);

            FacturasTot ft = new FacturasTot(fcag);

            HashSet e = new HashSet();

            FacturasCab fcb = new FacturasCab(Long.parseLong(jTextFieldNFactura3.getText()), cli, fecha, ft, e);

            boolean estado = controladorFacturas.crearFactura(fcb);

            File fichero = null;
            int seleccionar = jFileChooser1.showOpenDialog(Facturas);
            if (seleccionar == jFileChooser1.APPROVE_OPTION) {
                fichero = new File(jFileChooser1.getSelectedFile().getAbsolutePath());
            } else {
                JOptionPane.showMessageDialog(Facturas, "No selecciono ningun fichero");
            }

            if (fichero.exists() && !jTextFieldNFactura3.getText().isEmpty() && getFileExtension(fichero).equals(".xml")) {

                try {

                    DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    Document doc = db.parse(fichero);
                    Element nodoRaiz = doc.getDocumentElement();

                    if ("FACTURAS".equals(nodoRaiz.getNodeName())) {

                        NodeList listaLineas = nodoRaiz.getElementsByTagName("LineaFactura");
                        // NodeList listaCliente = nodoRaiz.getElementsByTagName("Clientes");

                        // Clientes cl = controladorClientes.obtenerClienteId(listaCliente.item(1).getTextContent());
                        for (int i = 0; i < listaLineas.getLength(); i++) {

                            Element elementoLinea = (Element) listaLineas.item(i);

                            FacturasLin flin = new FacturasLin();

                            FacturasLinId fld = new FacturasLinId();

                            Articulos art = controladorArticulos.obtenerArticulosId(elementoLinea.getElementsByTagName("Referencia").item(0).getChildNodes().item(0).getNodeValue());

                            BigDecimal precios = new BigDecimal(elementoLinea.getElementsByTagName("Precio").item(0).getChildNodes().item(0).getNodeValue());
                            BigDecimal cantidad = new BigDecimal(elementoLinea.getElementsByTagName("Cantidad").item(0).getChildNodes().item(0).getNodeValue());
                            BigDecimal descuentos = new BigDecimal(elementoLinea.getElementsByTagName("Descuento").item(0).getChildNodes().item(0).getNodeValue());
                            BigDecimal ival = new BigDecimal(elementoLinea.getElementsByTagName("ivaLinea").item(0).getChildNodes().item(0).getNodeValue());

                            FacturasCab fc = controladorFacturas.getListaFacturasID(Long.parseLong(jTextFieldNFactura3.getText().toString()));

                            if (fc != null) {
                                FacturasCab f = controladorFacturas.getListaFacturasID(Long.parseLong(String.valueOf(jTextFieldNFactura3.getText())));
                                List lineas = new ArrayList(f.getFacturasLins());
                                lineas.sort(FacturasLin.ordenarLineas);
                                for (Iterator it = lineas.iterator(); it.hasNext();) {
                                    FacturasLin fl = (FacturasLin) it.next();
                                    maxFact = fl.getId().getLineafac();
                                    maxFact += 1;
                                }

                                if (art.getStock().intValue() == 0) {
                                    maxFact -= 1;
                                } else {

                                    int restante = (art.getStock().intValue() - cantidad.intValue());
                                    if (restante >= 0) {

                                        long lineasFacturas = maxFact;
                                        fld.setLineafac(lineasFacturas);
                                        fld.setNumfac(fc.getNumfac());

                                        flin.setId(fld);
                                        flin.setArticulos(art);
                                        flin.setFacturasCab(fc);
                                        flin.setCantidad(cantidad);
                                        flin.setPrecio(precios);
                                        flin.setDtolinea(descuentos);
                                        flin.setIvalinea(ival);
                                        controladorFacturas.crearFacturaLinea(flin);
                                        //System.out.println(restante);
                                        art.setStock(new BigDecimal(restante));
                                        controladorArticulos.actualizaStock(art);
                                        factot();
                                    } else {
                                        long lineasFacturas = maxFact;
                                        fld.setLineafac(lineasFacturas);
                                        fld.setNumfac(fc.getNumfac());

                                        flin.setId(fld);
                                        flin.setArticulos(art);
                                        flin.setFacturasCab(fc);
                                        flin.setCantidad(cantidad);
                                        flin.setPrecio(precios);
                                        flin.setDtolinea(descuentos);
                                        flin.setIvalinea(ival);
                                        controladorFacturas.crearFacturaLinea(flin);
                                        //System.out.println(restante);
                                        art.setStock(new BigDecimal(0));
                                        controladorArticulos.actualizaStock(art);
                                        factot();
                                    }

                                }

                            } else {

                                if (art.getStock().intValue() == 0) {
                                } else {
                                    int restante = (art.getStock().intValue() - cantidad.intValue());

                                    if (restante >= 0) {
                                        long lineasFacturas = maxFact;
                                        fld.setLineafac(lineasFacturas);
                                        fld.setNumfac(fcb.getNumfac());

                                        flin.setId(fld);
                                        flin.setArticulos(art);
                                        flin.setFacturasCab(fcb);
                                        flin.setCantidad(cantidad);
                                        flin.setPrecio(precios);
                                        flin.setDtolinea(descuentos);
                                        flin.setIvalinea(ival);
                                        controladorFacturas.crearFacturaLinea(flin);
                                        //System.out.println(restante);
                                        art.setStock(new BigDecimal(restante));
                                        controladorArticulos.actualizaStock(art);
                                        factot();
                                    };
                                }
                            }
                        }
                        DefaultTableModel modelo = (DefaultTableModel) jTableNumLineas.getModel();
                        DefaultTableModel modelo2 = (DefaultTableModel) jTableNumTotal.getModel();
                        modelo.setRowCount(0);
                        modelo2.setRowCount(0);
                    } else {
                        JOptionPane.showMessageDialog(Facturas, "Formato de fichero no valido");
                    }

                } catch (SAXException ex) {
                    JOptionPane.showMessageDialog(Facturas, "Importado a xml sin exito");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(Facturas, "Importado a xml sin exito");
                } catch (ParserConfigurationException ex) {
                    JOptionPane.showMessageDialog(Facturas, "Importado a xml sin exito");
                } catch (NullPointerException ne) {
                    JOptionPane.showMessageDialog(Facturas, "Formato xml no valido");
                }

            } else {
                JOptionPane.showMessageDialog(this, "No existe el fichero o el numero de factura esta vacia");

            }
            cargarDatosFacturas();
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(this, "Escriba numero factura");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Algo fallo");
        }
    }

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        insertarLineas();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField2ActionPerformed

    private void calcularEstadisticas() {
        try {
            String fecha1 = jFormattedTextField2.getText();
            System.out.println(fecha1);

            String fecha2 = jFormattedTextField1.getText();
            System.out.println(fecha2);
            String dni = (String) jComboBox1.getSelectedItem();
            System.out.println(dni);
            String dni2 = (String) jComboBox2.getSelectedItem();
            System.out.println(dni2);
            ctrl_procedure controladorProcedure = new ctrl_procedure();
            controladorProcedure.ejecutaProcedure(fecha1, fecha2, dni, dni2);

            estadisticas = (ArrayList<EstadisticasClientes>) controladorEstadisticas.getEstadisticas();

            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            estadisticas = (ArrayList<EstadisticasClientes>) controladorEstadisticas.getEstadisticas();

            modelo.setRowCount(0);

            if (estadisticas.size() == 0) {
                JOptionPane.showMessageDialog(this, "No hay ninguna estadisitica para ese rango de fechas/clientes");
            } else {
                estadisticas.forEach((esta) -> {
                    modelo.addRow(new Object[]{esta.getId().getAnio(), esta.getId().getMesNum(), esta.getMesNom(), esta.getClientes().getDnicif(), esta.getClientes().getNombrecli(), esta.getSumaBase(), esta.getSumaDtos(), esta.getSumaIva(), esta.getSumaTotales()});
                });

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Campos vacios/fecha mal fomateada");
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        calcularEstadisticas();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void exportarJson() {
        try {
            double bImp = 0.0;
            double bDescuentos = 0.0;
            double bIva = 0.0;
            double bTotal = 0.0;
            double dlin2 = 0.0;
            FileWriter fw = null;
            boolean exito = false;
            BufferedWriter bf = null;
            int seleccionar = jFileChooser1.showOpenDialog(Facturas);

            File fichero = null;

            if (seleccionar == jFileChooser1.APPROVE_OPTION) {
                fichero = new File(jFileChooser1.getSelectedFile().getAbsolutePath());
                System.out.println(fichero.getAbsolutePath());
            } else {
                JOptionPane.showMessageDialog(Facturas, "No selecciono ningun fichero");
            }

            try {

                if (jTextFieldNFactura3.getText().isEmpty() && fichero.exists() && getFileExtension(fichero).equals(".json")) {
                    JOptionPane.showMessageDialog(Facturas, "Excriba un numero de factura");
                } else {

                    FacturasCab fcb = controladorFacturas.getListaFacturasID(Long.parseLong(jTextFieldNFactura3.getText()));

                    /* String nombreFichero = fcb.getNumfac() + ".json";
                File ficheroJson = new File(nombreFichero);
                if (!ficheroJson.exists()) {
                    ficheroJson.createNewFile();
                }*/
                    fw = new FileWriter(fichero);
                    bf = new BufferedWriter(fw);
                    bf.write("{\n");
                    bf.write("  \"Facturas\": {\n");
                    bf.write("\t\"Cliente\": {\n");
                    bf.write(" \t\"numFactura\": ");
                    bf.write('"' + String.valueOf(fcb.getNumfac()) + '"' + "," + "\n");
                    bf.write(" \t\"dniCif\": ");
                    bf.write('"' + fcb.getClientes().getDnicif() + '"' + "," + "\n");
                    bf.write(" \t\"nombreCliente\": ");
                    bf.write('"' + fcb.getClientes().getNombrecli() + '"' + "," + "\n");
                    bf.write(" \t\"Fecha\": ");
                    bf.write('"' + String.valueOf(fcb.getFechafac()) + '"' + "\n");
                    bf.write(" },\n");
                    bf.write("  \t\"LineasFacturas\": [\n");
                    int i = 0;
                    for (Iterator it = fcb.getFacturasLins().iterator(); it.hasNext();) {

                        FacturasLin flin = (FacturasLin) it.next();
                        bf.write(" \t{\n");
                        bf.write(" \t\"lineaFactura\": ");
                        bf.write('"' + String.valueOf(flin.getId().getLineafac()) + '"' + "," + "\n");
                        bf.write(" \t\"referencia\": ");
                        bf.write('"' + flin.getArticulos().getReferencia() + '"' + "," + "\n");
                        bf.write(" \t\"descripcion\": ");
                        bf.write('"' + flin.getArticulos().getDescripcion() + '"' + "," + "\n");
                        bf.write(" \t\"precio\": ");
                        bf.write('"' + flin.getArticulos().getPrecio().toString() + '"' + "," + "\n");
                        bf.write(" \t\"descuentoLinea\": ");
                        bf.write('"' + flin.getDtolinea().toString() + '"' + "," + "\n");
                        bf.write(" \t\"ivaLinea\": ");
                        bf.write('"' + flin.getIvalinea().toString() + '"' + "," + "\n");
                        bf.write(" \t\"cantidad\": ");
                        bf.write('"' + flin.getCantidad().toString() + '"' + "," + "\n");
                        bf.write(" \t\"subtotal\": ");

                        double dlin = flin.getDtolinea().doubleValue() / 100;

                        double iva = flin.getIvalinea().doubleValue() / 100;

                        dlin2 = (100 - flin.getDtolinea().doubleValue()) / 100;

                        bImp = (flin.getCantidad().doubleValue() * flin.getPrecio().doubleValue());
                        bDescuentos = (bImp * dlin);
                        bIva = (flin.getCantidad().doubleValue() * flin.getPrecio().doubleValue() * dlin2 * iva);
                        bTotal = (bImp + bIva);
                        bf.write('"' + bTotal + '"' + "\n");
                        if (i == fcb.getFacturasLins().size() - 1) {
                            bf.write(" \t}\n");
                        } else {
                            bf.write(" \t},\n");
                        }
                        i++;

                    }
                    bf.write("  \t],\n");
                    bf.write("\t\"FacturaTotal\": {\n");
                    bf.write(" \t\"numFactura\": ");
                    bf.write('"' + String.valueOf(fcb.getNumfac()) + '"' + "," + "\n");
                    bf.write(" \t\"total\": ");
                    bf.write('"' + fcb.getFacturasTot().getTotalfac().toString() + '"' + "\n");
                    bf.write("   }\n");
                    bf.write("  }\n");
                    bf.write(" }\n");
                }
            } catch (IOException ex) {
                exito = false;
            } finally {
                try {
                    bf.flush();
                    bf.close();
                    fw.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(Facturas, "Fallo al exportar, numero de factura vacia");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(Facturas, "Fallo al exportar");
                }
            }

        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(Facturas, "CAMPOS VACIOS");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Facturas, "Fallo al exportar");
        }
    }

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        exportarJson();
    }//GEN-LAST:event_jButton20ActionPerformed

    /* private void insertarLineasJson(FacturasLin flin) {
        System.out.println(flin.getArticulos().getDescripcion());
        controladorFacturas.crearFacturaLinea(flin);
    }*/
    public void importarJson() {
        long maxFact = 1;
        String lin = "";
        try {
            Clientes cli = controladorClientes.obtenerClienteId((String) jComboBoxClientes.getSelectedItem());
            Date fecha = new Date();
            FacturasCab fcag = new FacturasCab(Long.parseLong(jTextFieldNFactura3.getText()), cli);

            FacturasTot ft = new FacturasTot(fcag);

            HashSet e = new HashSet();

            FacturasCab fcb = new FacturasCab(Long.parseLong(jTextFieldNFactura3.getText()), cli, fecha, ft, e);

            boolean estado = controladorFacturas.crearFactura(fcb);
            File fichero = null;
            int seleccionar = jFileChooser1.showOpenDialog(Facturas);
            if (seleccionar == jFileChooser1.APPROVE_OPTION) {
                fichero = new File(jFileChooser1.getSelectedFile().getPath());
            } else {
                JOptionPane.showMessageDialog(Facturas, "No selecciono ningun fichero");
            }

            if (fichero.exists() && getFileExtension(fichero).equals(".json")) {
                FileReader fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr);
                List<String> datos = new ArrayList<>();

                while (br.read() != -1) {
                    lin = br.readLine();

                    String xa = null;
                    String xb = null;
                    String[] xc = null;
                    String xd = null;
                    String xe = null;
                    String xf = null;
                    String xg = null;
                    String[] xh = null;

                    if (lin.contains("lineaFactura")) {
                        String[] dato = lin.split(" ");
                        String[] S = dato[1].split(",");
                        xa = S[0].replace("\"", "");
                        datos.add(xa);
                        //System.out.println(xa);
                    } else if (lin.contains("referencia")) {
                        String[] dato = lin.split(" ");
                        String[] Sas = dato[1].split(",");
                        xb = Sas[0].replace("\"", "");
                        datos.add(xb);
                    } else if (lin.contains("descripcion")) {
                        String[] dato = lin.split(" ");
                        xc = dato[1].split(",");
                        datos.add(xc[0]);
                    } else if (lin.contains("precio")) {
                        String[] dato = lin.split(" ");
                        String[] asdsa = dato[1].split(",");
                        xd = asdsa[0].replace("\"", "");
                        datos.add(xd);
                    } else if (lin.contains("descuentoLinea")) {
                        String[] dato = lin.split(" ");
                        String[] asdsa = dato[1].split(",");
                        xe = asdsa[0].replace("\"", "");
                        datos.add(xe);
                    } else if (lin.contains("ivaLinea")) {
                        String[] dato = lin.split(" ");
                        String[] asdsa = dato[1].split(",");
                        xf = asdsa[0].replace("\"", "");
                        datos.add(xf);
                    } else if (lin.contains("cantidad")) {
                        String[] dato = lin.split(" ");
                        String[] asdsa = dato[1].split(",");
                        xg = asdsa[0].replace("\"", "");
                        datos.add(xg);
                    } else if (lin.contains("subtotal")) {
                        String[] dato = lin.split(" ");
                        xh = dato[1].split(",");
                        datos.add(xh[0]);

                        if (!estado) {
                            FacturasCab f = controladorFacturas.getListaFacturasID(Long.parseLong(String.valueOf(jTextFieldNFactura3.getText())));
                            List lineas = new ArrayList(f.getFacturasLins());
                            lineas.sort(FacturasLin.ordenarLineas);
                            for (Iterator it = lineas.iterator(); it.hasNext();) {
                                FacturasLin fl = (FacturasLin) it.next();
                                maxFact = fl.getId().getLineafac();
                                maxFact += 1;
                            }
                            //System.out.println(datos.get(1));
                            FacturasLinId fid = new FacturasLinId(fcb.getNumfac(), maxFact);
                            Articulos arti = controladorArticulos.obtenerArticulosId(datos.get(1));
                            FacturasLin flin = new FacturasLin(fid, arti, fcb, new BigDecimal(datos.get(5)), new BigDecimal(datos.get(3)), new BigDecimal(datos.get(4)), new BigDecimal(datos.get(5)));
                            if (arti.getStock().intValue() == 0) {
                                maxFact -= 1;
                            } else {

                                int restante = arti.getStock().intValue() - Integer.parseInt(datos.get(6));
                                if (restante > 0) {
                                    //System.out.println("Hola");
                                    controladorFacturas.crearFacturaLinea(flin);
                                    factot();
                                    //System.out.println(restante);
                                    arti.setStock(new BigDecimal(restante));
                                    controladorArticulos.actualizaStock(arti);
                                }

                            }

                            datos.removeAll(datos);

                        } else {
                            FacturasCab f = controladorFacturas.getListaFacturasID(Long.parseLong(String.valueOf(jTextFieldNFactura3.getText())));
                            List lineas = new ArrayList(f.getFacturasLins());
                            lineas.sort(FacturasLin.ordenarLineas);
                            //System.out.println(datos.get(1));
                            FacturasLinId fid = new FacturasLinId(fcb.getNumfac(), Long.parseLong(datos.get(0)));
                            Articulos arti = controladorArticulos.obtenerArticulosId(datos.get(1));
                            FacturasLin flin = new FacturasLin(fid, arti, fcb, new BigDecimal(datos.get(5)), new BigDecimal(datos.get(3)), new BigDecimal(datos.get(4)), new BigDecimal(datos.get(5)));
                            System.out.println("Hola");
                            if (arti.getStock().intValue() == 0) {

                            } else {

                                int restante = arti.getStock().intValue() - Integer.parseInt(datos.get(6));
                                if (restante > 0) {

                                    controladorFacturas.crearFacturaLinea(flin);
                                    factot();
                                    //System.out.println(restante);
                                    arti.setStock(new BigDecimal(restante));
                                    controladorArticulos.actualizaStock(arti);

                                }

                            }

                            datos.removeAll(datos);
                            //cargarDatosFacturas();
                        }
                    }
                }
                br.close();
                fr.close();
                cargarDatosFacturas();
                DefaultTableModel modelo = (DefaultTableModel) jTableNumLineas.getModel();
                DefaultTableModel modelo2 = (DefaultTableModel) jTableNumTotal.getModel();
                modelo.setRowCount(0);
                modelo2.setRowCount(0);
            } else {
                JOptionPane.showMessageDialog(Facturas, "Formato de fichero no valido");

            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(Facturas, "FICHERO NO ENCONTRADO");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(Facturas, "FALLO AL LEER");
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(Facturas, "DATOS NO VACIOS");
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(Facturas, "eSCRIBE UNA FACTURA");
        } catch (NullPointerException nl) {
            JOptionPane.showMessageDialog(Facturas, "FACTURA NO EXISTE");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Facturas, "NO SE PUDO IMPORTAR");
        }
        cargarDatosFacturas();
    }

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        importarJson();
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jTextFieldNFactura3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNFactura3KeyTyped
        // TODO add your handling code here:
        numerico(evt, jTextFieldNFactura5);
    }//GEN-LAST:event_jTextFieldNFactura3KeyTyped

    private void jTextFieldNFactura5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNFactura5KeyTyped
        // TODO add your handling code here:
        numerico(evt, jTextFieldNFactura5);
    }//GEN-LAST:event_jTextFieldNFactura5KeyTyped

    private void jTextFieldCantidad2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCantidad2KeyTyped
        // TODO add your handling code here:
        numerico(evt, jTextFieldCantidad2);
    }//GEN-LAST:event_jTextFieldCantidad2KeyTyped

    private void jTextFieldNFactura4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNFactura4KeyTyped
        // TODO add your handling code here:
        numerico(evt, jTextFieldNFactura4);
    }//GEN-LAST:event_jTextFieldNFactura4KeyTyped

    private void cargarPrecio() {

        if (jComboBoxArticulos.getSelectedItem() != null) {
            articulos3 = (ArrayList<Articulos>) controladorArticulos.obtenerArticuloDescripcion((String) jComboBoxArticulos.getSelectedItem());
            jTextFieldPrecio.setText(articulos3.get(0).getPrecio().toString());
        }

    }

    private void factot() {
        try {
            FacturasCab f = new FacturasCab();
            if (jTableFacturasCab.getSelectedRow() == -1) {
                f = controladorFacturas.getListaFacturasID(Long.parseLong(jTextFieldNFactura.getText()));

            } else {
                f = controladorFacturas.getListaFacturasID(Long.parseLong(String.valueOf(jTableFacturasCab.getValueAt(jTableFacturasCab.getSelectedRow(), 0))));
            }

            List lineas = new ArrayList();
            lineas = new ArrayList(f.getFacturasLins());
            System.out.println(f.getFacturasTot());
            DefaultTableModel modeloTotal = (DefaultTableModel) jTableNumTotal.getModel();
            FacturasTot lineasTotal = f.getFacturasTot();

            double bImp = 0.0;
            double bDescuentos = 0.0;
            double bIva = 0.0;
            double bTotal = 0.0;
            double dlin2 = 0.0;

            lineas.sort(FacturasLin.ordenarLineas);

            for (Iterator it = lineas.iterator(); it.hasNext();) {
                FacturasLin fl = (FacturasLin) it.next();
                double dlin = fl.getDtolinea().doubleValue() / 100;

                double iva = fl.getIvalinea().doubleValue() / 100;

                dlin2 = (100 - fl.getDtolinea().doubleValue()) / 100;

                bImp += (fl.getCantidad().doubleValue() * fl.getPrecio().doubleValue());
                bDescuentos += (bImp * dlin);
                bIva += (fl.getCantidad().doubleValue() * fl.getPrecio().doubleValue() * dlin2 * iva);
            }

            System.out.println(bImp + " " + bDescuentos + " " + bIva);
            bTotal = (bImp + bIva);

            if (f.getFacturasTot() == null) {
                // factot(f);
                FacturasTot ft = new FacturasTot(f, BigDecimal.valueOf(bImp), BigDecimal.valueOf(bDescuentos), BigDecimal.valueOf(bIva), BigDecimal.valueOf(bTotal));

                ft.setNumfac(f.getNumfac());
                controladorFacturas.creaModifica(false, ft);

                modeloTotal.setRowCount(0);
                modeloTotal.addRow(new Object[]{lineasTotal.getFacturasCab().getNumfac(), lineasTotal.getBaseimp(), lineasTotal.getImpDto(), lineasTotal.getImpIva(), lineasTotal.getTotalfac()});

            } else {
                FacturasTot ft = new FacturasTot(f, BigDecimal.valueOf(bImp), BigDecimal.valueOf(bDescuentos), BigDecimal.valueOf(bIva), BigDecimal.valueOf(bTotal));

                ft.setNumfac(f.getNumfac());

                controladorFacturas.creaModifica(true, ft);

                modeloTotal.setRowCount(0);
                modeloTotal.addRow(new Object[]{lineasTotal.getFacturasCab().getNumfac(), lineasTotal.getBaseimp(), lineasTotal.getImpDto(), lineasTotal.getImpIva(), lineasTotal.getTotalfac()});

            }

        } catch (NullPointerException ne) {
        } catch (NumberFormatException na) {
            JOptionPane.showMessageDialog(this, "Numero de factura vacia");
        } catch (ArrayIndexOutOfBoundsException ae) {
            JOptionPane.showMessageDialog(this, "Datos no validos");
        }
    }

    private void anadirLineaFacturas() {
        FacturasCab f = null;
        try {
            System.out.println((String) jComboBoxArticulos.getSelectedItem());
            Articulos articulo = controladorArticulos.obtenerArticulosDescripcion2((String) jComboBoxArticulos.getSelectedItem());
            //articulos2 = (controladorArticulos.obtenerArticuloDescripcion((String) jComboBoxArticulos.getSelectedItem());
            long maxFact = (long) 0.0;

            if (articulo.getStock().intValue() == 0) {
                JOptionPane.showMessageDialog(Facturas, "SIN STOCK DEL ARTICULO");
            } else if (Integer.parseInt(jTextFieldNFactura5.getText().toString()) > articulo.getStock().intValue()) {
                JOptionPane.showMessageDialog(Facturas, "STOCK SUPERIOR AL EXISTENTE");
                // System.out.println("EL ARTICULO " + articulos2.get(0).getDescripcion() + " " + articulos.get(0).getStock());
            } else {
                f = controladorFacturas.getListaFacturasID(Long.parseLong(String.valueOf(jTextFieldNFactura3.getText())));
                List lineas = new ArrayList(f.getFacturasLins());
                lineas.sort(FacturasLin.ordenarLineas);

                for (Iterator it = lineas.iterator(); it.hasNext();) {
                    FacturasLin fl = (FacturasLin) it.next();
                    maxFact = fl.getId().getLineafac();
                }

                if (maxFact == 0) {
                    maxFact = 1;
                    FacturasLinId fci = new FacturasLinId(Long.parseLong(jTextFieldNFactura3.getText()), maxFact);
                    HashSet li = new HashSet();
                    // Articulos articulo = controladorArticulos.obtenerArticulosId(articulos2.get(0).getReferencia());
                    int restante = (articulo.getStock().intValue() - Integer.parseInt(jTextFieldNFactura5.getText()));
                    //System.out.println(restante);
                    articulo.setStock(new BigDecimal(restante));

                    cargarDatosFacturas();

                    boolean estado = controladorArticulos.actualizaStock(articulo);

                    FacturasLin fcl = new FacturasLin(fci, articulo, f, BigDecimal.valueOf(Double.parseDouble(jTextFieldNFactura5.getText())), BigDecimal.valueOf(Double.parseDouble(jTextFieldPrecio.getText())), BigDecimal.valueOf(Double.parseDouble(jTextFieldCantidad2.getText())), BigDecimal.valueOf(Double.parseDouble(jTextFieldNFactura4.getText())));
                    boolean insertar = controladorFacturas.crearFacturaLinea(fcl);
                    if (insertar) {
                        JOptionPane.showMessageDialog(Facturas, "Añadido con exito");
                    } else {
                        JOptionPane.showMessageDialog(Facturas, "Añadido sin exito");
                    }
                    System.out.println("" + restante);
                } else {
                    maxFact += 1;
                    FacturasLinId fci = new FacturasLinId(Long.parseLong(jTextFieldNFactura3.getText()), maxFact);
                    //HashSet li = new HashSet();
                    /*BigDecimal CantidadDesplegable = BigDecimal.valueOf(Double.parseDouble((String) jComboBoxCantidad.getSelectedItem()));
                    BigDecimal StockRestante = articulos.get(0).getStock();
                    BigDecimal a = new BigDecimal("-1");
                    BigDecimal result = CantidadDesplegable.subtract(StockRestante);
                    BigDecimal resultadoFinal = result.multiply(a);*/
                    //Articulos articulo = controladorArticulos.obtenerArticulosId(articulos.get(0).getReferencia());

                    int restante = (articulo.getStock().intValue() - Integer.parseInt(jTextFieldNFactura5.getText()));
                    System.out.println("" + restante);
                    //Articulos art = new Articulos(articulos.get(0).getReferencia(), articulos.get(0).getDescripcion(), articulos.get(0).getPrecio(), articulos.get(0).getPorciva(), resultadoFinal, li);
                    articulo.setStock(new BigDecimal(restante));
                    controladorArticulos.actualizaStock(articulo);

                    FacturasLin fcl = new FacturasLin(fci, articulo, f, BigDecimal.valueOf(Double.parseDouble(jTextFieldNFactura5.getText())), BigDecimal.valueOf(Double.parseDouble(jTextFieldPrecio.getText())), BigDecimal.valueOf(Double.parseDouble(jTextFieldCantidad2.getText())), BigDecimal.valueOf(Double.parseDouble(jTextFieldNFactura4.getText())));
                    boolean insertar = controladorFacturas.crearFacturaLinea(fcl);

                    if (insertar) {

                        boolean estado = controladorArticulos.actualizaStock(articulo);
                        if (estado) {

                            JOptionPane.showMessageDialog(Facturas, "Añadido con exito");
                            // factot();

                        } else {
                            JOptionPane.showMessageDialog(Facturas, "Añadido sin exito");

                        }
                    } else {
                        JOptionPane.showMessageDialog(Facturas, "Añadido sin exito");
                    }

                }
            }

            if (jTableFacturasCab.getSelectedRow() != -1) {
                factot();
                cargarDatosArticulos();
                buscarNumLin();

                DefaultTableModel modelo = (DefaultTableModel) jTableNumLineas.getModel();
                DefaultTableModel modelo2 = (DefaultTableModel) jTableNumTotal.getModel();
                modelo.setRowCount(0);
                modelo2.setRowCount(0);

            }

        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(Facturas, "Datos invalidos");

        } catch (IndexOutOfBoundsException ie) {
            JOptionPane.showMessageDialog(Facturas, "SIN STOCK");
        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(Facturas, "Numero de factura no existe");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Facturas, "Numero de factura no valida, o algun campo vacio");
        }

    }

    private void buscarNumLin() {
        try {
            if (jTableFacturasCab.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(Facturas, "Selecciona una fila");

            }

            jTextFieldNFactura.setText(String.valueOf(jTableFacturasCab.getValueAt(jTableFacturasCab.getSelectedRow(), 0)));

            jComboBoxClientes.setSelectedItem(String.valueOf(jTableFacturasCab.getValueAt(jTableFacturasCab.getSelectedRow(), 2)));

            FacturasCab fcl = controladorFacturas.getListaFacturasID(Long.parseLong(String.valueOf(jTableFacturasCab.getValueAt(jTableFacturasCab.getSelectedRow(), 0))));

            List lineas = new ArrayList(fcl.getFacturasLins());
            lineas.sort(FacturasLin.ordenarLineas);
            FacturasTot lineasTotal = fcl.getFacturasTot();

            DefaultTableModel modeloLineas = (DefaultTableModel) jTableNumLineas.getModel();
            modeloLineas.setRowCount(0);

            DefaultTableModel modeloTotal = (DefaultTableModel) jTableNumTotal.getModel();
            modeloTotal.setRowCount(0);

            for (Iterator it = lineas.iterator(); it.hasNext();) {
                FacturasLin fc = (FacturasLin) it.next();
                modeloLineas.addRow(new Object[]{fc.getFacturasCab().getNumfac(), fc.getId().getLineafac(), fc.getArticulos().getReferencia(), fc.getCantidad().toString(), fc.getPrecio().toString(), fc.getDtolinea().toString(), fc.getIvalinea()});
            }

            if (lineasTotal != null) {
                factot();

            } else {
                factot();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Facturas, "Selecciona la fila de facturas");
        }

    }

    private void anadirFactura() {
        try {
            Clientes cli = controladorClientes.obtenerClienteId((String) jComboBoxClientes.getSelectedItem());
            Date fecha = new Date();
            FacturasCab fcag = new FacturasCab(Long.parseLong(jTextFieldNFactura.getText()), cli);

            FacturasTot ft = new FacturasTot(fcag);

            HashSet e = new HashSet();

            FacturasCab fcab = new FacturasCab(Long.parseLong(jTextFieldNFactura.getText()), cli, fecha, ft, e);

            boolean estado = controladorFacturas.crearFactura(fcab);
            if (!estado) {
                JOptionPane.showMessageDialog(Facturas, "Factura existente");
            }

            cargarDatosFacturas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Facturas, "Campos vacios");
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Articulos;
    private javax.swing.JButton AñadirLineaFactura;
    private javax.swing.JDialog Clientes;
    private javax.swing.JDialog Facturas;
    private javax.swing.JLabel Stock;
    private javax.swing.JTextField descripcion;
    private javax.swing.JTextField dnicif;
    private javax.swing.JTextField iva;
    private javax.swing.JButton jBuscarClientes;
    private javax.swing.JButton jBuscarClientes1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBoxArticulos;
    private javax.swing.JComboBox<String> jComboBoxClientes;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableArticulos;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTable jTableFacturasCab;
    private javax.swing.JTable jTableNumLineas;
    private javax.swing.JTable jTableNumTotal;
    private javax.swing.JTextField jTextFieldCantidad2;
    private javax.swing.JTextField jTextFieldNFactura;
    private javax.swing.JTextField jTextFieldNFactura3;
    private javax.swing.JTextField jTextFieldNFactura4;
    private javax.swing.JTextField jTextFieldNFactura5;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField nombreCli;
    private javax.swing.JTextField precio;
    private javax.swing.JTextField referencia;
    private javax.swing.JTextField stock;
    // End of variables declaration//GEN-END:variables
}
