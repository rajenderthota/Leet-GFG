class Solution {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2){
        // Create HashSets from nums1 and nums2
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }

        // Find elements in set1 but not in set2
        HashSet<Integer> uniqueInNums1 = new HashSet<>(set1);
        uniqueInNums1.removeAll(set2);

        // Find elements in set2 but not in set1
        HashSet<Integer> uniqueInNums2 = new HashSet<>(set2);
        uniqueInNums2.removeAll(set1);

        // Convert results to List
        List<Integer> list1 = new ArrayList<>(uniqueInNums1);
        List<Integer> list2 = new ArrayList<>(uniqueInNums2);

        // Add to result list
        List<List<Integer>> result = new ArrayList<>();
        result.add(list1);
        result.add(list2);

        return result;
    }

    public List<List<Integer>> findDifference1(int[] nums1, int[] nums2) {

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