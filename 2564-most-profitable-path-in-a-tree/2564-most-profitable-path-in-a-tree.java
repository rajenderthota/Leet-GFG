class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
     int n = amount.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        int[] bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        getBobTime(graph, bob, 0, 0, bobTime, new boolean[n]);
        
        return getMaxProfit(graph, 0, 0, 0, bobTime, new boolean[n], amount);
    }
    
    private boolean getBobTime(List<Integer>[] graph, int node, int parent, int time, int[] bobTime, boolean[] visited) {
        visited[node] = true;
        bobTime[node] = time;
        
        if (node == 0) return true;
        
        for (int neighbor : graph[node]) {
            if (!visited[neighbor] && getBobTime(graph, neighbor, node, time + 1, bobTime, visited)) {
                return true;
            }
        }
        
        bobTime[node] = Integer.MAX_VALUE;
        return false;
    }
    
    private int getMaxProfit(List<Integer>[] graph, int node, int time, int parent, int[] bobTime, boolean[] visited, int[] amount) {
        visited[node] = true;
        
        int profit = 0;
        if (time < bobTime[node]) {
            profit = amount[node];
        } else if (time == bobTime[node]) {
            profit = amount[node] / 2;
        }
        
        int maxChildProfit = Integer.MIN_VALUE;
        boolean isLeaf = true;
        
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                isLeaf = false;
                maxChildProfit = Math.max(maxChildProfit, getMaxProfit(graph, neighbor, time + 1, node, bobTime, visited, amount));
            }
        }
        
        return profit + (isLeaf ? 0 : maxChildProfit);
    }
}