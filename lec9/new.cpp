#include<iostream>
#include<vector>
using namespace std;
bool find(vector<int>& arr,int vidx,int data){
    if(vidx>=arr.size()){
        return false;
    }
if(arr[vidx]==data){
     return true;
}
    find(arr,++vidx,data);
}
/*int maximum(vector<int>arr,int vidx){
    if(vidx>=arr.size())
    return 0;
    if(arr[vidx]>max)
    int max=arr[vidx];
   int max= maximum(arr,vidx++);
}
*/
int main(){
vector<int>arr={10,6,8,10,4,5,5,6,8,-3,2,12,8,3};
int vidx=0;
int data;
cin>>data;
bool a=find(arr,vidx,data);
cout<<a;
//maximum(vidx+1);
}

