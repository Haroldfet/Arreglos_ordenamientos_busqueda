package org.example.busquedas;

// Clase para ordenar un arreglo

public class OrdenamientoInsercion {

    //Ordena el arreglo

    public static void ordenar(int[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            int actual = arreglo[i];
            int j = i - 1;

            // Mueve los elementos que son mayores al valor actual

            while (j >= 0 && arreglo[j] > actual) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = actual;
        }
    }
}