package colecciones.pila;

import java.util.ArrayList;
import java.util.List;

public class SecuenciaBalanceada {
    public static boolean secuenciaBalanceada(List<Character> l) throws OverflowException, UnderflowException{
        if (l.isEmpty()) return true; 
        Pila<Character> parentesisAbiertos = new PilaArreglo<>();
        for(Character c: l){
            if (c.equals('{') || c.equals('(') || c.equals('[')){
                parentesisAbiertos.apilar(c);
            }
            if(c.equals('}')){
                try{
                    if(parentesisAbiertos.tope().equals('{')) parentesisAbiertos.desapilar(); 
                    else return false; 
                } catch (UnderflowException e){
                    return false; 
                }
            }
            if(c.equals(']')){
                try{
                    if(parentesisAbiertos.tope().equals('[')) parentesisAbiertos.desapilar(); 
                    else return false; 
                } catch (UnderflowException e){
                    return false; 
                }
            }
            if(c.equals(')')){
                try{
                    if(parentesisAbiertos.tope().equals('(')) parentesisAbiertos.desapilar(); 
                    else return false; 
                } catch (UnderflowException e){
                    return false; 
                }
            }
        }
        return parentesisAbiertos.cantElementos() == 0; 
    }

    public static void main (String args[]) throws OverflowException, UnderflowException{
        List<Character> secuencia = new ArrayList<>();
        String sec = "(hola)({{[[]]}})"; 
        for (char c : sec.toCharArray()) {
            secuencia.add(c);
        }
        System.out.println(secuenciaBalanceada(secuencia));
    }
}
