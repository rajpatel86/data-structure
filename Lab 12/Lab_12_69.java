
import java.util.Scanner;
public class Lab_12_69{
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
		li.removeDuplicates();
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
	public void removeDuplicates(){
		if(first.link == null){
			return;
		}
		Node current = first;
		while(current.link!=null){
			if(current.data == current.link.data){
				current.link = current.link.link;
			}
			else{
			current = current.link;
			}
		}
	}
	public void display(){
		Node temp = first;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp = temp.link;
		}
	}
}
