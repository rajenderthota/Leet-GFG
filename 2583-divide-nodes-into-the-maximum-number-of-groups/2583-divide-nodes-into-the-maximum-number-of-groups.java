class Solution {


  Map<Integer, List<Integer>> map;
    public int magnificentSets(int n, int[][] edges) {
        map = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        // adjacency list
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            map.get(u).add(v);
            map.get(v).add(u);
        }
        
        // get all components as Graph can be disconnected
        List<List<Integer>> components = getComponents(n);
        
        int ans = 0;
        /*
            - Take each component and get max groups can be formed from that component
            - return -1 if you can't form groups from any one of the components
        */
        for(List<Integer> component : components) {
            int groups = -1;
            for(int node : component) {
                groups = Math.max(groups, find(node, n));
            }
            if(groups == -1)
                return -1;
            ans += groups;
        }
        return ans;
    }
    
    private List<List<Integer>> getComponents(int n) {
        boolean[] visited = new boolean[n + 1];
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                ans.add(visit(i, new ArrayList<>(), visited));
            }
        }
        return ans;
    }
    
    private List<Integer> visit(int cur, List<Integer> nodes, boolean[] visited) {
        visited[cur] = true;
        nodes.add(cur);
        for(int next : map.get(cur)) {
            // skip if you have already visited this node
            if(visited[next]) continue;
            visit(next, nodes, visited);
        }
        return nodes;
    }
    
    private int find(int node, int n) {
        int[] group = new int[n + 1];
        Arrays.fill(group, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        int groups = 0;
        while(!queue.isEmpty()) {
            int k = queue.size();
            // store nodes in set to avoid duplicates
            Set<Integer> set = new HashSet<>();
            while(k-- > 0) {
                int cur = queue.poll();
                // this case occurs when 2 nodes in the same level are connected
                // so, return -1
                if(group[cur] != -1) return -1;
                group[cur] = groups;
                for(int next : map.get(cur)) {
                    if(group[next] == -1) {
                        set.add(next);
                    }
                }
            }
            queue.addAll(set);
            groups++;
        }
        return groups;
    }


    // public int magnificentSets(int n, int[][] edges) {
        
    // List<Integer>[] graph = new ArrayList[n + 1];
    //     for (int i = 1; i <= n; i++) {
    //         graph[i] = new ArrayList<>();
    //     }

    //     // Build adjacency list
    //     for (int[] edge : edges) {
    //         graph[edge[0]].add(edge[1]);
    //         graph[edge[1]].add(edge[0]);
    //     }

    //     int[] color = new int[n + 1]; // 0: unvisited, 1: color1, -1: color2
    //     Arrays.fill(color, 0);
    //     int maxGroups = 0;

    //     // Try to color the graph (Bipartite Check + BFS for levels)
    //     for (int i = 1; i <= n; i++) {
    //         if (color[i] == 0) {
    //             int maxDepth = bfs(graph, color, i);
    //             if (maxDepth == -1) return -1; // Graph is not bipartite
    //             maxGroups = Math.max(maxGroups, maxDepth);
    //         }
    //     }

    //     return maxGroups;
    // }

    // private int bfs(List<Integer>[] graph, int[] color, int start) {
    //     Queue<Integer> queue = new LinkedList<>();
    //     Map<Integer, Integer> level = new HashMap<>();
    //     queue.add(start);
    //     color[start] = 1; // Start coloring
    //     level.put(start, 1);
    //     int maxLevel = 1;

    //     while (!queue.isEmpty()) {
    //         int node = queue.poll();
    //         int currLevel = level.get(node);

    //         for (int neighbor : graph[node]) {
    //             if (color[neighbor] == 0) { // Unvisited node
    //                 color[neighbor] = -color[node]; // Alternate coloring
    //                 level.put(neighbor, currLevel + 1);
    //                 queue.add(neighbor);
    //                 maxLevel = Math.max(maxLevel, currLevel + 1);
    //             } else if (color[neighbor] == color[node]) {
    //                 return -1; // Not bipartite
    //             }
    //         }
    //     }

    //     return maxLevel;
    // }
}