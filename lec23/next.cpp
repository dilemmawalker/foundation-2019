#include<iostream>
#include<vector>
#include<string>
#include<climits>
using namespace std;
int infinitepermu(vector<int> & arr,int target,int sum,string ans){
    if(sum==target){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=0;i<arr.size();i++){
        if(sum + arr[i]<=target)
        count+=infinitepermu(arr,target,sum+arr[i],ans+to_string(arr[i]));
    }
    return count;
}
int infinitecombi(vector<int> & arr,int target,int sum,int vidx,string ans){
    if(sum==target){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=vidx;i<arr.size();i++){
        if(sum + arr[i]<=target)
        count+=infinitecombi(arr,target,sum+arr[i],i,ans+to_string(arr[i]));
    }
    return count;
}
int combiwithoutrepeat(vector<int> & arr,int target,int sum,int vidx,string ans){
    if(sum==target){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=vidx;i<arr.size();i++){
        if(sum + arr[i]<=target)
        count+=combiwithoutrepeat(arr,target,sum+arr[i],i+1,ans+to_string(arr[i]));
    }
    return count;
}
int permuwithoutrepeat(vector<int> & arr,int target,int sum,int vidx,string ans,vector<bool>& arr1){
    if(sum==target){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=vidx;i<arr.size();i++){

        if(sum + arr[i]<=target && !arr1[i]){
            arr1[i]=true;
        count+=permuwithoutrepeat(arr,target,sum+arr[i],0,ans+to_string(arr[i]),arr1);
        arr1[i]=false;
        }
    }
    return count;
}

void nqueen(int box,int queen,string ans,int qpsf,int vidx){
    if(qpsf==queen){
        cout<<ans<<endl;
    }
    for(int i=vidx+1;i<box;i++){
        nqueen(box,queen,ans+"b"+to_string(i)+"q"+to_string(qpsf),qpsf+1,i);
    }
    return ;
}
int infinitepermusubseq(vector<int>& arr,int target, int sum ,string ans,int vidx){
    if(sum>=target){
    if(sum==target){
        cout<<ans<<endl;
        return 1;
    }
    return 0;
    }
   int count=0;
       
   if(sum+arr[vidx]<=target){
    count+=infinitepermusubseq(arr,target,sum+arr[vidx],ans+to_string(arr[vidx]),0);
   count+=infinitepermusubseq(arr,target,sum,ans,vidx+1);
   }
    return count;
}
int infinitecombisubseq(vector<int>& arr,int target, int sum ,string ans,int vidx){
    if(sum>=target){
    if(sum==target){
        cout<<ans<<endl;
        return 1;
    }
    return 0;
    }
   int count=0;
       
   if(sum+arr[vidx]<=target){
    count+=infinitecombisubseq(arr,target,sum+arr[vidx],ans+to_string(arr[vidx]),vidx);
   count+=infinitecombisubseq(arr,target,sum,ans,vidx+1);
   }
    return count;
}
int withoutrepeatcombisubseq(vector<int>& arr,int target, int sum ,string ans,int vidx){
    if(sum>=target){
    if(sum==target){
        cout<<ans<<endl;
        return 1;
    }
    return 0;
    }
   int count=0;
       
   if(sum+arr[vidx]<=target){
    count+= withoutrepeatcombisubseq(arr,target,sum+arr[vidx],ans+to_string(arr[vidx]),vidx+1);
   count+= withoutrepeatcombisubseq(arr,target,sum,ans,vidx+1);
   }
    return count;
}
int withoutrepeatpermusubseq(vector<int>& arr,int target, int sum ,string ans,int vidx,int arr2){
    if(sum>=target){
    if(sum==target){
        cout<<ans<<endl;
        return 1;
    }
    return 0;
    }
   int count=0;
       
   if(sum+arr[vidx]<=target){
       int mask=(1<<arr[vidx]);
       if((arr2 & mask)==0){
           arr2|=mask;
    count+= withoutrepeatpermusubseq(arr,target,sum+arr[vidx],ans+to_string(arr[vidx]),0,arr2);
        arr2 &=(~mask);
       }
   count+= withoutrepeatpermusubseq(arr,target,sum,ans,vidx+1,arr2);
   }
    return count;
}
 

int main(){
    vector<int> arr={2,3,5,7};
    vector<bool>arr1(4,false);
int arr2=0;
//cout<<infinitepermu(arr,10,0,"");
//cout<<coins2(arr,10,0,0,"");
//cout<<coins3(arr,10,0,0,"");
//cout<<permuwithoutrepeat(arr,10,0,0,"",arr1);
// nqueen(5,3,"",0,0);
 //cout<< infinitepermusubseq(arr,10, 0 ,"",0);
 //cout<< infinitecombisubseq(arr,10, 0 ,"",0);
// cout<< withoutrepeatcombisubseq(arr,10, 0 ,"",0);
 cout<< withoutrepeatpermusubseq(arr,10, 0 ,"",0,arr2);
}