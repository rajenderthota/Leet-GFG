class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> numsMap=new HashMap<>();
        List<Integer> resultsArrayList=new ArrayList<>();


        for(int i=0;i<nums.length;i++){
            numsMap.put(nums[i],i);        
        }

        for(int i=0;i<nums.length;i++){
            
            if(numsMap.containsKey(target-nums[i]) && numsMap.get(target-nums[i]) != i){
                resultsArrayList.add(i);
                resultsArrayList.add(numsMap.get(nums[i]));
            }

        }

        int[] result = resultsArrayList.stream().distinct().mapToInt(i -> i).toArray();

        return result;
        
    }
}