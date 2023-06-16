package SistemaDeControl.Excepciones;

public class NoExisteElCuil extends IllegalArgumentException{
    public NoExisteElCuil(String info)
    {
        super(info);
    }

}
