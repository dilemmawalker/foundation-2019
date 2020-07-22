#include<iostream>
#include<string>
#include<climits>
#include<vector>
using namespace std;
 #define vi vector<int>
 #define vvi vector<vi>
 #define vb vector<bool>
 #define vvb vector<vb>
bool issafetoplace(vector<vector<bool>> & arr,int x,int y){
    int arr1[4][2]={{0,-1},{-1,0},{-1,-1},{-1,1}};

    for(int i=0;i<arr.size();i++){
        for(int j=1;j<arr[0].size();j++){
            int r=x+j*arr1[i][0];
            int c=y+j*arr1[i][1];
            
            if(r<0 || c<0 || r>=arr.size() || c>=arr[0].size())
                break;

                if(arr[r][c]==true){
                return false;
            }

        }
    }
    return true;
}
int queenmatrixcombi(int tnq,int qpsf,int vidx,vector<vector<bool>> & arr,string ans){
if(qpsf==tnq){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=vidx;i<arr.size()*arr[0].size();i++){
        int x=i/arr.size();
        int y=i%arr.size();
        if(issafetoplace(arr,x,y)){
            arr[x][y]=true;
    count+= queenmatrixcombi(tnq,qpsf+1,i+1,arr,ans+"("+to_string(x)+","+to_string(y)+")");
         arr[x][y]=false;
        }
    }
    return count;
}
bool issafetoplace2(vector<vector<bool>> & arr,int x,int y){
    int arr1[8][2]={{0,-1},{-1,0},{-1,-1},{-1,1},{0,1},{1,0},{1,1},{1,-1}};

    for(int i=0;i<8;i++){
        for(int j=1;j<max(arr.size(),arr[0].size());j++){ 
            int r=x+j*arr1[i][0];
            int c=y+j*arr1[i][1];
            
            if(r<0 || c<0 || r>=arr.size() || c>=arr[0].size())
                break;

                if(arr[r][c]==true){
                return false;
            }

        }
    }
    return true;
}
int queenmatrixpermu(int tnq,int qpsf,int vidx,vector<vector<bool>> & arr,string ans){
if(qpsf==tnq){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=0;i<arr.size()*arr[0].size();i++){
        int x=i/arr.size();
        int y=i%arr.size();
        
        if(!arr[x][y] && issafetoplace2(arr,x,y)){
            arr[x][y]=true;
    count+= queenmatrixpermu(tnq,qpsf+1,0,arr,ans+"("+to_string(x)+","+to_string(y)+")");
         arr[x][y]=false;
        }
    }
    return count;
}
int newmethodqueen(int r,int tnq,vi & col, vb  & diag,vb & adiag,string ans,int n){
    
    if(tnq==0 || r==n){
        if(tnq==0){
        cout<<ans<<endl;
        return 1;
    }
    return 0;
    }
    int count=0;
    for(int c=0;c<n;c++){
        if(!col[c] && !diag[r+c] && !adiag[r-c+n-1]){
        col[c]=true;
        diag[r+c]=true;
        adiag[r-c+n-1]=true;
        count+=newmethodqueen(r+1,tnq-1,col,diag,adiag,ans+"("+to_string(r)+","+to_string(c)+")",n);
        col[c]=false;
        diag[r+c]=false;
        adiag[r-c+n-1]=false;
     }
    }
     return count;

}



int main(){
    vector<vector<bool>> arr(4,vector<bool>(4,false));
     // cout<<queenmatrixcombi(4,0,0,arr,"");
    // cout<<queenmatrixpermu(4,0,0,arr,"");
    vi col(4,0);
    vb diag(7,false);
    vb adiag(7,false);
    cout<<newmethodqueen(0,4, col, diag, adiag,"",4);
}