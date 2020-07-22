import java.util.Scanner;
import java.util.*;
class test{
   public static Scanner scn=new Scanner(System.in);
    public static void main(String[]args){
        PriorityQueue<Integer>pq=new PriorityQueue<>();
    
        int t=scn.nextInt();
        for(int i=1;i<=t;i++){
        int n=scn.nextInt();
        int b=scn.nextInt();
        for(int j=1;j<=n;j++){
            int a=scn.nextInt();
			pq.add(a);
		}
		int b1=b;
        int c=0;
        while(b1>0 && pq.size()>0){
			b1=b1-pq.peek();
			if(b1>0)
			c++;
			pq.remove();
        }
		System.out.println("Case #"+i+": "+c); 
		while(pq.size()>0)
		pq.remove();
        
    }
}
}