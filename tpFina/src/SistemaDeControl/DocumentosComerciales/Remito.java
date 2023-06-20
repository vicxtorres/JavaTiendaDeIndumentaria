package SistemaDeControl.DocumentosComerciales;

import SistemaDeControl.ClienteProveedor.Proveedor;
import SistemaDeControl.Producto.SetProductos;

public class Remito extends Documento {

private Proveedor proveedor;


        /**
         * constructores
         * @param numero de documento
         * @param listadoProductos  el listado de productos que contiene
         * @param proveedor el proveedor con sus datos
         */
        public Remito(int numero, SetProductos listadoProductos, Proveedor proveedor) {
                super(numero, listadoProductos);
                this.proveedor = proveedor;
        }
        public Remito(int numero, SetProductos listadoProductos)
        {
                super(numero,listadoProductos);
                proveedor = new Proveedor();
        }

        public Remito()
        {
                proveedor = new Proveedor();
        }



        public Proveedor getProveedor() {
                return proveedor;
        }

        public void setProveedor(Proveedor proveedor) {
                this.proveedor = proveedor;
        }


        /**
         * getters y setters
         * @param o
         * @return
         */
        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Remito remito)) return false;

                return getProveedor() != null ? getProveedor().equals(remito.getProveedor()) : remito.getProveedor() == null;
        }

        @Override
        public int hashCode() {
                return 5434;
        }


        /**
         * tostring
         */

        @Override
        public String toString() {
                return "Remito{" +
                        "proveedor=" + proveedor +
                        '}';
        }

}
