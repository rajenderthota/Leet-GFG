class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
         // Step 1: Initialize a boolean adjacency matrix
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];
        
        // Step 2: Fill the adjacency matrix with the given prerequisites
        for (int[] prerequisite : prerequisites) {
            int courseA = prerequisite[0];
            int courseB = prerequisite[1];
            isPrerequisite[courseA][courseB] = true;
        }
        
        // Step 3: Use Floyd-Warshall algorithm to compute transitive closure
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (isPrerequisite[i][k] && isPrerequisite[k][j]) {
                        isPrerequisite[i][j] = true;
                    }
                }
            }
        }
        
        // Step 4: Answer the queries
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            int courseU = query[0];
            int courseV = query[1];
            result.add(isPrerequisite[courseU][courseV]);
        }
        
        return result;
    }
}