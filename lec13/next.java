import java.util.Scanner;
import java.util.ArrayList;
class next{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String []args){
          String [] arr={" ","abc","def","ghi","jkl","mno","pqrs","tuw","xyz"};
         String str="247";
      System.out.print(keypad(arr,str));

    }
   public static  ArrayList<String> keypad(String [] arr,String str){
      if(str.length()==0){
          ArrayList<String> arr1=new ArrayList<>();
          arr1.add(" ");
          return arr1;
      }
      char ch=str.charAt(0);
      String ros=str.substring(1);
    ArrayList<String> ans=keypad(arr,ros);
    ArrayList<String> myans=new ArrayList<>();
    String ans1=arr[ch-'0'];
      for(String s:ans){
           for(int i=0;i<ans1.length();i++){
              char f=ans1.charAt(i);
              myans.add(f+s);
          }
      }
      return myans;

    }
}