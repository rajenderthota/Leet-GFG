class Solution {
    public long pickGifts(int[] gifts, int k) {

        // Arrays.sort(gifts);
        // int n=gifts.length,count=0,result=0;
        // for(int i=n-1;i>=0;i--){
            

        //      if(count <= k){
        //         int temp=(int) Math.sqrt(gifts[i]);
        //     result+=temp;
        //     System.out.println(count+" - "+gifts[i]+ " - "+ result);
        //     }
        //     // break;
        //     count++;
        //     result=result+gifts[i];
        // }
        // return result;



         // Sort gifts in ascending order
        // Arrays.sort(gifts);
        // int n = gifts.length;
        // long result = 0;
        
        // // Iterate from the largest gift downward
        // for (int i = n - 1; i >= 0; i--) {
        //     if (k > 0) { // Apply square root for the first k largest gifts

        //         int temp = (int) Math.sqrt(gifts[i]);

        //         while( temp >= 10){
        //             temp= (int) Math.sqrt(temp);
        //         }
        //         System.out.println(temp);
        //         result += temp;
        //         k--; // Decrement k after processing one gift
        //     } else { // Add the rest of the gifts as is
        //         result += gifts[i];
        //     }
        // }
        // return result;



         // Use a max-heap (priority queue with reverse order comparator)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add all gifts to the max-heap
        for (int gift : gifts) {
            maxHeap.add(gift);
        }

        // Perform k iterations
        for (int i = 0; i < k; i++) {
            // Extract the largest pile
            int maxGifts = maxHeap.poll();
            
            // Compute the remaining gifts and push back to heap
            int remainingGifts = (int) Math.sqrt(maxGifts);
            maxHeap.add(remainingGifts);
        }

        // Calculate the sum of remaining gifts
        long totalGifts = 0;
        while (!maxHeap.isEmpty()) {
            totalGifts += maxHeap.poll();
        }

        return totalGifts;
    }
}