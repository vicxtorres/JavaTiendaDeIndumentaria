package SistemaDeControl.Archivos;

import SistemaDeControl.Producto.Producto;
import SistemaDeControl.Producto.SetProductos;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContoladoraArchivos
{

    /**
     * Graba un ArrayList de cualquier clase en un archivo...
     * Utiliza un tipo de dato genérico para reutilizar el algoritmo, el mismo debe implementar la interfaz Serializable.
     * @param arrayList
     * @param nombreArchivo debe terminar en .dat
     * @param <T>
     */
    public static <T extends Serializable> void grabarArrayList (ArrayList<T> arrayList, String nombreArchivo)
    {
        FileOutputStream fileOutputStream=null;
        ObjectOutputStream objectOutputStream = null;

        try
        {
            fileOutputStream = new FileOutputStream(nombreArchivo);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for(T elemento : arrayList)
            {
                objectOutputStream.writeObject(elemento);
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
     * @param treeSet
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
    public static <T extends Serializable> ArrayList<T> leerArrayList (String nombreArchivo)
    {
        ArrayList<T> arrayList =new ArrayList<T>();
        FileInputStream fileInputStream=null;
        ObjectInputStream objectInputStream=null;

        try
        {
            fileInputStream = new FileInputStream(nombreArchivo);
            objectInputStream = new ObjectInputStream(fileInputStream);

            while(true)
            {
                T aux = (T) objectInputStream.readObject();
                arrayList.add(aux);
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
        return arrayList;
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


}
