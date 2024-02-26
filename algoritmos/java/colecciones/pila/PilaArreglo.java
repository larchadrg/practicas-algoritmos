package colecciones.pila; 
public class PilaArreglo<T> implements Pila<T>{
    public static final int tamañoInicial = 10;
    public int tamañoActual = 10; 
    private int indiceTope; 
    private Object[] pila; 

    public PilaArreglo(){
        indiceTope = -1; 
        pila = new Object[tamañoInicial]; 
    }

    @Override
    public boolean vacia() {
        return indiceTope == -1; 
    }

    @SuppressWarnings("unchecked")
    @Override
    public T tope() throws UnderflowException {
        if (vacia()) throw new UnderflowException(); 
        return (T) pila[indiceTope]; 
    }

    @Override
    public void apilar(T elem) throws OverflowException {
       if(indiceTope+1 == tamañoInicial){
            Object nuevaPila[] = new Object[tamañoActual+10];
            for(int i = 0; i<tamañoActual; i++){
                nuevaPila[i] = pila[i]; 
            }
            pila = nuevaPila; 
       }
       pila[indiceTope+1] = elem; 
       indiceTope++; 
    }

    @SuppressWarnings("unchecked")
    @Override
    public T desapilar() throws UnderflowException{
        if (vacia()) throw new UnderflowException(); 
        indiceTope--; 
        return (T) pila[indiceTope+1]; 
    }

    @Override
    public void vaciar() {
        indiceTope = -1; 
    }

    @Override
    public int cantElementos() {
        return indiceTope+1; 
    }

    @Override 
    public String toString(){
        String rta = ""; 
        for(int i=indiceTope; i>=0;i--){
            rta += pila[i] + " ";
        }
        return rta; 
    }

    public static void main(String args[]) throws OverflowException, UnderflowException{
        
    }
}