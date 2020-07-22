#include<iostream>
#include<vector>
#include<string>
#include<climits>
using namespace std;
/*void nqueenpermutation( vector<int>arr,ans, vector<bool>arr1,vidx){
    if(vidx==arr1.length()){
        
    }
   
        arr1[vidx]=true;
        ans+"q1"+to_string(vidx+1);
        for(int j=0;j<n;j++){

            if(arr1[j]==false){
            arr1[j]=true;
            ans+"q1"+to_string(j+1);
            for(int k=0;k<n;k++){
                if(arr1[k]==false){
                    arr1[k]=true;
                    nqueenpermutation(arr,ans+"q3"+to_string(k+1),arr1,vidx+1);
         }
         arr1[vidx]=false;


        }
            }
        }
        arr1[]=false;//do  all elements false
    
}*/
int nqueencombi(int boxes,int tnq,int qloc,int qpsf,string ans){
if(qpsf==tnq ){
    cout<<ans<<endl;
    return 1;
}
int count=0;
for(int i=qloc+1;i<=boxes;i++){
    count+=nqueencombi(boxes,tnq,i,qpsf+1,ans+"b"+to_string(i+1)+" q"+to_string(qpsf+1)+" ");
   
}
return count;
}
int nqueenpermu(int boxes,int tnq,vector<bool>loc,int qpsf,string ans){
if(qpsf==tnq ){
    cout<<ans<<endl;
    return 1;
}
int count=0;
for(int i=0;i<=boxes;i++){
    if(!loc[i]){
        loc[i]=true;
    count+=nqueenpermu(boxes,tnq,loc,qpsf+1,ans+"b"+to_string(i)+" q"+to_string(qpsf+1)+" ");
   loc[i]=false;
}
}
return count;
}
int nqueencombisubseq(int boxes,int tnq,int qloc,int qpsf,string ans){
    if(qpsf==tnq  || qloc==boxes){
        if(qpsf == tnq){
            cout<<ans<<endl;
            return 1;
        }
        return 0;
    }
    int count=0;
    count += nqueencombisubseq(boxes,tnq,qloc+1,qpsf+1,ans+"b"+to_string(qloc)+" q"+to_string(qpsf+1)+" ");
    count += nqueencombisubseq(boxes,tnq,qloc+1,qpsf,ans);
    return count;
}
int nqueenpermusubseq(int boxes,int tnq,vector<bool>loc,int qpsf,string ans,int vidx){
    if(qpsf==tnq  || qloc>boxes){
        if(qpsf == tnq){
            cout<<ans<<endl;
            return 1;
        }
        return 1;
    }
    int count=0;
    if(!loc[vidx]){
        loc[vidx]=true;
    count += nqueenpermusubseq(boxes,tnq,loc,qpsf+1,ans+"b"+to_string(qloc)+" q"+to_string(qpsf+1)+" ",vidx+1);
    count += nqueenpermusubseq(boxes,tnq,loc,qpsf,ans,vidx+1);
    loc[vidx]=false;
    return count;
    }
}
void isSafeToPlace(vector<vector<bool>> &boxes, int x, int y)
 {

    int dir[4][2] = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    for (int d = 0; d < 4; d++)
    {

        for (int rad = 1; rad < boxes[0].size(); rad++)
        {
            int r = x + rad * dir[d][0];
            int c = y + rad * dir[d][1];
            if (r >= 0 && c >= 0 && r < boxes.size() && c < boxes[0].size() && boxes[r][c])
            {
                return false;
            }
        }
    }

    return true;
}
int nQueen(vector<vector<bool>> &boxes, int tnq, int qloc, int qpsf, string ans)
{
    if (qpsf == tnq)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    for (int i = qloc + 1; i < boxes.size() * boxes[0].size(); i++)
    {
        int x = i / boxes.size();
        int y = i % boxes.size();
        if (isSafeToPlace(boxes, x, y))
        {
            boxes[x][y] = true;
            count += nQueen(boxes, tnq, i, qpsf + 1, ans + "(" + to_string(x) + ", " + to_string(y) + ")" + "@" + to_string(qpsf) + " ");
            boxes[x][y] = false;
        }
    }
    return count;
}
int nQueen01(vector<vector<bool>> &boxes, int tnq, int qloc, int qpsf, string ans)
{
    if (vidx==boxes.size()*boxes[0].size() || tnq==qpsf)
    {
        if(qpsf==tnq)
       {cout<<ans<<" ";
        return 1;
       }
        return 0;
    }
  int count=0;
        int x = i / boxes.size();
        int y = i % boxes.size();
        if (isSafeToPlace(boxes, x, y))
        {
            boxes[x][y] = true;
            count += nQueen01(boxes, tnq,qpsf + 1,vidx+1, ans + "(" + to_string(x) + ", " + to_string(y) + ")" + "@" + to_string(qpsf) + " ");
            boxes[x][y] = false;
        }
        count+=nQueen01(boxes, tnq,qpsf + 1,vidx+1, ans);
    
    return count;
}

/*void nqueencombimatrixsubseq(int boxes,int tnq,int qloc,int qpsf,int ans){

}*/


int main(){
    int n=7;
  //  vector<int>arr(n,0);
     vector<bool>arr1(n,false);
     string s="";
//cout<<nqueencombi(5,3,-1,0,"");
vector<bool>loc(n,false);
//cout<<nqueencombisubseq(7,3,0,0,"");
//cout<<nqueenpermusubseq(7,3,loc,0,"");
cout<<nqueen01(boxes,0,0,"");
    return 0;
}