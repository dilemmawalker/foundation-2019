import java.util.ArrayList;
public class bst{

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

public static Node bstcreate(int []arr,int si,int ei){
    if(si>ei)
    return null;
    int mid=si+(ei-si)/2;
    Node node=new Node(arr[mid]);
    node.left=bstcreate(arr,si,mid-1);
    node.right=bstcreate(arr,mid+1,ei);
    return node;
}
public static void bst1(){
    int []arr=new int[10];
    for(int i=0;i<10;i++){
        arr[i]=(i+1)*10;
    }
    Node root=bstcreate(arr,0,arr.length-1);
    //System.out.println(find(root,80));
   // display(root);
   Node a=adddata(root,51);
   display(a);

}
public static boolean find(Node node,int data){
    while(node!=null){
        if(node.data==data)
        return true;
        else if(data<node.data)
         node=node.left;
        else
        node= node.right;
    }
    return false;

}
public static Node adddata(Node node,int data){
    if(node==null)
    return new Node(data);

    if(data<node.data)
    node.left=adddata(node.left,data);
    else
    node.right=adddata(node.right,data);

    return node;

}
public static int maxintree(Node root){
    if(root==null)
    return INTEGER.MAX_VALUE;
    Node lnode=root;
    while(lnode.right!=null){
        lnode=lnode.right;
    }
    return lnode.data;
}
public static Node removenode(Node node,int data){
    if(node==null)
    return null;

    if(node.data==data){
        if(node.left==null || node.right==null){
            return node.left==null?node.right:node.left;
        }
        int maxdata=maxintree(node.left);
        node.data=maxdata;
    }
    else if(data<node.data)
    node.left=removenode(node.left,data);
    else 
    removenode(node.right,data);
}


public static void main(String[]args){
    bst1();
    removenode(root,50);
    display(); 
   
    
}
}