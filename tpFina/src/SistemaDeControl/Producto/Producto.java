package SistemaDeControl.Producto;

import java.util.Date;

public abstract class Producto
{
    private int SKU;
    private Date fechaDeIngreso;
    private double precioCosto;
    private double precioVenta;
    private String marca;
    private Color color;
    private String descripcion;
    private String disciplina;
    private boolean esOferta;
    private boolean esNovedad;


    public Producto()
    {
        SKU = 0;
        fechaDeIngreso = null;
        precioCosto = 0;
        precioVenta = 0;
        marca = "";
        color = null;
        descripcion = "";
        disciplina = "";
        esOferta = false;
        esNovedad = false;
    }

    /**
     * Constructor completo de Producto
     * @param SKU codigo
     * @param fechaDeIngreso
     * @param precioCosto
     * @param precioVenta
     * @param marca
     * @param color AZUL, ROJO, ROSA, CELESTE, MARRON, MULTICOLOR, GRIS, VERDE, VIOLETA, AMARILLO, NARANJA
     * @param descripcion
     * @param disciplina
     * @param esOferta
     * @param esNovedad
     */
    public Producto(int SKU, Date fechaDeIngreso, double precioCosto, double precioVenta, String marca, Color color, String descripcion, String disciplina, boolean esOferta, boolean esNovedad) {
        this.SKU = SKU;
        this.fechaDeIngreso = fechaDeIngreso;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.marca = marca;
        this.color = color;
        this.descripcion = descripcion;
        this.disciplina = disciplina;
        this.esOferta = esOferta;
        this.esNovedad = esNovedad;
    }


    ///GETTERS
    public int getSKU() {
        return SKU;
    }

    public Date getFechaDeIngreso() {
        return fechaDeIngreso;
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

    public String getDescripcion() {
        return descripcion;
    }

    public String getDisciplina() {
        return disciplina;
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

    public void setFechaDeIngreso(Date fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
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

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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


    /**
     * Metodo abstracto, implementado en las clases Accesorio, Calzado e Indumentaria
     * @return String con la medida indicada
     */
    public abstract String getMedida();



}
