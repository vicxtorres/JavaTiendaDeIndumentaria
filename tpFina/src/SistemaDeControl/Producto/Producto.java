package SistemaDeControl.Producto;

import SistemaDeControl.Interfaces.I_Convertir_JsonObject;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public abstract class Producto implements Comparable, Serializable, I_Convertir_JsonObject
{
    private int SKU;
    private double precioCosto;
    private double precioVenta;
    private String marca;
    private Color color;
    private String disciplina;
    private boolean esOferta;
    private boolean esNovedad;
    private int stock;


    public Producto()
    {
        SKU = 0;
        precioCosto = 0;
        precioVenta = 0;
        marca = "";
        color = null;
        disciplina = "";
        esOferta = false;
        esNovedad = false;
    }

    /**
     * Constructor completo de Producto
     * @param SKU codigo

     * @param precioCosto
     * @param precioVenta
     * @param marca
     * @param color AZUL, ROJO, ROSA, CELESTE, MARRON, MULTICOLOR, GRIS, VERDE, VIOLETA, AMARILLO, NARANJA
     * @param disciplina
     * @param esOferta
     * @param esNovedad
     * @param stock indica cuantos productos exactamente iguales a este hay
     */
    public Producto(int SKU, double precioCosto, double precioVenta, String marca, Color color, String disciplina, boolean esOferta, boolean esNovedad, int stock) {
        this.SKU = SKU;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.marca = marca;
        this.color = color;
        this.disciplina = disciplina;
        this.esOferta = esOferta;
        this.esNovedad = esNovedad;
        this.stock = stock;
    }

    ///GETTERS
    public int getSKU() {
        return SKU;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public String getMarca() {
        return marca;
    }

    public Color getColor() {
        return color;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public int getStock() {
        return stock;
    }

    public boolean isEsOferta() {
        return esOferta;
    }

    public boolean isEsNovedad() {
        return esNovedad;
    }


    ///SETTERS despues ver cual usamos y cuales no
    public void setSKU(int SKU) {
        this.SKU = SKU;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setEsOferta(boolean esOferta) {
        this.esOferta = esOferta;
    }

    public void setEsNovedad(boolean esNovedad) {
        this.esNovedad = esNovedad;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    @Override
    public String toString() {
        return
                "\nSKU: " + SKU +
                "\nPrecio de costo: " + precioCosto +
                "\nPrecio de venta: " + precioVenta +
                "\nMarca: " + marca +
                "\nColor: " + color +
                "\nDisciplina: " + disciplina +
                "\nEs oferta: " + esOferta +
                "\nEs novedad: " + esNovedad +
                "\nSTOCK: " + stock +
                "\n------------------------------\n";
    }



    /**
     * Compara los productos mediante su código SKU
     * @param elementoComparado the object to be compared.
     * @return 0 = iguales
     */
    @Override
    public int compareTo(Object elementoComparado) //x.compareTo(elementoComparado);
    {
        int rta = 0;
        if (elementoComparado != null) {
            if (elementoComparado instanceof Producto) {
                Producto aux = (Producto) elementoComparado;
              //  Integer SKU = new Integer(getSKU());
                //Integer otroSKU = new Integer(aux.getSKU());

                rta = Integer.compare(getSKU(), aux.getSKU());
            }
        }
        return rta;
    }


    /**
     * Metodo abstracto, implementado en las clases Accesorio, Calzado e Indumentaria
     * @return String con la medida indicada
     */
    public abstract String getMedida();

    /**Json
     *
     * @return
     * @throws JSONException
     */
    @Override
    public JSONObject convertirJsonObject() throws JSONException {
        JSONObject jsonObject = new JSONObject (  );
        jsonObject.put ("SKU",SKU  );
        jsonObject.put ( "Precio de costo",precioCosto );
        jsonObject.put ( "Precio de venta",precioVenta );
        jsonObject.put ( "Marca",marca );
        jsonObject.put ( "Color",color);
        jsonObject.put ( "Disciplina",disciplina );
        jsonObject.put ( "Es oferta",esOferta );
        jsonObject.put ( "Es novedad",esNovedad );
        jsonObject.put ( "Stock",stock );


        return jsonObject;
    }

/*
   SI PONGO EL EQUALS NO ME ANDA LO DE ARCHIVOS NI IDEA

   @Override
    public boolean equals(Object obj) {
        boolean rta = false;
        if (obj != null) {

            if (obj instanceof Producto) {
                Producto aux = (Producto) obj;

                if (getMarca().equals(aux.getMarca()) && (getSKU() == aux.getSKU()))
                {
                    rta = true;
                }
            }
        }
        return rta;
    }


    @Override
    public int hashCode() {
        return Objects.hash(SKU, precioCosto, precioVenta, marca, color, disciplina, esOferta, esNovedad, stock);
    }


  */
}
