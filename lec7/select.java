import java.util.Scanner;
public class select {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String args[]){
        int n,temp;
        n=scn.nextInt();
        int []arr=new int[n];
        for(int a=0;a<n;a++){
        arr[a]=scn.nextInt();
        }
        for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            if(arr[i]>arr[j])
            {
           temp=arr[i];
           arr[i]=arr[j];
           arr[j]=temp;
            }
            
        }
        }
        for(int k=0;k<n;k++){
            System.out.print(arr[k]);
        }
    }
}
    