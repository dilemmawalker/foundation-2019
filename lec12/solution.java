import java.util.Scanner;
import java.util.ArrayList;
class practice{
    public static Scanner scn=new Scanner(System.in);
    public static String[] code = { ".", "abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz"};
    public static void main(String []args){
//String str="ab";
    //System.out.print(display(str));
//System.out.print(check(str));
//System.out.print(check1("179"));
int sr=0,sc=0,er=2,ec=2;
 boolean[][]isdone=new boolean [3][3];
System.out.print(floodfill(sr,sc,er,ec,isdone));
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