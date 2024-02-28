package arraySorter;

import java.util.ArrayList;

/**
* Provee métodos para ordenar arreglos de objetos comparables.
* Los algoritmos de ordenamiento provistos por esta clase son:
* <ul>
* <li>Bubble sort.</li>
* <li>Selection sort.</li>
* <li>Shell sort.</li>
* <li>Quick sort.</li>
* <li>Merge sort.</li>
* </ul>
* El invariante que deben cumplir todos los arreglos {@code array} para ser utilizados como argumentos de los distintos algoritmos de ordenamiento es:
* <pre>
* array != null &amp;&amp; for (T elem : array) {elem != null}
* </pre>
*/
public class ArraySorter {

   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Bubble Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void bubbleSort(T[] array) {
      if (array == null) throw new IllegalArgumentException("El arreglo es null, no se puede ordenar");
      boolean sorted = false;
      int n = array.length; 
      for (int pass = 1; (pass < n) && !sorted; ++pass) {
         sorted = true;
         for (int index = 0; index < n - pass; ++index) {
            int nextIndex = index + 1;
            if (array[index].compareTo(array[nextIndex]) > 0) {
               swap(array, index, nextIndex);
               sorted = false;
            }
         }
      }
   }

   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Selection Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void selectionSort(T[] array) {
      if (array == null) throw new IllegalArgumentException("array is null, can't sort");
      //last = indice del ultimo elemento de la parte no ordenada
      for (int last = array.length - 1; last >= 1; last--) {
         //largest = posicion del elemento mas grande
         int largest = indexOfLargest(array, last + 1);
         swap(array, last, largest);
      }
   }


   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Shell Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
  public static <T extends Comparable<? super T>> void shellSort(T[] array) {
   if (array == null || array.length <= 1) {
       return; // If the array is null or has only one element, it's already sorted
   }

   int n = array.length;
   int h = 1;

   // Calculate the initial gap sequence using Knuth's formula
   while (h < n / 3) {
       h = 3 * h + 1;
   }

   // Start with the largest gap and gradually reduce it
   while (h >= 1) {
       // Perform insertion sort for elements at distance h apart
       for (int i = h; i < n; i++) {
           // Insert array[i] into the sorted sequence array[0...i-h], with step h
           for (int j = i; j >= h && less(array[j], array[j - h]); j -= h) {
               swap(array, j, j - h);
           }
       }
       // Reduce the gap
       h /= 3;
   }
}

private static <T extends Comparable<? super T>> boolean less(T a, T b) {
   return a.compareTo(b) < 0;
}


   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Quick Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void quickSort(T[] array) {
      if (array == null || array.length == 0) {
         return; // If the array is null or empty, there's nothing to sort
      }
      quickSort(array, 0, array.length - 1); // Call the overloaded method to start the sorting process
   }

   private static <T extends Comparable<? super T>> void quickSort(T[] array, int low, int high) {
      if (low < high) {
         // Partition the array and get the pivot index
         int pivotIndex = partition(array, low, high);

         // Recursively sort elements before and after the pivot
         quickSort(array, low, pivotIndex - 1);
         quickSort(array, pivotIndex + 1, high);
      }
   }

   private static <T extends Comparable<? super T>> int partition(T[] array, int low, int high) {
      // Choose the pivot (middle element)
      T pivot = array[(low + high) / 2];

      // Move smaller elements to the left and larger elements to the right of the pivot
      while (low <= high) {
         // Find element on the left that should be on the right
         while (array[low].compareTo(pivot) < 0) {
            low++;
         }

         // Find element on the right that should be on the left
         while (array[high].compareTo(pivot) > 0) {
            high--;
         }

         // Swap elements, and move the pointers
         if (low <= high) {
            T temp = array[low];
            array[low] = array[high];
            array[high] = temp;
            low++;
            high--;
         }
      }
      return low;
   }


   /**
   * Ordena un arreglo, usando el orden natural de sus elementos utilizando Merge Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   @SuppressWarnings("unchecked")
   public static <T extends Comparable<? super T>> void mergeSort(T[] array) {
      T[] tempArr = (T[]) new Comparable[array.length]; 
      mergeSort(array, tempArr,0,array.length-1);
   }
   private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] tempArr, int izq, int der){
      if(izq < der){
         int centro =  (izq + der) /2; 
         mergeSort(a, tempArr, izq, centro);
         mergeSort(a, tempArr, centro+1, der);
         merge(a,tempArr,izq,centro+1,der); 
      }
   }

   private static <T extends Comparable<? super T>> void merge(T[]a,T[]b, int posIzq, int posDer, int finDer){
      int finIzq = posDer - 1; 
      int posTemp = posIzq; 
      int cantElems = finDer - posIzq + 1; 
      while(posIzq <= finIzq && posDer <= finDer){
         if(a[posIzq].compareTo(a[posDer]) <= 0 ) b[posTemp++] = a[posIzq++];
         else b[posTemp++] = a[posDer++];  
      }
      while (posIzq <= finIzq) b[posTemp++] = a[posIzq++]; 
      while (posDer <= finDer) b[posTemp++] = a[posDer++]; 
      for(int i=0;i<cantElems;i++,finDer--){
         a[finDer] = b[finDer]; 
      }
   }


   /* (non-Javadoc)
   * Este método intercambia dos posiciones de un arreglo.
   */ 
   private static <T extends Comparable<? super T>> void swap(T[] array, int i, int j) {
      T temp = array[i];
      array[i] = array[j];
      array[j] = temp;
   }

   /* (non-Javadoc)
   * Este método retorna el indice del elemento mas grande. 
   */
   private static <T extends Comparable<? super T>> int indexOfLargest(T[] array, int n){
      int largest = 0;
      for (int i = 1; i < n; i++){
         if (array[i].compareTo(array[largest]) > 0){
            largest = i;
         }
      }  
      return largest;
   }


}
