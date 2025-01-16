class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
         int xor1 = 0, xor2 = 0;

        // Compute the XOR of all elements in nums1
        for (int num : nums1) {
            xor1 ^= num;
        }

        // Compute the XOR of all elements in nums2
        for (int num : nums2) {
            xor2 ^= num;
        }

        int result = 0;

        // If nums2 has an odd length, each element of nums1 contributes xor2
        if (nums2.length % 2 != 0) {
            result ^= xor1;
        }

        // If nums1 has an odd length, each element of nums2 contributes xor1
        if (nums1.length % 2 != 0) {
            result ^= xor2;
        }

        return result;
    }
}