package SistemaDeControl;

import SistemaDeControl.Archivos.ContoladoraArchivos;
import SistemaDeControl.Archivos.GrabadoraProductos;
import SistemaDeControl.Producto.Producto;
import SistemaDeControl.Producto.SetProductos;

import java.util.Scanner;

public class MainPruebas
{
        public static void main(String[] args)
        {
            Scanner scan = new Scanner(System.in);

            //ingresoDeDatos(scan);
            SetProductos stockDeProductos = new SetProductos();
            stockDeProductos = ContoladoraArchivos.leerSetProductos("SetProductos.dat");
            System.out.println("\n\nOTRO SET\n"+stockDeProductos.toString()); //para ver si leyo bien el archivo
        }


    public static void ingresoDeDatos(Scanner scan)
    {
        /**
         * 1. INGRESAMOS PRODUCTOS AL SET DE PRODUCTOS */
        Producto producto =  null;
        SetProductos setProductos = new SetProductos();
        int control = 0;
        while(control ==0) {
            producto = new GrabadoraProductos().ingresarProducto();
            setProductos.agregar(producto);

            System.out.println("Si desea ingresar otro producto presione 0, en caso contrario 1");
            control = scan.nextInt();
        }
        System.out.println("SET DE PRODUCTOS\n" + setProductos.toString());


        /**
         * LO GRABAMOS EN UN ARCHIVO, funciona
         */
        ContoladoraArchivos.grabarSetProductos(setProductos, "SetProductos.dat");
        SetProductos stockDeProductos = new SetProductos();
        stockDeProductos = ContoladoraArchivos.leerSetProductos("SetProductos.dat");

        System.out.println("\n\nOTRO SET\n"+stockDeProductos.toString());
    }
}
