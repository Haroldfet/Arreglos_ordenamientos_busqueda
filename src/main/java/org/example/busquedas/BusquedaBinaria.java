package org.example.busquedas;

// búsqueda binaria

public class BusquedaBinaria {

    public static class Resultado {
        public final boolean encontrado;
        public final int comparaciones;

        public Resultado(boolean encontrado, int comparaciones) {
            this.encontrado = encontrado;
            this.comparaciones = comparaciones;
        }
    }

    // Busca un número usando búsqueda binaria.

    public static Resultado buscar(int[] arreglo, int objetivo) {
        int izquierda = 0;
        int derecha = arreglo.length - 1;
        int comparaciones = 0;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            comparaciones++;
            if (arreglo[medio] == objetivo) {
                return new Resultado(true, comparaciones);
            }
            if (arreglo[medio] < objetivo) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return new Resultado(false, comparaciones);
    }
}