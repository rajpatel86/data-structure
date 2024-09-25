
import java.util.Scanner;
public class Lab_6_33{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Swap sw = new Swap();
		System.out.print("Enter value of a : ");
		sw.a =  sc.nextInt();
		System.out.print("Enter value of b : ");
		sw.b = sc.nextInt();
		sw.swapNumber();
		System.out.println("After swapping : ");
		System.out.println("Value of a = "+sw.a);
		System.out.println("Value of b = "+sw.b);
	}
	
}
class Swap{
	int a,b;
	protected void swapNumber(){
		a = a+b;
		b = a-b;
		a = a-b;
	}
}
