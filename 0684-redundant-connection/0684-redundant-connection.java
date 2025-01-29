class Solution {

            // Find function with path compression
       static int find(int x, int parent[]) {
            if (parent[x] != x) {
                parent[x] = find(parent[x],parent); // Path compression
            }
            return parent[x];
        }

               // Union function to merge two sets
       static boolean union(int x, int y,int parent[]) {
            int rootX = find(x,parent);
            int rootY = find(y,parent);
            if (rootX == rootY) {
                return false; // Cycle detected
            }
            parent[rootX] = rootY; // Union the sets
            return true;
        };

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        // Initialize the parent and rank arrays
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }



 

        // Process each edge
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1],parent)) {
                return edge; // This edge forms a cycle
            }
        }

        return new int[0]; // Should never reach here
    }
}