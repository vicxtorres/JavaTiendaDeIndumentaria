package SistemaDeControl.DocumentosComerciales.Listas;

import SistemaDeControl.ClienteProveedor.Cliente;
import SistemaDeControl.DocumentosComerciales.Factura;
import SistemaDeControl.DocumentosComerciales.Remito;
import SistemaDeControl.Excepciones.ListaVacia;
import SistemaDeControl.Interfaces.I_metodosListas;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ListaFacturas implements I_metodosListas<Factura> {

    private HashMap<Cliente, Factura> facturaHashMap;



    /**constructor */

    public ListaFacturas()
    {
        facturaHashMap = new HashMap<>();
    }


    /**getter */
    public HashMap<Cliente, Factura> getFacturaHashMap() {
        return facturaHashMap;
    }

    /**
     * metodos heredados desde la interfaz
     * @param elemento
     * @return
     */
    @Override
    public boolean borrar(Factura elemento) {
    boolean borrado = false;
    if(facturaHashMap.containsKey(elemento.getCliente()))
    {
        facturaHashMap.remove(elemento.getCliente());
        borrado = true;
    }
    else
    {
        throw new NoSuchElementException("No existe la factura ingresada.");
    }
    return borrado;
    }

    @Override
    public boolean agregar(Factura elemento) {
        boolean agregado = false;
        if(facturaHashMap.containsValue(elemento.getNumero()))
        {
            throw new IllegalStateException("La factura ya fue ingresada previamente.");
        }
        else{
            facturaHashMap.put(elemento.getCliente(),elemento);
            agregado = true;
        }
        return agregado;
    }

    @Override
    public String listar() throws ListaVacia {
    if(facturaHashMap.isEmpty())
    {
        throw new ListaVacia("No hay facturas cargadas.");
    }
    StringBuilder sb = new StringBuilder();
    for(Map.Entry<Cliente, Factura> entry : facturaHashMap.entrySet())
    {
        Factura f = entry.getValue();
        sb.append(f);
    }
    return sb.toString();
    }

    @Override
    public Factura buscar(Factura element) {
        if(facturaHashMap.containsValue(element.getNumero()))
        {
            return element;
        }
        else
        {
            throw  new NoSuchElementException("No se encontró la factura.");
        }
    }
}
