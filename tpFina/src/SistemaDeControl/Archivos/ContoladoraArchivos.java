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
     * Graba una lista de cualquier clase en un archivo...
     * Utiliza un tipo de dato genérico para reutilizar el algoritmo, el mismo debe implementar la interfaz Serializable.
     * @param lista puede ser ListaClientes, ListaProveedores, etc
     * @param nombreArchivo debe terminar en .dat
     * @param <T>
     */
    public static <T extends Serializable> void grabarListas (T lista, String nombreArchivo)
    {
        FileOutputStream fileOutputStream=null;
        ObjectOutputStream objectOutputStream = null;

        try
        {
            fileOutputStream = new FileOutputStream(nombreArchivo);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(lista); //graba directamente la lista enviada por parametro
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
     * Graba un HashMap de cualquier tipo en un archivo. Utiliza un entrySet para guardar cada elemento.
     * @param hashMap
     * @param nombreArchivo
     * @param <K>
     * @param <V>
     */
    public static <K extends Serializable, V extends Serializable> void grabarHashMap (HashMap<K,V> hashMap, String nombreArchivo)
    {
        FileOutputStream fileOutputStream=null;
        ObjectOutputStream objectOutputStream = null;

        try
        {
            fileOutputStream = new FileOutputStream(nombreArchivo);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for (Map.Entry<K, V> entry : hashMap.entrySet()) {
                K clave = entry.getKey();
                V valor = entry.getValue();
                objectOutputStream.writeObject(clave);
                objectOutputStream.writeObject(valor);
            }
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
     * Graba un TreeSet de Producto
     * @param nombreArchivo debe terminar en .dat
     */
    public static void grabarSetProductos (SetProductos setProductos, String nombreArchivo)
    {
        FileOutputStream fileOutputStream=null;
        ObjectOutputStream objectOutputStream = null;

        try
        {
            fileOutputStream = new FileOutputStream(nombreArchivo);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(setProductos);
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
     * Lee el archivo enviado y lo guarda en un ArrayList del tipo que sea
     *
     * @param <T>
     * @param nombreArchivo
     * @return un ArrayList
     */
    public static <T extends Serializable> T leerLista (String nombreArchivo)
    {
        T lista = null;
        FileInputStream fileInputStream=null;
        ObjectInputStream objectInputStream=null;

        try
        {
            fileInputStream = new FileInputStream(nombreArchivo);
            objectInputStream = new ObjectInputStream(fileInputStream);

            lista = (T) objectInputStream.readObject();
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
        return lista;
    }


    /**
     * Lee el archivo enviado y lo guarda en un TreeSet de Producto
     * @param nombreArchivo
     * @return TreeSet de Producto
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
     * Lee el archivo enviado y lo guarda en un HashMap
     * @param nombreArchivo
     * @return un HashMap
     * @param <K>
     * @param <V>
     */
    public static <K extends Serializable, V extends Serializable> HashMap<K,V> leerHashMap (String nombreArchivo)
    {
        HashMap<K,V> hashMap = new HashMap<K, V>();
        FileInputStream fileInputStream=null;
        ObjectInputStream objectInputStream=null;

        try
        {
            fileInputStream = new FileInputStream(nombreArchivo);
            objectInputStream = new ObjectInputStream(fileInputStream);


            while (true) {
                K clave = (K) objectInputStream.readObject();
                V valor = (V) objectInputStream.readObject();
                hashMap.put(clave, valor);
            }
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
        return hashMap;
    }


    /** graba una factura en un archivo
     *
     * @param factura la factura cargada
     * @param nombreArchivo nombre del archivo
     */
    public static void grabarFactura (Factura factura, String nombreArchivo)
    {
        FileOutputStream fileOutputStream=null;
        ObjectOutputStream objectOutputStream = null;

        try
        {
            fileOutputStream = new FileOutputStream(nombreArchivo);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(factura);
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
     * leer una factura desde un archivo
     */
    public static Documento leerFactura (String nombreArchivo)
    {
        Documento factura = new Factura();
        FileInputStream fileInputStream=null;
        ObjectInputStream objectInputStream=null;

        try
        {
            fileInputStream = new FileInputStream(nombreArchivo);
            objectInputStream = new ObjectInputStream(fileInputStream);

            factura = (Documento) objectInputStream.readObject();
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
        return factura;
    }


    /**AHORA LO MISMO CON REMITOS
     *
     */

    public static void grabarRemito (Remito remito, String nombreArchivo)
    {
        FileOutputStream fileOutputStream=null;
        ObjectOutputStream objectOutputStream = null;

        try
        {
            fileOutputStream = new FileOutputStream(nombreArchivo);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(remito);
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


    public static Documento leerRemito (String nombreArchivo)
    {
        Documento remito = new Remito();
        FileInputStream fileInputStream=null;
        ObjectInputStream objectInputStream=null;

        try
        {
            fileInputStream = new FileInputStream(nombreArchivo);
            objectInputStream = new ObjectInputStream(fileInputStream);

            remito = (Documento) objectInputStream.readObject();
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
        return remito;
    }


    public static void grabarProducto (Producto producto, String nombreArchivo)
    {
        FileOutputStream fileOutputStream=null;
        ObjectOutputStream objectOutputStream = null;

        try
        {
            fileOutputStream = new FileOutputStream(nombreArchivo);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(producto);
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


    /** metodo que utiliza un numero de factura pasado por teclado
     * para modificar stock
     */

    public static void modificarConFactura (int numeroFactura)
    {
        String numero = "Factura" + numeroFactura +".dat";
        Documento factura = ContoladoraArchivos.leerFactura(numero);
        SetProductos stock = ContoladoraArchivos.leerSetProductos("Stock de tienda");
        for(Producto p : factura.getListadoProductos().getProductos())
        {
            try{
                stock.borrar(p);

            }
            catch (ProductoInexistente e) {
                e.getMessage();
            }
        }
        ContoladoraArchivos.grabarSetProductos(stock, "Stock de tienda");

    }

    public static void modificarStockConRemito (int numeroRemito)
    {
        String numero = "Remito" + numeroRemito +".dat";
        Documento remito = ContoladoraArchivos.leerRemito(numero);
        SetProductos stock = ContoladoraArchivos.leerSetProductos("Stock de tienda");
        for(Producto p : remito.getListadoProductos().getProductos())
        {
            stock.agregar(p);
        }
        ContoladoraArchivos.grabarSetProductos(stock, "Stock de tienda");

    }

    public static void modificarStockManualmente (int sku, int nuevoStock)
    {
        SetProductos stock = ContoladoraArchivos.leerSetProductos("Stock de tienda");
        for(Producto p : stock.getProductos())
        {
            if(p.getSKU() == sku)
            {
                p.setStock(nuevoStock);
            }
        }
        ContoladoraArchivos.grabarSetProductos(stock, "Stock de tienda");
    }


}

