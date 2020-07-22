
#include<vector>
#include<iostream>
#define vi vector<int>
#define vii vector<vi>

using namespace std;
void display(vi &dp){
for(int i=0;i<dp.size();i++){
cout<<dp[i]<<" ";
}
}
void display2(vii &dp){
for(vi & ar:dp){
    for(int & ele:ar){
        cout<<ele<<" ";
    }
    cout<<endl;
}
}
int fibo(int n,vi &dp){
    if(n<=1){
        dp[n]=n;
        return n;
    }

    if(dp[n]!=0)
    return dp[n];

    dp[n]=fibo(n-1,dp)+fibo(n-2,dp);
}

void fibo2(int n,vi &dp){
    for(int i=0;i<=n;i++){
        if(i<=1){
            dp[i]=i;
            continue;
        }
        dp[i]=dp[i-1]+dp[i-2];
    }
}

int mazepath(int h,int v,vii &dp){
if(h>=dp.size()-1 && v>=dp.size()-1){
    dp[h][v]=1;
return 1;
}
int c=0;

if(dp[h][v]!=0)
return dp[v][h];

if(h+1<dp.size()){
c+=mazepath(h+1,v,dp);
}
if(v+1<dp.size()){
   c+= mazepath(h,v+1,dp);
}
dp[h][v]=c;
return c;
}

int mazepath1(int h,int v,vii &dp){

for(int sr=dp.size()-1;sr>=0;sr--){
for(int sc=dp.size()-1;sc>=0;sc--){
    if(sr==dp.size()-1 || sc==dp.size()-1){
        dp[sr][sc]=1;
        continue;
    }
    int c=0;
if(sr+1<dp.size()){
c+=dp[sr+1][sc];
}
if(sc+1<dp.size()){
   c+= dp[sr][sc+1];
}
dp[sr][sc]=c;
}
}
}

int mazepath2(int h,int v,vii &dp){
if(h>=dp.size()-1 && v>=dp.size()-1){
    dp[h][v]=1;
return 1;
}
if(dp[h][v]!=0)
return dp[v][h];
int c=0;
if(h+1<dp.size()){
c+=mazepath2(h+1,v,dp);
}
if(v+1<dp.size()){
   c+= mazepath2(h,v+1,dp);
}
if(h+1<dp.size() && v+1<dp.size()){
c+=mazepath2(h+1,v+1,dp);
}
dp[h][v]=c;
return c;
}

int mazepath2DP(int h,int v,vii &dp){

for(int sr=dp.size()-1;sr>=0;sr--){
for(int sc=dp.size()-1;sc>=0;sc--){
    if(sr==dp.size()-1 || sc==dp.size()-1){
        dp[sr][sc]=1;
        continue;
    }
    int c=0;
if(h<dp.size()){
c+=dp[sr+1][sc];
}
if(v<dp.size()){
   c+=dp[sr][sc+1];
}
if(h<dp.size() && v<dp.size()){
c+=dp[sr+1][sc+1];
}
dp[sr][sc]=c;
}
}
}

int main(){
   // int n=6;
    //vector<int>dp(n+1,0);
    //fibo(n,dp);
    //display(dp);   
    //fibo2(n,dp);
     int n=3;
     //vector<int>dp(n+1,0);
      vii dp(n,vi(n,0));
   //int a= mazepath1(0,0,dp);
 int a= mazepath2DP(0,0,dp);
   cout<<a<<endl;
   display2(dp);
    //display(dp);  
}