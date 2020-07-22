#include<iostream>
using namespace std;
void inc(int st,int end){
if(st==end+1)
return;
cout<<st<<" ";
inc(st+1,end);
}
void dec(int st,int end){
if(st==end+1)
return;
dec(st+1,end);
cout<<st<<" ";
}
int dec_returntype(int st,int end){
    if(st==end+1)
    return st-1;

int head=dec_returntype(st+1,end);
cout<<head<<" ";
return head-1;
}
int fact(int n){
if(n<=1)
return 1;
int val=fact(n-1);
return val*n;
}
int powr(int n,int po){
    if(po<=0)
    return 1;
    int val=powr(n,po-1);
   
    return val*n ;
}
int power(int n,int po){
    if(po<=0)
    return 1; 
    int val=power(n,po/2);
     if(po%2!=0){
        
        return val*val*n;
    }
    else{
       
        return val*val;
    }
    
}

int main(){
    int st,end,n,po;
   // cin>>st>>end;
  //  inc(st,end);
  //  dec(st,end);
  // dec_returntype(st,end);
  //cout<<(fact(end));
  cin>>n>>po;
  cout<<(power(n,po));
}