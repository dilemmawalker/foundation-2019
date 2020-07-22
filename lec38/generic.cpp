#include<vector>
#include<stack>
#include<iostream>
using namespace std;
class Node{
    public:
int data=0;
vector<Node*>childs;
Node(){

}
Node(int data){
    this->data=data;
}

};
Node *createtree(vector<int>&arr){
    stack<Node *>st;
    for(int  i=0;i<arr.size()-1;i++){
        if(arr[i]!=-1){
            Node* node=new Node(arr[i]);
            st.push(node);
        }
        else{
            Node *node=st.top();
            st.pop();
            st.top()->childs.push_back(node);
        }
    }
    return st.top();
}
display(Node *node){
    cout<<node->data<<" -> ";
    for(Node *child:node->childs){
        cout<<child->data<<", "<<endl;
    }
    for(Node *child:node->childs){
        display(child);
    }
}
/*
Node* linearize2(Node *node){
if(node->child.size()==0){
    return node;
}
Node *mytail=linearize2(node->childs.back());
for(int i=node->childs.size()-2;i>=0;i--){
Node *tail=linearize2(node->childs[i]);
tail->childs.push_back(node->childs.back());

node->childs.pop_back();
}
return mytail;
}*/
bool issymmetric(Node*node1,Node *node2){
    if(node1->childs.size()!=node2->childs.size())
    return false; 

    for(int i=0,j=node2->childs.size()-2;i<=j;i++,j--){
        Node *child1=node1->childs[i];
        Node *child2=node2->childs[j];
        if(!issymmetric(child1,child2))
        return false;

    }
    return true;
}

bool mirror(Node*node1,Node *node2){
    if(node1->childs.size()!=node2->childs.size())
    return false; 
    for(int i=0,j=node2->childs.size()-2;i<=j;i++,j--){
        Node *child1=node1->childs[i];
        Node *child2=node2->childs[j];
        if(child1!=child2)
        return false;
    }

    for(int i=0,j=node2->childs.size()-2;i<=j;i++,j--){
        Node *child1=node1->childs[i];
        Node *child2=node2->childs[j];
        if(! mirror(child1,child2)){
            return false;
        }
        
    }
    return true;
}
Node *traversal(Node node1,Node node2){
    
}
int main(){
    vector<int>arr{10,20,50,-1,60,-1,-1,30,70,-1,80,100,-1,110,-1,-1,90,-1,-1,40,5,-1,4,-1,-1};
    Node *node=createtree(arr);
   // display(node);
   cout<<issymmetric(node,node);
   cout<< mirror(node,node);
   return 0;
}