#include<iostream>
#include<vector>
using namespace std;
void display(vector<int> & arr){
    int a=arr[0];int b=arr[0];
for(int i:arr){
   if(i >a)
   a=i; 
   if(i<b)
   b=i;
}cout<<"max is "<<a<<endl;
cout<<"min is "<<b;
}
void input(vector<int>& arr){
    for(int i=0;i<arr.size();i++){
        cin>>arr[i];
    }
}


int  main(){
vector<int>arr(5,0);
input(arr);
display(arr);
return 0;
}