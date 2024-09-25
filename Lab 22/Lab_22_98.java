
//Heap Sort
import java.util.Scanner;

public class Lab_22_98 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter value of arr["+i+"]");
            arr[i] = sc.nextInt();
        }
        heapSort(arr,n);
        System.out.println("Sorted array is:");
        for(int num:arr){
            System.out.print(num+" ");
        }
    }
    private static void heapSort(int[] arr,int n){
        buildMaxHeap(arr,n);
        for(int i=n-1;i>=0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,i,0);
        }
    }
    private static void buildMaxHeap(int[] arr,int n){
        for(int i=n/2-1;i>=0;i--){
            heapify(arr,n,i);
        }
    }
    private static void heapify(int[] arr,int n,int i){
        int maxIndex=i;
        int leftChild=2*i+1;
        int rightChild=2*i+2;
        if(leftChild<n && arr[leftChild]>arr[maxIndex]){
            maxIndex=leftChild;
        }
        if(rightChild<n && arr[rightChild]>arr[maxIndex]){
            maxIndex = rightChild;
        }
        if(i!=maxIndex){
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
            heapify(arr,n,maxIndex);
        }
    }
}
