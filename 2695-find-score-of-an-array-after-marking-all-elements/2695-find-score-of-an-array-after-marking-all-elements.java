class Solution {

    public long findScore(int[] nums){
         // Priority Queue to store elements with their indices sorted by value and index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // Fill the priority queue
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        boolean[] marked = new boolean[nums.length]; // Tracks marked elements
        long score = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int value = current[0];
            int index = current[1];

            // If already marked, skip
            if (marked[index]) {
                continue;
            }

            // Add to score
            score += value;

            // Mark the current element and its neighbors
            marked[index] = true;
            if (index > 0) {
                marked[index - 1] = true;
            }
            if (index < nums.length - 1) {
                marked[index + 1] = true;
            }
        }

        return score;
    }



        public long findScore_v2(int[] nums) {

     // find array size
        int n = nums.length, m = n / 3 + 1;
        long result = 0;
        Set<Integer> visitedIndx = new HashSet<>();

        Map<Integer,Integer> freqMap=new HashMap<Integer,Integer>();

        for(int i=0;i<n;i++){
            if(freqMap.containsKey(nums[i])){
                freqMap.put(nums[i], freqMap.get(nums[i])+1);
            }else{
                freqMap.put(nums[i], 1);
            }
        }

         int aux[]=Arrays.copyOf(nums, n);
            Arrays.sort(aux);


            for(int i=0;i<n;i++){

                int currentItem= aux[i];

                if(freqMap.size() == 0)
                break;

                if(freqMap.get(currentItem) !=null && freqMap.get(currentItem) >= 1){

                    freqMap.put(currentItem,freqMap.get(currentItem)-1);

                    if(freqMap.get(currentItem) <=0)
                        freqMap.remove(currentItem);

                    for(int j=0;j<n;j++){

                        if( nums[j] == currentItem){
                            nums[j]=-1;
                            result+=currentItem;

                            if(j+1 < n && nums[j+1] != -1){
                                 freqMap.put(nums[j+1], freqMap.get(nums[j+1])-1);
                                 nums[j+1]=-1;
                                 if(freqMap.get(nums[j+1])  != null && freqMap.get(nums[j+1]) <=0)
                                    freqMap.remove(nums[j+1]);
                            }
                             if(j-1 >= 0 && nums[j-1] != -1){
                                 freqMap.put(nums[j-1], freqMap.get(nums[j-1])-1);
                                 nums[j-1]=-1;

                                 if(freqMap.get(nums[j-1])  != null && freqMap.get(nums[j-1]) <=0)
                                    freqMap.remove(nums[j-1]);
                            }


                        }
                    }

                }


            }

        // int result=0;
        // create auxilary array

           

        return result;

        }

    //below is brute force approach
    public long findScore_v1(int[] nums) {

        // find array size
        int n = nums.length, m = n / 3 + 1, result = 0;
        Set<Integer> visitedIndx = new HashSet<>();

        for (int i = 0; i < m; i++) {

            // find m sorted elements from given array

            int counter = 0;

            for (int j = 0; counter < n; counter++) {

                while (visitedIndx.contains(j))
                    j++;

                if (visitedIndx.contains(j))
                    continue;

                if (j >= n)
                    continue;

                int nextSE = nums[j], currentIndx = j;
                // int currentIndx=j;
                for (int k = 0; k < n; k++) {

                    if (nextSE == nums[k])
                        continue;

                    if (!visitedIndx.contains(k) && (nextSE > nums[k] && nextSE != nums[k])) {
                        nextSE = nums[k];
                        currentIndx = k;
                    }
                }

                result += nums[currentIndx];
                System.out.println(currentIndx + " - " + nums[currentIndx]);

                // perform actual logic here
                visitedIndx.add(currentIndx);

                if (((currentIndx + 1) < n) && !visitedIndx.contains(currentIndx + 1)) {
                    visitedIndx.add(currentIndx + 1);
                }
                // else{

                // }

                if (currentIndx - 1 >= 0 && currentIndx - 1 < n && !visitedIndx.contains(currentIndx - 1)) {
                    visitedIndx.add(currentIndx - 1);
                }

                // else{

                // }

                System.out.println(visitedIndx);
                // perform swap so that next iteration
                // int temp=nums[j];
                // nums[j]=nums[currentIndx];
                // nums[currentIndx]=temp;

                // exist if the count reach to max
                // if(j == m)
                // break;
            }

        }

        // //create map with Array element as key and its correspding adjacent index as
        // values
        // Map<Integer,List<Integer>> adjacentMap=mew HashMap<>();

        // // create Auxilary array to get the sorted elements
        // int auxNums[]= new int[n];
        // for(int i-0;i<n;i++){
        // int currentElement=nums[i]
        // auxNums[i]=currentElement;

        // // creating / updating adjacent matrix map
        // if(adjacentMap.containsKey(currentElement)){

        // adjacentMap.put(currentElement,adjacentMap.get(currentElement).add())

        // }else{

        // List<Integer> indxList=new ArrayList<>();
        // indxList.add(currentElement);

        // }
        // }

        // //sort the given array to get smallest elements
        // Arrays.sort(nums);

        // // create set to track visited indexes
        // Set<Integer> visitedIndexes=new HashSet<>();

        // for(int i=0;i<n;i++){

        // }

        return result;

    }
}