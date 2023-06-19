package SistemaDeControl.Excepciones;

import java.util.List;

public class ListaVacia extends NoSuchFieldException //podriamos cambiarle el nombre a ColeccionVacia para hacerla un poquito mas generica
{
    public ListaVacia(String info)
    {
        super(info);
    }
}
