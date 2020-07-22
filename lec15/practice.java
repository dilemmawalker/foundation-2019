import java.util.Scanner;
public class practice{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String args[]){
        boardgame(0,10,"");
    }
    public static void boardgame(int start,int end,String ans){
        if(start ==end){
            System.out.println(ans);
            return;
        }
       
        for(int dice=1;dice<=6;dice++){
            if(start<=end)
            boardgame(start+dice,end,ans+dice);
            else return;
        }
    } 
}
