package SistemaDeControl.Producto.Calzado;

import SistemaDeControl.Interfaces.I_Convertir_JsonObject;
import SistemaDeControl.Producto.Color;
import SistemaDeControl.Producto.Producto;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Clase Calzado uno de los productos que tenemos
 */
public class Calzado extends Producto implements I_Convertir_JsonObject
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
     * @param precioCosto
     * @param precioVenta
     * @param marca
     * @param color
     * @param disciplina
     * @param esOferta
     * @param esNovedad
     * @param stock
     * @param tipoCalzado ZAPATILLA, BOTIN, OJOTA
     * @param talleNumero
     */
    public Calzado(int SKU, double precioCosto, double precioVenta, String marca, Color color, String disciplina, boolean esOferta, boolean esNovedad, int stock, TipoCalzado tipoCalzado, float talleNumero) {
        super(SKU, precioCosto, precioVenta, marca, color, disciplina, esOferta, esNovedad, stock);
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


    @Override
    public String toString() {
        return "\nCalzado." +
                "\nTipo: " + tipoCalzado +
                "\nNumero de talle: " + talleNumero + super.toString();
    }

    /**Json
     *
     * @return
     * @throws JSONException
     */
    @Override
    public JSONObject convertirJsonObject() throws JSONException {
        JSONObject jsonObject= super.convertirJsonObject ( );
        jsonObject.put ( "Tipo calzado ",tipoCalzado.name () );
        jsonObject.put ( "Numero de talle",talleNumero );
        return jsonObject;
    }
}
