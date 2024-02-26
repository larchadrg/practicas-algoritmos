package racionales;

public class Racional {
    private long numerador; 
    private long denominador; 


    public Racional(long numerador, long denominador){
        if (denominador < 0) throw new IllegalArgumentException("el denominador debe ser positivo"); 
        this.numerador = numerador; 
        this.denominador = denominador; 
    }

    public static Racional sumar(Racional num1, Racional num2){
        long nDenom = num1.denominador * num2.denominador;
        return new Racional(num2.denominador * num1.numerador +
            	    num1.denominador * num2.numerador, nDenom);
    }

    public static Racional restar(Racional num1, Racional num2){
        long nDenom = num1.denominador * num2.denominador;
        return new Racional(num2.denominador * num1.numerador - 
            	    num1.denominador * num2.numerador, nDenom);
    }

    private void simplificar() {
        long mcd = mcd(Math.abs(numerador), Math.abs(denominador));
        numerador /= mcd;
        denominador /= mcd;
    }

    private long mcd(long l, long m) {
        while (m != 0) {
            long temp = m;
            m = l % m;
            l = temp;
        }
        return l;
    }

    public boolean equals(Racional otra) {
        this.simplificar();
        otra.simplificar();
        return this.numerador == otra.numerador && this.denominador == otra.denominador;
    }

    @Override 
    public String toString(){
        return numerador +"/"+denominador; 
    }

    public static void main(String args[]){
        Racional n1 = new Racional(2, 4);
        Racional n2 = new Racional(6, 8); 
        Racional n3 = sumar(n1, n2);
        System.out.println(n3);
        System.out.println(n3.equals(new Racional(5,4)));
    }
}
