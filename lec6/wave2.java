import java.util.Scanner;
public class wave2{
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
        int rmin=0,cmin=0,rmax=arr.length-1,cmax=arr[0].length-1;
        int tne=arr.length*arr[0].length;
        while(tne>0){
            for(int i=cmin;i<=cmax && tne>0;i++){
            System.out.print(arr[rmin][i]+" ");
            tne--;
            }
            rmin++;
            for(int i=rmin;i<=rmax && tne>0;i++){
                System.out.print(arr[i][cmax]+" ");
                tne--;
            }
        cmax--;
        for(int i=cmax;i>=cmin && tne>0;i--){
         System.out.print(arr[rmax][i]+ " ");
         tne--;
        }
        rmax--;
        for(int i=rmax;i>=rmin & tne>0;i--){
            System.out.print(arr[i][cmin]+" ");
            tne--;
        }
        cmin--;
        }
        }
    }