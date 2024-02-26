package colecciones.pila;

public class PilaLSE<T> implements Pila<T> {

    public class Nodo{
        private T info; 
        private Nodo sig; 

        public Nodo(T info){
            this.info = info;
            sig = null; 
        }

        public void setInfo(T info){
            this.info = info; 
        }

        public void setSig(Nodo sig){
            this.sig = sig; 
        }

        public T getInfo(){
            return this.info; 
        }

        public Nodo getSig(){
            return sig; 
        }

    }

    private int cantElementos;
    private Nodo tope;  

    public PilaLSE(){
        tope = null;
        cantElementos = 0; 
    }

    public PilaLSE(T cabeza){
        tope = new Nodo(cabeza); 
        cantElementos = 0; 
    }

    @Override
    public boolean vacia() {
        return cantElementos == 0; 
    }

    @Override
    public T tope() throws UnderflowException {
        if (vacia()) throw new UnderflowException(); 
        return tope.getInfo(); 
    }

    @Override
    public void apilar(T elem) throws OverflowException {
        Nodo nuevoNodo = new Nodo(elem); 
        if (vacia()){
            tope = nuevoNodo; 
        } else {
            nuevoNodo.setSig(tope);
            tope = nuevoNodo; 
        }
        cantElementos++; 
    }

    @Override
    public T desapilar() throws UnderflowException {
        if (cantElementos == 0) throw new UnderflowException(); 
        T info = tope.getInfo(); 
        tope = tope.sig; 
        cantElementos--; 
        return info; 

    }

    @Override
    public void vaciar() {
        tope = null; 
    }

    @Override
    public int cantElementos() {
        return cantElementos; 
    }

    @Override
    public String toString(){
        String rta = ""; 
        Nodo aux = tope; 
        while(aux != null){
            rta += aux.getInfo() + " ";
            aux = aux.getSig(); 
        }
        return rta; 
    }
    
}
