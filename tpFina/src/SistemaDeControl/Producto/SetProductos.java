package SistemaDeControl.Producto;

import java.util.TreeSet;

public class SetProductos
{
    TreeSet <Producto> productos;

    public SetProductos()
    {
        productos = new TreeSet<Producto>();
    }

    public SetProductos(TreeSet<Producto> productos)
    {
        this.productos = productos;
    }




}
