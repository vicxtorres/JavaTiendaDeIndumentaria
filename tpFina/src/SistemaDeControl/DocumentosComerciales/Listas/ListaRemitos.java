package SistemaDeControl.DocumentosComerciales.Listas;

import SistemaDeControl.ClienteProveedor.Proveedor;
import SistemaDeControl.DocumentosComerciales.Remito;
import SistemaDeControl.Excepciones.ListaVacia;
import SistemaDeControl.Interfaces.I_metodosListas;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ListaRemitos implements I_metodosListas<Remito> {

    private HashMap<Proveedor,Remito> remitoHashMap;

    public ListaRemitos()
    {
        remitoHashMap = new HashMap<>();
    }

    /**getters y setters*/

    public HashMap<Proveedor, Remito> getRemitoHashMap() {
        return remitoHashMap;
    }

    public void setRemitoHashMap(HashMap<Proveedor, Remito> remitoHashMap) {
        this.remitoHashMap = remitoHashMap;
    }


    /**
     * equals and hashcode

     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListaRemitos that)) return false;

        return getRemitoHashMap() != null ? getRemitoHashMap().equals(that.getRemitoHashMap()) : that.getRemitoHashMap() == null;
    }



    @Override
    public int hashCode() {
       return 43;
    }


    /**
     * tostring
     * @return
     */
    @Override
    public String toString() {
        return "ListaRemitos{" +
                "remitoHashMap=" + remitoHashMap +
                '}';
    }


    /**
     * metodos heredados de la interfaz
     * @param elemento
     * @return
     */
    @Override
    public boolean borrar(Remito elemento) {
        boolean borrado = false;
        if (remitoHashMap.containsKey(elemento.getProveedor())) {
            remitoHashMap.remove(elemento.getProveedor());
            borrado = true;
        } else {
            throw new NoSuchElementException("No existe el remito");
        }
        return borrado;
    }

    @Override
    public boolean agregar(Remito elemento) {
        boolean agregado = false;
        if(remitoHashMap.containsValue(elemento.getNumero()))
        {
            throw new IllegalStateException("El Remito ya habia sido agregado.");
        }
        else
        {
            remitoHashMap.put(elemento.getProveedor(),elemento);
            agregado = true;
        }
        return agregado;
    }

    @Override
    public String listar() throws ListaVacia {
        if(remitoHashMap.isEmpty())
        {
            throw new ListaVacia("No hay remitos cargados.");
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Proveedor, Remito> entry : remitoHashMap.entrySet())
        {
            Remito remito = entry.getValue();
            sb.append(remito);
        }
        return sb.toString();
    }


    @Override
    public Remito buscar(Remito element) {
        if(remitoHashMap.containsValue(element.getNumero()))
        {
            return element;
        }
        else
        {
            throw new NoSuchElementException("No se encontró el remito");

        }
    }
}
