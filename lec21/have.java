import java.util.Scanner;
import java.util.ArrayList;
public class have{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String args[]){
        
      /* int[] arr1={2,8,12,14,18,36};
       int[] arr2={4,6,12,17,29,64,94};
       int[] ans= merge_sort(arr1,arr2);
       for(int i=0;i<ans.length;i++){
           System.out.print(ans[i]+" ");*/
           int [] arr={0,1,1,2,0,0,1,0,1,2,0,1,0,1,2,1,0};
        int[]  arr1= sort012(arr);

           for(int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]+" ");

       }
    }
        
 public   static int[]  merge_sort(int arr1[],int arr2[]){
            int a=0;
           int b=0;
           int c=0;
           int arr[]= new int[arr1.length+arr2.length];
           while(a<arr1.length && b<arr2.length){
               if(arr1[a]<arr2[b] )
               {
                arr[c]=arr1[a];
                a++;
               }
               else {
                   arr[c]=arr2[b];
                   b++;
               }
               
               c++;
           }
         
            while(a<arr1.length){
                arr[c]=arr1[a];
                a++;
                c++;
            }
        
            while(b<arr2.length){
                arr[c]=arr2[b];
                b++;
                c++;
            }
          return arr;
        }
        public static void swap(int [] arr,int a,int b){
            arr[a]=arr[b];
            arr[b]=arr[a];
        }
 public static int[] sort01(int[]arr){
            int pt=0;
            int itr=0;
            while(itr<arr.length){
                if(arr[itr]==0){
                    swap(arr,pt,itr);
                    pt++;
                }
                itr++;
            }
            return arr;
        }
        public static int[]sort012(int [] arr){
            int p=0,p1=arr.length-1;
            int itr=0;
            while(itr<arr.length){
                if(arr[itr]==0){
                    swap(pt,itr);
                    pt++;
                    itr++;
                }
                else if(arr[itr]=2){
                    swap(arr,pt1,itr);
                    pt1--;
                    continue;

                }
                itr++;
            }
        }

 /*static void quicksort(int [] arr,int start,int end){
        if(){

        }
       int pivot=arr.length/2;
       int mid=arr[pivot];
        if(start>end){
            arr[start]=arr[end];
            arr[end]=arr[start];
            start++;
        }
        if(start<end && start<=mid){
            start++;
        }
        if(start>middle){
            00.

        }

        }*/
}