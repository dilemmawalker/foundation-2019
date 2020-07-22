import java.util.ArrayList;

 class heapnew{
    private ArrayList<Integer> arr;
    private boolean ismax;
    
    //  heapnew(){
    //     this.arr=new ArrayList<>();
    //     this.ismax=true;
    // }
    public void createheap(int[]ar){
        this.arr=new ArrayList<>();
        for(int ele:ar)
        this.arr.add(ele);

        for(int i=arr.size()-1;i>=0;i--){
            downheapify(i);
        }

    }
        public heapnew(int[]ar){   //heap creation from array 0(n)
            createheap(ar);
        }
        public heapnew(int[]ar,boolean ismax){     //heap creation from array 0(n)
            this.ismax=ismax;
            createheap(ar);
        }
        public int size(){
            return arr.size();
        }
        public  void downheapify2(int idx,int s){   //log n
 
            int maxidx=idx;
       int lci=idx*2+1;
       int rci=idx*2+2;
          if(lci<=s && compareto(lci,maxidx))
          maxidx=lci;
          if(rci<=s && compareto(rci,maxidx))
          maxidx=rci;
            if(maxidx!=idx){
               swap(maxidx,idx);     
            downheapify2(maxidx,s);
            }
        }
   
  public  void downheapify(int idx){   //log n
 
            int maxidx=idx;
       int lci=idx*2+1;
       int rci=idx*2+2;
          if(lci<arr.size() && compareto(lci,maxidx))
          maxidx=lci;
          if(rci<arr.size() && compareto(rci,maxidx))
          maxidx=rci;
            if(maxidx!=idx){
               swap(maxidx,idx);     
            downheapify(maxidx);
            }
        }
        public   void display(){
            
            for(int i=0;i<arr.size();i++)
            System.out.println(arr.get(i)+" ");
            
        }
        public   void  swap(int i,int j){
            
                int val1=arr.get(i);
                int val2=arr.get(j);
                arr.set(i,val2);
                arr.set(j,val1);
            }
            public   void upheapify(int cidx){  //log n
                int pidx=(cidx-1)/2;
                if(compareto(cidx,pidx)){
                    swap(pidx,cidx);
                    upheapify(pidx);
                }
            }
            public  void push(int a){
                arr.add(a);
                int idx=arr.size()-1;
                upheapify(idx);
            }
            public  void pop(){
                swap(0,arr.size()-1);
                arr.remove(arr.size()-1);
                downheapify(0);
            }
            public  int top(){
                return arr.get(0);
            }
            public  void update(int idx,int val){
                arr.set(idx,val);
                downheapify(idx);
                upheapify(idx);
            }
            public  boolean compareto(int i,int j){  //i is child & j is parent
               
                if(ismax){
                    if(arr.get(i)-arr.get(j)>0)
                
                    return true;
                }
                else{
                    if(arr.get(j)-arr.get(i)>0)
                    
                    return true;
                }
                return false;
            }
}