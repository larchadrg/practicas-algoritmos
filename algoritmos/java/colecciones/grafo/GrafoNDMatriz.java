package colecciones.grafo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GrafoNDMatriz<T> implements Grafo<T> {
    private int[][] arcos;
    private int size;
    private ArrayList<T> nodos; 

    public GrafoNDMatriz(ArrayList<T> nodos){
        this.size = nodos.size(); 
        this.nodos = nodos; 
        this.arcos = new int[size][size];
    }

    public void aggArco(int nodo1, int nodo2){
        arcos[nodo1][nodo2] = 1; 
        arcos[nodo2][nodo1] = 1; 
    }

    public void eliminarArco(int nodo1, int nodo2){
        arcos[nodo1][nodo2] = 0;
        arcos[nodo2][nodo1] = 0; 
    }

    public int getSize(){
        return size; 
    }

    @Override
    public Set<T> obtenerAdyacentes(T nodo) {
        Set<T> result = new LinkedHashSet<>();
        int indexNodo = nodos.indexOf(nodo); 
        for(int i = 0; i<size;i++){
            if(arcos[i][indexNodo]==1) result.add(nodos.get(i));
        }
        return result; 
    }

    public T obtenerAdyacenteNoVisitado(T nodo, Set<T> visitados){
        int indexNodo = nodos.indexOf(nodo); 
        for(int i = 0; i<size;i++){
            if(arcos[i][indexNodo]==1 && !visitados.contains(nodos.get(i))) return nodos.get(i); 
        }
        return null; 
    }

    @Override
    public void mostrarDFS(T nodoInicial) throws IllegalArgumentException {
        if (!nodos.contains(nodoInicial)) throw new IllegalArgumentException("El nodo no se encuentra en el grafo"); 
        Set<T> nodosVisitados = new HashSet<>(); 
        mostrarDFSRecursivo(nodoInicial, nodosVisitados);
        
    }

    private void mostrarDFSRecursivo(T nodoInicial, Set<T> nodosVisitados){
        System.out.println(nodoInicial);
        nodosVisitados.add(nodoInicial); 
        Set<T> nodosAdyacentes = obtenerAdyacentes(nodoInicial); 
        for(T nodo: nodosAdyacentes){
            if(!nodosVisitados.contains(nodo)){
                mostrarDFSRecursivo(nodo, nodosVisitados);
            }
        }
    }

    /**
     * Muestra todos los nodos en pantalla. 
     * Nota: esta version es distinta a la del teorico, recorre el 
     * grafo en la direccion contraria. 
     * @param nodoInicial nodo por el cual se inicia a recorrer el grafo
     */
    public void mostrarDFSPila(T nodoInicial){
        if (!nodos.contains(nodoInicial)) throw new IllegalArgumentException("El nodo no se encuentra en el grafo"); 
        Set<T> nodosVisitados = new HashSet<>();
        Stack<T> pila = new Stack<>(); 
        pila.add(nodoInicial); 

        while (!pila.isEmpty()) {
            T elem = pila.pop();
            if(!nodosVisitados.contains(elem)){
                System.out.print(elem + " ");
                nodosVisitados.add(elem);
                pila.addAll(obtenerAdyacentes(elem)); 
            }
            
        }
    }

    @Override
    public void mostrarBFS(T nodoInicial) throws IllegalArgumentException {
        if (!nodos.contains(nodoInicial)) throw new IllegalArgumentException("El nodo no se encuentra en el grafo"); 
        Queue<T> cola = new LinkedList<>(); 
        Set<T> nodosVisitados = new HashSet<>(); 
        cola.add(nodoInicial); 
        nodosVisitados.add(nodoInicial);  
        while (!cola.isEmpty()) {
            T elem = cola.poll();
            System.out.println(elem);
            Set<T> adyacentes = obtenerAdyacentes(elem); 
            for(T nodo: adyacentes){
                if(!nodosVisitados.contains(nodo)){
                    nodosVisitados.add(nodo); 
                    cola.add(nodo); 
                }
            }
        }
    }

    public Set<T> obtenerNodos(){
        return new HashSet<T>(nodos); 
    }

    public static void main(String args[]){
        Character nodos[] = {'A','B','C','D','E','F','G'}; 
        GrafoNDMatriz<Character> grafo = new GrafoNDMatriz<>(new ArrayList<>(Arrays.asList(nodos))); 
        grafo.aggArco(0, 1);
        grafo.aggArco(0, 2);
        grafo.aggArco(0, 4);
        grafo.aggArco(1, 3);
        grafo.aggArco(1, 5);
        grafo.aggArco(0, 1);
        grafo.aggArco(2, 6);
        grafo.aggArco(4, 5);

        //System.out.println(grafo.obtenerAdyacentes('B'));
        //grafo.mostrarDFS('A');
        grafo.mostrarDFSPila('A'); 
    }

    @Override
    public boolean poseeParteInalcanzable() {
        for(int i = 0; i<size; i++){
            for(int j = 0; i<size; j++){

            }
        }
    }
}