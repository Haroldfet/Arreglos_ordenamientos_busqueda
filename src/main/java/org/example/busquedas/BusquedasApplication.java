package org.example.busquedas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class BusquedasApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusquedasApplication.class, args);
        
        // 1. Generar arreglo aleatorio
        int[] arreglo = new int[20];
        Random rand = new Random();
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = rand.nextInt(100) + 1;
        }

        // 2. Imprimir arreglo original
        System.out.println("Arreglo original:");
        imprimirArreglo(arreglo);

        // 3. Ordenar por inserción
        int[] arregloOrdenado = arreglo.clone();
        OrdenamientoInsercion.ordenar(arregloOrdenado);
        System.out.println("Arreglo ordenado:");
        imprimirArreglo(arregloOrdenado);

        // 4. Pedir número a buscar
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese número que desea buscar: ");
        int numero = scanner.nextInt();

        // 5. Búsqueda lineal
        BusquedaLineal.Resultado resultadoLineal = BusquedaLineal.buscar(arregloOrdenado, numero);
        System.out.println("\n--- Búsqueda Lineal ---");
        System.out.println("¿Encontrado?: " + (resultadoLineal.encontrado ? "Sí" : "No"));
        System.out.println("Comparaciones realizadas: " + resultadoLineal.comparaciones);

        // 6. Búsqueda binaria
        BusquedaBinaria.Resultado resultadoBinaria = BusquedaBinaria.buscar(arregloOrdenado, numero);
        System.out.println("\n--- Búsqueda Binaria ---");
        System.out.println("¿Encontrado?: " + (resultadoBinaria.encontrado ? "Sí" : "No"));
        System.out.println("Comparaciones realizadas: " + resultadoBinaria.comparaciones);

        // 7. Comparación de resultados
        System.out.println("\n--- Comparación de Métodos ---");
        if (resultadoLineal.encontrado == resultadoBinaria.encontrado) {
            System.out.println("Ambos métodos coinciden en el resultado.");
        } else {
            System.out.println("Los métodos discrepan en el resultado.");
        }
        System.out.println("Comparaciones (Lineal vs Binaria): " + resultadoLineal.comparaciones + " vs " + resultadoBinaria.comparaciones);
    }

    // Imprimir arreglo

    private static void imprimirArreglo(int[] arreglo) {
        for (int n : arreglo) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}