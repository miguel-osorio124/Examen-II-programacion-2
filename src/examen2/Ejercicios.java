/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author turupawn
 */
public class Ejercicios {
    static void guardar(String nombre_archivo, ArrayList<Producto> productos)
    {
        try
        {
            PrintWriter p1 = new PrintWriter(nombre_archivo);

            for(Producto product : productos)
            {
                p1.println(product.nombre + " " + product.categoria+" "+ product.existencias + " " + product.precio);
            }

            p1.close();
        }catch (Exception e)
        {
            System.out.println("Ocurrio un error al guardar.");
        }
    }

    
    
    static ArrayList<Producto> abrir(String nombre_archivo)
    {
       ArrayList<Producto> p2= new ArrayList<>(); 
        try
        {
            Scanner scanner = new Scanner(new File(nombre_archivo));
            while(scanner.hasNext())
            {
                String nombre = scanner.next();
                String categoria = scanner.next();
                int existencias = scanner.nextInt();
                double precio = scanner.nextDouble();
                p2.add (new Producto(nombre, categoria, existencias, precio) );
            }
            scanner.close();
        }catch(Exception e)
        {
            System.out.print("Error al leer el archivo");
        }
        return p2;
    }
}