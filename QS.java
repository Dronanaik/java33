package hardik;

import java.util.Scanner;
public class QS{
    public int partition(int[] arr,int low,int high){
        int i = low+1;
        int j = high;
        int key= arr[low];
        while(true){
            while(i<high && arr[i]<=key)
                i++;
            while(i>=low&& arr[j]>key)
                j--;
            if(i<j){
                int temp =arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
            else{
                int temp =arr[low];
                arr[low] =arr[j];
                arr[j]=temp;
                return j;
            }  
        }
    }
    public void qsort(int[] arr,int low,int high){
        if(low<high){
            int j =partition(arr, low, high);
            qsort(arr,low,j-1);
            qsort(arr,j+1,high);
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter the number of elements");
        int n=scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("enter the elements");
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        QS qs = new QS();
        long startTime = System.currentTimeMillis();
        qs.qsort(arr, 0, n-1);
        long endTime =System.currentTimeMillis();
        System.out.println("sorted elements are :");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println("time taken="+(endTime-startTime)+"milliseconds");
        scanner.close();
    }
}