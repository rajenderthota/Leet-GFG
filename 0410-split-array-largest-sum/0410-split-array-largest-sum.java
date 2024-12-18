class Solution {



 public int splitArray(int[] nums, int k) {
        int n = nums.length;

        // Initialize memoization array
        memo = new int[n][k + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Precompute prefix sums for efficient range sum calculation
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Start the recursive process
        return dfs(nums, prefixSum, 0, k);
    }

    private int[][] memo;

    private int dfs(int[] nums, int[] prefixSum, int idx, int k) {
        int n = nums.length;

        // Base case: if we're at the end of the array and no partitions left
        if (idx == n) {
            return k == 0 ? 0 : Integer.MAX_VALUE;
        }

        // Base case: if no partitions are left but there are remaining elements
        if (k == 0) {
            return Integer.MAX_VALUE;
        }

        // Check memoization
        if (memo[idx][k] != -1) {
            return memo[idx][k];
        }

        int minLargestSum = Integer.MAX_VALUE;

        // Try splitting the array at different points
        for (int end = idx; end < n; end++) {
            int currentSum = prefixSum[end + 1] - prefixSum[idx];
            int nextPartition = dfs(nums, prefixSum, end + 1, k - 1);

            if (nextPartition == Integer.MAX_VALUE) {
                continue; // Invalid partition
            }

            // Minimize the largest sum among all partitions
            minLargestSum = Math.min(minLargestSum, Math.max(currentSum, nextPartition));

            // Prune: If the current sum exceeds the current minimum, stop further splits
            if (currentSum > minLargestSum) {
                break;
            }
        }

        // Store result in memo and return
        return memo[idx][k] = minLargestSum;
    }



    public int splitArray1(int[] nums, int k) {
        this.memo1=new HashMap<>();
        recursion(nums,0, k, 0, 0);
        
        return ans;
    }

    int ans = Integer.MAX_VALUE;
    Map<String, Integer> memo1;
    public void recursion( int[] nums,int idx, int k, int runningSum, int max){

        // if(idx == nums.length){
        //     if(k == 1){
        //         ans = Math.min(ans, max);
        //     } 
        //     return;
        // }

        // recursion( nums,idx + 1, k, runningSum + nums[idx], Math.max(max, runningSum + nums[idx]));
        // recursion( nums, idx + 1, k - 1, nums[idx], Math.max(max, Math.max(runningSum, nums[idx])));


          // Base case: if we've used all elements
        if (idx == nums.length) {
            if (k == 1) {
                ans = Math.min(ans, max);
            }
            return;
        }

        // Create a unique key for memoization
        String key = idx + "," + k + "," + runningSum + "," + max;

        // Check if the result is already computed
        if (memo1.containsKey(key)) {
            return;
        }

        // Recursive calls
        recursion(nums, idx + 1, k, runningSum + nums[idx], Math.max(max, runningSum + nums[idx]));
        if (k > 1) {
            recursion(nums, idx + 1, k - 1, nums[idx], Math.max(max, Math.max(runningSum, nums[idx])));
        }

        // Store the result in the memoization map
        memo1.put(key, ans);
    }
}