
import java.util.Scanner;

public class Lab_7_39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        sc.close();
        Stack stack = new Stack(s.length());
        int mid = stack.n / 2;

        for (int i = 0; i < mid; i++) {
            stack.push(s.charAt(i));
        }

        int start = (stack.n % 2 == 0) ? mid : mid + 1;

        for (int i = start; i < stack.n; i++) {
            if (stack.isEmpty() || s.charAt(i) != stack.pop()) {
                System.out.println("Invalid String");
                return;
            }
        }

        if(stack.isEmpty()){
            System.out.println("Valid String");
        }
        else{
            System.out.println("Invalid String");
        }
    }
}
class Stack{
    int n;
    char[] c;
    int top=-1;
    public Stack(int size){
        n = size;
        c = new char[n];
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
            return c[top+1];
        }
    }
    public void push(char ch){
        if(top>=n-1){
            System.out.println("Stack Overflow");
        }
        else{
            top = top+1;
            c[top] = ch;
        }
    }
}
