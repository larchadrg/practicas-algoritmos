package pares;

import java.util.HashSet;
import java.util.Set;

public class Par<T> {
    public T elem1; 
    public T elem2; 

    public Par(T elem1, T elem2){
        this.elem1 = elem1; 
        this.elem2 = elem2; 
    }

    @Override
    public String toString(){
        return String.format("(%s,%s)",elem1.toString(),elem2.toString()); 
    }

    public static Set<Par<Integer>> composicion(Set<Par<Integer>> rel1, Set<Par<Integer>> rel2){
        Set<Par<Integer>> result = new HashSet<>();
        for(Par<Integer> parRel1 : rel1){
            for(Par<Integer> parRel2 : rel2){
                if(parRel1.elem2.equals(parRel2.elem1)){
                    result.add(new Par<Integer>(parRel1.elem1, parRel2.elem2));
                }
            }
        }
        return result; 
    }

    public static Set<Par<Integer>> clausuraTransitiva(Set<Par<Integer>> rel1, Set<Par<Integer>> rel2){
        Set<Par<Integer>> relation = composicion(rel1, rel2);
        int currentSize = 0; 
        do {
            currentSize = relation.size();
            Set<Par<Integer>> newRelation = composicion(relation, rel2); 
            relation.addAll(newRelation); 
        } while (relation.size() != currentSize); 

        return relation; 
    }

    public static void main(String args[]){
        Par<Integer> p1 = new Par<Integer>(1, 2);
        Par<Integer> p2 = new Par<Integer>(2, 4);
        Par<Integer> p3 = new Par<Integer>(2, 5);
        Set<Par<Integer>> set1 = new HashSet<>(); 
        Set<Par<Integer>> set2 = new HashSet<>(); 
        set1.add(p1); set2.add(p2); set2.add(p3); 
        System.out.println(composicion(set1, set2));
        System.out.println(clausuraTransitiva(set1, set2));
    }
}
