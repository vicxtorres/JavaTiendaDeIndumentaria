package SistemaDeControl.Excepciones;

public class ProductoInexistente extends NoSuchFieldException
{
    public ProductoInexistente (String info)
    {
        super(info);
    }
}
