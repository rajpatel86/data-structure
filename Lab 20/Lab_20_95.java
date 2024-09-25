
import java.util.Scanner;
public class Lab_20_95{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total number of elements : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter value of arr["+i+"] : ");
            arr[i] = sc.nextInt();
        }
        radixSort(arr,n);
        System.out.println("Sorted array : ");
        for(int output:arr){
            System.out.println(output);
        }

    }
    private static void radixSort(int[] arr,int n){
        int m=getMax(arr,n);
        for(int place=1;m/place>0;place*=10){
            countingSort(arr,n,place);
        }
    }
    private static void countingSort(int[] arr,int n,int place){
        int[] output = new int[n];
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            count[(arr[i]/place)%10]++;
        }
        for(int i=1;i<10;i++){
            count[i] += count[i-1];
        }
        for(int i=n-1;i>=0;i--){
            output[count[(arr[i]/place)%10]-1] = arr[i];
            count[(arr[i]/place)%10]--;
        }
        for(int i=0;i<n;i++){
            arr[i] = output[i];
        }
    }
    private static int getMax(int[] arr,int n){
        int max=arr[0];
        for(int i=1;i<n;i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}