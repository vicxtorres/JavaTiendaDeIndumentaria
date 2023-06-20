package SistemaDeControl.Interfaces;

import SistemaDeControl.Excepciones.ColeccionVacia;
import SistemaDeControl.Excepciones.ProductoInexistente;

public interface I_metodosColeccion <T>
{
    public boolean borrar(T elemento) throws ProductoInexistente;

    public boolean agregar(T elemento);

    public String listar() throws ColeccionVacia, ProductoInexistente;

    public T buscar(T element) throws ProductoInexistente;

}
