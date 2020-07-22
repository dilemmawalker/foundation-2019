import java.util.Scanner;
public class pattern6{
public static Scanner scn= new Scanner(System.in);
public static void main(String args[]){
int n= scn.nextInt();
print(n);
}
public static int print(int n){
    int i,nst=1;
    for(i=0;i<n;i++){
        int val=1;
        for(int cst=0;cst<nst;cst++){
            System.out.print(val);
            val=(val*(i-cst))/(cst+1);
        }
        nst++;
System.out.println();
    }
    return 0;
}
}