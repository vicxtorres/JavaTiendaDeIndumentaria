package SistemaDeControl.Producto.Calzado;

import SistemaDeControl.Producto.Color;
import SistemaDeControl.Producto.Producto;

import java.util.Date;

/**
 * Clase Calzado uno de los productos que tenemos
 */
public class Calzado extends Producto
{
    private TipoCalzado tipoCalzado;
    private float talleNumero;

    public Calzado() {
        super();
        talleNumero = 0;
        tipoCalzado = null;
    }

    /**
     * Constructor completo de Calzado
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
     * @param tipoCalzado ZAPATILLA, BOTIN, OJOTA
     * @param talleNumero
     */
    public Calzado(int SKU, Date fechaDeIngreso, double precioCosto, double precioVenta, String marca, Color color, String descripcion, String disciplina, boolean esOferta, boolean esNovedad, TipoCalzado tipoCalzado, float talleNumero) {
        super(SKU, fechaDeIngreso, precioCosto, precioVenta, marca, color, descripcion, disciplina, esOferta, esNovedad);
        this.tipoCalzado = tipoCalzado;
        this.talleNumero = talleNumero;
    }


    ///GETTERS
    public TipoCalzado getTipoCalzado() {
        return tipoCalzado;
    }

    ///SETTERS
    public void setTalleNumero(float talleNumero) {
        this.talleNumero = talleNumero;
    }

    public void setTipoCalzado(TipoCalzado tipoCalzado) {
        this.tipoCalzado = tipoCalzado;
    }


    /** Calzado, pasa el talle de float a un String para retornarlo
     *@return String -> Numero de talle
     * */
    @Override
    public String getMedida()
    {
        String talle = String.valueOf(talleNumero);
        return talle;
    }


}
