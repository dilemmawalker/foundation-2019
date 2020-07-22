#include<iostream>
#include<vector>
#include<queue>
using namespace std;
class edge{
    public:
     int v=0;
     int w=0;
    edge(int v,int w){
        this->v=v;
        this->w=w;
    }
};
int n=9;
vector<vector<edge*>>graph(n,vector<edge*>());
 void addedge(int u,int v,int w){
    if(u<0 || v<0 || u>=graph.size() || v>=graph.size()){
        return ;
    }
    graph[u].push_back(new edge(v,w));
    // graph[v].push_back(new edge(u,w));
}
void constructgraph(){
   /* addedge(0,1,10);
    addedge(0, 3, 10);
    addedge(1, 2, 10);
    addedge(2, 3, 40);
    addedge(3, 4, 2);
    addedge(4, 5, 2);
    addedge(4, 6, 3);
    addedge(5, 6, 8);
    //addedge(2,5,1);
    //addedge(0,6,1);*/
    addedge(1,2,1);
    addedge(1, 3, 1);
    addedge(1, 2, 1);
    addedge(2, 4, 1);
    addedge(3, 4, 1);
    addedge(3, 5, 1);
    addedge(4, 6, 1);
    addedge(6, 7, 1);
    addedge(7,4,1);

    
}


void removeedge(int u,int v){
    int i=0;
    while(i<graph[u].size()){
        edge *e=graph[u][i];
        if(e->v==v)
        break;
        i++;
    }
    int j=0;
    while(j<graph[v].size()){
        edge *e=graph[v][j];
        if(e->v==u)
        break;
        j++;
    }
    graph[u].erase(graph[u].begin()+i);
    graph[v].erase(graph[v].begin()+j);
}
void  removevtx(int u){
    while(graph[u].size()>0){
        edge *e=graph[u][graph[u].size()-1];
        removeedge(u,e->v);
    }
}
bool toposort(int src,vector<bool> & vis,vector<int> & stack,vector<bool>cycle1){
vis[src]=true;
cycle1[src]=true;
bool res=false;
for(edge *e:graph[src]){
    if(!vis[e->v])
   res=res|| toposort(e->v,vis,stack,cycle1);
   else if(cycle1[e->v])
   return true;
}
stack.push_back(src);
cycle1[src]=false;
return res;
}
void topologicalsortcycle(){
    vector<bool>vis(graph.size(),false);
    vector<int>stack;
    vector<bool>graph1(graph.size(),false);
    for(int i=0;i<n;i++){
        if(!vis[i])
        cout<<toposort(i,vis,stack,graph1);
    }
    while(stack.size()!=0){
        cout<<stack.back()<<" ";
        stack.pop_back();
    }
}


/*void kosala(){
vector<bool>vis(graph.size(),false);
    vector<int>stack1;
    for(int i=0;i<n;i++){
        if(!vis[i]){
vis[src]=true;
for(edge *e:graph[src]){
    if(!vis[e->v])
    toposort(e->v,vis,stack);
}
stack1.push_back(src);
        }
     }

}*/
void khans(){
    queue<int>que;
    vector<int>ans;
    vector<int>arr(n,0);

    for(int i = 0;i<graph.size();i++)
    {
        for(edge* e: graph[i])
        {
            arr[e->v]++;
        }
    }

    for(int i=0;i<arr.size();i++){
        if(arr[i]==0)
        que.push(i);
    }
    while(que.size()!=0){
        int rvtx=que.front();
        que.pop();
        ans.push_back(rvtx);
       for(edge *e:graph[rvtx]){
           arr[e->v]--;
           if(arr[e->v]==0)
           que.push(e->v);
       }
    }
    if(ans.size()!=graph.size())
    cout<<"cyclic";
    else
    for(int j=0;j<ans.size();j++)
    cout<<ans[j] << " ";
  }
void constructgraphnew(){
    addedge(0,1,0);
    addedge(0,2,0);
    addedge(1,5,0);
    addedge(5,6,0);
    addedge(6,8,0);
    addedge(3,2,0);
    addedge(3,4,0);
    addedge(2,7,0);
    addedge(7,6,0);
}

void solve(){
//     int n;
//     cout<<"enter no. of edges";
// cin>>n;
// vector<int>arr(n,0);
/*for(int i=0;i<n;i++){
    cout<<"enter "<<i<<" edge"<<endl;
    int a;
    cin>>a;
    int b;
    cin>>b;
    constructgraphnew(a,b);
    arr[b]=arr[b]+1;
}*/
constructgraphnew();
khans();
}
int main(){
    
    // display();
   // removeedge(3,4);

    // removevtx(3);
//    int n=7;
  // constructgraph();
   //vector<bool>vis(n,false);
  // topologicalsortcycle();
  solve();
}