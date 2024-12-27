class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> result = new ArrayList<>();
        // HashSet<Integer> nums1Set=new HashSet<Integer>(Arrays.asList(nums1));

        // Convert to HashSet
        HashSet<Integer> nums1Set = Arrays.stream(nums1) // Create an IntStream
                .boxed() // Convert int to Integer
                .collect(Collectors.toCollection(HashSet::new)); // Collect to HashSet

        HashSet<Integer> nums2Set = Arrays.stream(nums2) // Create an IntStream
                .boxed() // Convert int to Integer
                .collect(Collectors.toCollection(HashSet::new)); // Collect to HashSet

        List<Integer> nums1lst = new ArrayList<Integer>();
        for (Integer num1 : nums1Set) {
            if (!nums2Set.contains(num1)) {
                nums1lst.add(num1);
            }
        }

        result.add(nums1lst);
        List<Integer> nums2lst = new ArrayList<Integer>();
        for (Integer num2 : nums2Set) {
            if (!nums1Set.contains(num2)) {
                nums2lst.add(num2);
            }
        }
        result.add(nums2lst);
        return result;
    }
}