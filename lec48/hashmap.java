import java.util.HashMap;
import java.util.ArrayList;
public class hashmap{
    public static void main(String[]args){
        //hashmap1();
        //hashmap2("sxdcfvghdjksdc");
        hashmap3("sxdcfvghdjksdc");
    }
    public static void hashmap1(){
        HashMap<String,Integer>map=new HashMap<>();
        map.put("USA",100);
        map.put("india",800);
        map.put("brazil",50);

        System.out.println(map);
    }
    public static void hashmap2(String str){
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        System.out.print(map);
    }
    public static void hashmap3(String str){
        HashMap<Character,ArrayList<Integer>>map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(!map.containsKey(ch))
            map.put(ch,new ArrayList<>());

            map.get(ch).add(i);
        }
        for(Character ch:map.keySet()){
            System.out.println(ch+"->"+map.get(ch));
        }
    }
    public static void hashmap4(int[] arr){
        HashMap<Integer,Integer>map=newHashMap<>();
        for(int i=0;i<arr.length;i++){
            
        }
    }

}