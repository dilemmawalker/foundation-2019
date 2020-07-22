#include <iostream>
#include <vector>
#include <string>
#include <climits>
using namespace std;
int coins(vector<int> &arr, int target, int sum, string ans)
{
    if (sum == target)
    {
        cout<<ans<<endl;
        
        return 1;
    }
    int count = 0;
    for (int i = 0; i < arr.size(); i++)
    {
        if (sum+arr[i] <= 10)
        {
            
            count += coins(arr, target, sum + arr[i], ans + to_string(arr[i]));
        }
    }
    return count;
}
int coins2(vector<int> &arr, int target, int vidx,int sum, string ans)
{
    if (sum == target)
    {
        cout<<ans<<endl;
        
        return 1;
    }
    int count = 0;
    for (int i = vidx; i < arr.size(); i++)
    {
        if (sum+arr[i] <= target)
        {
            
            count += coins2(arr, target,i, sum + arr[i], ans + to_string(arr[i]));
        }
    }
    return count;
}
int coins3(vector<int> &arr, int target, int vidx,int sum, string ans)
{
    if (sum == target)
    {
        cout<<ans<<endl;
        
        return 1;
    }
    int count = 0;
    for (int i = vidx; i < arr.size(); i++)
    {
        if (sum+arr[i] <= target)
        {
            
            count += coins3(arr, target,i+1, sum + arr[i], ans + to_string(arr[i]));
        }
    }
    return count;
}
int coins4(vector<int> &arr, int target, vector<bool> & isdone,int sum, string ans)
{
    if (sum == target)
    {
        cout<<ans<<endl;
        
        return 1;
    }
    int count = 0;
    for (int i = 0; i < arr.size(); i++)
    {
        if (sum+arr[i] <= target && !isdone[i])
        {
            isdone[i]=true;
            count += coins4(arr, target,isdone, sum + arr[i], ans + to_string(arr[i]));
            isdone[i]=false;
        }
    }
    return count;
} 
int equiset(vector<int>arr,int vidx,int sum1,int sum2,string ans1,string ans2){
if(vidx==arr.size()){
    if(sum1==sum2){
        cout<<ans1<<" = "<<ans2<<endl;
        return 1;
    }
    return 0;
}
int count=0;
count+=equiset(arr,vidx+1,sum1+arr[vidx],sum2,ans1+" "+to_string(arr[vidx]),ans2);
count+=equiset(arr,vidx+1,sum1,sum2+arr[vidx],ans1,ans2+" "+to_string(arr[vidx]));
return count;
}
int checktarget(vector<int> & arr,int vidx,int target,string ans){
    if(vidx==arr.size() || (target==0 && ans.length() !=0)){
        if(target==0 && ans.length() !=0){
        cout<<ans<<endl;
        return 1;
    }
    return 0;
    }
    int count=0;
    if(target-arr[vidx]>=0){
        count+=checktarget(arr,vidx,target-arr[vidx],ans+to_string(arr[vidx]));
    }
    count+=checktarget(arr,vidx+1,target,ans);
    return count;
    }
    int checktargetpermutation(vector<int> & arr,int vidx,int target,string ans){
    if(vidx==arr.size() || (target==0 && ans.length() !=0)){
        if(target==0 && ans.length() !=0){
        cout<<ans<<endl;
        return 1;
    }
    return 0;
    }
    int count=0;
    if(target-arr[vidx]>=0){
        count+=checktargetpermutation(arr,vidx,target-arr[vidx],ans+to_string(arr[vidx]));
    }
    else
    {
        count+=checktargetpermutation(arr,0,target-arr[vidx],ans+to_string(arr[vidx]));
    }
    
    count+=checktargetpermutation(arr,vidx+1,target,ans);
    return count;
    }

int main()

{
    vector<int> arr(4, 0);
     arr = {2 ,3, 5, 7};

   // arr={10,20,30,40,50,60,70};
    //vector<bool>isdone(arr.size(),false);
   // cout << coins3(arr, 10,0, 0, "");
    //cout << coins4(arr, 10,isdone, 0, "");
    //cout<<equiset(arr,0,0,0,"","");
    cout<<checktargetpermutation(arr,0,10,"");

}