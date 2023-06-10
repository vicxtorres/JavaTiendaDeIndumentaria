package SistemaDeControl.ClienteProveedor;

public class Cliente {

private String nombre;
private String cuil;
private String domicilio;

private CondicionIVA condicionIVA;


    /**
     * constructores
     * @param nombre nombre completo
     * @param cuil   formato XX-XXXXXXXX-X
     * @param domicilio CALLE Y NUMERO
     */

    public Cliente(String nombre, String cuil, String domicilio, CondicionIVA condicionIVA) {
        this.nombre = nombre;
        this.cuil = cuil;
        this.domicilio = domicilio;
        this.condicionIVA = condicionIVA;
    }

    public Cliente() {
        nombre = "";
        cuil = "";
        domicilio = "";
    }

    /**getters y setters*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public CondicionIVA getCondicionIVA() {
        return condicionIVA;
    }

    public void setCondicionIVA(CondicionIVA condicionIVA) {
        this.condicionIVA = condicionIVA;
    }

    /**
     * EQUALS
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;

        if (getNombre() != null ? !getNombre().equals(cliente.getNombre()) : cliente.getNombre() != null) return false;
        if (getCuil() != null ? !getCuil().equals(cliente.getCuil()) : cliente.getCuil() != null) return false;
        return getDomicilio() != null ? getDomicilio().equals(cliente.getDomicilio()) : cliente.getDomicilio() == null;
    }


    /**
     * HASCHODE POR LAS DUDAS
     * @return UN NUMERO PARA EL EQUALS
     */
    @Override
    public int hashCode() {
        return 13;
    }


}
