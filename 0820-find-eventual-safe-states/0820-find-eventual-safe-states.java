class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
  int n = graph.length;
        int[] state = new int[n]; // 0 = unvisited, 1 = visiting, 2 = safe

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isSafe(i, graph, state)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean isSafe(int node, int[][] graph, int[] state) {
        if (state[node] > 0) {
            return state[node] == 2; // Return true if already determined safe
        }

        state[node] = 1; // Mark node as visiting
        for (int neighbor : graph[node]) {
            if (state[neighbor] == 1 || !isSafe(neighbor, graph, state)) {
                return false; // Found a cycle or unsafe path
            }
        }

        state[node] = 2; // Mark node as safe
        return true;
    }
}