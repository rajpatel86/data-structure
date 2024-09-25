
import java.util.Scanner;
public class Lab_7_40{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string : ");
		String s = sc.nextLine();
		Stack st = new Stack(s.length());
		for(int i=0;i<s.length();i++){
			if(s.charAt(i) == 'a'){
			st.push(s.charAt(i));
			}
			else if(s.charAt(i) == 'b'){
				if(st.isEmpty()){
					System.out.println("Invalid String");
					return;
				}
				st.pop();
			}
			else{
				System.out.println("Invalid String");
				return;
			}
		}
		if(st.isEmpty()){
			System.out.println("Valid String");
		}
		else{
			System.out.println("Invalid String");
		}
	}
}
class Stack{
	int top=-1;
	int n;
	char[] ch;
	public Stack(int size){
		n = size;
		ch = new char[n];
	}
	public void push(char c){
		if(top>=n-1){
			System.out.println("Stack Overflow");
		}
		else{
			top = top+1;
			ch[top] = c;
		}
	}
	public boolean isEmpty(){
		return top==-1;
	}
	public char pop(){
		if(top<0){
			return ' ';
		}
		else{
			top = top-1;
			return ch[top+1];
		}
	}
}
