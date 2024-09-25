
import java.util.Scanner;

public class Lab_14_77 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "";
        int val;
        BinarySearchTree bst = new BinarySearchTree();

        while (!s.equals("-1")) {
            System.out.println("Enter 1 to insert a node : ");
            System.out.println("Enter 2 to search a node : ");
            System.out.println("Enter 3 to delete a node : ");
            System.out.println("Enter -1 to exit");
            s = sc.next();

            switch (s) {
                case "1":
                    System.out.print("Enter the value you want to insert : ");
                    val = sc.nextInt();
                    bst.insert(val);
                    break;
                case "2":
                    System.out.print("Enter the value you want to search : ");
                    val = sc.nextInt();
                    bst.search(val);
                    break;
                case "3":
                    System.out.print("Enter the value you want to delete : ");
                    val = sc.nextInt();
                    bst.delete(val);
                    break;
                case "-1":
                    System.out.println("Exiting the loop");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        sc.close();
    }
}

class Node {
    int key;
    Node left, right;

    Node(int data) {
        key = data;
        left = null;
        right = null;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    
    void insert(int data) {
        root = insertRecord(root, data);
    }

    public Node insertRecord(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.key) {
            root.left = insertRecord(root.left, data);
        } else if (data > root.key) {
            root.right = insertRecord(root.right, data);
        }
        return root;
    }

    
    void search(int data) {
        int searchLevel = 0;
        boolean found = searchRecord(root, data, searchLevel);
        if (!found) {
            System.out.println("The value is not found");
        }
    }

    boolean searchRecord(Node root, int data, int level) {
        if (root == null) {
            return false;
        }
        if (data == root.key) {
            System.out.println("The value is available at level " + level);
            return true;
        } else if (data > root.key) {
            return searchRecord(root.right, data, level + 1);
        } else {
            return searchRecord(root.left, data, level + 1);
        }
    }

   
    void delete(int data) {
        root = deleteRecord(root, data);
    }

    public Node deleteRecord(Node root, int data) {
        if (root == null) {
            return root;
        }

        if (data < root.key) {
            root.left = deleteRecord(root.left, data);
        } else if (data > root.key) {
            root.right = deleteRecord(root.right, data);
        } else {
           
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            
            root.key = minValue(root.right);

           
            root.right = deleteRecord(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
}
