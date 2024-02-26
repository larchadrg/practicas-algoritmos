package colecciones.lista;

import java.util.List;

public class ListaLCirc<T> implements Lista<T> {
    Nodo<T> finLista; 
    int elementos; 

    public ListaLCirc(){
        finLista = null; 
        elementos = 0; 
    }

    @Override
    public boolean agregar(T elem) {
        Nodo<T> nuevoNodo = new Nodo<>(elem); 
        if (esVacia()){
            nuevoNodo.setSig(nuevoNodo);
        } else {
            
        }

    }

    @Override
    public boolean agregarTodos(Lista<T> otraLista) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregarTodos'");
    }

    @Override
    public boolean insertar(T elem, int indice) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public T eliminar(int indice) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public T obtener(int indice) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtener'");
    }

    @Override
    public Lista<T> subLista(int desdeInd, int hastaInd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subLista'");
    }

    @Override
    public boolean contiene(T elem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contiene'");
    }

    @Override
    public void vaciar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'vaciar'");
    }

    @Override
    public int elementos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'elementos'");
    }

    @Override
    public boolean esVacia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'esVacia'");
    }

    @Override
    public boolean repOK() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'repOK'");
    }
    
}
