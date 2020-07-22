#include<iostream>
#include<vector>
using namespace std;

void input(vector<vector<int>>& arr)
{
for(int row=0;row<arr.size();row++){
for(int col=0;col<arr[row].size();col++){
cin>>arr[row][col];

}
}
}


void display(vector<vector<int>>& arr){
    for(int row=0;row<arr.size();row++){
        if(row%2==0){
        for(int col=0;col<arr[row].size();col++){
        cout<<arr[row][col]<<" ";    
        }
        }
    
        else{
        for(int col=arr[row].size()-1;col>=0;col--){
            cout<<arr[row][col]<<" ";
        }
        }cout<<endl;
    }
    
}

int main(){
    int n,m;
    cout<<"enter the no. of rows";
    cin>>n;
    cout<<"enter the no. of colmns";
    cin>>m;
    vector<vector<int>>arr(n,vector<int>(m,0));
    input(arr);
    display(arr);
}