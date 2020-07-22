import java.util.Scanner;
import java.util.ArrayList;
public class jj{
   
    public static void main(String args[]){
        System.out.print(permu1("abc"));
    }
    public static int permu1(String str){
        if(str.length()==0){
            return 1;
        }
        int c=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String ros=str.substring(0,i)+str.substring(i+1);
            c+=permu1(ros);
        }
        return c;
    }
}