#include<iostream>
#include<vector>
using namespace std;
bool find(vector<int>& arr,int vidx,int data){
if(vidx>=arr.size()){
return false;
}
bool a=find(arr,++vidx,data);
if(a==true)
return true;
else{
  if(arr[vidx]==data)
  return true;
  else
  {
    return false;
  }
  
}
}
int main(){
    vector<int>arr={10,6,8,10,4,5,5,6,8,-3,2,12,8,3};
     int vidx=0;
    int data;
   cin>>data;
   bool a=find(arr,vidx,data);
 if(a==1)
 cout<<"true";
 else
   cout<<"false";
 }