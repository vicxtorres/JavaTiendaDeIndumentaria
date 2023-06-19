package SistemaDeControl;

import SistemaDeControl.Archivos.ContoladoraArchivos;
import SistemaDeControl.ClienteProveedor.Cliente;
import SistemaDeControl.ClienteProveedor.CondicionIVA;
import SistemaDeControl.ClienteProveedor.Proveedor;
import SistemaDeControl.DocumentosComerciales.Documento;
import SistemaDeControl.DocumentosComerciales.Factura;
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
        /*
        Producto adidasEntrap = new Calzado(123,10000, 15000, "Adidas",Color.MULTICOLOR,"Entrap es un nuevo producto para Unisex de adidas. ","Futbol", false, false, 3, TipoCalzado.ZAPATILLA, 40 );
        Producto adidasTresEstrellas = new Indumentaria(133,15000, 25000, "Adidas",Color.GRIS,"100% Argentina. Remera estampada para seguir festejando a la selección en todo momento y lugar. El tejido de algodón suave te envuelve con comodidad y el logo adidas con los colores de la bandera + el escudo de la AFA + la tres estrellas, dejan bien en claro a qué selección apoyás. Nuestros productos de algodón apoyan el cultivo de algodón sostenible.","Urbano", false, true, 123, TipoIndumentaria.REMERA,"XL" );
        Producto pelotaArgentum22 = new Accesorio(333, 12000,43000,"Adidas", Color.MULTICOLOR,"De 1978 al futuro. Los llamativos gráficos difuminados de esta pelota adidas Argentum 22 se inspiran en la icónica pelota Tango Rosario que protagonizó la coronación de Argentina como campeón del mundo en suelo local. Su estructura sin costuras con uniones termoselladas y el sello de calidad FIFA Quality Pro garantizan un desempeño predecible en la cancha.", "Futbol", false, true, 122, TipoAccesorio.PELOTA,"5" );



        SetProductos nuevoSet = new SetProductos();
        nuevoSet.agregar(adidasEntrap);
        nuevoSet.agregar(adidasTresEstrellas);
        nuevoSet.agregar(pelotaArgentum22);


        //grabarSetProductos(nuevoSet,"Stock de tienda");
        Cliente cliente1 = new Cliente("Axel", "20-235432134-9", "Mexico 1483", CondicionIVA.IVA_EXENTO);
        Proveedor proveedor1 = new Proveedor("Vic", "28-346542340-5","Catamarca 123", CondicionIVA.RESPONSABLE_INSCRIPTO);


        Factura factura1 = new Factura(1, nuevoSet, cliente1, 100000);
        //System.out.println(factura1);
        grabarFactura(factura1, "Factura 1");

         */
        Documento factura2 = leerFactura("Factura 1");
        System.out.println(factura2.toString());


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

                                try {
                                    System.out.println(stock.listar());
                                }
                                catch (ProductoInexistente e)
                                {
                                    e.getCause();
                                }
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







        /*
              System.out.println("PROBANDO MAIN \nSistema de control de Inventario\n");

        /**
         * ESTO ES DE PRUEBA NO PREOCUPARSE


        System.out.println("Colores disponibles:");
        for (Color color : Color.values()) {
            System.out.println(color.name());
        }

        Date fecha = new Date(2004/03/02);

        Producto zapatillasNike = new Calzado(1,fecha,130,150,"Nike", Color.ROJO,"Duraderas","Running",false,true,1, TipoCalzado.ZAPATILLA,35);
        Producto remeraNike = new Indumentaria(2,fecha,180,200,"Nike", Color.AZUL,"bien","Futbol",true,false,1, TipoIndumentaria.REMERA,"m");
        Producto zapatillasNikeDos = new Calzado(1,fecha,130,150,"Nike", Color.ROJO,"Duraderas","Running",false,true,1, TipoCalzado.ZAPATILLA,35);

        SetProductos setProductos = new SetProductos();


        setProductos.agregar(zapatillasNike);
        setProductos.agregar(remeraNike);
        setProductos.agregar(zapatillasNikeDos);

        ContoladoraArchivos.grabarSetProductos(setProductos, "productos.dat");
        System.out.println(setProductos.toString()); //FUNCIONAAAAAAAAAAAA cuando ingreso dos iguales aumenta el stock :)


        SetProductos otroSet = new SetProductos();
        System.out.println(otroSet.toString());

        otroSet = ContoladoraArchivos.leerSetProductos("productos.dat");
        System.out.println(otroSet.toString());

         */



    }
}