import java.util.Scanner;
import java.util.PriorityQueue;
class practice{
  public static  Scanner scn=new Scanner(System.in);
    public static void main(String[]args){
        PriorityQueue<Integer>pq=new PriorityQueue<Integer>();
      
        int t=scn.nextInt();
        for(int i=1;i<=t;i++){
         
        int n=scn.nextInt();
        int b=scn.nextInt();
        int[]arr=new int[n];
        for(int j=0;j<n;j++){
        arr[j]=scn.nextInt();
            pq.add(arr[j]);
        }
        int c=0;
        while(b>=0 && pq.size()>0){
			b=b-pq.peek();
			if(b>=0)
			c++;
			pq.remove();
        }
        int y=c;
        int x=i;
		System.out.println("Case #"+x+": "+y); 
		while(pq.size()>0)
		pq.remove();
     }
    }
}
