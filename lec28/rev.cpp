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
int n=7;
vector<vector<edge*>>graph(n,vector<edge*>());
 void addedge(int u,int v,int w){
    if(u<0 || v<0 || u>=graph.size() || v>=graph.size()){
        return ;
    }
    graph[u].push_back(new edge(v,w));
    graph[v].push_back(new edge(u,w));
}
void constructgraph(){
    addedge(0,1,10);
    addedge(0, 3, 10);
    addedge(1, 2, 10);
    addedge(2, 3, 40);
    addedge(3, 4, 2);
    addedge(4, 5, 2);
    addedge(4, 6, 3);
    addedge(5, 6, 8);
    //addedge(2,5,1);
    //addedge(0,6,1);
    
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
void hashpath(int src,int dest,vector<bool>vis,string ans){
    if(src==dest){
        cout<<ans+to_string(src)<<endl;
        return ;
    }
    vis[src]=true;
    for(int i=0;i<graph[src].size();i++){
        int nbr=graph[src][i]->v;
        if(!vis[nbr])
        hashpath(nbr,dest,vis,ans+to_string(src)+"->");
    }return;
}
void allpath(int src,int dest,int wt,vector<bool> &vis,string ans){
    if(src==dest){
        cout<<ans+to_string(src)<<"@"<<wt<<endl;
        return ;
    }
    vis[src]=true;
    for(int i=0;i<graph[src].size();i++){
     int nbr=graph[src][i]->v;
     int w=graph[src][i]->w;
     if(!vis[nbr])
     allpath(nbr,dest,wt+w,vis,ans+to_string(src)+"->");   
    }
    vis[src]=false;
    return;
}
int sw=1e8;
string sssf="";

int lw=-1;
string lssf="";

void maxminpaths(int src,int dest,int wt,vector<bool>vis,string ans){
    if(src==dest){
        if(sw>wt){
            sw=wt;
            sssf=ans;
        }
        if(lw<wt){
            lw=wt;
            lssf=ans;
        }
    }
    vis[src]=true;
    for(edge *e:graph[src]){
        if(!vis[e->v])
        maxminpaths(e->v,dest,wt+ e->w,vis,ans+to_string(src)+"->");
    }
    vis[src]=false;
}
void dfs(int src, vector<bool>vis){
    vis[src]=true;
    for (edge *e : graph[src]){
    if (!vis[e->v])
            dfs(e->v, vis);
}
}
void noofcomponents(){
    vector<bool>vis(n,false);
    int count=0;
    for(int i=0;i<n;i++){
        if(!vis[i]){
            count++;
            dfs(i,vis);
        }
    }
    cout<<count;
}



void display(){
    
    for(int i=0;i<graph.size();i++){
      cout<<i<<"-> ";
        for(int j=0;j<graph[i].size();j++){
            edge *e=graph[i][j];
           cout<< "(" << e->v << "," << e->w  <<")";
        }
        cout<<endl;
    }
}
void bfs(int src){
    queue<int>que;
    vector<bool>vis(n,false);
    que.push(src);
    que.push(-1);
    int cycle=0;
    int level=0;
    int dest=6;
    while(que.size()!=1){
        int rvtx=que.front();
        que.pop();

      

        if(vis[rvtx]){
            cycle++;
            cout<<"cycle:"<<cycle<<"@"<<rvtx<<endl;
            continue;
        }
        
        if(rvtx==dest){
            cout<<"goal:"<<level<<endl;
        }
        vis[rvtx]=true;
        for(edge *e:graph[rvtx]){
            if(!vis[e->v])
            que.push(e->v);
            
        }
        
          if(que.front()==-1){
                level++;
                que.pop();
                que.push(-1);
            }
    }
}
void bfs2(int src){
    queue<int>que;
    vector<bool>vis(n,false);
    que.push(src);
    bool isdest=false;
    int cycle=0;
    int level=0;
    int dest=6;
    while(que.size()!=1){
        int size=que.size();
        while(size-->0){
            int rvtx=que.front();
            que.pop();
        //confusion
         if(vis[rvtx]){
            cycle++;
            cout<<"cycle:"<<++cycle<<"@"<<rvtx<<endl;
            continue;
        }
        
        if(rvtx==dest && !isdest){
            cout<<"goal:"<<level<<endl;
            isdest=true;  
        }
        vis[rvtx]=true;
        for(edge *e:graph[rvtx]){
            if(!vis[e->v])
            que.push(e->v);
            
        }
    }
    level++;
}
}
/*void hamiltonianpath(int src,vector<bool>vis,string ans,int count,int c){
    if(count==7){
        return ;
    }
        if(!vis[src+count]){

            vis[src+count]=true;
            if(src==6)
            c+=src;
         hamioltonianpath(0,vis,ans+" "+src);
            else
         hamioltonianpath(src+1,vis,ans+" "+src);

        }
        return ;
        if(c==21)
        cout<<ans<<endl;
}*/
int hamiltonianpath(int vtx,int osrc,int vtxcount,vector<bool> & vis,string ans){
    if(vtxcount==graph.size()-1){
        bool flag=false;
        for(edge *e: graph[vtx]){
            if(e->v==osrc){
                cout<<"cycle:"<<ans+to_string(vtx)<<endl;
                flag=true;
            }
        }
        if(!flag)
        cout<<"path:"<<ans+to_string(vtx)<<endl;
        return 1;
    }

    vis[vtx]=true;
    for (edge *e : graph[vtx]){
    if (!vis[e->v])
    {

            hamiltonianpath(e->v,osrc,vtxcount+1, vis,ans+to_string(vtx));
    }
} 
vis[vtx]=false;
}
bool isbipartite(int i,vector<int>& vis){
queue<pair<int,int>>que;
bool flag=true;
que.push({i,0});
while(graph.size()!=0){
    pair<int,int>rvtx=que.front();
    que.pop();
    if(vis[rvtx.first]!=-1){
        if(vis[rvtx.first]!=rvtx.second){
            cout<<"conflict"<<endl;
            flag=false;

        }
        continue;
    }
    vis[rvtx.first]=rvtx.second;
    for(edge *e:graph[rvtx.first]){
        if(vis[e->v]==-1){
            que.push({e->v,(rvtx.second+1)%2});
         }
        }
    }
    return flag;
} 
void bipartite(){
vector<int>vis(graph.size(),-1);
int count=0;
for(int i=0;i<graph.size();i++){
    if(vis[i]==-1){
   cout<<count<<" "<<(boolalpha)<< isbipartite(i,vis)<<endl;
   count++;
    }
}
}
void toposort(int src,vector<bool> & vis,vector<int> & stack){
vis[src]=true;
for(edge *e:graph[src]){
    if(!vis[e->v])
    toposort(e->v,vis,stack);
}
stack.push_back(src);
}
void topologicalsort(){
    vector<bool>vis(graph.size(),false);
    vector<int>stack;
    for(int i=0;i<n;i++){
        if(!vis[i])
        toposort(i,vis,stack);
    }
    while(stack.size()!=0){
        cout<<stack.back()<<" ";
        stack.pop_back();
    }
}


int main(){
    
    // display();
   // removeedge(3,4);

    // removevtx(3);
//    int n=7;
   constructgraph();
   //vector<bool>vis(n,false);
  // hashpath(0,6,vis,"");
 // allpath(0,6,0,vis,"");
 //maxminpaths(0,6,0,vis,"");
 //cout<<"min. weight  "<<sssf<<" @"<<sw<<endl;
 //cout<<"max. weight  "<<lssf<<" @"<<lw;
    //display();
  // bfs(0);
   //bfs2(0);
  /* for(int i=0;i<=6;i++){

  hamioltonianpath(0,vis,"",0,0);

   }*/
  // hamiltonianpath(0,0,0,vis,"");
//bipartite();
//topologicalsort();

}