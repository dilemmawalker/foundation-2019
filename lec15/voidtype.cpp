#include <iostream>
#include <vector>
#include<string>
#include<climits>
using namespace std;
void subseq(string ques,string ans){
    if(ques.length()==0){
        cout<<ans<<" ";
        return ;
    }
    char ch=ques[0];
    string ros=ques.substr(1);

    subseq(ros,ans+ch);
    subseq(ros,ans);
}
/*void basicques(){
}
void solve{
    basicques();
}*/
void removehi(string ques,string ans){
    if(ques.length()==0){
        cout<<ans<<" ";
        return ;
    }
  
    if(ques.length()>1 && ques.substr(0,2)=="hi"){
        removehi(ques.substr(2),ans);
    }
    else{
        removehi(ques.substr(1),ans+ques[0]);
    }

}
void removeduplicates(string ques,string ans){
    if(ques.length()==0){
        cout<<ans<<" ";
        return ;
    }
    char ch=ques[0];
    if(ques.length()>1 && ch!=ques[1]){
        removeduplicates(ques.substr(1),ans+ques[1]);
    }
    else
    {
        removeduplicates(ques.substr(1),ans);
    }
    

}
void countnoofdublicates(string ques,string ans,int count){
    if(ques.length()==1){
        cout<<ans;
        cout<<ques[0]+to_string(count);
    return ;
    }
    char ch=ques[0];
    if(ques.length()>1 && ch!=ques[1]){
        count++;
        countnoofdublicates(ques.substr(1),ans+ch+to_string(count),0);
}
else if(ques.length()>1){
     count++;
        countnoofdublicates(ques.substr(1),ans,count);
}
else{
    countnoofdublicates(ques,ans,count);
}
}
void mazepath(int sr,int sc,int er,int ec, string ans){
if(sr==er && sc==ec){
    cout<<ans<<endl;
    return ;
}
if(sr+1<=er ){
    mazepath(sr+1,sc,er,ec,ans+"v");
}
if(sc+1<=ec){
    mazepath(sr,sc+1,er,ec,ans+"h");
}
}

int main(){
   // subseq("abc","");
   // removehi("hihihhhiiihihh","");
   // removeduplicates("aaabbbcccdddddddaaaa","a");
  // countnoofdublicates("aaaaabbbccccdddddddaaaae","",0);
mazepath(0,0,2,2,"");
}