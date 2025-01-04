class Solution {

//using que approach

 public int findTheWinner(int n, int k) {
        // Create a queue to represent the circle of friends
        Queue<Integer> queue = new LinkedList<>();

        // Add all friends (1 to n) to the queue
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        // Simulate the process
        while (queue.size() > 1) {
            // Move the first k-1 people to the back of the queue
            for (int i = 1; i < k; i++) {
                queue.add(queue.poll());
            }
            // Remove the k-th person
            queue.poll();
        }

        // The last remaining person is the winner
        return queue.peek();
    }


//below is iterative approach 
public int findTheWinner_iterative(int n, int k) {
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