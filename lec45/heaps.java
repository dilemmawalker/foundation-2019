import java.util.ArrayList;

 class heaps{
    private ArrayList<Integer> arr;
    
     heaps(){
        this.arr=new ArrayList<>();
    }
    public static void main(String[]args){
        heaps obj=new heaps();
        
         obj.arr.add(0);
         obj.arr.add(0);
         obj.arr.add(1);
         obj.arr.add(2);
         obj.arr.add(2);
        obj.arr.add(3);
        obj.arr.add(7);
        obj.arr.add(8);
        obj.arr.add(6);
        obj.arr.add(12);
        obj.arr.add(4);
        obj.arr.add(5);
        obj.arr.add(9);
        obj.arr.add(10);
        obj.arr.add(20);
        
            //  downheapify(0,obj);
            //  upheapify(0,obj);
            //  downheapify(5,obj);
            //  upheapify(5,obj);

             //display(obj);  
            heapsort(obj);
                   
     }
   public static void heapsort(heaps obj){
    
   for(int i=0;i<=obj.arr.size()-1;i++){  //gives max heap 

      // downheapify(i,obj);        
      upheapify(i,obj);
   }
   int s=obj.arr.size()-1;
   while(s>0){
    swap(0,s,obj);
    s--;
    downheapify2(0,obj,s);
    // display(obj);
    // upheapify(0,obj);
   }
   display(obj);

    }
    public static  void downheapify2(int idx,heaps obj,int s){   //log n
 
        int maxidx=idx;
   int lci=idx*2+1;
   int rci=idx*2+2;
   
      if(lci<=s && obj.arr.get(lci)>=obj.arr.get(maxidx))
      maxidx=lci;
      if(rci<=s && obj.arr.get(rci)>=obj.arr.get(maxidx))
      maxidx=rci;
        if(maxidx!=idx){
           swap(maxidx,idx,obj);     
        downheapify2(maxidx,obj,s);
        }
    }
  public static  void downheapify(int idx,heaps obj){   //log n
 
            int maxidx=idx;
       int lci=idx*2+1;
       int rci=idx*2+2;
          if(lci<obj.arr.size() && obj.arr.get(lci)>=obj.arr.get(maxidx))
          maxidx=lci;
          if(rci<obj.arr.size() && obj.arr.get(rci)>=obj.arr.get(maxidx))
          maxidx=rci;
            if(maxidx!=idx){
               swap(maxidx,idx,obj);     
            downheapify(maxidx,obj);
            }
        }
        public static  void display(heaps obj){
            
            for(int i=0;i<obj.arr.size();i++)
            System.out.println(obj.arr.get(i)+" ");
            
        }
        public static  void  swap(int i,int j,heaps obj){
            
                int val1=obj.arr.get(i);
                int val2=obj.arr.get(j);
                obj.arr.set(i,val2);
                obj.arr.set(j,val1);
            }
            public static  void upheapify(int cidx,heaps obj){  //log n
                int pidx=(cidx-1)/2;
                if(obj.arr.get(pidx)<obj.arr.get(cidx)){
                    swap(pidx,cidx,obj);
                    upheapify(pidx,obj);
                }
            }
            public static void push(int a,heaps obj){
                obj.arr.add(a);
                int idx=obj.arr.size()-1;
                upheapify(idx,obj);
            }
            public static void pop(int a,heaps obj){
                swap(0,obj.arr.size()-1,obj);
                obj.arr.remove(obj.arr.size()-1);
                downheapify(0,obj);
            }
            public static int top(heaps obj){
                return obj.arr.get(0);
            }
            public static void update(int idx,int val,heaps obj){
                obj.arr.set(idx,val);
                downheapify(idx,obj);
                upheapify(idx,obj);
            }


 
}