import java.util.Scanner;
public class practice{
    public static Scanner scn= new Scanner(System.in);
    public static void main(String args[]){
       
      
    System.out.print( dice1(0,15,""));
    }
    static int arr[]={0,0,0,17,0,0,0,11,0,0,0,0,0,0,0,0,0,0,0,0,0};
    static int [] snake={0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,2,0};
    public static int dice1(int start, int end,String ans){
        if(start==end){
            System.out.print(ans+"  ");
            return 1;
        }
        int count=0;
        if(start==0){
           count+= dice1(start+1,end,ans+1);
          count+=  dice1(start+1,end,ans+6);
        }
        else if(arr[start]>0)
        dice1(arr[start],end,ans);
        else if(snake[start]>0){
            dice1(snake[start],end,ans);
        }
        else{
        for(int i=1;i<=6;i++){
            if(start+i<=end && start!=0){
              count+=  dice1(start+i,end,ans+i);
            }
        }
    }
        return count;
    }
}