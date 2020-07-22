#include <iostream>
#include<vector>
using namespace std;


bool binary(vector<int>& arr){
    int i;
    cout<<"enter no. to be searched";
    int no;
    cin>>no;
    int si=0;
    int ei=arr.size()-1;
        while(si<=ei){
            int mid=(si+ei)/2;
            if(arr[mid]==no)
            return true;
            else if(arr[mid]<no)
            si=mid+1;
            else ei=mid-1;
        }
    return false;
}


int input(vector<int>& arr){
 for(int i=0;i<arr.size();i++)   
 cin>>arr[i];
 return 0;
}
int main(){
    int n;
    cout<<"enter the no. of inputs in array";
    cin>>n;
    vector<int>arr(n,0);
    input(arr);
    cout<<binary(arr);
    return 0;
}
