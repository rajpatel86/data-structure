
import java.util.Scanner;

public class Lab_14_79 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int data;
        BinarySearchTree bst1 = new BinarySearchTree();
        System.out.println("BST1:");
        while(true){
            System.out.println("Enter value you want to enter : ");
            System.out.println("Enter -1 to exit");
            data = sc.nextInt();
            if(data == -1) break;
            bst1.insert(data);
        }
        
        BinarySearchTree bst2 = new BinarySearchTree();
        System.out.println("BST2:");
        while (true) { 
            System.out.println("Enter value you want to enter : ");
            System.out.println("Enter -1 to exit");
            data = sc.nextInt();
            if(data == -1) break;
            bst2.insert(data);
        }

        if(isSameTree(bst1.root, bst2.root)){
            System.out.println("BST1 and BST2 are equal");
        }
        else{
            System.out.println("BST1 and BST2 are not equal");
        }
        
        sc.close();
    }
    private static boolean isSameTree(Node root1, Node root2) {
        if(root1 == null && root2 == null) {
            return true;
        } else if(root1 == null || root2 == null) {
            return false;
        } else if(root1.key == root2.key) {
            return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
        }
        return false;
    }
}

class Node {
    int key;
    Node left;
    Node right;
    
    Node(int data) {
        key = data;
        left = null;
        right = null;
    }
}

class BinarySearchTree {
    Node root;
    
    void insert(int data) {
        root = insertRecord(root, data);
    }
    
    Node insertRecord(Node root, int data) {
        if(root == null) {
            return new Node(data);
        }
        if(data < root.key) {
            root.left = insertRecord(root.left, data);
        } else if(data > root.key) {
            root.right = insertRecord(root.right, data);
        }
        return root;
    }
}
