class Solution {
    public boolean containsDuplicate(int[] nums) {

        // for(int i=0;i<nums.length;i++){

        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums [i] == nums[j])
        //         return true;
        //     }
        // }
        
        // return false;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
            return true;
            else
            map.put(nums[i],1);
        }   

        return false;
    }
}