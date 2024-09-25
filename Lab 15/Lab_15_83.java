
import java.util.Scanner;
public class Lab_15_83 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        int data=0;
        while(data!=-1){
            System.out.print("Enter the number (-1 to stop): ");
            data=sc.nextInt();
            if(data==-1) break;
                bst.insert(data);
        }
        System.out.println("Minimum value in BST = "+bst.minValue());
        System.out.println("Maximum value in BST = "+bst.maxValue());
    }
}
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class BinarySearchTree{
    Node root;
    BinarySearchTree(){
        root=null;
    }
    void insert(int data){
        root=insertRecord(root,data);
    }
    Node insertRecord(Node root,int data){
        if(root == null){
            root = new Node(data);
            return root;
        }
        if(data<root.data){
            root.left = insertRecord(root.left,data);
        }
        if(data>root.data){
            root.right = insertRecord(root.right,data);
        }
        return root;
    }
    int minValue(){
        Node curr=root;
        while(curr.left!=null){
            curr=curr.left;
        }
        return curr.data;
    }
    int maxValue(){
        Node curr=root;
        while(curr.right!=null){
            curr=curr.right;
        }
        return curr.data;
    }
}
