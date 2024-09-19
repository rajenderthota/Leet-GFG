class Solution {
    public boolean check(int[] nums) {

        // int left=0,right=nums.length-2;
        // boolean rotate=false;
        // HashSet<Integer> ns=new HashSet<>();

        // while(left < right){

        //     if( nums[left] <= nums[left+1]){
        //         ns.add(nums[left]);
        //         left++;
                
        //     }else{
        //         if(rotate || left == 0 || (nums[0] != nums[left+1] && ns.contains(nums[left+1] )))
        //         return false;
        //         rotate=true;
        //         left++;
        //     }

        // }
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if( nums[i] > nums[(i+1)%n]){
                count++;
            }
        }

       // If there is more than one "break", it is not sorted and rotated
        if (count > 1) {
            return false;
        }

        // Check if all elements are the same
        boolean allEqual = true;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[0]) {
                allEqual = false;
                break;
            }
        }

        return allEqual || count ==1;
    }
}