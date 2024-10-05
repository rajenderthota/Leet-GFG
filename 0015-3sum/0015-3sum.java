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

//below is not good compared first solution

// Set<List<Integer>> result = new HashSet<>();
//         Arrays.sort(nums);  // Sort the array for ordering and to avoid duplicates
        
//         for (int i = 0; i < nums.length - 2; i++) {
//             Set<Integer> seen = new HashSet<>();
//             int target = -nums[i];  // Target is the negative of the current element
            
//             for (int j = i + 1; j < nums.length; j++) {
//                 int complement = target - nums[j];
                
//                 if (seen.contains(complement)) {
//                     result.add(Arrays.asList(nums[i], complement, nums[j]));
//                 }
                
//                 seen.add(nums[j]);  // Add the current number to the set
//             }
//         }
        
//         return new ArrayList<>(result);  // Convert the set to a list of lists



// Arrays.sort(nums); // Sorted Array
//         List<List<Integer>> answer = new ArrayList<>();
        
//         if (nums.length < 3) {
//             return answer;
//         }
        
//         if (nums[0] > 0) {
//             return answer;
//         }
        
//         HashMap<Integer, Integer> hashMap = new HashMap<>();
        
//         for (int i = 0; i < nums.length; ++i) {
//             hashMap.put(nums[i], i);
//         }
        
//         for (int i = 0; i < nums.length - 2; ++i) {
//             if (nums[i] > 0) {
//                 break;
//             }
            
//             for (int j = i + 1; j < nums.length - 1; ++j) {
//                 int required = -1 * (nums[i] + nums[j]);
//                 if (hashMap.containsKey(required) && hashMap.get(required) > j) {
//                     answer.add(Arrays.asList(nums[i], nums[j], required));
//                 }
//                 j = hashMap.get(nums[j]);
//             }
            
//             i = hashMap.get(nums[i]);
//         }
        
//         return answer;


       List<List<Integer>> result = Collections.synchronizedList(new ArrayList<>());
        Arrays.sort(nums);  // Sort the array to use two-pointer technique

        // Use parallel stream to parallelize the outer loop (the 'i' loop)
        IntStream.range(0, nums.length - 2).parallel().forEach(i -> {
            if (i > 0 && nums[i] == nums[i - 1]) {
                return;  // Skip duplicate elements for 'i' to avoid duplicate triplets
            }

            if (nums[i] > 0) {
                return;  // No valid triplets if nums[i] is positive after sorting
            }

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        });

        return result.stream().distinct().collect(Collectors.toList());  // Ensure no duplicates in the result
    

    }
}

