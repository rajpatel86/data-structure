
import java.util.Scanner;

public class Lab_7_41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total number of test cases: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextLine();
        }
        sc.close();
        
        for (int i = 0; i < n; i++) {
            if (isBalanced(s[i])) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }

    public static boolean isBalanced(String s) {
        Stack st = new Stack(s.length());
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!st.isEmpty()) {
                char last = st.peek();
                if (isPair(last, cur)) {
                    st.pop();
                    continue;
                }
            }
            st.push(cur);
        }
        return st.isEmpty();
    }

    public static boolean isPair(char last, char cur) {
        return (last == '(' && cur == ')') || 
               (last == '{' && cur == '}') || 
               (last == '[' && cur == ']');
    }
}

class Stack {
    char[] ch;
    int n;
    int top = -1;
    
    public Stack(int size) {
        n = size;
        ch = new char[n];
    }
    
    public void push(char c) {
        if (top >= n - 1) {
            System.out.println("Stack Overflow");
        } else {
            ch[++top] = c;
        }
    }
    
    public char pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return ' ';
        } else {
            return ch[top--];
        }
    }
    
    public char peek() {
        if (top < 0) {
            return ' ';
        } else {
            return ch[top];
        }
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
}
