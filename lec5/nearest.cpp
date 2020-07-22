#include <iostream>
#include<vector>
using namespace std;


int binary(vector<int>& arr){
    int i;
    cout<<"enter no. to be searched";
    int no=0,mid=0;
    cin>>no;
    int si=0;
    int ei=arr.size()-1;
        while(si<=ei){
             mid=(si+ei)/2;
            if(arr[mid]==no){
            return arr[mid];
            }
            else if(arr[mid]<no)

            si=mid+1;
            else ei=mid-1;
        }

    if(si==arr.size()){
        return arr[ei];
    }else if(ei==-1){
        return arr[si];
    }else{
        if(no-arr[ei]>arr[si]-no){
            return arr[si];
        }else{
            return arr[ei];
        }
    }
    ; 
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
