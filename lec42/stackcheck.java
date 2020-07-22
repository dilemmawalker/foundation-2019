import java.util.Stack;
class stackcheck{
   public static  void checkmaxonright(int[]arr){
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(st.size()==0){
                st.push(arr[i]);
                continue;
            }
         while(st.size()>0 && st.peek()<arr[i]){
                System.out.println(st.pop()+"->"+arr[i]);
            }
            st.push(arr[i]);
        }
        while(st.size()!=0){
            System.out.println(st.pop()+"->"+"no element found");
        }
    }
    public static void checkmaxonleft(int[]arr){
        Stack<Integer>st=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            if(st.size()==0){
                st.push(arr[i]);
                continue;
            }
            while(st.size()>0 && st.peek()<arr[i]){
                System.out.println(st.pop()+"->"+arr[i]);
            }
            st.push(arr[i]);
        }
        while(st.size()!=0){
            System.out.println(st.pop()+"->"+"no element found");
        }
    }
    public static  void checkminonright(int[]arr){
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(st.size()==0){
                st.push(arr[i]);
                continue;
            }
         while(st.size()>0 && st.peek()>arr[i]){
                System.out.println(st.pop()+"->"+arr[i]);
            }
            st.push(arr[i]);
        }
        while(st.size()!=0){
            System.out.println(st.pop()+"->"+"no element found");
        }
    }
    public static void checkminonleft(int[]arr){
        Stack<Integer>st=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            if(st.size()==0){
                st.push(arr[i]);
                continue;
            }
            while(st.size()>0 && st.peek()>arr[i]){
                System.out.println(st.pop()+"->"+arr[i]);
            }
            st.push(arr[i]);
        }
        while(st.size()!=0){
            System.out.println(st.pop()+"->"+"no element found");
        }
    }

 public static void main(String []args){
        int[]arr={4,5,2,25};
//checkmaxonright(arr);
//checkmaxonleft(arr);
//checkminonright(arr);
checkminonleft(arr);
    }
}