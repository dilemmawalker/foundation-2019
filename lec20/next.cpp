#include<iostream>
#include<vector>
#include<string>
#include<climits>
using namespace std;

void dictionary(vector<string>& dict,string word,string ans){
    if(word.length()==0){
        cout<<ans<<endl;
        return ;
    }
    for(int i=0;i<=word.length();i++){
       string str=word.substr(0,i);
       bool flag = false;
        for(int j=0;j<dict.size();j++){
            if(str.compare(dict[j])==0){
              flag = true;
              break;
            }
        }
        if(flag ==true){
          dictionary(dict,word.substr(i),ans+str+" ");
        }

    }
}
//void sudoku(vector<string>arr,int x,int y){
    
//}
void baloon()
int main(){
    // int n=9;
  // vector<string>dict={"man","go","mango","i","like","sam","samsung","and","sung"};
    //dictionary(dict,"ilikemangoandsamsung","");
    //sudoku(arr,0,0);
    baloon()
    return 0;
}