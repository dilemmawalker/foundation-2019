#include <iostream>
#include <vector>

using namespace std;
void display(vector<int> &arr){
for(int i=0;i<arr.size();i++){
    bool flag=false;
    for(int j=1;j<arr.size()-i;j++){
      if(arr[j-1]>arr[j]){
          flag=true;
         swap(arr[j-1],arr[j]);
      }
    }
    if (flag==false)
    break;
}
for(int a=0;a<arr.size();a++){
    cout<<arr[a];
}
}
int input(vector<int> &arr){
    for(int i=0;i<arr.size();i++){
     cin>>arr[i];
    }
    return 0;
}

int main(){
    int n;
    cin>>n;
    vector<int>arr(n,0);
    input(arr);
    display(arr);
}