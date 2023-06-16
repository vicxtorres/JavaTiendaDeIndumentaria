package SistemaDeControl.ClienteProveedor.Listas;

import SistemaDeControl.Excepciones.CuitYaAgregado;
import SistemaDeControl.Excepciones.ListaVacia;
import SistemaDeControl.Excepciones.NoExisteElCuil;
import SistemaDeControl.Interfaces.I_metodosListas;

import java.util.ArrayList;


/**
 * es una plantilla para una eventual lista de proveedores o clientes.
 * @param <T> clase proveedor o cliente
 */
public class ListaProveedoresClientes <T> implements I_metodosListas  {

    private ArrayList <T> lista;


    /**
     * agrega un elemento (cliente o proveedor) a la lista
     * @param elemento es el cliente o proveedor
     * @return si fue agregado correctamente, un boolean que es true.
     */

    @Override
    public boolean agregar(T elemento) {
        boolean agregado = false;
        if(lista.contains(elemento))
        {
            throw new CuitYaAgregado("Cuit ya Agregado previamente. Pruebe con otro cuit.");
        }
        else
        {
            lista.add(elemento);
            agregado = true;
        }
        return agregado;
    }


    /**
     * borra un cliente o un proveedor de la lista.
     * @return
     */

    @Override
    public boolean borrar(T elemento) {
        boolean borrado = false;
     if(lista.contains(elemento))
     {
         lista.remove(elemento);
         borrado = true;
     }
     else {
         throw new NoExisteElCuil("No existe el cuil en la lista. No se puede borrar.");
     }

     return borrado;
    }

    @Override
    public String listar() throws ListaVacia {
        if(lista.isEmpty())
        {
            throw new ListaVacia("No hay Cuits ingresados!");
        }
        StringBuilder sb = new StringBuilder();
        for(T element : lista)
        {
            sb.append(element);
        }
        return sb.toString();
    }


}
