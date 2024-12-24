class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        
        // return minDiameterAfterMerging(edges1,edges2);
        return findMinDiameterAfterMerging(edges1,edges2);
    }



    //*******second solution start from here */


public static int findMinDiameterAfterMerging(int[][] edges1, int[][] edges2) {
        // Build adjacency lists for the trees
        List<List<Integer>> tree1 = buildTree(edges1);
        List<List<Integer>> tree2 = buildTree(edges2);

        // Find diameters and centers of both trees
        int[] result1 = findDiameter(tree1);
        int diameter1 = result1[0];
        int center1 = result1[1];

        int[] result2 = findDiameter(tree2);
        int diameter2 = result2[0];
        int center2 = result2[1];

        // Calculate the new diameter
        int newDiameter = Math.max(
            Math.max(diameter1, diameter2),
            (diameter1 + 1) / 2 + (diameter2 + 1) / 2 + 1
        );

        return newDiameter;
    }

    private static  List<List<Integer>> buildTree(int[][] edges) {
        int n = edges.length + 1; // Nodes are 0-indexed
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        return tree;
    }

    private static int[] findDiameter(List<List<Integer>> tree) {
        // Step 1: Find the farthest node from an arbitrary node (node 0)
        int[] farthest1 = bfs(tree, 0);

        // Step 2: Find the farthest node from that node
        int[] farthest2 = bfs(tree, farthest1[1]);

        // Diameter length and center node
        int diameter = farthest2[0];
        int center = farthest2[1];
        return new int[]{diameter, center};
    }

    private static int[] bfs(List<List<Integer>> tree, int start) {
        int n = tree.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        int farthestNode = start;
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                farthestNode = node;
                for (int neighbor : tree.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            distance++;
        }

        return new int[]{distance - 1, farthestNode};
    }

    // **** second solution ends here 

 // Method to find the diameter and height of a tree using two BFS calls
    public static int[] findDiameterAndHeight(int n, List<List<Integer>> adj) {
        // BFS to find the farthest node from an arbitrary node
        int[] distFromFirst = bfs(0, adj, n);
        int farthestNode = 0;
        for (int i = 0; i < n; i++) {
            if (distFromFirst[i] > distFromFirst[farthestNode]) {
                farthestNode = i;
            }
        }

        // BFS from the farthest node to find the diameter
        int[] distFromFarthest = bfs(farthestNode, adj, n);
        int diameter = 0;
        for (int d : distFromFarthest) {
            diameter = Math.max(diameter, d);
        }

        // Find the maximum distance (height) from the farthest node (rooted at that node)
        int height = 0;
        for (int d : distFromFarthest) {
            height = Math.max(height, d);
        }

        return new int[]{diameter, height};
    }

    // BFS function to return the distance from the source node
    private static int[] bfs(int src, List<List<Integer>> adj, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[src] = 0;
        queue.offer(src);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        return dist;
    }

    public static int minDiameterAfterMerging(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        // Build the adjacency list for both trees
        List<List<Integer>> adj1 = buildAdjacencyList(edges1, n);
        List<List<Integer>> adj2 = buildAdjacencyList(edges2, m);

        // Find diameter and height of both trees
        int[] tree1 = findDiameterAndHeight(n, adj1); // [diameter1, height1]
        int[] tree2 = findDiameterAndHeight(m, adj2); // [diameter2, height2]

        // Maximum of the two diameters or the sum of the two heights + 1 (for the new edge)
        return Math.max(Math.max(tree1[0], tree2[0]), tree1[1] + tree2[1] + 1);
    }

    // Helper method to build adjacency list from edges
    private static List<List<Integer>> buildAdjacencyList(int[][] edges, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }

}