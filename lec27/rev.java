import java.util.ArrayList;
class rev{
   
    public static class edge{
        int v=0;
        int w=0;
        edge(int v,int w){
            this.v=v;
            this.w=w;
        }
    }
    public static ArrayList<ArrayList<edge>>graph=new ArrayList<>();
    public static void addedge(int u,int v,int w){
        if(u<0 || v<0 || u>=graph.size() || v>=graph.size())
        return;
        graph.get(u).add(new edge(v,w));
        graph.get(v).add(new edge(u,w));
    }
    public static void constructgraph(){
        for(int i=0;i<7;i++){
            graph.add(new ArrayList<>());
        }
        addedge(0,1,10);
        addedge(0,3,10);
        addedge(1,2,10);
        addedge(2,3,40);
        addedge(3,4,2);
        addedge(4,5,2);
        addedge(4,6,3);
        addedge(5,6,8);
        
    }
    public static void display(){
        for(int i=0;i<graph.size();i++){
            System.out.print(i+"-> ");
            for(int j=0;j<graph.get(i).size();j++){
               edge e=graph.get(i).get(j);
                System.out.print("("+e.v+","+e.w+")");
            }
            System.out.println();
        }
    }
    public static void removeedge(int u,int v){
        int i=0;
        while(i<graph.get(u).size()){
            edge e=graph.get(u).get(i);
            if(e.v==v)
            break;

            i++;
        }
        int j=0;
        while(j<graph.get(v).size()){
            edge e=graph.get(v).get(j);
            if(e.v==u)
            break;
            j++;
        }
        graph.get(u).remove(i);
        graph.get(v).remove(j);
    }
    public static void removevtx(int u){
        ArrayList<edge>list=graph.get(u);
        while(list.size()>0){
            edge e=list.get(list.size()-1);
            removeedge(u,e.v);
        }
    }


   public static void main(String []args){
        constructgraph();   
       // removeedge(3,4); 
       removevtx(3);
        display(); 
    }

}