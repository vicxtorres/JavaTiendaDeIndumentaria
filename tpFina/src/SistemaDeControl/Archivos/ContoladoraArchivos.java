package SistemaDeControl.Archivos;

import SistemaDeControl.DocumentosComerciales.Documento;
import SistemaDeControl.DocumentosComerciales.Factura;
import SistemaDeControl.DocumentosComerciales.Remito;
import SistemaDeControl.Excepciones.ProductoInexistente;
import SistemaDeControl.Producto.Producto;
import SistemaDeControl.Producto.SetProductos;

import javax.print.Doc;
import javax.swing.text.Document;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContoladoraArchivos
{

    /**
     * Graba una objeto en un archivo...
     * Utiliza un tipo de dato genérico para reutilizar el algoritmo, el mismo debe implementar la interfaz Serializable.
     * @param objeto puede ser ListaClientes, ListaProveedores, MapaFacturas, MapaRemitos, SetProductos, Remito, Factura, etc
     * @param nombreArchivo debe terminar en .dat
     * @param <T>
     */
    public static <T extends Serializable> void grabar (T objeto, String nombreArchivo)
    {
        FileOutputStream fileOutputStream=null;
        ObjectOutputStream objectOutputStream = null;

        try
        {
            fileOutputStream = new FileOutputStream(nombreArchivo);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(objeto); //graba directamente la lista enviada por parametro
        }
        catch (IOException ex)
        {
            ex.getMessage();
        }

        finally {
            try
            {
                if(fileOutputStream!=null)
                    fileOutputStream.close();

                if(objectOutputStream!=null)
                    objectOutputStream.close();

            }catch (IOException ex)
            {
                ex.getMessage();
            }
        }
    }

    
    /**
     * Lee el archivo enviado y lo retorna como el objeto que lee el archivo (T)
     * @param <T>
     * @param nombreArchivo
     * @return objeto de tipo T
     */
    public static <T extends Serializable> T leer (String nombreArchivo)
    {
        T objeto = null;
        FileInputStream fileInputStream=null;
        ObjectInputStream objectInputStream=null;

        try
        {
            fileInputStream = new FileInputStream(nombreArchivo);
            objectInputStream = new ObjectInputStream(fileInputStream);

            objeto = (T) objectInputStream.readObject();

        }
        catch (EOFException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            try
            {
                if(fileInputStream!=null)
                    fileInputStream.close();
                if(objectInputStream!=null)
                    objectInputStream.close();
            }
            catch (IOException ex)
            {
                ex.getMessage();
            }
        }
        return objeto;
    }


    /**
     * Lee el archivo enviado y lo guarda en un Set de Producto
     * @param nombreArchivo
     * @return Set de Producto
     */
    public static SetProductos leerSetProductos (String nombreArchivo)
    {
        SetProductos setProductos =new SetProductos();
        FileInputStream fileInputStream=null;
        ObjectInputStream objectInputStream=null;

        try
        {
            fileInputStream = new FileInputStream(nombreArchivo);
            objectInputStream = new ObjectInputStream(fileInputStream);

            setProductos = (SetProductos) objectInputStream.readObject();
        }
        catch (EOFException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            try
            {
                if(fileInputStream!=null)
                    fileInputStream.close();
                if(objectInputStream!=null)
                    objectInputStream.close();
            }
            catch (IOException ex)
            {
                ex.getMessage();
            }
        }
        return setProductos;
    }


    /**
     * Lee una factura desde el archivo
     * @param nombreArchivo
     * @return
     */
    public static Documento leerDocumento (String nombreArchivo)
    {
        Documento documento = new Documento();
        FileInputStream fileInputStream=null;
        ObjectInputStream objectInputStream=null;

        try
        {
            fileInputStream = new FileInputStream(nombreArchivo);
            objectInputStream = new ObjectInputStream(fileInputStream);

            documento = (Documento) objectInputStream.readObject();
        }
        catch (EOFException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            try
            {
                if(fileInputStream!=null)
                    fileInputStream.close();
                if(objectInputStream!=null)
                    objectInputStream.close();
            }
            catch (IOException ex)
            {
                ex.getMessage();
            }
        }
        return documento;
    }

    
    
    /** Utiliza un numero de factura pasado por teclado para modificar STOCK
     * @param numeroFactura
     */
    public static void modificarStockConFactura (int numeroFactura)
    {
        String numero = "Factura" + numeroFactura +".dat";
        Documento factura = ContoladoraArchivos.leerDocumento(numero);
        SetProductos stock = ContoladoraArchivos.leerSetProductos("StockDeTienda.dat");
        for(Producto p : factura.getListadoProductos().getProductos())
        {
            try{
                stock.borrar(p);

            }
            catch (ProductoInexistente e) {
                e.getMessage();
            }
        }
        ContoladoraArchivos.grabar(stock, "StockDeTienda.dat");
    }


    /** Utiliza un numero de remito pasado por teclado para modificar STOCK
     * @param numeroRemito
     */
    public static void modificarStockConRemito (int numeroRemito)
    {
        String numero = "Remito" + numeroRemito +".dat";
        Documento remito = ContoladoraArchivos.leerDocumento(numero);
        SetProductos stock = ContoladoraArchivos.leerSetProductos("StockDeTienda.dat");
        for(Producto p : remito.getListadoProductos().getProductos())
        {
            stock.agregar(p);
        }
        ContoladoraArchivos.grabar(stock, "StockDeTienda.dat");

    }

    
    
    /**
     * Modifica el stock de un producto manualmente
     * @param sku del producto a modificar
     * @param nuevoStock del producto
     */
    public static void modificarStockManualmente (int sku, int nuevoStock)
    {
        SetProductos stock = ContoladoraArchivos.leerSetProductos("StockDeTienda.dat");
        for(Producto p : stock.getProductos())
        {
            if(p.getSKU() == sku)
            {
                p.setStock(nuevoStock);
            }
        }
        ContoladoraArchivos.grabar(stock, "StockDeTienda.dat");
    }


    /**
     * metodo para visualizar la factura
     * @param numeroFactura
     * @return el string de la misma
     */

    public static String verFactura (int numeroFactura)
    {
        String numero = "Factura" + numeroFactura +".dat";
        Documento factura = ContoladoraArchivos.leerDocumento(numero);
        return factura.toString();
    }

    public static String verRemito (int numeroRemito)
    {
        String numero = "Remito" +numeroRemito+".dat";
        Documento remito = ContoladoraArchivos.leerDocumento(numero);
        return remito.toString();
    }
}

