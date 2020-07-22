 import java.util.PriorityQueue;
 import java.util.HashMap;
 public class huffmanED{
   private static HashMap<String,String>encode=new HashMap<>();
   private static HashMap<String,String>decode=new HashMap<>();
    private class node implements Comparable<node>{
        String data="";
        int freq;
        node left=null;
        node right=null;
        public node(String data,int freq,node left,node right){
            this.data=data;
            this.freq=freq;
            this.left=left;
            this.right=right;
        }
        @Override
        public int compareTo(node o){
            return this.freq-o.freq;
        }
    }
        public huffmanED(String str){
            huffmantree(str);
        }
            public void huffmantree(String str){
        PriorityQueue<node>pq=new PriorityQueue<>();
            int[]freqmap=new int[26];
            for(int i=0;i<str.length();i++)
            freqmap[str.charAt(i)-'a']++;

            for(int i=0;i<freqmap.length;i++){
                if(freqmap[i]>0)
                pq.add(new node((char)(i+'a')+"",freqmap[i],null,null));
            }
            while(pq.size()!=1){
                node a=pq.remove();
                node b=pq.remove();
                pq.add(new node("",a.freq+b.freq,a,b));
            }
            node root=pq.remove();
            huffmantraversal(root,"");
           
        }
        public void huffmantraversal(node root,String binarycode){
            if(root.left==null && root.right==null){
                encode.put(root.data,binarycode);
                decode.put(binarycode,root.data);
                return;
            }
            huffmantraversal(root.left,binarycode+"0");
            huffmantraversal(root.right,binarycode+"1");
        }
        public String encoderstring(String str){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<str.length();i++){
                String s=str.charAt(i)+"";
                sb.append(encode.get(s));
            }
            return sb.toString();
        }
        public String decoderstring(String str){
            StringBuilder sb=new StringBuilder();
            int i=0;
            for(int j=0;j<str.length();j++){
                String s=str.substring(i,j)+"";
               if( decode.containsKey(s)){
                sb.append(s);
                i=j;
               }
            }
            return sb.toString();
        }

    
    
}