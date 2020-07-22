import java.util.LinkedList;
import java.util.ArrayList;
public class hashmap{
    public class Node{
        Integer key;
        Integer value;
        public Node(Integer key,Integer value){
            
            this.key=key;
            this.value=value;

        }
        @Override
        public String toString(){
            return this.key+"="+this.value;
        }
    }
    hashmap(){
       reassign();
    }
    public void reassign(){
        for(int i=0;i<buckets.length;i++){
            buckets[i]=new LinkedList<>();
         }
         this.size=0;
    }
    private int size=0;
    private LinkedList<Node>[] buckets=new LinkedList[10];

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("{");

        for(int i=0;i<buckets.length;i++){
            if(buckets[i].size()>0){
                LinkedList<Node>group=buckets[i];
                int size=group.size();

                while(size-->0){
                    Node tempNode=group.getFirst();
                    sb.append(tempNode+",");
                    group.addLast(group.removeFirst());
                }
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        return sb.toString();
    }
    public void rehash(){
        System.out.println("rehash");
        LinkedList<Node>oldbuckets[]=buckets;
        buckets=new LinkedList[oldbuckets.length*2];
        reassign();

        for(int i=0;i<oldbuckets.length;i++){
           if( oldbuckets[i].size()>0){
               LinkedList<Node>group=oldbuckets[i];
               int size=group.size();

               while(size-->0){
                   Node tNode=group.removeFirst();
                   put(tNode.key,tNode.value);
               }
           }
        }
    }
//    public void put(Integer key,Integer value){
//         for(int i=0;i<buckets.length;i++){
//             buckets[i]=new LinkedList<>();
//         }
//     }

public int get(Integer key){
    int code=mygroup(key);
    LinkedList<Node>group=buckets[code];
    Node rn=foundingroup(group,key);
    return rn==null?null:rn.value;
}
public void remove(Integer key){
int code=mygroup(key);
LinkedList<Node>group=buckets[code];
Node rn=foundingroup(group,key);
if(rn!=null){
    this.size--;
     group.removeFirst();
}
else{
System.out.print("element not found");
return ;
}
}
public void put(Integer key,Integer val){
    int code=mygroup(key);
    LinkedList<Node>group=buckets[code];
    Node rn=foundingroup(group,key);
    if(rn!=null){
        rn.value=val;
    }
    else{
        group.addLast(new Node(key,val));
        this.size++;

        double lambda =(group.size()*1.0)/buckets.length;
        if(lambda>=0.3)
        rehash();
    }
}

public boolean containsKey(Integer key){
int code=mygroup(key);
LinkedList<Node> group=buckets[code];
Node rn=foundingroup(group,key);
return rn==null?false:true;
}
public int size(){
    return this.size;
}
public boolean isempty(){
    return this.size==0;
}
public ArrayList<Integer>keySet(){

ArrayList<Integer>arr=new ArrayList<>();

for(int i=0;i<buckets.length;i++){
    if(buckets[i].size()>0){
    LinkedList<Node> group =buckets[i];
   for(int j=0;j<group.size();j++){
    Node rn=group.getFirst();
    arr.add(rn.key);
    group.addLast(group.removeFirst());
     }
   }
 }
 return arr;
}
public Integer getOrDefault(int key,int defaul){
    int code=mygroup(key);
    LinkedList<Node> group=buckets[code];
    Node rn=foundingroup(group,key);
    return rn!=null?rn.value: defaul;
}


public Node foundingroup(LinkedList<Node>group,Integer key){
if(group==null)
return null;
int size=group.size();
Node rn=null;
while(size-->0){
    Node tempNode=group.getFirst();
    if(tempNode.key==key){
        rn=tempNode;
        break;
    }
    group.addLast(group.removeFirst());
}
return rn;
}

public int mygroup(Integer key){
        
        return myhashcode(key)%buckets.length;
    }
    public int myhashcode(Integer key){
        Integer code=key.hashCode();
        return Math.abs(code);
    }
}