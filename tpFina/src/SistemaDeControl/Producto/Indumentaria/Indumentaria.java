package SistemaDeControl.Producto.Indumentaria;
import SistemaDeControl.Producto.Color;
import SistemaDeControl.Producto.Producto;

import java.util.Date;

/**
 * Clase Indumentaria: uno de los productos que tenemos
 */
public class Indumentaria extends Producto
{

    private TipoIndumentaria tipoIndumentaria;
    private String talleMedida;

    public Indumentaria ()
    {
        super();
        tipoIndumentaria = null;
        talleMedida = "";
    }

    /**
     * Constructor completo de Indumentaria
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
     * @param stock
     * @param tipoIndumentaria PANTALON, REMERA, SHORT, CALZA, CAMPERA, BUZO, MEDIAS, GORRA
     * @param talleMedida XS, X, M, L, XL, XXL, XXXL
     */
    public Indumentaria(int SKU, Date fechaDeIngreso, double precioCosto, double precioVenta, String marca, Color color, String descripcion, String disciplina, boolean esOferta, boolean esNovedad, int stock, TipoIndumentaria tipoIndumentaria, String talleMedida) {
        super(SKU, fechaDeIngreso, precioCosto, precioVenta, marca, color, descripcion, disciplina, esOferta, esNovedad, stock);
        this.tipoIndumentaria = tipoIndumentaria;
        this.talleMedida = talleMedida;
    }

    ///GETTERS
    public TipoIndumentaria getTipoIndumentaria() {
        return tipoIndumentaria;
    }


    //SETTERS
    public void setTipoIndumentaria(TipoIndumentaria tipoIndumentaria) {
        this.tipoIndumentaria = tipoIndumentaria;
    }

    public void setTalleMedida(String talleMedida) {
        this.talleMedida = talleMedida;
    }



    /**
     * Indumentaria, metodo que retorna la medida
     * @return String -> XS | X | M | L | XL | XXL | XXXL
     */
    @Override
    public String getMedida() {
        return talleMedida;
    }

    @Override
    public String toString() {
        return "\nIndumentaria." +
                "\nTipo: " + tipoIndumentaria +
                "\nMedida de talle: " + talleMedida +super.toString();
    }

}
