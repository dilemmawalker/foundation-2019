#include<iostream>
#include<vector>
using namespace std;
int display(vector<vector<int>>& arr1, vector<vector<int>>& arr2){
for(int row=0;row<arr1.size();row++){
    for(int col=0;col<arr1[row].size();col++){
    arr1[row][col]+=arr2[row][col];
    cout<<arr1[row][col];
    }cout<<endl;
}
return 0;
}
int input(vector<vector<int>>& arr1)
{
for(int row=0;row<arr1.size();row++){
for(int col=0;col<arr1[row].size();col++){
cin>>arr1[row][col];

}
}return 0;
}
int main(){
    int n,m;
    cout<<"enter the no. of rows";
    cin>>n;
    cout<<"enter the no. of columns";
    cin>>m;
    vector<vector<int>>arr1(n,vector<int>(m,0));
    vector<vector<int>>arr2(n,vector<int>(m,0));
    input(arr1);
    input(arr2);
    display(arr1,arr2);
}