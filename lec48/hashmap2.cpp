#include<iostream>
#include<unordered_map>
#include<vector>

using  namespace std;
int longestseries(vector<int>& arr){
unordered_map<int,bool>map;
for(int ele:arr){
map[ele]=true;
}
int size=-1;
int number=-1;

for(auto keys:map){
    if(map.find(keys.first-1)!=map.end())
    map[keys.second]=false;
}
for(auto keys:map){
    if(keys.second){
        int num=keys.first+1;
        int ssize=1;
       while(map.find(num)!=map.end()){
            num++;
            ssize++;
        }
        if(ssize>size){
        size=ssize;
        number=keys.first;
        }
    }
}
for(int i=0;i<size;i++){
    cout<<number+i<<" ";
}
}
int main(){
vector<int>arr={0,1,2,100,99,98,97,96,95,94,12,3,4,5,10,8};
longestseries(arr);
return 0;
}