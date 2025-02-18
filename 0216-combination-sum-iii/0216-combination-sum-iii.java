class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
      List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> slate, int k, int target, int start) {
        // Backtracking case
        if (slate.size() > k || target < 0) {
            return;
        }
        if (slate.size() == k && target == 0) {
            result.add(new ArrayList<>(slate));
            return;
        }

        // Recursive case
        for (int i = start; i <= 9; i++) {
            slate.add(i);
            backtrack(result, slate, k, target - i, i + 1);
            slate.remove(slate.size() - 1); // Backtrack
        }
    }

}