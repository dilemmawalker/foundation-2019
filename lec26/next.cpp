#include<iostream>
#include<string>
#include<climits>
#include<vector>
using namespace std;
bool issafetoplace1(vector<vector<bool>> & arr,int x,int y){
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
int issafetoplace2(){

}
int sudoku(){

}

int main(){

}