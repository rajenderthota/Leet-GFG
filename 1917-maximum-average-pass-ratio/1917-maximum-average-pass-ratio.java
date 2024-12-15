class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {

      // Max heap based on the gain of pass ratio
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> 
            Double.compare(b[2], a[2])); // Sort based on gain (descending)
        
        // Step 1: Calculate initial gain for each class and add to the heap
        for (int[] c : classes) {
            int pass = c[0];
            int total = c[1];
            double gain = gain(pass, total);
            maxHeap.offer(new double[]{pass, total, gain});
        }
        
        // Step 2: Distribute extra students
        for (int i = 0; i < extraStudents; i++) {
            double[] top = maxHeap.poll(); // Get the class with max gain
            int pass = (int) top[0];
            int total = (int) top[1];
            // Update class with one more passing student
            pass++;
            total++;
            // Recalculate the gain and push back into the heap
            double newGain = gain(pass, total);
            maxHeap.offer(new double[]{pass, total, newGain});
        }
        
        // Step 3: Calculate the final average pass ratio
        double totalRatio = 0.0;
        while (!maxHeap.isEmpty()) {
            double[] c = maxHeap.poll();
            totalRatio += c[0] / c[1];
        }
        
        return totalRatio / classes.length;
        
    }


     // Method to calculate the gain in pass ratio by adding one student
    private double gain(int pass, int total) {
        return ((double)(pass + 1) / (total + 1)) - ((double) pass / total);
    }
}