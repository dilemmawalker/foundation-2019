#include<vector>
#include<iostream>
#include<list>
#include<climits>
#define vi vector<int>
#define vii vector<vi>

using namespace std;
int noofsets(int n,int k,vii & dp){
    if(n==k){
        dp[n][k]=1;
        return 1;
    }
    if(n<k){
    return 0;
    }

    if(k==1){
        dp[n][k]=1;
    return 1;
    }

    if(dp[n][k]!=0)
    return dp[n][k];

    int a=noofsets(n-1,k-1,dp);
    int b=noofsets(n-1,k,dp);

    int ans=a+b*k;
    dp[n][k]=ans;
    return ans;
}
void display2D(vii &dp)
{
    for (vi &ar : dp)
    {
        for (int &ele : ar)
            cout << ele << " ";
        cout << endl;
    }
    cout << endl;
}
void display(vi &dp){
    for(int ar:dp){
        cout<<ar<<" ";
    }
}

int noofsets2(int n,int k,vii & dp){
    for(int i=1;i<=n;i++){
    for(int j=1;j<=k;j++){
        if(i<j){
            dp[i][j]=0;
            continue;
        }
        if (i == j || j == 1)
            {
                dp[i][j] = 1;
                continue;
            }

    int a=noofsets(n-1,k-1,dp);
    int b=noofsets(n-1,k,dp);

    int ans=a+b*k;
    dp[i][j]=ans;
   
}
}
return dp[n][k];
}

vii dirarr={{0,1},{-1,1},{1,1}};
int goldmine(int x,int y,vii &arr ,vii & dp){

    if(y==arr[0].size()-1){
        return dp[x][y]=arr[x][y];
    }
    if(dp[x][y]!=0)
    return dp[x][y];

    int maxans=-1e6;
    for(int d=0;d<3;d++){
        int r=x+dirarr[d][0];
        int c=y+dirarr[d][1];
        if(r>=0 && c>=0 && r<arr.size() && c<arr[0].size())
        maxans=max(maxans,goldmine(r,c,arr,dp));
    }
    dp[x][y]=maxans+arr[x][y];
    return dp[x][y];
}
int goldmine2(int x,int y,vii &arr ,vii & dp){

    for(int i=arr[0].size()-1;i>=0;i--){
        for(int j=arr.size()-1;j>=0;j--){

            if (i == arr[0].size() - 1)
            {
                dp[i][j] = arr[i][j];
                continue;
            }

    int maxans=-1e6;
    for(int d=0;d<3;d++){
        int r=i+dirarr[d][0];
        int c=j+dirarr[d][1];
        if(r>=0 && c>=0 && r<arr.size() && c<arr[0].size())
        maxans=max(maxans,dp[r][c]);
    }
    dp[i][j]=maxans+arr[i][j];

    }
    }
    int maxAns = -1e6;
    for (int row = 0; row < arr.size(); row++)
    {
        maxAns = max(maxAns, dp[row][0]);
    }

    return maxAns;
}

int maxsquareans=0;
int maxsquareof1s(int r,int c,vii &arr , vii & dp){
    if(r==arr.size() || c==arr[0].size()){
        return 0;
    }
    if(dp[r][c]!=-1)
    return dp[r][c];
    
    int down= maxsquareof1s(r+1,c,arr,dp);
    int right= maxsquareof1s(r,c+1,arr,dp);
    int diag= maxsquareof1s(r+1,c+1,arr,dp);

    int minpossiblesquare=0;
    if(arr[r][c]==1)
    minpossiblesquare=min(down,(min(right,diag)))+1;

    dp[r][c]=minpossiblesquare;
    maxsquareans=max(dp[r][c],maxsquareans);

    return dp[r][c];
}
int maxsquareof1s_1(int r,int c,vii &arr , vii & dp){
    if(r==arr.size() || c==arr[0].size()){
        return 0;
    }
    if(dp[r][c]!=-1)
    return dp[r][c]=arr[r][c];
    
    int down= maxsquareof1s_1(r+1,c,arr,dp);
    int right= maxsquareof1s_1(r,c+1,arr,dp);
    int diag= maxsquareof1s_1(r+1,c+1,arr,dp);

    int minpossiblesquare=0;
    if(arr[r][c]==1)
    minpossiblesquare=min(down,(min(right,diag)))+1;

    dp[r][c]=minpossiblesquare;
    maxsquareans=max(dp[r][c],maxsquareans);

    return dp[r][c];
}

int maxsquareof1sDP(int r,int c,vii &arr , vii & dp){
    int minpossiblesquare=0;
   for(int i=r-1;i>=0;i--){
       for(int j=c-1;j>=0;j--){

  if(i==r-1 || j==c-1){
     dp[i][j]=arr[i][j];
        continue;}
    
    int down= dp[i+1][j];
    int right=dp[i][j+1];
    int diag= dp[i+1][j+1];

    
    if(arr[i][j]==1)
     dp[i][j]=min(down,(min(right,diag)))+1;
    
    
    maxsquareans=max(dp[i][j],maxsquareans);  
       }
   }
   return maxsquareans;
}

int tilefloor(int n,int m,vi &dp){
if(n==m)
return 2;
if(n<m)
return 1;

int a=tilefloor(n-1,m,dp);
int b=tilefloor(n-m,m,dp);
int ans=a+b;
return ans;
}

int tilefloor1(int n,int m,vi &dp){
if(n==m){
    dp[n]=2;
return 2;
}
if(n<m){
    dp[n]=1;
return 1;
}
if(dp[n]!=0)
return dp[n];
int a=tilefloor1(n-1,m,dp);
int b=tilefloor1(n-m,m,dp);
int ans=a+b;
return dp[n]=ans;
}

int tilefloor2(int n,int m,vi &dp){
for(int i=0;i<=n;i++){

if(i==m){
    dp[i]=2;
continue;
}
if(i<m){
    dp[i]=1;
continue;
}

int a=dp[i-1];
int b=dp[i-m];
int ans=a+b;
dp[i]=ans;
}
return dp[n];
}
int tileFloor_02(int n, int m)
{
    if (n <= m)
        return ((n == m) ? 2 : 1);

    list<int> ll;
    for (int i = 1; i <= m; i++)
        ll.push_back(1);

    for (int i = m; i <= n; i++)
    {
        int horizontal = ll.back(); //dp[i - 1];
        int vertical = ll.front();  //dp[i - m];

        ll.push_back(horizontal + vertical);
        ll.pop_front();
    }
    
    return ll.back();
}

int permuinfinite(vector<int>arr,vector<int>&dp,int sum,int target){
if(sum > target) {
    return 0;
}
if(sum==target){
return 1;
}
int a=0;
for(int i=0;i<arr.size();i++){
a+=permuinfinite(arr,dp,sum+arr[i],target);
}

return a;
}


int permuinfinite2(vector<int>arr,vector<int>&dp,int sum,int target){
if(sum > target) {
    return 0;
}
if(sum==target){     
    return 1;
}
if(dp[sum] > 0) {
    return dp[sum];
}
int a=0;
for(int i=0;i<arr.size();i++){
a+=permuinfinite2(arr,dp,sum+arr[i],target);
}
dp[sum]=a;
return a;
}

int coinchangepermutation(vi & arr,int target,vi &dp){
    if(target==0)
    return dp[target]=1;
    int count=0;
    for(int i=0;i<arr.size();i++){
        if(target-arr[i]>=0)
        count+=coinchangepermutation(arr,target-arr[i],dp);
    }
    dp[target]=count;
    return dp[target];
}

int coinchangepermutationDP(vi & arr,int target,vi &dp){
    dp[0]=1;
    for(int i=1;i<=target;i++){
        int count=0;
        for(int j=0;j<arr.size();j++){

      if(i-arr[j]>=0){
        count+=dp[i-arr[j]];
      }
      
        }
        dp[i]=count;
    }
    return dp[target];
}

int coinchangecombinationDP(vi & arr,int target,vi &dp){

dp[0]=1;
    for(int j=0;j<arr.size();j++){
        int count=0;
    for(int i=1;i<=target;i++){
    
        if(i-arr[j]>=0){
       dp[i]+=dp[i-arr[j]];
      
        }
        }      
    }
    return dp[target];
}




// int combiinfinite3(vector<int>arr,vector<int>dp,int sum,int target){

// if(sum==target){
//     dp[]=sum;     
// return 1;
// }
// int a=0;
// for(int i=0;i<arr.size();i++){
// a+=dp[sum+arr[i]];
// }
// dp[]=a;
// return a;
// }

void equationsolve(int a,int b,int c,int d){
    
  int count=0;
    for(int i=a;i>=0;i--){
        for(int j=b;j>=0;j--){
            for(int k=c;k>=0;k--){
                if(d-(a+b+c)==0)
                count++;
            }
        }
    }
    return count;
}



int main(){
     int n=5,k=3;
    // vii arr = {{1, 0, 1},
    //            {1, 1, 1},
    //            {0, 1, 1}};
   
// vii dp(3 , vi(3, -1));

 
//int a=noofsets(n,k,dp);
//cout<<a;
//display2D(dp);
// int b=goldmine(0,0,arr,dp);
// cout<<b;
// display2D(dp);


// int a=maxsquareof1sDP(3,3,arr,dp);
// cout<<a<<endl;

//  display2D(dp);


 // vi arr={2,3,5};
// vi dp(8,0);
// cout<<permuinfinite2(arr,dp,0,7)<<endl;
// display(dp);

// vi dp(8,0);
// cout<<tilefloor2(7,4,dp)<<endl;
// display(dp);


vi arr={2,3,5,7};
 vi dp(10+1,0);
 //  cout<<coinchangepermutation(arr,10,dp)<<endl;
  cout<<coinchangecombinationDP(arr,10,dp)<<endl;
 // cout<<coinchangepermutationDP(arr,10,dp)<<endl;
display(dp);
return 0;
}