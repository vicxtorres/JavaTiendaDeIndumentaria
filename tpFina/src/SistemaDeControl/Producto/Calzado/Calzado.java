package SistemaDeControl.Producto.Calzado;

import SistemaDeControl.Producto.Producto;

public class Calzado extends Producto
{
    private float talleNumero;
    private TipoCalzado tipoCalzado;

    public float getTalleNumero() {
        return talleNumero;
    }

    public TipoCalzado getTipoCalzado() {
        return tipoCalzado;
    }


    @Override
    public String getMedida()
    {
        return null;
    }


}
