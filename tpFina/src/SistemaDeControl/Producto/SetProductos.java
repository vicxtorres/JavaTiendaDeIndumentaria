package SistemaDeControl.Producto;
import SistemaDeControl.Excepciones.ProductoInexistente;
import SistemaDeControl.Interfaces.I_Convertir_JsonArray;
import SistemaDeControl.Interfaces.I_metodosListas;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.Serializable;
import java.util.TreeSet;

public class SetProductos implements I_metodosListas <Producto>, Serializable, I_Convertir_JsonArray //VEO SI ME FUNCIONA ESTA INTERFAZ ASI LA APROVECHAMOS
{
    TreeSet <Producto> productos;

    public SetProductos()
    {
        productos = new TreeSet<Producto>();
    }


    ///GETTERS
    public TreeSet<Producto> getProductos() {
        return productos;
    }



    /**
     * Agrega un Producto al Set de productos, si no se agrega es porque esta duplicado. Remueve el Producto, aumenta su stock y lo vuelve a ingresar.
     * @param elemento a agregar
     *                 - Debe tener el metodo compareTo implementado
     * @return boolean, true si se agrego correctamente
     */
    @Override
    public boolean agregar(Producto elemento) {

        /*
        boolean agregado = productos.add(elemento);
        if(!agregado)
        {
            productos.remove(elemento); //elimina elemento
            int nuevoStock = (elemento.getStock()) + 1;  //escribe stock nuevo
            elemento.setStock(nuevoStock); //aumenta el stock del producto
        }
        agregado = productos.add(elemento); //lo agrega actualizado
        return agregado;

         */
        boolean agregado = false;
        if(!productos.contains(elemento))
        {
            productos.add(elemento);
            agregado = true;
        }
        else
        {
            for(Producto p : productos)
            {
                if(p.getSKU() == elemento.getSKU())
                {
                    int nuevoStock = p.getStock() + elemento.getStock();
                    p.setStock(nuevoStock);
                    agregado = true;
                }
            }
        }
        return agregado;
    }


    /**
     * Elimina un Producto del Set de productos. Se puede utilizar en ventas, actualiza el stock.
     * @param elemento a eliminar
     * @return boolean, true si se eliminó correctamente
     * @throws ProductoInexistente si el Producto enviado no existe en el Set
     */
    @Override
    public boolean borrar(Producto elemento) throws ProductoInexistente {
        /*
        boolean eliminado = productos.remove(elemento);
        if (eliminado)
        {
            if(elemento.getStock()>1) //si antes de eliminarlo habia mas de un producto, entonces actualizo el stock
            {
                int stockNuevo = (elemento.getStock())-1; //le resto el eliminado
                elemento.setStock(stockNuevo);
                productos.add(elemento);
            }
        }else
        {
            throw new ProductoInexistente("El producto a eliminar no existe");
        }
        return eliminado;
         */
        boolean eliminado = false;
        if(productos.contains(elemento)){
            for (Producto p : productos) {
                if (p.getSKU() == elemento.getSKU()) {
                    int nuevoStock = p.getStock() - elemento.getStock();
                    p.setStock(nuevoStock);
                    if (nuevoStock < 0) {
                        p.setStock(0);
                        eliminado = true;
                    }
                }
            }
        }
        else
        {
            throw new ProductoInexistente("El producto que usted quiere eliminar no existe.");
        }
        return eliminado;
    }


    /**
     * Devuelve el TreeSet como una cadena
     * @return String, listado de productos
     * @throws ProductoInexistente si el TreeSet se encuentra vacio
     */
    @Override
    public String listar() throws ProductoInexistente {
        if(productos.isEmpty()) {
            throw new ProductoInexistente("No hay productos ingresados.");
        }
        StringBuilder sb = new StringBuilder();
        for(Producto p : productos)
        { sb.append("--------------------------"+p+"\n");
        } return sb.toString();
    }


    /**
     * Busca un Producto en el Set de productos.
     * @param element a buscar
     * @return Producto, buscado
     * @throws ProductoInexistente si el elemento no se encuentra
     */
    @Override
    public Producto buscar(Producto element) throws ProductoInexistente {
        if(productos.contains(element))
        {
            return element;
        }
        else {
            throw new ProductoInexistente("No se encontró el producto.");
        }
    }


    public void modificarOferta(Producto element, boolean oferta) throws ProductoInexistente
    {
        if(productos.contains(element))
        {
            productos.remove(element);
            element.setEsOferta(oferta);
            productos.add(element);
        }
        else {
            throw new ProductoInexistente("No se encontró el producto.");
        }
    }

    public void modificarNovedad(Producto element, boolean novedad) throws ProductoInexistente
    {
        if(productos.contains(element))
        {
            productos.remove(element);
            element.setEsNovedad(novedad);
            productos.add(element);
        }
        else {
            throw new ProductoInexistente("No se encontró el producto.");
        }
    }

    public void modificarPrecio(Producto element, double precioNuevo) throws ProductoInexistente
    {
        if(productos.contains(element))
        {
            productos.remove(element);
            element.setPrecioVenta(precioNuevo);
            productos.add(element);
        }
        else {
            throw new ProductoInexistente("No se encontró el producto.");
        }
    }


    public boolean contiene (Producto element)
    {
        boolean contiene = false;
        if(productos.contains(element))
        {
            contiene = true;
        }
        return contiene;
    }


    @Override
    public String toString() {
        return "\n- Productos -\n" + productos;
    }

    /**Json
     *
     * @return
     * @throws JSONException
     */
    @Override
    public JSONArray convertirJsonArray() throws JSONException {
        JSONArray jsonArray = new JSONArray (  );
        for (Producto p:productos) {
            jsonArray.put ( p.convertirJsonObject () );
        }
        return jsonArray;
    }

}
