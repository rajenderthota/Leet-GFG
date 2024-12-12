class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

    //     int n=nums1.length, m= nums2.length;
    //     int rl=Math.min(n,m);
    //     int result[]=new int[rl];

    //     // HashSet<Integer> nums1Set=new HashSet<>();
    //    Set<Integer> nums1Set = Arrays.stream(nums1)
    //             .boxed() // Convert int to Integer
    //             .collect(Collectors.toSet());

    // return    Arrays.stream(nums2)
    //     .filter(nums1Set::contains)
    //     .collect(Collectors.toArray());

    Set<Integer> nums1Set = Arrays.stream(nums1) .boxed() // Convert int to Integer 
    .collect(Collectors.toSet());
     return Arrays.stream(nums2) .filter(nums1Set::contains) .distinct() .toArray();



        
        
    }
}