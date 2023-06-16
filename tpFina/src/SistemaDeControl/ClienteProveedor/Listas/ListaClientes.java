package SistemaDeControl.ClienteProveedor.Listas;

import SistemaDeControl.ClienteProveedor.Cliente;
import SistemaDeControl.Excepciones.CuitYaAgregado;
import SistemaDeControl.Excepciones.ListaVacia;
import SistemaDeControl.Excepciones.NoExisteElCuil;
import SistemaDeControl.Interfaces.I_metodosListas;

import java.util.ArrayList;

public class ListaClientes implements I_metodosListas<Cliente> {

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
            throw new ListaVacia("No hay clientes ingresados.")
        }
        StringBuilder sb = new StringBuilder();
        for(Cliente cliente : lista)
        {
            sb.append(cliente);

        }
        return sb.toString();
    }
}
