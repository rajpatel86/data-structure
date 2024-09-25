
import java.util.Scanner;
class Node {
    String name;
    String phoneNumber;
    Node left, right;

    Node(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.left = this.right = null;
    }
}
class PhoneBookBST {
    private Node root;

    public PhoneBookBST() {
        this.root = null;
    }
    public void addEntry(String name, String phoneNumber) {
        root = addRecursive(root, name, phoneNumber);
    }

    private Node addRecursive(Node node, String name, String phoneNumber) {
        if (node == null) {
            return new Node(name, phoneNumber);
        }
        if (name.compareTo(node.name) < 0) {
            node.left = addRecursive(node.left, name, phoneNumber);
        } else if (name.compareTo(node.name) > 0) {
            node.right = addRecursive(node.right, name, phoneNumber);
        } else {
            node.phoneNumber = phoneNumber;
        }
        return node;
    }
    public void removeEntry(String name) {
        root = removeRecursive(root, name);
    }

    private Node removeRecursive(Node node, String name) {
        if (node == null) {
            return null;
        }
        if (name.compareTo(node.name) < 0) {
            node.left = removeRecursive(node.left, name);
        } else if (name.compareTo(node.name) > 0) {
            node.right = removeRecursive(node.right, name);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node smallestNode = findSmallestNode(node.right);
            node.name = smallestNode.name;
            node.phoneNumber = smallestNode.phoneNumber;
            node.right = removeRecursive(node.right, smallestNode.name);
        }
        return node;
    }

    private Node findSmallestNode(Node node) {
        return node.left == null ? node : findSmallestNode(node.left);
    }
    public String searchPhoneNumber(String name) {
        return searchRecursive(root, name);
    }

    private String searchRecursive(Node node, String name) {
        if (node == null) {
            return null;
        }
        if (name.equals(node.name)) {
            return node.phoneNumber;
        }
        return name.compareTo(node.name) < 0 ? searchRecursive(node.left, name) : searchRecursive(node.right, name);
    }
    public void listAscending() {
        listAscendingRecursive(root);
    }

    private void listAscendingRecursive(Node node) {
        if (node != null) {
            listAscendingRecursive(node.left);
            System.out.println(node.name + ": " + node.phoneNumber);
            listAscendingRecursive(node.right);
        }
    }
    public void listDescending() {
        listDescendingRecursive(root);
    }

    private void listDescendingRecursive(Node node) {
        if (node != null) {
            listDescendingRecursive(node.right);
            System.out.println(node.name + ": " + node.phoneNumber);
            listDescendingRecursive(node.left);
        }
    }
}
public class Lab_15_84 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhoneBookBST phoneBook = new PhoneBookBST();
        boolean running = true;

        while (running) {
            System.out.println("\nPhone Book Menu:");
            System.out.println("1. Add new entry");
            System.out.println("2. Remove entry");
            System.out.println("3. Search phone number");
            System.out.println("4. List all entries (ascending order)");
            System.out.println("5. List all entries (descending order)");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter name: ");
                    String addName = sc.nextLine();
                    System.out.print("Enter phone number: ");
                    String addPhoneNumber = sc.nextLine();
                    phoneBook.addEntry(addName, addPhoneNumber);
                    System.out.println("Entry added.");
                    break;

                case 2:
                    System.out.print("Enter name to remove: ");
                    String removeName = sc.nextLine();
                    phoneBook.removeEntry(removeName);
                    System.out.println("Entry removed.");
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    String phoneNumber = phoneBook.searchPhoneNumber(searchName);
                    if (phoneNumber != null) {
                        System.out.println(searchName + ": " + phoneNumber);
                    } else {
                        System.out.println("Entry not found.");
                    }
                    break;

                case 4:
                    System.out.println("Listing all entries in ascending order:");
                    phoneBook.listAscending();
                    break;

                case 5:
                    System.out.println("Listing all entries in descending order:");
                    phoneBook.listDescending();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        sc.close();
    }
}
