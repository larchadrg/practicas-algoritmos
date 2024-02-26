package colecciones.grafo;

import java.util.LinkedList;
import java.util.Set;

/**
 * Implementación de grafo con listas encadenadas
 */
public class DigrafoLista<T> implements Grafo<T> {
    private T[] vertices; 
    private int cantVertices; // Número de vértices
    private LinkedList<Integer> adj[]; // Lista de adyacencia

    @SuppressWarnings("unchecked")
    public DigrafoLista(T[] vertices) {
        cantVertices = vertices.length; 
        this.vertices = vertices; 
        adj = new LinkedList[cantVertices];
        for (int i = 0; i < vertices.length; ++i)
            adj[i] = new LinkedList<>();
    }

    // Método para agregar una arista al grafo
    public void agregarArista(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // En caso de un grafo no dirigido
    }

    @Override
    public void mostrarDFS(T nodo) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarDFS'");
    }

    @Override
    public void mostrarBFS(T nodo) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarBFS'");
    }

    @Override
    public Set<T> obtenerAdyacentes(T nodo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerAdyacentes'");
    }

    @Override
    public Set<T> obtenerNodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerNodos'");
    }

    @Override
    public boolean poseeParteInalcanzable() {
        boolean[] visitados = new boolean[cantVertices]; 
        for(int i=0; i< cantVertices; i++){
            if(!visitados[i]){
                DFSUtil(i,visitados); 
            }
        }
        for(int i=0;i<cantVertices;i++){
            if(!visitados[i]) return true; 
        }
        return false; 
    }
    
    private void DFSUtil(int v, boolean[] visitados){
        visitados[v] = true; 
        for(int ady: adj[v]){
            if(!visitados[ady]) DFSUtil(ady, visitados);
        }
    }

    
    public static void main(String args[]) {
        // Crear un grafo con 5 vértices
        Integer lista[] = {1,2,3,4,5};
        Grafo<Integer> g = new DigrafoLista<>(lista);
        // Agregar aristas al grafo
        g.agregarArista(0, 1);
        g.agregarArista(0, 2);
        g.agregarArista(3, 4);

        // Verificar si hay partes inalcanzables en el grafo
        boolean tienePartesInalcanzables = g.poseeParteInalcanzable();
        if (tienePartesInalcanzables)
            System.out.println("El grafo tiene partes inalcanzables");
        else
            System.out.println("El grafo no tiene partes inalcanzables");
    }
}
