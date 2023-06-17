package SistemaDeControl.Interfaces;

import SistemaDeControl.Excepciones.ListaVacia;

import java.util.ArrayList;

public interface I_metodosListas <T>  {

    public boolean borrar(T elemento);

    public boolean agregar(T elemento);

    public String listar() throws ListaVacia;

    public T buscar(T element);

}

