import java.util.Scanner;
import java.util.ArrayList;
public class practice{
    public static Scanner scn= new Scanner(System.in);
    static String[] key={"","abc","def","ghi","jkl","mno","pqr","st","uvwx","yz"};
    public static void main(String args[]){
     
        
    // ArrayList<String> arr=subse("abc");
    // System.out.print(arr);
     //   subsequence("abc","");
    //  ArrayList<String> arr=subse1("ab");
 //    System.out.print(arr);
    //  System.out.print(keypad("179"));
        maze(0,10,0,0);
    }
   public static  void subsequence(String str,String ans){
        if(str.length()==0){
            System.out.print(ans+" ");
            return ;
        }
        char ch=str.charAt(0);
        String ros=str.substring(1);
        subsequence(ros,ans);
        subsequence(ros,ans+ch);
     return ;
    }
    public static ArrayList<String> subse(String str){
        if(str.length()==0){
            ArrayList<String>arr=new ArrayList<>();
            arr.add("");
            return arr;
        }
        char ch=str.charAt(0);
        String ros=str.substring(1);
       ArrayList<String>ans=subse(ros);
        ArrayList<String>anss=new ArrayList<>();
        for(String ass:ans){
            anss.add(ass);
            anss.add(ch+ass);
        }
        return anss;
    }
    public static ArrayList<String> subse1(String str){
        if(str.length()==0){
            ArrayList<String>arr=new ArrayList<>();
            arr.add("");
            return arr;
        }
        char ch=str.charAt(0);
        String ros=str.substring(1);
       ArrayList<String>ans=subse1(ros);
        ArrayList<String>anss=new ArrayList<>();
        for(String ass:ans){
            anss.add(ass);
            anss.add(ch+ass);
            anss.add((int)ch+ass);
        }
        return anss;
    }
    public static ArrayList<String> keypad(String str){
        if(str.length()==0){
            ArrayList<String>new1=new ArrayList<>();
            new1.add("");
            return new1;
        }
        String ch=str.substring(0,1);
        String ros=str.substring(1);
        int a=Integer.parseInt(ch);
        String ar=key[a];
        ArrayList<String> arr=keypad(ros);
        ArrayList<String> ans=new ArrayList<>();
        for(String s:arr){
        for(int c=0;c<ar.length();c++){
            char chh=ar.charAt(c);
            ans.add(chh+s);
        }
    }
    return ans;
    }
    public static void maze(int start,int end,int ans,int anss){
        if(start==end){
            System.out.print(anss+" ");

            return;
        }
        if(start>end)
        return ;

        for(int i=1;i<=6;i++){
            anss=anss*10+i;
            maze(start+i,end,ans,anss);
            anss=(anss-i)/10;
         }
        return;
    }
}