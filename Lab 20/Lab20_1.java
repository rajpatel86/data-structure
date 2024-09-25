
import java.util.Scanner;

public class Lab20_1{

    public static void selectionSort(int[] a, int n){        
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if (a[j]<a[i]) {
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
            
        }

        for(int i=0;i<n;i++){
            System.out.println("a["+i+"] = "+ a[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Size :");
        int n=sc.nextInt();
        int []a=new int[n];

        for(int i=0;i<n;i++){
            System.out.println("Enter element in a["+i+"]");
            a[i]=sc.nextInt();
        }

        selectionSort(a,n);
    }
}
