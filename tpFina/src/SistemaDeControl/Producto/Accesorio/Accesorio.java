package SistemaDeControl.Producto.Accesorio;

import SistemaDeControl.Producto.Color;
import SistemaDeControl.Producto.Producto;

import java.util.Date;

/**
 * Clase Accesorio: uno de los productos que tenemos
 */
public class Accesorio extends Producto
{
    private TipoAccesorio tipoAccesorio;
    private String tamano; //chico, mediano, grande

    public Accesorio()
    {
        super();
        tamano="";
        tipoAccesorio=null;
    }

    /**
     * Constructor completo de Accesorio
     * @param SKU
     * @param fechaDeIngreso
     * @param precioCosto
     * @param precioVenta
     * @param marca
     * @param color
     * @param descripcion
     * @param disciplina
     * @param esOferta
     * @param esNovedad
     * @param tipoAccesorio BOLSO, PELOTA
     * @param tamano Chico, Mediano, Grande
     */
    public Accesorio(int SKU, Date fechaDeIngreso, double precioCosto, double precioVenta, String marca, Color color, String descripcion, String disciplina, boolean esOferta, boolean esNovedad, TipoAccesorio tipoAccesorio, String tamano) {
        super(SKU, fechaDeIngreso, precioCosto, precioVenta, marca, color, descripcion, disciplina, esOferta, esNovedad);
        this.tipoAccesorio = tipoAccesorio;
        this.tamano = tamano;
    }


    ///GETTERS
    public TipoAccesorio getTipoAccesorio() {
        return tipoAccesorio;
    }

    ///SETTERS
    public void setTipoAccesorio(TipoAccesorio tipoAccesorio) {
        this.tipoAccesorio = tipoAccesorio;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }


    /**
     * Accesorio, metodo que retorna la medida
     * @return String -> Chico | Mediano | Grande
     */
    @Override
    public String getMedida()
    {
        return tamano;
    }
}
