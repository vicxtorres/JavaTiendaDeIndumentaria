package SistemaDeControl.ClienteProveedor.Listas;

import SistemaDeControl.ClienteProveedor.Cliente;
import SistemaDeControl.Excepciones.CuitYaAgregado;
import SistemaDeControl.Excepciones.ListaVacia;
import SistemaDeControl.Excepciones.NoExisteElCuil;
import SistemaDeControl.Interfaces.I_Convertir_JsonArray;
import SistemaDeControl.Interfaces.I_metodosListas;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ListaClientes implements I_metodosListas<Cliente>, Serializable , I_Convertir_JsonArray {

    private ArrayList<Cliente> lista;


    /**Constructores
     */

    public ListaClientes(ArrayList<Cliente> lista)
    {
        this.lista = lista;
    }

    public ListaClientes()
    {
        lista = new ArrayList<>();
    }


    /**
     * metodos heredados de la interfaz generica
     */
    @Override
    public boolean borrar(Cliente cliente) {
        boolean borrado = false;
        if(lista.contains(cliente))
        {
            lista.remove(cliente);
            borrado = true;
        }
        else{
            throw new NoExisteElCuil("No existe el cliente. Agregue otro cuil.");
        }
        return borrado;
    }

    @Override
    public boolean agregar(Cliente cliente) {
      boolean agregado = false;
      if (lista.contains(cliente))
      {
          throw new CuitYaAgregado("Cliente ya agregado. Intente nuevamente.");
      }
      else
      {
          lista.add(cliente);
          agregado = true;
      }
      return agregado;
    }

    @Override
    public String listar() throws ListaVacia {
        if(lista.isEmpty())
        {
            throw new ListaVacia("No hay clientes ingresados.");
        }
        StringBuilder sb = new StringBuilder();
        for(Cliente cliente : lista)
        {
            sb.append(cliente);

        }
        return sb.toString();
    }

    @Override
    public Cliente buscar(Cliente element) {
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
        for (Cliente c:lista)
        {
            jsonArray.put ( c.convertirJsonObject () );
        }
        return jsonArray;

    }
}
