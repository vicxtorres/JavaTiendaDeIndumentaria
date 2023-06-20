package SistemaDeControl.Archivos;

import SistemaDeControl.Producto.Accesorio.Accesorio;
import SistemaDeControl.Producto.Accesorio.TipoAccesorio;
import SistemaDeControl.Producto.Calzado.Calzado;
import SistemaDeControl.Producto.Calzado.TipoCalzado;
import SistemaDeControl.Producto.Color;
import SistemaDeControl.Producto.Indumentaria.Indumentaria;
import SistemaDeControl.Producto.Indumentaria.TipoIndumentaria;
import SistemaDeControl.Producto.Producto;

import java.awt.*;
import java.util.Scanner;

public class GrabadoraProductos
{

    /**
     * Es para crear los productos que luego ingresaremos en el Set
     * @return un Producto
     */
    public Producto ingresarProducto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la grabadora de productos");
        System.out.println("Seleccione el tipo de producto a grabar: ");
        System.out.println("1. Indumentaria");
        System.out.println("2. Calzado");
        System.out.println("3. Accesorio");
        int opcion = scanner.nextInt();

        Producto producto = null;

        switch (opcion) {
            case 1:
                Indumentaria indumentaria = new Indumentaria();
                producto = ingresarDatosIndumentaria(scanner, indumentaria);
                break;
            case 2:
                Calzado calzado = new Calzado();
                producto = ingresarDatosCalzado(scanner, calzado);
                break;
            case 3:
                Accesorio accesorio=new Accesorio();
                producto = ingresarDatosAccesorio(scanner, accesorio);
                break;
            default:
                System.out.println("Opción inválida");
        }
        return producto;
    }



    public void datosComunes(Scanner scanner, Producto producto)
    {
        System.out.println("Ingrese los datos del producto:");

        System.out.print("SKU: ");
        int sku = scanner.nextInt();
        producto.setSKU(sku);

        System.out.print("Precio de costo: ");
        double precioCosto = scanner.nextDouble();
        producto.setPrecioCosto(precioCosto);

        System.out.print("Precio de venta: ");
        double precioVenta = scanner.nextDouble();
        producto.setPrecioVenta(precioVenta);

        System.out.print("Marca: ");
        String marca = scanner.next();
        producto.setMarca(marca);

        System.out.print("Disciplina: ");
        String disciplina = scanner.next();
        producto.setDisciplina(disciplina);


        mostrarColores();
        System.out.print("Color (en mayusculas): ");
        String color = scanner.next();
        try{
            Color colorElegido = Color.valueOf(color);
            producto.setColor(colorElegido);
        }catch (IllegalArgumentException ex)
        {
            System.out.println("El color ingresado no es válido. Por favor, elige uno de los colores mostrados.");
        }


        System.out.print("¿Es oferta? (true/false): ");
        boolean esOferta = scanner.nextBoolean();
        producto.setEsOferta(esOferta);

        System.out.print("¿Es novedad? (true/false): ");
        boolean esNovedad = scanner.nextBoolean();
        producto.setEsNovedad(esNovedad);

        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        producto.setStock(stock);

    }


    /**
     * Pide datos de Indumentaria y la crea
     * @param scanner
     * @param producto
     * @return
     */
    public Indumentaria ingresarDatosIndumentaria (Scanner scanner, Indumentaria producto) {
        datosComunes(scanner, producto);

        System.out.println("Tipos de Indumentaria disponibles.");
        for (TipoIndumentaria indumentaria : TipoIndumentaria.values()) {
            System.out.println(indumentaria.name());
        }
        System.out.print("Tipo de indumentaria: ");
        String tipo = scanner.next();
        try {

            TipoIndumentaria tipoIndumentaria = TipoIndumentaria.valueOf(tipo);
            producto.setTipoIndumentaria(tipoIndumentaria);
        } catch (IllegalArgumentException ex)
        {
            System.out.println("El tipo ingresado no existe.");
        }

        System.out.print("Medida del talle (xs,x,l,m,xl,xxl) : ");
        String talle = scanner.next();
        producto.setTalleMedida(talle);
        return producto;
    }


    /**
     * Pide los datos de Calzado y lo crea
     * @param scanner
     * @param producto
     * @return
     */
    public Calzado ingresarDatosCalzado (Scanner scanner, Calzado producto)
    {
        datosComunes(scanner, producto);

        System.out.println("Tipos de Calzado disponibles.");
        for (TipoCalzado indumentaria : TipoCalzado.values()) {
            System.out.println(indumentaria.name());
        }
        System.out.print("Tipo de calzado: ");
        String tipo = scanner.next();
        try
        {
            TipoCalzado tipoCalzado = TipoCalzado.valueOf(tipo);
            producto.setTipoCalzado(tipoCalzado);
        }catch (IllegalArgumentException ex)
        {
            System.out.println("El tipo ingresado no existe.");
        }

        System.out.print("Numero de talle: ");
        float talle = scanner.nextFloat();
        producto.setTalleNumero(talle);

        return producto;
    }


    /**
     * Pide datos de Accesorio y lo crea
     * @param scanner
     * @param producto
     * @return
     */
    public Accesorio ingresarDatosAccesorio (Scanner scanner, Accesorio producto)
    {
        datosComunes(scanner, producto);

        System.out.println("Tipos de Accesorio disponibles.");
        for (TipoAccesorio accesorio : TipoAccesorio.values()) {
            System.out.println(accesorio.name());
        }
        System.out.print("Tipo de accesorio: ");
        String tipo = scanner.next();
        try
        {
            TipoAccesorio tipoAccesorio = TipoAccesorio.valueOf(tipo);
            producto.setTipoAccesorio(tipoAccesorio);
        }catch (IllegalArgumentException ex)
        {
            System.out.println("El tipo ingresado no existe.");
        }


        System.out.print("Tamano de accesorio: ");
        String medida = scanner.next();
        producto.setTamano(medida);

        return producto;
    }


    public void mostrarColores()
    {
        System.out.println("Colores disponibles.");
        for (Color color : Color.values()) {
            System.out.println(color.name());
        }
    }




}
