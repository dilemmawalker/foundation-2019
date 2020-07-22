public class stack{
    int[] st;
    int tos=-1;
     stack(){
this.st=new int[10];
}
stack(int size){
this.st=new int[size];
}
stack(int[]arr){
    this.st=new int[2*arr.length];
    for(int i=0;i<arr.length;i++){
       this. st[i]=arr[i];
    }
    this.tos=arr.length-1;
}

public void push(int data){
    if(tos==st.length-1){
        System.out.print("stackoverflow:"+tos);
        return ;
    }
    st[++tos]=data;
}
public int top(){
if(tos==-1){
    System.out.print("stackisempty");
    return -1;
}
return st[tos];
}
public int pop(){
    if(tos==-1){
        System.out.print("stackisempty");
        return -1;
    }
    return st[tos--];
}
public int size(){
    return tos;
}
public boolean isempty(){
    if(tos==-1)
    return false;
    else
    return true;
}

}