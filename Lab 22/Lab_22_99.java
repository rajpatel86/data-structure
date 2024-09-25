
//Shell Sort
import java.util.Scanner;

public class Lab_22_99 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Entetr value of arr["+i+"] : ");
            arr[i] = sc.nextInt();
        }
        shellSort(arr,n);
        System.out.println("Sorted array in Shell Sort : ");
        for(int num:arr){
            System.out.print(num+" ");
        }

    }
    private static void shellSort(int[] arr,int n){
        for(int gap=n/2;gap>=1;gap/=2){
            for(int j=gap;j<n;j++){
                for(int i=j-gap;i>=0;i-=gap){
                    if(arr[i+gap]>arr[i]){
                        break;
                    }
                    else{
                        int temp = arr[i];
                        arr[i] = arr[i+gap];
                        arr[i+gap] = temp;
                    }
                }
            }
        }
    }
}
