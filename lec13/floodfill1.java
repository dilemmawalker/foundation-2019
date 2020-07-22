import java.util.Scanner;
import java.util.ArrayList;
class floodfill1{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String []args){
//System.out.print(knightpath(0,0,3,3,new boolean[4][4]));
System.out.print(knightpath1(0,0,0,64,new boolean[8][8],new int[8][8]));
    }

    public static boolean isvalid(int x,int y,boolean[][]isdone){
    if(x>=0&&y>=0&&x<isdone.length&&y<isdone[0].length&&!isdone[x][y])
        return true;

        return false;
    }
    public static int knightpath(int sr,int sc,int er,int ec,boolean[][] isdone){
        if(sr==er && sc==ec){
            return 1;
        }
    
    int [][] dir={{2,1},{2,-1},{1,2},{1,-2},{-2,1},{-2,-1},{-1,2},{-1,-2}};
    
    int count=0;
    isdone[sr][sc]=true;
    for(int d=0;d<dir.length;d++){
        int x=sr+dir[d][0];
        int y=sc+dir[d][1];
        if(isvalid(x,y,isdone)){
           count+=knightpath(x,y,er,ec,isdone);
            }
        }
        isdone[sr][sc]=false;
        return count;
    }
    public static boolean knightpath1(int sr,int sc,int count,int boxsize,boolean[][] isdone,int [][] ans){
        isdone[sr][sc]=true;
    ans[sr][sc]=count;
        if(count==boxsize-1){
           for(int[] ar:ans){
               for(int ele:ar){
                   System.out.print(ele+" ");
               }
    System.out.println();
           }
           return true;
        }
    
    int [][] dir={{2,1},{2,-1},{1,2},{1,-2},{-2,1},{-2,-1},{-1,2},{-1,-2}};

    boolean res=false;

    for(int d=0;d<dir.length && !res;d++){
        int x=sr+dir[d][0];
        int y=sc+dir[d][1];
        if(isvalid(x,y,isdone)){
           res=res || knightpath1(x,y,count+1,boxsize,isdone,ans);
            }
        }
        isdone[sr][sc]=false;
        ans[sr][sc]=0;
        return res;
    }

}
