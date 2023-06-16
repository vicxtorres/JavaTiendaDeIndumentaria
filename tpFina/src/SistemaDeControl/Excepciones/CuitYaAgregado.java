package SistemaDeControl.Excepciones;

public class CuitYaAgregado extends IllegalArgumentException{

    public CuitYaAgregado(String info)
    {
        super(info);
    }
}
