
import java.util.Scanner;

public class Lab_9_53 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of PriorityQueue: ");
        int size = sc.nextInt();
        sc.nextLine();
        PriorityQueue q = new PriorityQueue(size);

        String s = "";
        while (!s.equals("-1")) {
            System.out.println("Enter 1 to insert in PriorityQueue");
            System.out.println("Enter 2 to delete from PriorityQueue");
            System.out.println("Enter 3 to display the PriorityQueue");
            System.out.println("Enter -1 to exit");
            s = sc.nextLine();
            switch (s) {
                case "1":
                    System.out.print("Enter data: ");
                    int data = sc.nextInt();
                    System.out.print("Enter priority: ");
                    int priority = sc.nextInt();
                    sc.nextLine();
                    q.insert(data, priority);
                    break;
                case "2":
                    System.out.println("Deleted item: " + q.delete());
                    break;
                case "3":
                    q.display();
                    break;
                case "-1":
                    System.out.println("Exiting the loop");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
        sc.close();
    }
}

class PriorityQueue {
    private int[][] arr;
    private int size;
    private int rear;

    public PriorityQueue(int size) {
        this.size = size;
        this.arr = new int[size][2];
        this.rear = -1;
    }

    protected void insert(int data, int priority) {
        if (rear >= size - 1) {
            System.out.println("PriorityQueue Overflow");
            return;
        }
        
        rear++;
        
        int i = rear;
        while (i > 0 && priority > arr[i - 1][1]) {
            arr[i][0] = arr[i - 1][0];
            arr[i][1] = arr[i - 1][1];
            i--;
        }
        arr[i][0] = data;
        arr[i][1] = priority;
    }

    protected int delete() {
        if (rear < 0) {
            System.out.println("PriorityQueue Underflow");
            return -1;
        }
        
        int highestPriorityElement = arr[0][0];
        for (int i = 0; i < rear; i++) {
            arr[i][0] = arr[i + 1][0];
            arr[i][1] = arr[i + 1][1];
        }
        rear--;
        
        return highestPriorityElement;
    }

    protected void display() {
        if (rear < 0) {
            System.out.println("PriorityQueue is empty");
            return;
        }
        
        for (int i = 0; i <= rear; i++) {
            System.out.print("Element: " + arr[i][0] + ", Priority: " + arr[i][1]);
            if (i < rear) {
                System.out.print(" | ");
            }
        }
        System.out.println();
    }
}
