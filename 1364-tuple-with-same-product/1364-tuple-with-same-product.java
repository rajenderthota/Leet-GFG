class Solution {
    public int tupleSameProduct(int[] nums) {
         HashMap<Integer, List<int[]>> productMap = new HashMap<>();
        int count = 0;

        // Iterate over all pairs of nums[i] and nums[j]
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];

                // If this product is already seen, generate tuples
                if (productMap.containsKey(product)) {
                    // For each previous pair with the same product, generate 8 valid tuples
                    for (int[] pair : productMap.get(product)) {
                        // Each pair can create 8 tuples
                        count += 8;
                    }
                }

                // Add the current pair to the list for this product
                productMap.computeIfAbsent(product, k -> new ArrayList<>()).add(new int[]{nums[i], nums[j]});
            }
        }

        return count;
    }
}