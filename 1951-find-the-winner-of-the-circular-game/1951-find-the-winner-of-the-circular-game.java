class Solution {



public int findTheWinner(int n, int k) {
    int winner = 0; // Base case: 0-based index when there's only one person
    for (int i = 2; i <= n; i++) {
        winner = (winner + k) % i;
    }
    return winner + 1; // Convert to 1-based index
}



//below code is with recursion
    public int findTheWinner_recursion(int n, int k) {
        
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