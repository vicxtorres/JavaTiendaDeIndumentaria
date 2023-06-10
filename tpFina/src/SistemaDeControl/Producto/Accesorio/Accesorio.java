package SistemaDeControl.Producto.Accesorio;

import SistemaDeControl.Producto.Producto;

public class Accesorio extends Producto
{
    private TipoAccesorio tipoAccesorio;
    private String tamano; //chico, mediano, grande


    @Override
    public String getMedida() {
        return tamano;
    }
}
