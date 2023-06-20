package SistemaDeControl.ClienteProveedor.Listas;

import SistemaDeControl.ClienteProveedor.Proveedor;
import SistemaDeControl.Excepciones.CuitYaAgregado;

import SistemaDeControl.Excepciones.ColeccionVacia;
import SistemaDeControl.Excepciones.NoExisteElCuil;
import SistemaDeControl.Interfaces.I_Convertir_JsonArray;
import SistemaDeControl.Interfaces.I_metodosColeccion;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.NoSuchElementException;


/**
 * es una plantilla para una eventual lista de proveedores o clientes.

 */
public class ListaProveedores implements I_metodosColeccion<Proveedor>, Serializable, I_Convertir_JsonArray {

    private ArrayList <Proveedor> lista;


    /**constructores*/

    public ListaProveedores()
    {
        lista = new ArrayList<>();
    }
    public ListaProveedores(ArrayList<Proveedor> lista)
    {this.lista = lista;}



    /**
     * agrega un elemento (cliente o proveedor) a la lista
     * @param proveedor es el cliente o proveedor
     * @return si fue agregado correctamente, un boolean que es true.
     */

    @Override
    public boolean agregar(Proveedor proveedor) {
        boolean agregado = false;
        if(lista.contains(proveedor))
        {
            throw new CuitYaAgregado("Cuit ya Agregado previamente. Pruebe con otro cuit.");
        }
        else
        {
            lista.add(proveedor);
            agregado = true;
        }
        return agregado;
    }


    /**
     * borra un cliente o un proveedor de la lista.
     * @return
     */

    @Override
    public boolean borrar(Proveedor proveedor) {
        boolean borrado = false;
     if(lista.contains(proveedor))
     {
         lista.remove(proveedor);
         borrado = true;
     }
     else {
         throw new NoExisteElCuil("No existe el cuil en la lista. No se puede borrar.");
     }

     return borrado;
    }

    @Override
    public String listar() throws ColeccionVacia {
        if(lista.isEmpty())
        {
            throw new ColeccionVacia("No hay proveedores ingresados!");
        }
        StringBuilder sb = new StringBuilder();
        for(Proveedor proveedor : lista)
        {
            sb.append(proveedor);
        }
        return sb.toString();
    }


    @Override
    public Proveedor buscar(Proveedor element) {
        if(lista.contains(element))
        {
            return element;
        }
        else
        {
            throw new NoSuchElementException("No se encontró el cliente.");
        }

    }

    /**Json
     *
     * @return
     * @throws JSONException
     */
    @Override
    public JSONArray convertirJsonArray() throws JSONException {
        JSONArray jsonArray = new JSONArray ();
        for (Proveedor p:lista) {
            jsonArray.put ( p.convertirJsonObject () );
        }
        return jsonArray;
    }

    @Override
    public String toString() {
        return "Lista de Proveedores: " + lista ;
    }
}
