import java.util.Scanner;
public class new1{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String []args){
        
        int vidx=0,c=0;
        int data=scn.nextInt();
        int [] arr={10,6,8,10,4,5,5,6,8,-3,2,12,8,3};
      display(arr,vidx,data,c);

    }
    public static int[] display(int[] arr,int vidx,int data,int c){
     if(vidx>=arr.length)
     {
     int [] basearray=new int[c];
     return basearray;  
     }
     if(arr[vidx]==data)
     c++;
     int []ans=display(arr,vidx+1,data,c);
     if(ans[vidx]==data)
     ans[vidx]=vidx;
    return ans;
    }
}