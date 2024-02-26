package colecciones.pila;

public class Inversa {
    public static void mostrarInversa(int arr[]) throws OverflowException{
        Pila<Integer> pila = new PilaLSE<>(); 
        for(int i = 0; i<arr.length; i++){
            pila.apilar(arr[i]);
        }
        System.out.println(pila);
    }
    public static void main (String args[]) throws OverflowException, UnderflowException{
        int arreglo[] = {1,2,3,4,5}; 
        mostrarInversa(arreglo); 


        Pila<Integer> pila = new PilaLSE<>(); 
        pila.apilar(1);
        pila.apilar(3);
        pila.apilar(5);
        pila.desapilar();
        System.out.println(pila);
        System.out.println("cant elems: " + pila.cantElementos());

    }    
}
