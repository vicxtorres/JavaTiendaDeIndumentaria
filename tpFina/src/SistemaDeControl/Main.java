package SistemaDeControl;

import SistemaDeControl.Archivos.ContoladoraArchivos;
import SistemaDeControl.Archivos.GrabadoraProductos;
import SistemaDeControl.ClienteProveedor.Cliente;
import SistemaDeControl.ClienteProveedor.CondicionIVA;
import SistemaDeControl.ClienteProveedor.Listas.ListaClientes;
import SistemaDeControl.ClienteProveedor.Proveedor;
import SistemaDeControl.DocumentosComerciales.Documento;
import SistemaDeControl.DocumentosComerciales.Factura;
import SistemaDeControl.DocumentosComerciales.Listas.ListaFacturas;
import SistemaDeControl.DocumentosComerciales.Listas.ListaRemitos;
import SistemaDeControl.DocumentosComerciales.Remito;
import SistemaDeControl.Excepciones.ProductoInexistente;
import SistemaDeControl.Producto.Accesorio.Accesorio;
import SistemaDeControl.Producto.Accesorio.TipoAccesorio;
import SistemaDeControl.Producto.Calzado.Calzado;
import SistemaDeControl.Producto.Calzado.TipoCalzado;
import SistemaDeControl.Producto.Color;
import SistemaDeControl.Producto.Indumentaria.Indumentaria;
import SistemaDeControl.Producto.Indumentaria.TipoIndumentaria;
import SistemaDeControl.Producto.Producto;
import SistemaDeControl.Producto.SetProductos;

import java.util.Date;
import java.util.Scanner;

import static SistemaDeControl.Archivos.ContoladoraArchivos.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        /*
        Producto adidasEntrap = new Calzado(123,10000, 15000, "Adidas",Color.MULTICOLOR,"Futbol", false, false, 3, TipoCalzado.ZAPATILLA, 40 );
        Producto adidasTresEstrellas = new Indumentaria(133,15000, 25000, "Adidas",Color.GRIS,"Urbano", false, true, 123, TipoIndumentaria.REMERA,"XL" );
        Producto pelotaArgentum22 = new Accesorio(333, 12000,43000,"Adidas", Color.MULTICOLOR, "Futbol", false, true, 122, TipoAccesorio.PELOTA,"5" );



        Producto nikeHuarache = new Calzado(1, 30000, 45000, "Nike", Color.NEGRO,"Training", false, false, 5, TipoCalzado.ZAPATILLA, 45);
        Producto camisetaFrancia = new Indumentaria(2, 25000, 30000, "Nike", Color.AZUL, "Futbol", false, true, 10, TipoIndumentaria.REMERA, "L");
        Producto bolsoSeleccion = new Accesorio(34, 45000, 60000, "Adidas", Color.GRIS,"Futbol", true, true, 100, TipoAccesorio.BOLSO, "chico");

*/
        /*
        SetProductos nuevoSet = new SetProductos();
        nuevoSet.agregar(adidasEntrap);
        nuevoSet.agregar(adidasTresEstrellas);
        nuevoSet.agregar(pelotaArgentum22);
*/

/*
        SetProductos set2 = new SetProductos();
        set2.agregar(nikeHuarache);
        set2.agregar(camisetaFrancia);
        set2.agregar(bolsoSeleccion);
*/




        //grabarSetProductos(nuevoSet,"Stock de tienda");
        //Cliente cliente1 = new Cliente("Axel", "20-235432134-9", "Mexico 1483", CondicionIVA.IVA_EXENTO);
        //Proveedor proveedor1 = new Proveedor("Vic", "28-346542340-5","Catamarca 123", CondicionIVA.RESPONSABLE_INSCRIPTO);


        /*
        Factura factura1 = new Factura(1, nuevoSet, cliente1, 100000);
        System.out.println(factura1);
        grabarFactura(factura1, "Factura1.dat");

         */
        //Remito remito1 = new Remito(001,set2,proveedor1);
        //grabarRemito(remito1, "Remito1.dat");

       // ListaClientes lista = new ListaClientes();
       // lista.agregar(cliente1);

            /*
        System.out.println("\n*****GRABANDO EN ARCHIVO******");
        ContoladoraArchivos.grabarListas(lista, "listaCliente.dat");
        ListaClientes nuevalistt = new ListaClientes();
        nuevalistt = ContoladoraArchivos.leerLista("listaCliente.dat");
        System.out.println(nuevalistt.toString());
*/

        Documento factura2 = leerFactura("Factura1.dat");
        System.out.println(factura2.toString());
        //Documento remito2 = leerRemito("Remito1.dat");
        //System.out.println(remito2.toString());




        System.out.println("--------------------------------------------------");
        System.out.println("Bienvenido al sistema de inventario de VAV Sports ");
        System.out.println("---------------------------------------------------");
        int opcion;
        do {
            System.out.println("Que Desea hacer hoy?\n" +
                    "1)Ver Stock de tienda.\n" +
                    "2)Actualizar Stock.\n" +
                    "3)Ver documentos Comerciales\n" +
                    "4)Cerrar Programa.\n");
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("-------------------------\n");
                    System.out.println("     STOCK DE TIENDA.\n");
                    System.out.println("-------------------------\n");
                    int opcionVerStock;
                    do {
                        StringBuilder sb = new StringBuilder();
                        SetProductos stock =  leerSetProductos("Stock de tienda");
                        System.out.println("\nElija una opcion:\n" +
                                "1)Ver Stock Completo\n" +
                                "2)Ver Calzado.\n" +
                                "3)Ver Indumentaria.\n" +
                                "4)Ver Accesorios.\n" +
                                "5)Salir.");
                        opcionVerStock = scan.nextInt();
                        switch (opcionVerStock) {
                            case 1:

                                /**
                                 * Puedo mostrarlo directamente asi por si sufre modificaciones el archivo
                                 */
                                stock = ContoladoraArchivos.leerSetProductos("Stock de tienda");
                                System.out.println("STOCK COMPLETO:" + stock.toString());

                                /*
                                try {
                                    System.out.println(stock.listar());
                                }
                                catch (ProductoInexistente e)
                                {
                                    e.getCause();
                                }
                                 */
                                break;
                            case 2:
                                for (Producto p : stock.getProductos())
                                {
                                    if(p instanceof Calzado)
                                    {
                                       sb.append("-----------------------"+p+"\n");
                                    }
                                }
                                System.out.println(sb);

                                break;
                            case 3:
                                ///funciones para mostrar el stock de indumentaria.
                                for (Producto p : stock.getProductos())
                                {
                                    if(p instanceof Indumentaria)
                                    {
                                        sb.append("-----------------------"+p+"\n");
                                    }
                                }
                                System.out.println(sb);

                                break;
                            case 4:
                                ///funciones para mostrar el stock de accesorios.
                                for (Producto p : stock.getProductos())
                                {
                                    if(p instanceof Accesorio)
                                    {
                                        sb.append("-----------------------"+p+"\n");
                                    }
                                }
                                System.out.println(sb);

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
                                modificarConFactura(numeroNuevaFactura);
                                break;
                            case 2:
                                System.out.println("Ingrese el numero de la remito a ingresar.\n");
                                int numeroNuevoRemito = scan.nextInt();
                                // funciones de agregar un remito.
                                modificarStockConRemito(numeroNuevoRemito);
                                break;
                            case 3:
                                System.out.println("Ingrese el SKU cuyo stock desea corregir.\n");
                                int skuAModificar = scan.nextInt();
                                System.out.println("Ingrese el stock real.");
                                int skuNuevo = scan.nextInt();
                                ContoladoraArchivos.modificarStockManualmente(skuAModificar, skuNuevo);
                                //funciones para modificar el stock de un producto.
                                break;
                        }
                    }while(opcionActualizacionStock != 4);
                case 3:
                    System.out.println("-------------------------------\n");
                    System.out.println("        DOCUMENTOS COMERCIALES   \n");
                    System.out.println("-------------------------------\n");
                    int opcionDocumentos;
                    do {
                        System.out.println("Que documento comercial desea ver: \n");
                        System.out.println("1)Factura: \n");
                        System.out.println("2)Remito: \n");
                        System.out.println("3)Volver: \n");
                        opcionDocumentos = scan.nextInt();
                        switch (opcionDocumentos)
                        {
                            case 1:
                                System.out.println("ingrese el numero de factura que desea ver");
                                int numeroFactura = scan.nextInt();
                                System.out.println(verFactura(numeroFactura));
                                break;
                            case 2:
                                System.out.println("ingrese el numero de remito que desea ver");
                                int numeroRemito = scan.nextInt();
                                System.out.println(verRemito(numeroRemito));
                                break;
                            default:
                                System.out.println("Opcion incorrecta.");
                        }
                        break;
                    }while (opcionDocumentos !=3);

            }
        }while(opcion !=4);

    }






}