class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
      // Build adjacency list for the tree
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // To track visited nodes
        boolean[] visited = new boolean[n];
        
        // Number of valid components
        int[] componentCount = {0};

        // Perform DFS from the root (node 0)
        long totalSum = dfs(0, graph, values, k, visited, componentCount);

        // If the total sum is divisible by k, the entire tree is a valid component
        if (totalSum % k == 0) {
            componentCount[0]++;
        }

        return componentCount[0];
    }

    private long dfs(int node, List<List<Integer>> graph, int[] values, int k, boolean[] visited, int[] componentCount) {
        visited[node] = true;
        long subtreeSum = values[node]; // Current node's value
        
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                // Get the sum of the subtree rooted at the neighbor
                long childSum = dfs(neighbor, graph, values, k, visited, componentCount);

                // If the child sum is divisible by k, we can split here
                if (childSum % k == 0) {
                    componentCount[0]++;
                } else {
                    // Otherwise, add the child's sum to the current node's sum
                    subtreeSum += childSum;
                }
            }
        }
        
        return subtreeSum;
    }
}