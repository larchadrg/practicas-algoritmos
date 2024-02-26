package booleanos;

public class Booleano {
    int valor; 

    private Booleano(int valor){
        this.valor = valor; 
    }

    private int getValor() {
        return valor;
    }

    public static Booleano verdadero(){
        return new Booleano(0);
    }
    public static Booleano falso(){
        return new Booleano(1); 
    }

    public Booleano neg(){
        return new Booleano(valor+1); 
    }

    public Booleano disyuncion(Booleano vBooleano){
        return new Booleano(valor * vBooleano.getValor()); 
    }

    public Booleano implicacion(Booleano boo){
        return neg().disyuncion(boo);
    }

    public String toString(){
        if (valor % 2 == 0) return "Verdadero"; 
        else return "Falso"; 
    }

    public static void main(String args[]){
        Booleano verdadero = verdadero(); 
        Booleano falso = falso(); 
        System.out.println(verdadero.disyuncion(falso));
        System.out.println(verdadero.disyuncion(verdadero));
        System.out.println(falso.disyuncion(falso));
        System.out.println(falso.disyuncion(verdadero));

        System.out.println(verdadero.implicacion(falso));
        System.out.println(verdadero.implicacion(verdadero));
        System.out.println(falso.implicacion(falso));
        System.out.println(falso.implicacion(verdadero));
    }
}
