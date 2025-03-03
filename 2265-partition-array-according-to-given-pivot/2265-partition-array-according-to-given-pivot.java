class Solution {
    public int[] pivotArray(int[] nums, int pivot) {

       ArrayList<Integer> lessList = new ArrayList<>();
        ArrayList<Integer> equalList = new ArrayList<>();
        ArrayList<Integer> greaterList = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) {
                lessList.add(num);
            } else if (num == pivot) {
                equalList.add(num);
            } else {
                greaterList.add(num);
            }
        }

        lessList.addAll(equalList);
        lessList.addAll(greaterList);

        // Convert to array
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = lessList.get(i);
        }

        return arr;
    }
}