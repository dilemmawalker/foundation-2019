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
int dice(int start,int target, vector<int> &dp){
    if(start==target){
        dp[start]=1;
           return 1;
   }
    int count=0;
    if(dp[start]!=0)
    return dp[start];
for(int i=1;i<=6;i++){
    if(start+i<=target)
   count+= dice(start+i,target,dp);
}
dp[start]=count;
return count;
}
int diceDP(int start,int target, vector<int> &dp){
  for(int j=target;j>=start;j--){
    int count=0;
    if(j==target){
        dp[j]=1;
        continue;
    }  
for(int i=1;i<=6;i++){
    if(j+i<=target)
   count+= dp[j+i];
}
dp[j]=count;
}
return dp[1];
}

int outcomes(vector<int>arr,int sum,int target,vector<int>&dp){
    if(sum==target){
    dp[sum]=1;
        return 1;
    }

    int count=0;
    if(dp[sum]!=0)
    return dp[sum];
    for(int ele=0;ele<arr.size();ele++){
        if(sum+arr[ele]<=target)
        count+=outcomes(arr,sum+arr[ele],target,dp);
    }
    dp[sum]=count;
    return count;
}
int outcomesDP(vector<int>arr,int sum,int target,vector<int>&dp){
    
for(int j=target;j>=sum;j--){

    if(j==target){
        dp[j]=1;
        continue;
    }
   int count=0;
    for(int ele=0;ele<arr.size();ele++){
        if(j+arr[ele]<=target)
        count+=dp[j+arr[ele]];
    }
    dp[j]=count;
}
    return dp[0];
}


int main(){
     vector<int>dp(11,0);
   //  int ways=dice(1,10,dp);
    
     vector<int>arr={2,5,3,7};
    //  int ways=diceDP(1,10,dp);
    // cout<<ways<<endl;
    // display(dp);
    int a=outcomesDP(arr,0,10,dp);
    cout<<a<<endl;
   display(dp);
   
    return 0;
}