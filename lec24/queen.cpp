#include<vector>
#include<iostream>
#include<climits>
#include<string>
using namespace std;
/*int queenmatrix(int tnq,int qpsf,int vidx1,int vidx2,vector<bool>& arr,string ans)
{
    if(qpsf==tnq){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=vidx1;i<=arr.size();i++){
        for(int j=vidx2;j<=arr.size();j++){

        }
    }
}*/
int queenmatrixcombi(int tnq,int qpsf,int vidx,vector<vector<bool>> & arr,string ans){
if(qpsf==tnq){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=vidx;i<arr.size()*arr[0].size();i++){
        int x=i/arr.size();
        int y=i%arr.size();
    count+= queenmatrixcombi(tnq,qpsf+1,i+1,arr,ans+"("+to_string(x)+","+to_string(y)+")");
    
    }
    return count;
}
int queenmatrixpermu(int tnq,int qpsf,int vidx,vector<vector<bool>> & arr,string ans){
if(qpsf==tnq){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=vidx;i<arr.size()*arr[0].size();i++){
        int x=i/arr.size();
        int y=i%arr.size();
        if(!arr[x][y]){
            arr[x][y]=true;
        
    count+= queenmatrixpermu(tnq,qpsf+1,0,arr,ans+"("+to_string(x)+","+to_string(y)+")");
    arr[x][y]=false;
        }
    }
    return count;
}
int queenmatrixcombisubseq(int tnq,int qpsf,int vidx,vector<vector<bool>> & arr,string ans){
    if(qpsf==tnq || vidx==arr.size()*arr[0].size()){
if(qpsf==tnq){
        cout<<ans<<endl;
        return 1;
    }
    return 0;
    }
    int count=0;
        int x=vidx/arr.size();
        int y=vidx%arr.size();
    count+= queenmatrixcombisubseq(tnq,qpsf,vidx+1,arr,ans);
    count+= queenmatrixcombisubseq(tnq,qpsf+1,vidx+1,arr,ans+"("+to_string(x)+","+to_string(y)+")");
    return count;
}
int queenmatrixpermusubseq(int tnq,int qpsf,int vidx,vector<vector<bool>> & arr,string ans){
    if(qpsf==tnq || vidx==arr.size()*arr[0].size()){
if(qpsf==tnq){
        cout<<ans<<endl;
        return 1;
    }
    return 0;
    }
    int count=0;
        int x=vidx/arr.size();
        int y=vidx%arr.size();
        if(!arr[x][y]){
            arr[x][y]=true;
    
             count+= queenmatrixpermusubseq(tnq,qpsf+1,0,arr,ans+"("+to_string(x)+","+to_string(y)+")");
               arr[x][y]=false;
        }
        
        count+=queenmatrixpermusubseq(tnq,qpsf,vidx+1,arr,ans);
    return count;
}


int main(){
    vector<vector<bool>>arr(4,vector<bool>(4,false));
 // cout<<  queenmatrixcombi(4,0,0,arr,"");
 //cout<<  queenmatrixpermu(4,0,0,arr,"");
 //cout<<queenmatrixcombisubseq(4,0,0,arr,"");
 cout<< queenmatrixpermusubseq(4,0,0,arr,"");
}