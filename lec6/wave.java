import java.util.Scanner;
public class wave{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String []args){
        int n,m;
        System.out.print("enter the no. of rows and columns");
        n=scn.nextInt();
        m=scn.nextInt();
        int [][]arr=new int[n][m];
        input(arr);
        display(arr);
    }
    public static void input(int [][]arr){
        for(int row=0;row<arr.length;row++){
            for(int col=0;col<arr[row].length;col++){
            arr[row][col]=scn.nextInt();
            
            }
            }
    }
    public static void display(int [][]arr){
        int dir=0,r=0,c=0;
        while(true){
            dir=(dir+arr[r][c])%4;
            if(dir==0){
                c++;
                if(c==arr[0].length){
                    System.out.print(r+", "+(c-1));
                    break;
                }
            }
            else if(dir ==1){
                r++;
                if(r==arr.length){
                    System.out.print((r-1)+", "+c);
                }

            }
            else if (dir==2){
                c--;

                if(c==-1){
                    System.out.print(r+ ","+(c+1));
                    break;
                }
            }
            else{
                r--;
                if(r==-1){
                    System.out.print((r+1) + ", "+c);
                    break;
                }

            }

        }
    }
}