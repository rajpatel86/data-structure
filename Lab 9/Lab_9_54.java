
import java.util.Scanner;
class Queue {
    private String[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }
    public void enqueue(String item) {
        if (front==-1) {
            front=0;
        }
        if (size == capacity) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }
    public String dequeue() {
        if (size == 0) {
            return "Queue is empty";
        }
        String item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int getSize() {
        return size;
    }
}
class Peacock {
    private Queue feathers;
    public Peacock(int capacity) {
        feathers = new Queue(capacity);
    }
    public void buy(String color) {
        feathers.enqueue(color);
    }
    public String fetch() {
        if (feathers.isEmpty()) {
            return "No feathers to fetch";
        }
        String bottomFeather = feathers.dequeue();
        feathers.enqueue(bottomFeather);
        return bottomFeather;
    }
}
public class Lab_9_54 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the capacity of the queue:");
        int capacity = scanner.nextInt();
        scanner.nextLine();
        Peacock percy = new Peacock(capacity);
        System.out.println("Enter the queries separated by spaces:");
        String input = scanner.nextLine();
        String[] inputQueries = input.split(" ");
        for (String query : inputQueries) {
            switch (query.split("_")[0]) {
                case "buy":
                    String color = query.split("_")[1];
                    percy.buy(color);
                    break;
                case "fetch":
                    System.out.println(percy.fetch());
                    break;
                default:
                    System.out.println("Invalid query");
            }
        }
        scanner.close();
    }
}
