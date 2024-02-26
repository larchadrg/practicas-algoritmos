package colecciones.pila;

public class UnderflowException extends Exception {
    public UnderflowException(){
        super(); 
    }

    public UnderflowException(String s){
        super(s); 
    }
}
