#include<iostream>
#include<vector>
using namespace std;
int display(int n){
    if(n==0)
    return 1;
    
  int a=display(n-1);
     a*=n;
     return(a);
    
}
int max(vector<int>arr, int vidx){
    if(vidx==arr.size())
    return 0;
    cin>>arr[vidx];
    int m=max(arr,vidx+1);
    m=(m>arr[vidx])?m:arr[vidx];
    return m;
    
}
int pow(int n,int p){
    if(p==0)
    return 1;
    int a=pow(n,p-1);
    a=a*n;
    return a;
}
void display1(vector<int>arr,int vidx){
    if(vidx==arr.size())
    return;
    cin>>arr[vidx];
    display1(arr,vidx+1);
    cout<<arr[vidx];
}
int lar(vector<int>arr,int vidx){
    if(vidx==arr.size())
    return 0;
    int a=lar(arr,vidx+1);
    a=a>arr[vidx]?a:arr[vidx];
    return a;
}
bool find1(vector<int>arr,int n,int vidx){
if(vidx>=arr.size()){
return false;
}
if(arr[vidx]==n){
return true;
}
find1(arr,n,vidx+1);
}
int firstindex(vector<int>arr,int n, int vidx){
    if(vidx==arr.size())
    return -1;
if(arr[vidx]==n)
return vidx;
int a= firstindex(arr,n,vidx+1);
return a;
}
int lastindex(vector<int>arr,int n, int vidx){
    if(vidx==arr.size())
    return -1;
int a=lastindex(arr,n,vidx+1);
if(a!=-1)
return a;
else{
if(arr[vidx]==n)
return vidx;
else 
return -1;
}
}
void allindices(vector<int>arr,int n,int vidx){
    if(vidx==arr.size())
    return ;
    if(arr[vidx]==n)
    cout<<vidx;
    allindices(arr,n,vidx+1);
}
vector<int> alli(vector<int>arr,int n,int vidx,int cisf){
    if(vidx==arr.size())
    {
        vector<int>arr1(cisf,0);
        return arr1;
    }
    if(arr[vidx]==n){
    vector<int>res=alli(arr,n,vidx+1,cisf+1);
    res[cisf-1]=vidx;
    }
    else
        vector<int>res=alli(arr,n,vidx+1,cisf);
        return res;
}

int main(){
    int n,p;
   cin>>n;
    int cisf=0;
    //cin>>p;
    int vidx=0;
    vector<int>arr={2,8,6,6,6,7,5,4,7,7};
   // int a=display(n);
   // cout<<a;
  // int a=max(arr,vidx);
   //cout<<a;
  //int a= pow(n,p);
  //cout<<a;
 // display1(arr,vidx);
 //int a=lar(arr,vidx);
 //bool a=find1(arr,n,vidx);
 //cout<<a;
 int []a=alli(arr,n,vidx,cisf);
 for(int i=0;i<a.size();i++)
 cout<<a[i];
 
}