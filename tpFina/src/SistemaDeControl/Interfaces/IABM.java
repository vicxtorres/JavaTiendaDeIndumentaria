package SistemaDeControl.Interfaces;

public interface IABM <E> //generica
{
    public boolean agregar(E elemento);
    public boolean borrar(E elemento);
    public boolean modificar(E elemento);
}
