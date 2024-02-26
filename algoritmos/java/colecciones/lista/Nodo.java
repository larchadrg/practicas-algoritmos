package colecciones.lista;

public class Nodo<T> {
    T info; 
    Nodo<T> sig; 

    public Nodo(T info){
        this.info = info;
        sig = null; 
    }

    public T getInfo() {
        return info;
    }

    public Nodo<T> getSig() {
        return sig;
    }

    public void setInfo(T info) {
        this.info = info;
    }
    public void setSig(Nodo<T> sig) {
        this.sig = sig;
    }
}
