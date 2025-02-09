class Solution {


    //optimized approach 
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        long totalPairs = 0, goodPairs = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            goodPairs += freqMap.getOrDefault(diff, 0);
            freqMap.put(diff, freqMap.getOrDefault(diff, 0) + 1);
        }

        totalPairs = (long) n * (n - 1) / 2; // nC2 total pairs
        return totalPairs - goodPairs; // Bad pairs = Total pairs - Good pairs
    }


    //below implemenation bruteforce
    public long countBadPairs_bruteforce(int[] nums) {
        
        int n=nums.length;
        long result=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                 if( j -i != nums[j]-nums[i]){
                    result++;
                 }
            }
        }

        return result;
    }
}