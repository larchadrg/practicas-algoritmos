package colecciones.grafo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra<T> {
    public int[][] dijkstra(Grafo<T> g, T nodoI, HashMap<T,T> previo){
        Set<T> nodos = g.obtenerNodos(); 
        HashMap<T, Integer> dist = new HashMap<>(); 
        for(T nodo:nodos){
            previo.put(nodo,null); 
            dist.put(nodo, Integer.MAX_VALUE); 
        }
        dist.put(nodoI, 0);
        Set<T> s = new HashSet<>(); 
        PriorityQueue<T> q = new PriorityQueue<>(nodos); 
        while(!q.isEmpty()){
            T nodoMasCercano = q.poll(); 
        }
    }
}
