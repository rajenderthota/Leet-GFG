class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // List<List<Integer>> result=new ArrayList<>();
        // int len=nums.length;
        // for(int i=0;i<len;i++){
        //     for(int j=i+1;j<len;j++){
        //         List<Integer> lst=new ArrayList<>();
        //         for(int k=j+1;k<len;k++){

        //             if(nums[i]+nums[j]+nums[k] == 0){
        //                 lst.add(nums[i]);
        //                  lst.add(nums[j]);
        //                   lst.add(nums[k]);
        //             }

        //         }
        //         if(lst !=null && lst.size() >=1){
        //             result.add(lst);
        //         }
        //     }
        // }
        
        // return result;


//  List<List<Integer>> result = new ArrayList<>();
//         Arrays.sort(nums);  // Sort the array to use two-pointer technique

//         for (int i = 0; i < nums.length - 2; i++) {
//             // Avoid duplicate triplets
//             if (i > 0 && nums[i] == nums[i - 1]) continue;
            
//             int left = i + 1;
//             int right = nums.length - 1;
//             int target = 0 - nums[i];  // Target sum for the remaining two numbers
            
//             while (left < right) {
//                 int sum = nums[left] + nums[right];
//                 if (sum == target) {
//                     result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
//                     // Move left and right pointers and avoid duplicates
//                     while (left < right && nums[left] == nums[left + 1]) left++;
//                     while (left < right && nums[right] == nums[right - 1]) right--;
                    
//                     left++;
//                     right--;
//                 } else if (sum < target) {
//                     left++;  // Move left pointer to increase the sum
//                 } else {
//                     right--;  // Move right pointer to decrease the sum
//                 }
//             }
//         }
        
//         return result;



Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);  // Sort the array for ordering and to avoid duplicates
        
        for (int i = 0; i < nums.length - 2; i++) {
            Set<Integer> seen = new HashSet<>();
            int target = -nums[i];  // Target is the negative of the current element
            
            for (int j = i + 1; j < nums.length; j++) {
                int complement = target - nums[j];
                
                if (seen.contains(complement)) {
                    result.add(Arrays.asList(nums[i], complement, nums[j]));
                }
                
                seen.add(nums[j]);  // Add the current number to the set
            }
        }
        
        return new ArrayList<>(result);  // Convert the set to a list of lists

    }
}