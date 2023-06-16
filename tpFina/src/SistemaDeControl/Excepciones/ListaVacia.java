package SistemaDeControl.Excepciones;

import java.util.List;

public class ListaVacia extends NoSuchFieldException{
    public ListaVacia(String info)
    {
        super(info);
    }
}
