package SistemaDeControl.DocumentosComerciales.Mapas;

import SistemaDeControl.ClienteProveedor.Proveedor;
import SistemaDeControl.DocumentosComerciales.Remito;
import SistemaDeControl.Excepciones.ColeccionVacia;
import SistemaDeControl.Interfaces.I_Convertir_JsonArray;
import SistemaDeControl.Interfaces.I_metodosColeccion;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class MapRemitos implements I_metodosColeccion<Remito>, I_Convertir_JsonArray, Serializable {

    private HashMap<Proveedor,Remito> remitoHashMap;

    public MapRemitos()
    {
        remitoHashMap = new HashMap<>();
    }

    /**getters y setters*/

    public HashMap<Proveedor, Remito> getRemitoHashMap() {
        return remitoHashMap;
    }

    public void setRemitoHashMap(HashMap<Proveedor, Remito> remitoHashMap) {
        this.remitoHashMap = remitoHashMap;
    }


    /**
     * equals and hashcode

     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MapRemitos that)) return false;

        return getRemitoHashMap() != null ? getRemitoHashMap().equals(that.getRemitoHashMap()) : that.getRemitoHashMap() == null;
    }



    @Override
    public int hashCode() {
        return 43;
    }


    /**
     * tostring
     * @return
     */
    @Override
    public String toString() {
        return "MapRemitos{" +
                "remitoHashMap=" + remitoHashMap +
                '}';
    }


    /**
     * metodos heredados de la interfaz
     * @param elemento
     * @return
     */
    @Override
    public boolean borrar(Remito elemento) {
        boolean borrado = false;
        if (remitoHashMap.containsKey(elemento.getProveedor())) {
            remitoHashMap.remove(elemento.getProveedor());
            borrado = true;
        } else {
            throw new NoSuchElementException("No existe el remito");
        }
        return borrado;
    }

    @Override
    public boolean agregar(Remito elemento) {
        boolean agregado = false;
        if(remitoHashMap.containsValue(elemento.getNumero()))
        {
            throw new IllegalStateException("El Remito ya habia sido agregado.");
        }
        else
        {
            remitoHashMap.put(elemento.getProveedor(),elemento);
            agregado = true;
        }
        return agregado;
    }

    @Override
    public String listar() throws ColeccionVacia {
        if(remitoHashMap.isEmpty())
        {
            throw new ColeccionVacia("No hay remitos cargados.");
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Proveedor, Remito> entry : remitoHashMap.entrySet())
        {
            Remito remito = entry.getValue();
            sb.append(remito);
        }
        return sb.toString();
    }


    @Override
    public Remito buscar(Remito element) {
        if(remitoHashMap.containsValue(element.getNumero()))
        {
            return element;
        }
        else
        {
            throw new NoSuchElementException("No se encontró el remito");

        }
    }

    /**Json
     *
     * @return
     * @throws JSONException
     */
    @Override
    public JSONArray convertirJsonArray() throws JSONException {
        JSONArray jsonArray = new JSONArray ();
        for(Map.Entry<Proveedor,Remito>entry : remitoHashMap.entrySet ())
        {
            Proveedor p = entry.getKey ();
            Remito r = entry.getValue ();

            JSONObject jsonObjectProveedor = p.convertirJsonObject ();
            JSONObject jsonObjectRemito = r.convertirJsonObject ();

            JSONObject items = new JSONObject();
            items.put ( "Proveedor", jsonObjectProveedor );
            items.put ( "Remito",jsonObjectRemito );

            jsonArray.put ( items );
        }
        return jsonArray;
    }
}
