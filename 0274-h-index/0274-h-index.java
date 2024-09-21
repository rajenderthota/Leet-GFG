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


    //  int n = citations.length;
    // Arrays.sort(citations);
    
    // for (int i = 0; i < n; i++) {
    //     if (citations[i] >= n - i) {
    //         return n - i;
    //     }
    // }
    
    // return 0;

//below counting sort implementation

    int n = citations.length;
    int[] count = new int[n + 1];

    // Counting Sort
    for (int citation : citations) {
        if (citation >= n) {
            count[n]++;
        } else {
            count[citation]++;
        }
    }

    int sum = 0;
    for (int i = n; i >= 0; i--) {
        sum += count[i];
        if (sum >= i) {
            return i;
        }
    }

    return 0;

    }
}