class Solution {

    private int[] segTree; // Segment Tree


    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
         int n = heights.length;
        segTree = new int[4 * n + 1];
        int stIdx = 1; // Segment Tree Index: Root at index 1

        buildSegmentTree(heights, 0, n - 1, stIdx);

        List<Integer> res = new ArrayList<>();
        for (int[] query : queries) {
            int alice = Math.min(query[0], query[1]);
            int bob = Math.max(query[0], query[1]);

            if (alice == bob || heights[bob] > heights[alice]) {
                res.add(bob);
                continue;
            }

            // Binary Search + RMQ (Range Max Query)
            int low = bob, high = n - 1, ans = Integer.MAX_VALUE;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int rmq = rangeMaxQuery(heights, low, mid, 0, n - 1, stIdx);

                if (heights[rmq] > heights[alice]) {
                    high = mid - 1;
                    ans = Math.min(ans, rmq);
                } else {
                    low = mid + 1;
                }
            }
            res.add(ans == Integer.MAX_VALUE ? -1 : ans);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }


       private void buildSegmentTree(int[] heights, int start, int end, int stIdx) {
    // Base case: Leaf node
    if (start == end) {
        segTree[stIdx] = start;
        return;
    }

    int mid = start + (end - start) / 2;

    // Recursively build the left and right subtrees
    int leftChild = 2 * stIdx;
    int rightChild = leftChild + 1;

    buildSegmentTree(heights, start, mid, leftChild);
    buildSegmentTree(heights, mid + 1, end, rightChild);

    // Compare indices of left and right children in the heights array
    segTree[stIdx] = heights[segTree[leftChild]] >= heights[segTree[rightChild]]
                     ? segTree[leftChild]
                     : segTree[rightChild];
}


  private int rangeMaxQuery(int[] heights, int qs, int qe, int start, int end, int stIdx) {
        if (start >= qs && end <= qe) // Total Overlap
            return segTree[stIdx];
        if (start > qe || end < qs) // No Overlap
            return Integer.MIN_VALUE;

        // Partial Overlap
        int mid = start + (end - start) / 2;
        int leftMax = rangeMaxQuery(heights, qs, qe, start, mid, 2 * stIdx);
        int rightMax = rangeMaxQuery(heights, qs, qe, mid + 1, end, 2 * stIdx + 1);

        if (leftMax == Integer.MIN_VALUE) return rightMax;
        if (rightMax == Integer.MIN_VALUE) return leftMax;

        return heights[leftMax] >= heights[rightMax] ? leftMax : rightMax;
    }

}