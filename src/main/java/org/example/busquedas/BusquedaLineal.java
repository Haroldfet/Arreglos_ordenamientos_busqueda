package org.example.busquedas;

//búsqueda lineal

public class BusquedaLineal {

    public static class Resultado {
        public final boolean encontrado;
        public final int comparaciones;

        public Resultado(boolean encontrado, int comparaciones) {
            this.encontrado = encontrado;
            this.comparaciones = comparaciones;
        }
    }

    //Busca un número usando búsqueda lineal.

    public static Resultado buscar(int[] arreglo, int objetivo) {
        int comparaciones = 0;
        for (int valor : arreglo) {
            comparaciones++;
            if (valor == objetivo) {
                return new Resultado(true, comparaciones);
            }
        }
        return new Resultado(false, comparaciones);
    }
}