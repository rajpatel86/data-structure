
import java.util.Scanner;
public class Lab_12_65{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList li = new LinkedList();
		System.out.println("Press -1 to exit");
		int data=0;
		while(true){
			System.out.print("Enter data : ");
			data = sc.nextInt();
			if(data==-1)break;
			li.addNode(data);
		}
		li.sort();
		li.display();
	}
}
class Node{
	int data;
	Node link;
	public Node(int data){
		this.data = data;
		this.link = null;
	}
}
class LinkedList{
	Node first = null;
	public void addNode(int data){
		Node newNode = new Node(data);
		if(first == null){
			first = newNode;
		}
		else{
			Node temp = first;
			while(temp.link!=null){
				temp = temp.link;
			}
			temp.link = newNode;
		}
	}
	public void sort(){
		Node current = first;
		Node next = first;
		int temp = 0;
		while(current!=null){
			next = current.link;
			while(next!=null){
				if(current.data>next.data){
				temp = current.data;
				current.data = next.data;
				next.data = temp;
				}
			next = next.link;
			}
			current = current.link;
		}
	}
	public void display(){
		Node temp = first;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp = temp.link;
		}
		System.out.println();
	}
}
