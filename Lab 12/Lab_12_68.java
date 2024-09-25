
import java.util.Scanner;
public class Lab_12_68{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter -1 to exit");
		LinkedList li = new LinkedList();
		int data=0;
		while(true){
			System.out.print("Enter data : ");
			data = sc.nextInt();
			if(data == -1)break;
			li.addNode(data);
		}
		li.swap();
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
	public void swap(){
		Node prev = first;
		Node current = first.link;
		Node temp = null;
		while(prev!=null && current!=null){
			if(temp!=null){
				temp.link = current;
			}
			else{
				first = current;
			}
			prev.link = current.link;
			current.link = prev;

			temp = prev;
			prev = prev.link;
			if(prev!=null)
			current = prev.link;
		else
			current = null;
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
