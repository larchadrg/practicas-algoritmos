package colecciones.pila;

public interface Pila<T> {
    /**
     * @return true iff the stack if empty 
     */
    public boolean vacia(); 

    /**
     * 
     * @return el tope de la pila si no está vacia. 
     * @throws UnderflowException si la pila está vacia 
     * @see #vacia() 
     */
    public T tope() throws UnderflowException;
    
    /**
     * Apila un elemento en el tope de la pila 
     * @param elem el elemento a apiar 
     * @throws OverflowException si la pila está llena 
     */
    public void apilar(T elem) throws OverflowException; 

    /**
     * 
     * @return el tope de la pila si no está vacia
     * @throws UnderflowException si la pila está vacia 
     * @see #vacia()
     */
    public T desapilar() throws UnderflowException; 

    /**
     * Elimina todos los elementos de la pila
     */
    public void vaciar();

    /**
     * @return cantidad de elementos en la pila 
     */
    public int cantElementos(); 
}
