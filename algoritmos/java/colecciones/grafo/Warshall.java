package colecciones.grafo;

import java.util.Arrays;

public class Warshall {
    /**
     * Calcula  los caminos mas cortos entre cada par de nodos de un grafo
     * @param grafo almacena los pesos de los arcos
     * @param dist alamcena el costo de viajar del nodo P al Q 
     * @param camino almacena el numero de nodos a recorrer para llegar de P a Q (-1 si es imposible)
     */
    public void warshallCaminos(int[][] grafo, int[][] dist, int[][] camino){
        
        int sizeGrafo = grafo.length; 
        for(int i = 1; i<sizeGrafo;i++){
            for(int j=1; j<sizeGrafo;j++){
                dist[i][j] = grafo[i][j]; 
                camino[i][j] = -1; 
                if (0<grafo[i][j] && grafo[i][j]<Integer.MAX_VALUE){ //distancia valida
                    camino[i][j] = 1; 
                }
            }
        }

        //se considera cada camino pasando por un posible k
        for(int k =1; k<sizeGrafo;k++){
            for(int i = 1; i<sizeGrafo;i++){
                for(int j=1; j<sizeGrafo;j++){
                    if (dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                        camino[i][j] = k; 
                    }
                }
            }
        }
    }

    public static int[][] warshallClausuraReflexoTransitiva(int grafo[][]){
        int[][] clausura = Arrays.copyOf(grafo, grafo.length); 
        for(int k=0;k<grafo.length;k++){
            for(int i=0;i<grafo.length;i++){
                for(int j = 0; j<grafo.length;j++){
                    clausura[i][i] = 1; 
                    clausura[i][j] = Math.max(clausura[i][j], Math.min(clausura[i][k],clausura[k][j])); 
                }
            }
        }
        return clausura; 
    }

    public static void main(String args[]){
        int[][] matriz = {
            {1, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
        };

        int[][] clausura = warshallClausuraReflexoTransitiva(matriz); 
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(clausura[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
