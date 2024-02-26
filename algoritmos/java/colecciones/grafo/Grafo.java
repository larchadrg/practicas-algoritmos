package colecciones.grafo;

import java.util.Set;

public interface Grafo<T> {
    public void mostrarDFS(T nodo) throws IllegalArgumentException; 
    public void mostrarBFS(T nodo) throws IllegalArgumentException;
    public Set<T> obtenerAdyacentes(T nodo); 
    public Set<T> obtenerNodos(); 
    public boolean poseeParteInalcanzable();
    public void agregarArista(int i, int j); 
}