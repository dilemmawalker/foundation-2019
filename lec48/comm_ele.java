class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        return ans(nums1,nums2);
    }
    public void ans(int[]arr1,int []arr2){
        HashMap<Integer,Boolean>map=new HashMap<>();
        for(int ar:arr1){
            map.put(ar,true);
        }
        for(int ar:arr2){
            if(map.containsKey(ar)){
                System.out.print(ele+" ");
                map.remove(ar);
            }
        }
        System.out.println();
    }
    public void ans2(int[]arr1,int[]arr2){
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int ele:arr1){
            map.put(ele,map.getOrDefault(ele,1)+1);
        }
        for(int ele:arr2){
            if(map.containsKey(ele)){
                System.out.print(ele+" ");
                if(map.get(ele)==1)
                map.remove(ele);
                else
                map.put(ele,map.get(ele)-1);
            }
        }
    }
    psvm(){
        int []a={1,2};
        int []b={2,3};
        ans(a,b);
    }

}