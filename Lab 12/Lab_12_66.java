
import java.util.Scanner;

public class Lab_12_66 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList li = new LinkedList();
        int data = 0;
        while (true) {
            System.out.print("Enter data (enter -1 to stop): ");
            data = sc.nextInt();
            if (data == -1) break;
            li.addNode(data);
        }
        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();
        li.swap(k);
        li.display();

        sc.close();
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
    Node first = null;

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

    public void swap(int k) {
        if (first == null) {
            System.out.println("List is empty. Cannot perform swap.");
            return;
        }

        int len = length(); 

        if (k <= 0 || k > len) {
            System.out.println("Invalid value of k. Cannot perform swap.");
            return;
        }

        if (2 * k - 1 == len) {
            System.out.println("Kth node from beginning and end are the same. No swap needed.");
            return;
        }

        Node prevKthFromBegin = null;
        Node kthFromBegin = first;
        for (int i = 1; i < k; i++) {
            prevKthFromBegin = kthFromBegin;
            kthFromBegin = kthFromBegin.link;
        }

        Node prevKthFromEnd = null;
        Node kthFromEnd = first;
        for (int i = 1; i < len - k + 1; i++) {
            prevKthFromEnd = kthFromEnd;
            kthFromEnd = kthFromEnd.link;
        }

        if (prevKthFromBegin != null) {
            prevKthFromBegin.link = kthFromEnd;
        } else {
            first = kthFromEnd;
        }

        if (prevKthFromEnd != null) {
            prevKthFromEnd.link = kthFromBegin;
        } else {
            first = kthFromBegin;
        }

        Node temp = kthFromBegin.link;
        kthFromBegin.link = kthFromEnd.link;
        kthFromEnd.link = temp;
    }

    private int length() {
        int count = 0;
        Node temp = first;
        while (temp != null) {
            count++;
            temp = temp.link;
        }
        return count;
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
