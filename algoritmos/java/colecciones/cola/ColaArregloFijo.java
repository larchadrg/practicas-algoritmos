package colecciones.cola;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
* Implementación basada en arreglos de tamaño fijo de la interfaz {@code Cola}.
* @see colecciones.cola.Cola
*/
public class ColaArregloFijo<T> implements Cola<T> {

	/**
	* Capacidad máxima por defecto ({@value #CAPACIDAD_POR_DEFECTO})
	*/
	public static final int CAPACIDAD_POR_DEFECTO = 20;
	private Object[] arreglo;
	private int elementos = 0;
	private int capacidad; 

	/**
	* Construye una nueva cola vacía con una capacidad máxima de {@value #CAPACIDAD_POR_DEFECTO}.
	*/
	public ColaArregloFijo() {
		this(CAPACIDAD_POR_DEFECTO);
	}

	/**
	* Construye una nueva cola vacía con una capacidad determinada mayor a 0.
	* @param capacidad la capacidad de la cola
	* @throws IllegalArgumentException si {@code capacidad} es menor o igual a 0 
	*/
	public ColaArregloFijo(int capacidad) {
		if (capacidad <= 0)
			throw new IllegalArgumentException("la capacidad debe ser un numero positivo (" + capacidad + ")");
		arreglo = new Object[capacidad];
		this.capacidad = capacidad; 
	}

	/**
	* Construye una cola a partir de elementos en una colección.
	* Los elementos en la colección se encolan de izquierda a derecha.
	* La capacidad de la cola va a ser suficiente para por lo menos contener todos los elementos de la colección.
	* @param elems los elementos a agregar a la cola
	*/
	public ColaArregloFijo(Collection<T> elems) {
		if (elems == null)
			throw new IllegalArgumentException("elems es null");
		arreglo = new Object[Math.max(elems.size(), CAPACIDAD_POR_DEFECTO)];
		for (T e : elems) {
			encolar(e);	
		}
	}

	@Override
	public boolean esVacia() {
		return elementos == 0; 
	}

	@Override
	public int elementos() {
		return elementos; 
	}

	@Override
	public boolean encolar(T elem) {
		if (elementos == capacidad) return false; 
		arreglo[elementos] = elem; 
		elementos++; 
		return true; 

	}

	@Override
	public T desencolar() throws IllegalArgumentException{
		if (esVacia()) throw new IllegalArgumentException(); 
		@SuppressWarnings("unchecked")
		T elem = (T) arreglo[0]; 
		for(int i =1; i<elementos; i++){
			arreglo[i-1] = arreglo[i];  
		}
		elementos--;
		return elem; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public T primero() {
		return (T) arreglo[0]; 
	}

	@Override
	public void vaciar() {
		elementos = 0; 
	}

	@Override
	public boolean repOK() {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");	
	}

	@Override
	public String toString() {
		String rta = ""; 
		for(int i=0;i<elementos;i++){
			rta += arreglo[i] + " "; 
		}
		return rta; 
	}

	@Override
	public boolean equals(Object other) {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");	
	}

	/**
	* Permite obtener un elemento del arreglo en un indice determinado realizando el casteo necesario.
	* @param index el indice del elemento a obtener
	*/
	@SuppressWarnings("unchecked")
   	private T elemento(int index) {
        	return (T) arreglo[index];
    	}

	private static boolean palindromo(List<Character> secuencia){
		int midSec = secuencia.size() / 2; 
		Cola<Character> cola = new ColaArregloFijo<>(); 
		for(int i = 0; i<midSec;i++){
			cola.encolar(secuencia.get(i)); 
		}
		if (secuencia.size() % 2 == 1) midSec++; 
		for(int i = secuencia.size()-1; i>=midSec;i--){
			if (!secuencia.get(i).equals(cola.desencolar())) return false; 
		} 
		return true; 
	}

	public static void main (String args[]){
		Cola<Integer> cola = new ColaArregloFijo<>(); 
		cola.encolar(1);
		cola.encolar(2); 
		cola.encolar(3);
		Integer desencolado = cola.desencolar(); 
		System.out.println(desencolado);
		System.out.println(cola);

		List<Character> secuencia = new ArrayList<>();
        String sec = "caabaacc"; 
        for (char c : sec.toCharArray()) {
            secuencia.add(c);
        }
        System.out.println(palindromo(secuencia));
	}
}