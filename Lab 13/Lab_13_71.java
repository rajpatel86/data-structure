
import java.util.Scanner;
public class Lab_13_71{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList li = new LinkedList();
		String s = "";
		int data=0;
		while(!s.equals("-1")){
			System.out.println("Enter 1 to insert node at first : ");
		System.out.println("Enter 2 to delete node at specific position : ");
		System.out.println("Enter 3 to insert node at last position : ");
		System.out.println("Enter 4 to display circular LinkedList : ");
		System.out.println("Enter -1 to exit");
		s = sc.next();
			switch(s){
		
				case "1":
				System.out.print("Enter data : ");
				data = sc.nextInt();
				li.insertAtFirst(data);
				break;
			case "2":
				System.out.print("Enter data that you want to delete : ");
				data = sc.nextInt();
				li.deleteAtSpecific(data);
				break;
			case "3":
				System.out.print("Enter data : ");
				data = sc.nextInt();
				li.insertAtLast(data);
				break;
			case "4":
				li.display();
				break;
			case "-1":
				return;
			}
		}
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
	public Node first = null;
	public Node last = null;
	public void addNode(int data){
		Node newNode = new Node(data);
		if(first == null){
			first = newNode;
			last = newNode;
			newNode.link = first;
		} 
		else{
			last.link = newNode;
			last = newNode;
			last.link = first;
		}
	}
	public void insertAtFirst(int data){
			Node newNode = new Node(data);
			if(first == null){
				first = newNode;
				last = newNode;
				newNode.link = first;
			}
			else{
				last.link = newNode;
				newNode.link = first;
				first = newNode;
			}
	}
	public void insertAtLast(int data){
			Node newNode = new Node(data);
			if(first == null){
				first = newNode;
				last = newNode;
				newNode.link = first;
			}
			else{
				last.link = newNode;
				last = newNode;
				newNode.link = first;
			}
	}
	public void deleteAtSpecific(int data){
		if(first == null){
				System.out.println("Cannot be deleted");
		}
		else{
				Node temp = first;
				if(first.data == data){
						last.link = first.link;
						first = first.link;
						return;
				}
				while(temp.link!=last){
						if(temp.link.data == data){
								temp.link = temp.link.link;
						}
						temp = temp.link;
				}
				if(last.data == data){
						temp.link = first;
						last = temp;
				}
				else{
					System.out.println("No node is present of similar data");
				}

		}
	}
	public void display(){
		Node temp = first;
		if(first == null){
			return;
		}
		System.out.print(temp.data+" ");
		temp = temp.link;
		while(temp!=first){
			System.out.print(temp.data+" ");
			temp = temp.link;
		}
		System.out.println();
	}
}
