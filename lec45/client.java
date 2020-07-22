public class client{   //client class is used to access when both class & file name are same.
    public static void main(String[]args){
        int[]arr={10,20,30,-2,-3,-4,5,6,7,8,9,22,11,13};
        heapnew pq=new heapnew(arr,true);
        // while(pq.size()!=0){
        //     System.out.print(pq.top()+" ");
        //     pq.pop();
        // }
        int s=pq.size()-1;
        while(s>=1){
            pq.swap(0,s);
            s--;
            pq.downheapify2(0,s);
          
        }
        pq.display();
    }
}