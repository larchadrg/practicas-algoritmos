package colecciones.arbol;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

public class TreeSort {
    TreeNode root;

    public TreeSort() {
        root = null;
    }

    // Method to insert a new node with given value in BST
    private TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }
        return node;
    }

    // Method to perform tree sort
    public void treeSort(int[] array) {
        for (int value : array) {
            root = insert(root, value);
        }
        for(int i = array.length-1; i>=0;i--)
            array[i] = popMax(); 
    }

    // Method to pop and return the node with maximum value in the tree
    public int popMax() {
        TreeNode parent = null;
        TreeNode current = root;

        // Find the rightmost node (which has the maximum value)
        while (current.right != null) {
            parent = current;
            current = current.right;
        }
        // If parent is null, then the root is the max node
        if (parent == null) {
            root = root.left;
        } else {
            parent.right = current.left;
        }
        return current.value;
    }

    @Override
    public String toString(){
        List<Integer> elementos = new LinkedList<>();
        return aListaInOrder(root, elementos).toString();  
    }

    private List<Integer> aListaInOrder(TreeNode raiz, List<Integer> elementos) {
        if (raiz != null) {
            aListaInOrder(raiz.left, elementos);
            elementos.add(raiz.value);
            aListaInOrder(raiz.right, elementos);
        }
        return elementos; 
    }

    // Method to test TreeSort
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 3, 7, 9};
        TreeSort treeSort = new TreeSort();
        System.out.println("Array before sorting:");
        for (int value : array) {
            System.out.print(value + " ");
        }
        treeSort.treeSort(array);
        System.out.println("\nArray after sorting:");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println("\nSorted tree:");
        System.out.println(treeSort);
    }
}
