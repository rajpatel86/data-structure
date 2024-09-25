
import java.util.Scanner;

public class Lab_13_76 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter degree of first polynomial: ");
        int degree1 = sc.nextInt();
        System.out.println("Enter coefficients for the first polynomial: ");
        LinkedList li1 = new LinkedList();
        for (int i = degree1; i >= 0; i--) {
            System.out.print("Enter coefficient of x^" + i + ": ");
            int data = sc.nextInt();
            li1.addNode(data);
        }
        System.out.print("Enter degree of second polynomial: ");
        int degree2 = sc.nextInt();
        System.out.println("Enter coefficients for the second polynomial: ");
        LinkedList li2 = new LinkedList();
        for (int i = degree2; i >= 0; i--) {
            System.out.print("Enter coefficient of x^" + i + ": ");
            int data = sc.nextInt();
            li2.addNode(data);
        }
        LinkedList li = add(li1, li2);
        Node temp = li.first;
        System.out.println("The sum of the polynomials is: ");
        int deg = Math.max(degree1,degree2);
        while (temp != null) {
            if(deg==0){
                System.out.print(temp.data);
            }
            else{
            System.out.print(temp.data + "x^" + deg);
            if (temp.link != null) {
                System.out.print(" + ");
            }
            deg--;
            }
            temp = temp.link;
        }
        System.out.println();
        
        sc.close();
    }

    public static LinkedList add(LinkedList li1, LinkedList li2) {
        LinkedList li = new LinkedList();
        Node temp1 = li1.first;
        Node temp2 = li2.first;
        while (temp1 != null || temp2 != null) {
            int sum = (temp1 != null ? temp1.data : 0) + (temp2 != null ? temp2.data : 0);
            li.addNode(sum);
            if (temp1 != null) temp1 = temp1.link;
            if (temp2 != null) temp2 = temp2.link;
        }
        return li;
    }
}

class Node {
    int data;
    Node link;

    public Node(int data) {
        this.data = data;
        this.link = null;
    }
}

class LinkedList {
    public Node first = null;

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
        } else {
            Node temp = first;
            while (temp.link != null) {
                temp = temp.link;
            }
            temp.link = newNode;
        }
    }

    public void display() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.link;
        }
        System.out.println();
    }
}
