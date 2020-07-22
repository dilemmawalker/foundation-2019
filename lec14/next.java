import java.util.Scanner;
import java.util.ArrayList;
class next{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String []args){
       // System.out.print(display("abc"));
       System.out.print(number("123"));
    }
    public static ArrayList<String> display(String str){
        // if(str.length()==0) return new ArrayList<>();
        if(str.length()==1){
            ArrayList<String> arr1=new ArrayList<>();
            arr1.add(str);
            return arr1;
        }
        char ch=str.charAt(0);
        String ros=str.substring(1);

      ArrayList<String>arr=new ArrayList<>();
        ArrayList<String> str2= display(ros);
        for(String s:str2){
        for(int i=0;i<=s.length();i++){
            String s1=s.substring(0,i);
            String s2=s.substring(i);
            arr.add(s1+ch+s2);
    }
        }
return arr;
    }
    public static ArrayList<String> number(String str){
        // if(str.length()==0) return new ArrayList<>();
        if(str.length()==0){
            ArrayList<String> arr1=new ArrayList<>();
            arr1.add("");
            return arr1;
        }
        ArrayList<String>myans=new ArrayList<>();
        char ch=str.charAt(0);
        if(ch=='0'){
            return number(str.substring(1));
        }
        else{
            ArrayList<String> recans=number(str.substring(1));
            for(String s:recans){
            char ch1=(char)('a'+ch-'1');
            myans.add(ch1+s);
        }
    }

        if(str.length()>1){
            char ch2=str.charAt(1);
             int num =(ch-'0')*10+(ch2-'0');
            //int num =Integer.parseInt(str.substring(0,2));
            if(num<27){
                ArrayList<String> recans=number(str.substring(2));
                for(String s:recans){
                    char ch1=(char)('a'+num-1);
                    myans.add(ch1+s);
                }
            }
        }
       
return myans;
    }
    public static boolean isvalidsudoku(int[][]board,int i,int j,int num){
        //row
        for(int idx=0;idx<board.length;idx++){
            if(board[idx][j]==num)
            return false;
            //col
            if(board[i][idx]==num){
                return false;
            }
        }
        //mat
        int r=(i*3)/3;
        int c=(j/3)*3;
        for(int row=0;row<3;row++){
            for(int col=0;col<3;col++){
                if(board[r+row][c+col]==num)
                return false;

            }
        }
        return true;
    }
    public static sudoku()
}