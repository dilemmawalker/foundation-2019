#include<iostream>
#include<vector>
#include<string>
#include<climits>
using namespace std;
void mazepathmulti(int sr,int sc,int er,int ec,string psf){ 
    if(sr==er && sc==ec){
        cout<<psf<<" ";
        return ;
    }
   
        for(int i=1;i+sr<=er;i++){
            mazepathmulti(sr+i,sc,er,ec,psf+"v"+to_string(i));
        }

        for(int i=1;i+sc<=ec;i++){
            mazepathmulti(sr,sc+i,er,ec,psf+"h"+to_string(i));
        }

        for(int i=1;i+sr<=er&& i+sc<=ec;i++){
            mazepathmulti(sr+i,sc+i,er,ec,psf+"d"+to_string(i));
        }
}
void permutation(string ques,string ans){
    if(ques.length()==0){
        cout<<ans<<" ";
        return ;
    }
     for(int i=0;i<ques.length();i++){
        char ch=ques[i];
         string ros=ques.substr(0,i)+ques.substr(i+1);
    permutation(ros,ans+ch);

     }
}
void combination(string ques,string ans){
    if(ques.length()==0){
        cout<<ans<<" ";
        return ;
    }
    int mapping =0;
    //vector<bool>mapping(26,false);
     for(int i=0;i<ques.length();i++){
        char ch=ques[i];
        if((mapping & (1<<(ch-'a')))==0){
            mapping |=(1<<(ch-'a'));
        
         string ros=ques.substr(0,i)+ques.substr(i+1);
    combination(ros,ans+ch);

     }
     }
}
int unique(vector<int>& arr,int k)
{
    vector<int> bits(32,0);
    for(int ele: arr){
        for(int i=0;i<32;i++)
        {
            int mask=(1<<i);
            if((ele&mask)!=0)
            {
                bits[i]++;
            }
        }
    }
    int ans=0;
    for(int i=0;i<32;i++)
    {
        if(bits[i]%k!=0)
        {
            ans|=(1<<i);
        }
    }
    return ans;
}

int main(){
   // mazepathmulti(0,0,2,2,"");
   string s="abc";
   // permutation(s,"");
   //combination("abb","");
   vector<string>arr(11,"");
   arr={"2","2"};
   unique(arr,5);
    return 0;
}