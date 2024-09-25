
import java.util.Scanner;

public class Lab_14_80 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int data;
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println("BST:");
        while(true){
            System.out.println("Enter value you want to enter : ");
            System.out.println("Enter -1 to exit");
            data = sc.nextInt();
            if(data == -1) break;
            bst.insert(data);
        }
        if(bst.symmetric()){
            System.out.println("Is symmetric");
        }
        else{
            System.out.println("Is not symmetric");
        }
    }    
}
class Node{
    Node left;
    Node right;
    int key;
    Node(int data){
        key = data;
        left = null;
        right = null;
    }
}
class BinarySearchTree{
    Node root;
    void insert(int data){
        root = insertRecord(root,data);
    }
    Node insertRecord(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        if(data<root.key){
            root.left = insertRecord(root.left,data);
        }
        else if(data>root.key){
            root.right = insertRecord(root.right,data);
        }
        return root;
    }
    boolean symmetric(){
        return root==null || symmetricTree(root.left,root.right);
    }
    boolean symmetricTree(Node node1,Node node2){
        if(node1==null && node2==null){
            return true;
        }
        if(node1==null || node2==null){
            return false;
    }
        return (node1.key == node2.key) && symmetricTree(node1.left,node2.right) && symmetricTree(node1.right,node2.left);
    }
}
