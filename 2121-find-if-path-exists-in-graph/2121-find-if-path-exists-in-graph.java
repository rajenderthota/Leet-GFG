class Solution {

     // Parent array that stores the root of each node's tree in the disjoint set forest

    private int[] parent;
    public boolean validPath(int n, int[][] edges, int source, int destination) {

   // Initialize the parent array where each node is initially its own parent (representative of its own set)

        parent = new int[n];

        for (int i = 0; i < n; ++i) {

            parent[i] = i;

        }

      

        // Union operation: merge the sets containing the two nodes of each edge

        for (int[] edge : edges) {

            parent[find(edge[0])] = find(edge[1]);

        }

      

        // If the source and destination nodes have the same parent/root, they are connected; otherwise, they are not

        return find(source) == find(destination);

    }


    // Method to find the root of the set that contains node x utilizing path compression for efficiency

    private int find(int x) {

        if (parent[x] != x) { // If x is not its own parent, it's not the representative of its set

            parent[x] = find(parent[x]); // Recurse to find the root of the set and apply path compression

        }

        return parent[x]; // Return the root of the set that contains x

    }





//-----------------different solution below
    public boolean validPath1(int n, int[][] edges, int source, int destination) {
        if(edges.length == 0) return true;
        boolean[] visited = new boolean[n];
        boolean flag = true;
        visited[source] = true;
    while(flag){
        flag = false;
        for(int[] edge : edges){
            if(visited[edge[0]] != visited[edge[1]]){
                visited[edge[0]] = true;
                visited[edge[1]] = true;
                flag = true;
            }
            if(visited[destination]) return true;
        }
    }
    return false;
    }
}