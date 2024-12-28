class Solution {
    public int singleNumber(int[] nums) {
        
        int ones = 0, twos = 0;

        for (int num : nums) {
            // Update ones and twos
            ones = (ones ^ num) & ~twos; // XOR with num and remove bits in twos
            twos = (twos ^ num) & ~ones; // XOR with num and remove bits in ones
        }

        return ones; // Unique number
    }
}