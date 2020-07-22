import java.util.ArrayList;
public class tre{

    public static class Node{
        int data=0;
        Node left=null;
        Node right=null;
        public Node(int data){
        this.data=data;
        }
        public Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    static int idx=0;
    public static Node createtree(int [] arr){
        if(idx==arr.length || arr[idx]==-1){
            idx++;
            return null;
        }
        Node node=new Node(arr[idx]);
        idx++;
        node.left=createtree(arr);
        node.right=createtree(arr);
        return node;

    }
    public static void display(Node node){
        if(node==null)
        return ;
        System.out.print(node.left!=null?node.left.data:".");
        System.out.print("->"+ node.data+"<-");
        System.out.println((node.right!=null?node.right.data:"."));
        display(node.left);
        display(node.right);
        

    }
   /* public static int maxx(Node node){
        if(node==null){
          return Integer.MIN_VALUE;
        }
      

        int a=maxx(node.left);
        int b=maxx(node.right);
        int m=node.data;
        if(a>m)
        m=a;
        if(node.right.data>m)
        m=node.right.data;
        return m;

    }*/
   public static  boolean find(Node node,int data){
        if(node==null){
            return false;
        }

        if(node.data==data)
        return true;

        boolean res=false;

       res=res|| find(node.left,data);
       res=res||find(node.right,data);
       return res;
   }
    public static ArrayList<Node>roottonodepath(Node node,int data){
    
        if(node==null){
            ArrayList<Node>base= new ArrayList<>();
            return base;
        }
        
        if(node.data==data){
            ArrayList<Node>base=new ArrayList<>();
            base.add(node);
        return base;
        }
          ArrayList<Node>left=roottonodepath(node.left,data);
       if(left.size()!=0){
           left.add(node);
           return left;
       }
      ArrayList<Node>right=roottonodepath(node.right,data);
       if(right.size()!=0){
           right.add(node);
           return right;
       }
       return new ArrayList<>();

    }
    public static int lca(Node node,int data1,int data2){
        ArrayList<Node>list1=roottonodepath(node,data1);
        ArrayList<Node>list2=roottonodepath(node,data2);
        int ans=-1;
        int i=list1.size()-1;
        int j=list2.size()-1;
        while(i>=0 && j>=0){
            if(list1.get(i)!=list2.get(j)){
                break;
            }
            ans=list1.get(i).data;
            i--;
            j--;
        }
        return ans;

    }
public static void kdown(Node node,Node pnode,int level){
    if(node==null)
    return;
    if(pnode!=null && node==pnode)
    return;

    if(level==0)
    System.out.print(node.data+" ");

    kdown(node.left,pnode,level-1);
    kdown(node.right,pnode,level-1);
}
public static void klevel(Node node, int k){
    ArrayList<Node>list1=roottonodepath(node,110);
    Node pnode=null;
    for(int i=0;i<list1.size();i++){
        kdown(node,pnode,k-i);
        pnode=list1.get(i);
    }
}
public static int kaway(Node node,int data,int k){
    if(node==null){
        return -1;
    }
    if(node.data==data){
        kdown(node,null,k);
        return 1;
    }
    int ld=kaway(node.left,data,k);
    if(ld!=-1){
        kdown(node,node.left,k-ld);
        return ld+1;
    }
    int rd=kaway(node.right,data,k);
    if(rd!=-1){
        kdown(node,node.right,k-rd);
        return rd+1;
    }
return -1;
}
public static int [] dia(Node node){
    if(node==null)
    return new int[]{0,-1};

    int[] ld=dia(node.left);
    int[] rd=dia(node.right);

    int[] ans=new int[2];
    ans[0]=Math.max(Math.max(ld[0],rd[0]),ld[1]+rd[1]+2);
    ans[1]=Math.max(ld[1],rd[1])+1;
    return ans;
}
static int maxsum1=0;
public static int nodetonodepath(Node node){
    if(node==null)
    return 0;
    int lmaxsum=nodetonodepath(node.left);
    int rmaxsum=nodetonodepath(node.right);

    int maxbranch=Math.max(lmaxsum,rmaxsum);

    maxsum1=Math.max(Math.max(maxsum1,node.data),maxbranch+node.data,lmaxsum+rmaxsum+node.data);
    return Math.max(maxbranch+node.data,node.data);
}



   public static void solve(){
        int arr[]={10,20,30,40,-1,-1,60,-1,70,-1,-1,80,90,100,120,-1,-1,120,-1,-1,110,-1,-1,140,-1,-1};
        Node root=createtree(arr);
       // display(root);
      // System.out.print(maxx(root));
     // System.out.print(find(root,60));
     //System.out.print(lca(root,30,50));
     //klevel(root,4);
    // kaway(root,120,3);
    //System.out.print(dia(root));
    nodetonodepath(root);

    }
    public static void main(String args[]){
        solve();
    }



}