package SistemaDeControl.Archivos;

import SistemaDeControl.Producto.Accesorio.Accesorio;
import SistemaDeControl.Producto.Calzado.Calzado;
import SistemaDeControl.Producto.Color;
import SistemaDeControl.Producto.Indumentaria.Indumentaria;
import SistemaDeControl.Producto.Producto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.SortedMap;


/**
 * Es para ingresar los productos que van al archivo SIN TERMINAR
 */
public class GrabadoraProductos
{

    public void grabarProducto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la grabadora de productos");

        System.out.println("Seleccione el tipo de producto a grabar:");
        System.out.println("1. Indumentaria");
        System.out.println("2. Calzado");
        System.out.println("3. Accesorio");
        int opcion = scanner.nextInt();

        // Declarar una variable para almacenar el producto a grabar
        Producto producto = null;

        switch (opcion) {
            case 1:
                producto = ingresarDatosIndumentaria(scanner);
                break;
            case 2:
                producto = ingresarDatosCalzado(scanner);
                break;
            case 3:
                producto = ingresarDatosAccesorio(scanner);
                break;
            default:
                System.out.println("Opción inválida");
                return;
        }

        System.out.println("El producto ha sido grabado correctamente.");
    }



    public void datosComunes(Scanner scanner, Producto producto)
    {
        System.out.println("Ingrese los datos del producto:");

        System.out.print("SKU: ");
        int sku = scanner.nextInt();
        producto.setSKU(sku);

        System.out.print("Fecha de ingreso (dd/mm/aaaa): ");
        String fechaIngresoStr = scanner.next();
        // Convertir la fecha ingresada a tipo Date utilizando SimpleDateFormat

        System.out.print("Precio de costo: ");
        double precioCosto = scanner.nextDouble();
        producto.setPrecioCosto(precioCosto);

        System.out.print("Precio de venta: ");
        double precioVenta = scanner.nextDouble();
        producto.setPrecioVenta(precioVenta);

        System.out.print("Marca: ");
        String marca = scanner.next();
        producto.setMarca(marca);






        System.out.print("Descripción: ");
        String descripcion = scanner.next();
        producto.setDescripcion(descripcion);

        System.out.print("Disciplina: ");
        String disciplina = scanner.next();
        producto.setDisciplina(disciplina);

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

    public Indumentaria ingresarDatosIndumentaria (Scanner scanner)
    {

        return null;
    }

    public Calzado ingresarDatosCalzado (Scanner scanner)
    {

        return null;
    }

    public Accesorio ingresarDatosAccesorio (Scanner scanner)
    {

        return null;
    }


    public void elegirColor()
    {
        System.out.println("Colores disponibles.");
        for (Color color : Color.values()) {
            System.out.println(color.name());
        }


    }




}
