package SistemaDeControl;

import SistemaDeControl.Producto.Accesorio.Accesorio;
import SistemaDeControl.Producto.Calzado.Calzado;
import SistemaDeControl.Producto.Indumentaria.Indumentaria;
import SistemaDeControl.Producto.Producto;
import SistemaDeControl.Producto.SetProductos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static SistemaDeControl.Archivos.ContoladoraArchivos.*;

public class MenuInterfazGrafica extends JFrame {

    private CardLayout cardLayout;
    private JPanel menuPrincipal;
    private JPanel subMenuStock;
    private JPanel subMenuActualizar;
    private JPanel subMenuDocumentos;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;


    public MenuInterfazGrafica() {
        setTitle("Menú");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        menuPrincipal();
        submenuStock();
        submenuActualizar();
        submenuDocumentos();

        add(menuPrincipal, "mainMenu");
        add(subMenuStock, "subMenuStock");
        add(subMenuActualizar,"subMenuActualizar");
        add(subMenuDocumentos, "subMenuDocumentos");

        cardLayout.show(getContentPane(), "mainMenu");
    }



    /**
     * MENU PRINCIPAL DEL SISTEMA DE INVENTARIO
     */
    private void menuPrincipal() {
        menuPrincipal = new JPanel();
        menuPrincipal.setLayout(new GridLayout(4, 1));


        /**SUBMENU DE TIENDA*/
        button1 = new JButton("Ver Stock de Tienda");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Has seleccionado ver el stock de la tienda.");
                cardLayout.show(getContentPane(), "subMenuStock");
            }
        });
        menuPrincipal.add(button1);


        /**SUBMENU ACTUALIZACION STOCK*/
        button2 = new JButton("Actualizar Stock");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción "Actualizar Stock"
                JOptionPane.showMessageDialog(null, "Has seleccionado actualizar el stock de la tienda.");
                cardLayout.show(getContentPane(), "subMenuActualizar");
            }
        });
        menuPrincipal.add(button2);


        /**SUBMENU DOCUMENTOS COMERCIALES*/
        button3 = new JButton("Ver Documentos Comerciales");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción "Ver Documentos Comerciales"
                JOptionPane.showMessageDialog(null, "Has seleccionado ver documentos comerciales.");
                cardLayout.show(getContentPane(), "subMenuDocumentos");
            }
        });
        menuPrincipal.add(button3);


        /**BOTON CERRAR PROGRAMA*/
        button4 = new JButton("Cerrar Programa");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuPrincipal.add(button4);

        add(menuPrincipal, BorderLayout.CENTER);
    }

    private void submenuStock() {
        subMenuStock = new JPanel();
        subMenuStock.setLayout(new GridLayout(4, 1));

        /**Boton opcion stock completo*/
        JButton subButton1 = new JButton("Stock Completo");
        subButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción 1 del submenú, STOCK COMPLETO
                SetProductos stock =  leerSetProductos("Stock de tienda");
                stock = leerSetProductos("StockDeTienda.dat");
                JOptionPane.showMessageDialog(null, stock.toString());
            }
        });
        subMenuStock.add(subButton1);


        /**Boton opcion calzado*/
        JButton subButton2 = new JButton("Calzado");
        subButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción 2 del submenú
                SetProductos stock =  leerSetProductos("Stock de tienda");
                stock = leerSetProductos("StockDeTienda.dat");
                StringBuilder sb = new StringBuilder();
                for (Producto p : stock.getProductos())
                {
                    if(p instanceof Calzado)
                    {
                        sb.append("-----------------------"+p+"\n");
                    }
                }
                JOptionPane.showMessageDialog(null, sb);
            }
        });
        subMenuStock.add(subButton2);


        /**Boton opcion indumentaria*/
        JButton subButton3 = new JButton("Indumentaria");
        subButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción 3 del submenú
                SetProductos stock =  leerSetProductos("Stock de tienda");
                stock = leerSetProductos("StockDeTienda.dat");
                StringBuilder sb = new StringBuilder();
                for (Producto p : stock.getProductos())
                {
                    if(p instanceof Indumentaria)
                    {
                        sb.append("-----------------------"+p+"\n");
                    }
                }
                JOptionPane.showMessageDialog(null, sb);
            }
        });
        subMenuStock.add(subButton3);


        /**Boton opcion accesorio*/
        JButton subButton4 = new JButton("Accesorio");
        subButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción 4 del submenú
                SetProductos stock =  leerSetProductos("Stock de tienda");
                stock = leerSetProductos("StockDeTienda.dat");
                StringBuilder sb = new StringBuilder();
                for (Producto p : stock.getProductos())
                {
                    if(p instanceof Accesorio)
                    {
                        sb.append("-----------------------"+p+"\n");
                    }
                }
                JOptionPane.showMessageDialog(null, sb);
            }
        });
        subMenuStock.add(subButton4);


        /**Boton opcion volver atras*/
        JButton backButton = new JButton("Volver al menú principal");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(getContentPane(), "mainMenu");
            }
        });
        subMenuStock.add(backButton);
    }

    private void submenuActualizar() {
        subMenuActualizar = new JPanel();
        subMenuActualizar.setLayout(new GridLayout(4, 1));


        /**Boton opcion agregar factura*/
        JButton subButton1 = new JButton("Dar Factura");
        subButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroNuevaFacturaStr = JOptionPane.showInputDialog("Ingrese el número de la factura realizada:");
                try {
                    int numeroNuevaFactura = Integer.parseInt(numeroNuevaFacturaStr);
                    modificarStockConFactura(numeroNuevaFactura);
                    JOptionPane.showMessageDialog(null, "Actualización realizada: el stock disminuyó");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: el número de factura ingresado no es válido");
                }
            }
        });
        subMenuActualizar.add(subButton1);


        /**Boton opcion agregar remito*/
        JButton subButton2 = new JButton("Recibir Remito");
        subButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroNuevoRemitoStr = JOptionPane.showInputDialog("Ingrese el número del remito recibido");
                try {
                    int numeroNuevoRemito = Integer.parseInt(numeroNuevoRemitoStr);
                    modificarStockConRemito(numeroNuevoRemito);
                    JOptionPane.showMessageDialog(null, "Actualización realizada: el stock aumentó");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: el número de remito ingresado no es válido");
                }
            }
        });
        subMenuActualizar.add(subButton2);


        /**Boton opcion modificar stock manualmente*/
        JButton subButton3 = new JButton("Modificar Stock Manualmente");
        subButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String SKU = JOptionPane.showInputDialog("Ingrese el SKU del producto a modificar: ");
                    int elSKU = Integer.parseInt(SKU);

                    String stock = JOptionPane.showInputDialog("Ingrese el stock nuevo: ");
                    int stockNuevo = Integer.parseInt(stock);

                    modificarStockManualmente(elSKU,stockNuevo);

                    JOptionPane.showMessageDialog(null, "Actualización realizada");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: el número de remito ingresado no es válido");
                }
            }
        });
        subMenuActualizar.add(subButton3);


        /**Boton opcion volver atras*/
        JButton backButton = new JButton("Volver al menú principal");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(getContentPane(), "mainMenu");
            }
        });
        subMenuActualizar.add(backButton);
    }

    private void submenuDocumentos() {
        subMenuDocumentos = new JPanel();
        subMenuDocumentos.setLayout(new GridLayout(4, 1));

        /**Boton opcion ver factura determinada por su numero*/
        JButton subButton1 = new JButton("Factura Determinada");
        subButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String numeroNuevaFacturaStr = JOptionPane.showInputDialog("Ingrese el número de la factura que desea ver:");
                try {
                    int numeroNuevaFactura = Integer.parseInt(numeroNuevaFacturaStr);
                    JOptionPane.showMessageDialog(null, verFactura(numeroNuevaFactura));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: el número de factura ingresado no es válido");
                }
            }
        });
        subMenuDocumentos.add(subButton1);



        /**Boton opcion ver remito determinado por su numero*/
        JButton subButton2 = new JButton("Remito determinado");
        subButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroRemitoStr = JOptionPane.showInputDialog("Ingrese el número de la remito que desea ver:");
                try {
                    int numeroRemito = Integer.parseInt(numeroRemitoStr);
                    JOptionPane.showMessageDialog(null, verRemito(numeroRemito));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: el número de remito ingresado no es válido");
                }
            }
        });
        subMenuDocumentos.add(subButton2);



        /**Boton opcion volver atras*/
        JButton backButton = new JButton("Volver al menú principal");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(getContentPane(), "mainMenu");
            }
        });
        subMenuDocumentos.add(backButton);

    }




}
