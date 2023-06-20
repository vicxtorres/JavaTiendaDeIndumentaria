package SistemaDeControl.Producto.Indumentaria;
import SistemaDeControl.Producto.Color;
import SistemaDeControl.Producto.Producto;
import org.json.JSONException;
import org.json.JSONObject;

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
     * @param precioCosto
     * @param precioVenta
     * @param marca
     * @param color

     * @param disciplina
     * @param esOferta
     * @param esNovedad
     * @param stock
     * @param tipoIndumentaria PANTALON, REMERA, SHORT, CALZA, CAMPERA, BUZO, MEDIAS, GORRA
     * @param talleMedida XS, X, M, L, XL, XXL, XXXL
     */
    public Indumentaria(int SKU, double precioCosto, double precioVenta, String marca, Color color,  String disciplina, boolean esOferta, boolean esNovedad, int stock, TipoIndumentaria tipoIndumentaria, String talleMedida) {
        super(SKU, precioCosto, precioVenta, marca, color,  disciplina, esOferta, esNovedad, stock);
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

    /**Json
     *
     * @return
     * @throws JSONException
     */
    @Override
    public JSONObject convertirJsonObject() throws JSONException {
        JSONObject jsonObject = super.convertirJsonObject ( );
        jsonObject.put ( "Tipo de indumnetaria",tipoIndumentaria.name () );
        jsonObject.put ( "Medida de talle", talleMedida );
        return jsonObject;

    }
}
