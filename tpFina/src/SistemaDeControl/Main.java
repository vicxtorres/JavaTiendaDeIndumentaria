package SistemaDeControl;

import SistemaDeControl.ClienteProveedor.Cliente;
import SistemaDeControl.Producto.Accesorio.Accesorio;
import SistemaDeControl.Producto.Accesorio.TipoAccesorio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("--------------------------------------------------");
        System.out.println("Bienvenido al sistema de inventario de VAV Sports ");
        System.out.println("---------------------------------------------------");
        int opcion;
        do {
            System.out.println("Que Desea hacer hoy?\n" +
                    "1)Ver Stock de tienda.\n" +
                    "2)Actualizar Stock.\n" +
                    "3)Cerrar Programa.\n");
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("-------------------------\n");
                    System.out.println("     STOCK DE TIENDA.\n");
                    System.out.println("-------------------------\n");
                    int opcionVerStock;
                    do {

                        System.out.println("\nElija una opcion:\n" +
                                "1)Ver Stock Completo\n" +
                                "2)Ver Calzado.\n" +
                                "3)Ver Indumentaria.\n" +
                                "4)Ver Accesorios.\n" +
                                "5)Salir.");
                        opcionVerStock = scan.nextInt();
                        switch (opcionVerStock) {
                            case 1:
                                ///funciones para mostrar el stock de todo.
                                break;
                            case 2:
                                ///funciones para mostrar el stock de calzado.
                                break;
                            case 3:
                                ///funciones para mostrar el stock de indumentaria.
                                break;
                            case 4:
                                ///funciones para mostrar el stock de accesorios.
                                break;
                            default:
                                System.out.println("Opción Incorrecta.");
                        }
                    }while(opcionVerStock!=5);
                     break;
                case 2:
                    System.out.println("-------------------------------\n");
                    System.out.println("        ACTUALIZACIÓN STOCK    \n");
                    System.out.println("-------------------------------\n");
                    int opcionActualizacionStock;
                    do {
                        System.out.println("Elija una opción: \n");
                        System.out.println("1) Agregar una factura. \n");
                        System.out.println("2) Agregar un remito. \n");
                        System.out.println("3) Corregir manualmente el stock de un articulo. \n");
                        System.out.println("4) salir. \n");
                        opcionActualizacionStock = scan.nextInt();
                        switch (opcionActualizacionStock)
                        {
                            case 1:
                                System.out.println("Ingrese el numero de la factura a ingresar.\n");
                                int numeroNuevaFactura = scan.nextInt();
                                //funciones de agregar una factura
                                break;
                            case 2:
                                System.out.println("Ingrese el numero de la remito a ingresar.\n");
                                int numeroNuevoRemito = scan.nextInt();
                                // funciones de agregar un remito.
                                break;
                            case 3:
                                System.out.println("Ingrese el SKU cuyo stock desea corregir.\n");
                                int skuAModificar = scan.nextInt();
                                //funciones para modificar el stock de un producto.
                                break;
                        }
                    }while(opcionActualizacionStock != 4);
            }
        }while(opcion !=3);




    }
}