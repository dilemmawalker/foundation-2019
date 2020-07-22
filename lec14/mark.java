import java.util.Scanner;
public class mark{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("enter no.");
int n=scn.nextInt();
patt(n);
    }
    public static int patt(int n){
    int nst,cst,nsp,csp,i,c=0,c1=0,i1;
    csp=n/2;
    cst=1;
    for(i=1;i<=n;i++){
        for(nsp=1;nsp<=csp;nsp++){
            System.out.print(" ");
        }c1=c;
        i1=1;
        for(nst=1;nst<=cst;nst++){
            
            if(i1<=((cst/2)+1))
            c1++;
            else 
            c1--;
            i1++;
            System.out.print(c1);
        }
        System.out.println();
        if(i<=n/2){
            csp--;
            cst+=2;
            c++;
        }
        else {
            csp++;
            cst-=2;
            c--;
        }
    }
    return 0;
    }
}