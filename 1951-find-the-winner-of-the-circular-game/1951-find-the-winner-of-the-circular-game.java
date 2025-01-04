class Solution {
    public int findTheWinner(int n, int k) {
        
        return findWinnerRecursive(n,k)+1;
    }

    private int findWinnerRecursive(int n, int k) {
    if (n == 1) {
        return 0; // Base case: if one person is left, they're the winner (0-based index)
    }
    // Recursive case: Josephus position
    return (findWinnerRecursive(n - 1, k) + k) % n;
}
}