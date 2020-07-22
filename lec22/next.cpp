#include<iostream>
#include<vector>
using namespace std;
string words[]={".,:;","abc","def","ghi","jkl","mno","pqrs","tuv","wx","yz","@S&","-%"};
int subseq(string str,string ans){
    if(str.length()==0){
        cout<<ans<<endl;
        return 1;
    }
   int count=0;
  count+=  subseq(str.substr(1),ans+str[0]);
  count+= subseq(str.substr(1),ans);
  return count;
}
int keypad(string str,string ans){
    if(str.length()==0){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    if(str.length()>=2){
    int b=(str[0]-'0')*10+str[1]-'0';
    if(b<=11){
        string ross=words[b];
        for(int i=0;i<ross.length();i++){
            if(ross.length()>=3)
        count+= keypad(str.substr(2),ans+ross[i]);
        else
        count+=keypad("",ans+ross[i]);
     }
    }
    }
     int a=str[0]-'0';
     string ros=words[a];
     for(int i=0;i<ros.length();i++){
        count+= keypad(str.substr(1),ans+ros[i]);
     }
     return count;
}
int permutation (string str,string ans){
    if(str.length()==0){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=0;i<str.length();i++){
        string ros=str.substr(0,i)+str.substr(i+1);
       count+= permutation(ros,ans+str[i]);
    }
    return count;
}
int combination (string str,string ans){
if(str.length()==0){
    cout<<ans<<endl;
    return 1;
}
int count=0;
vector<bool> arr(26,false);
for(int i=0;i<str.length();i++){
    if(!arr[str[i]-'a']){
        arr[str[i]-'a']=true;
        string ros=str.substr(0,i)+str.substr(i+1);
       count+= combination(ros,ans+str[i]);
    }
}
    return count;
}
int combination2(string str,string ans){
    if(str.length()==0){
    cout<<ans<<endl;
    return 1;
}
int count=0;
int arr=0;
for(int i=0;i<str.length();i++){
    int mask=1<<(str[i]-'a');
    if((arr & mask)==0){
        arr|=mask;
        string ros=str.substr(0,i)+str.substr(i+1);
       count+= combination2(ros,ans+str[i]);
    }
}
    return count;
}

int main(){
   // cout<<subseq("abcd","");
  //cout<< keypad("10110","");
 //cout<< permutation("abc","");
 cout<<combination2("aba","");
}