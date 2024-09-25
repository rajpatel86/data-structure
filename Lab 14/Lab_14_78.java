import java.util.Scanner;

public class Lab_14_78 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "";
        BinarySearchTree bst = new BinarySearchTree();
        while(!s.equals("-1")){
            System.out.println("Enter 1 to insert a node : ");
            System.out.println("Enter 2 to display Binary Search Tree in Preorder Traversal");
            System.out.println("Enter 3 to display Binary Search Tree in Inorder Traversal");
            System.out.println("Enter 4 to display Binary Search Tree in Postorder Traversal");
            System.out.println("Enter -1 to exit");
            s = sc.nextLine();

            switch(s){
                case "1":
                    System.out.print("Enter value of node you want to insert : ");
                    int val = sc.nextInt();
                    sc.nextLine();
                    bst.insert(val);
                    break;
                case "2":
                    bst.preorder();
                    break;
                case "3":
                    bst.inorder();
                    break;
                case "4":
                    bst.postorder();
                    break;
                case "-1":
                    System.out.println("Exiting the loop");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
        sc.close();
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
        if (root == null) {
            return new Node(data);
        }
        if (data < root.key) {
            root.left = insertRecord(root.left, data);
        } else if (data > root.key) {
            root.right = insertRecord(root.right, data);
        }
        return root;
    }

    
    void preorder() {
        preorderRecord(root);
        System.out.println();
    }

    void preorderRecord(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key + " ");
        preorderRecord(root.left);
        preorderRecord(root.right);
    }

  
    void inorder() {
        inorderRecord(root);
        System.out.println();
    }

    void inorderRecord(Node root) {
        if (root == null) {
            return;
        }
        inorderRecord(root.left);
        System.out.print(root.key + " ");
        inorderRecord(root.right);
    }

    
    void postorder() {
        postorderRecord(root);
        System.out.println();
    }

    void postorderRecord(Node root) {
        if (root == null) {
            return;
        }
        postorderRecord(root.left);
        postorderRecord(root.right);
        System.out.print(root.key + " ");
    }
}