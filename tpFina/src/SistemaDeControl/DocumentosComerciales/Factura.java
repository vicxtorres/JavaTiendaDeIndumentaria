package SistemaDeControl.DocumentosComerciales;

import SistemaDeControl.ClienteProveedor.Cliente;
import SistemaDeControl.ClienteProveedor.Proveedor;
import SistemaDeControl.Producto.Producto;
import SistemaDeControl.Producto.SetProductos;

public class Factura extends Documento{

private Cliente cliente;

private double totalFactura;


    /**
     * constructores
     * @param numero el numero del documento
     * @param listadoProductos  la lista que incluye el producto
     * @param cliente  el cliente
     * @param totalFactura  el total
     */
    public Factura(int numero, SetProductos listadoProductos, Cliente cliente, double totalFactura) {
        super(numero, listadoProductos);
        this.cliente = cliente;
        this.totalFactura = totalFactura;
    }


    public Factura(int numero, SetProductos listadoProductos) {
        super(numero, listadoProductos);
        cliente = new Cliente();
        totalFactura = 0;
    }

    public Factura ()
    {
        cliente = new Cliente();
        totalFactura = 0;
    }

    /**
     * getter y setter
     * @return
     */
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }


    /** equals y hashcode*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Factura factura)) return false;
        if (!super.equals(o)) return false;

        if (Double.compare(factura.getTotalFactura(), getTotalFactura()) != 0) return false;
        return getCliente() != null ? getCliente().equals(factura.getCliente()) : factura.getCliente() == null;
    }

    @Override
    public int hashCode() {
        return 34;
    }


    /**
     * tostring
     * @return con la informacion de la clase documento tambien
     */
    @Override
    public String toString() {
        return
                "\nFactura\n" +
                 cliente + "\n" +
                "\n-------------------------------------"+
                "\nTotal Factura =" + totalFactura +"\n" +
                "\n-------------------------------------"+
                super.toString() +
                "\n-----------------------------------";
    }
}
