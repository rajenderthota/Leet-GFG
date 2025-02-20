class Solution {
    public String findDifferentBinaryString(String[] nums) {
         int n = nums.length;
        StringBuilder result = new StringBuilder();
        
        // Using Cantor's diagonalization method
        for (int i = 0; i < n; i++) {
            // Flip the i-th bit of nums[i] to ensure uniqueness
            result.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        
        return result.toString();
    }
}