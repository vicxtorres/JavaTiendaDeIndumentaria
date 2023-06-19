package SistemaDeControl.Interfaces;

import SistemaDeControl.Excepciones.ListaVacia;
import SistemaDeControl.Excepciones.ProductoInexistente;

import java.util.ArrayList;

public interface I_metodosListas <T>  {

    public boolean borrar(T elemento) throws ProductoInexistente;

    public boolean agregar(T elemento);

    public String listar() throws ListaVacia, ProductoInexistente;

    public T buscar(T element) throws ProductoInexistente;

}

