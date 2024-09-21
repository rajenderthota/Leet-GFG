class Solution {
    public int hIndex(int[] citations) {
    //       int n = citations.length;
    // Arrays.sort(citations);

    // for (int i = n - 1; i >= 0; i--) {
    //     if (citations[i] >= n - i) {
    //         return n - i;
    //     }
    // }

    // return 0;


     int n = citations.length;
    Arrays.sort(citations);
    
    for (int i = 0; i < n; i++) {
        if (citations[i] >= n - i) {
            return n - i;
        }
    }
    
    return 0;
    }
}