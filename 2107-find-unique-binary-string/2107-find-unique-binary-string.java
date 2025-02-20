class Solution {


//using backtracking

public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        for (String num : nums) {
            set.add(num);
        }
        
        StringBuilder sb = new StringBuilder();
        return backtrack(set, sb, nums.length);
    }
    
    private String backtrack(Set<String> set, StringBuilder sb, int n) {
        if (sb.length() == n) {
            String candidate = sb.toString();
            if (!set.contains(candidate)) {
                return candidate;
            }
            return null;
        }
        
        sb.append('0');
        String result = backtrack(set, sb, n);
        if (result != null) return result;
        sb.setLength(sb.length() - 1);
        
        sb.append('1');
        result = backtrack(set, sb, n);
        if (result != null) return result;
        sb.setLength(sb.length() - 1);
        
        return null;
    }

//end of the backtracking


//bruteforce
 public String findDifferentBinaryString_bruteforce(String[] nums) {
        int n = nums.length;
        Set<String> set = new HashSet<>();
        for (String num : nums) {
            set.add(num);
        }
        
        for (int i = 0; i < (1 << n); i++) {
            String candidate = String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');
            if (!set.contains(candidate)) {
                return candidate;
            }
        }
        
        return "";
    }
    

    // most efficient way
    public String findDifferentBinaryString_eff(String[] nums) {
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