import java.util.Scanner;
import java.util.ArrayList;
public class practice{
    public static Scanner scn=new Scanner(System.in);
    public static String[] code = { ".", "abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz"};
    public static void main(String []args){
//String str="ab";
    //System.out.print(display(str));
//System.out.print(check(str));
//System.out.print(check1("179"));
int sr=0,sc=0,er=3,ec=3;
 boolean[][]isdone=new boolean [4][4];
System.out.print(floodfill(sr,sc,er,ec,isdone));
    }
    
    public static ArrayList<String> display(String str){
        if(str.length()==0){
            ArrayList<String>arr=new ArrayList<String>();
            arr.add("");
            return arr;
        }
        ArrayList<String>arr2=new ArrayList<String>();
        char ch=str.charAt(0);
        String str1=str.substring(1);
        ArrayList<String>arr1=display(str1);
        for(String s:arr1){
            arr2.add(s);
            arr2.add(ch+s);
        }
        return arr2;
    }
    public static ArrayList<String> check(String str){
        if(str.length()==0){
            ArrayList<String> arr=new ArrayList<String>();
            arr.add("");
            return arr;
        }
        ArrayList<String> arr2=new ArrayList<String>();
        char ch=str.charAt(0);
        String str1=str.substring(1);
        ArrayList<String>arr1=check(str1);
        for(String s:arr1){
            arr2.add(s);
            arr2.add(ch+s);
            arr2.add((int)ch+s);
        }
        return arr2;
    }  
      public static ArrayList<String> check1(String str){
        if(str.length()==0){
            ArrayList<String> arr=new ArrayList<String>();
            arr.add("");
            return arr;
        }
        ArrayList<String> arr2=new ArrayList<String>();
        char ch=str.charAt(0);
        String str1=str.substring(1);
        ArrayList<String>arr1=check1(str1);

        for(String s:arr1){
           String str4=code[ch-'0'];
        for(int i=0;i<str4.length();i++){
            char c=str4.charAt(i);
            arr2.add(c+s);
        }
    }
        return arr2;
    }
    public static ArrayList<String> floodfill(int sr,int sc,int er,int ec,boolean[][] isdone){
        if(sr==er&&sc==ec){
            ArrayList<String>arr=new ArrayList<>();
            arr.add(" ");
            return arr;
        }
        isdone[sr][sc]=true;
        ArrayList<String> ans=new ArrayList<>();
        if(sc+1<=ec && !isdone[sr][sc+1]){
            ArrayList<String> right=floodfill(sr,sc+1,er,ec,isdone);
            for(String s:right){
            ans.add("r"+s);
            }
        }
        if(sc-1>=0 && !isdone[sr][sc-1]){
            ArrayList<String> left=floodfill(sr,sc-1,er,ec,isdone);
            for(String s:left){
            ans.add("l"+s);
            }
        }
        if(sr-1>=0 && !isdone[sr-1][sc]){
            ArrayList<String> up=floodfill(sr-1,sc,er,ec,isdone);
            for(String s:up){
            ans.add("u"+s);
            }
        }
        if(sr+1<=er && !isdone[sr+1][sc]){
            ArrayList<String> down=floodfill(sr+1,sc,er,ec,isdone);
            for(String s:down){
            ans.add("d"+s);
            } 
        }
        isdone[sr][sc]=false;
        return ans;
        }
     }