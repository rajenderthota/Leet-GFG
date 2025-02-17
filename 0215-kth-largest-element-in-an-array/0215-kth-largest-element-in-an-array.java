class Solution {


     public int findKthLargest(int[] nums, int k) {

        int n=nums.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>(k);
        for(int i=0;i<k;i++){
            pq.offer(nums[i]);
        }
        for(int i=k;i<n;i++){
            if(pq.peek() < nums[i]){
                pq.poll();
                pq.offer(nums[i]);
            }

        }
        return pq.poll();
     }


    public int findKthLargest_quickSelect(int[] nums, int k) {
        
        return quickSelect(nums,0,nums.length-1,k);
    }


    // Function to find the k-th smallest element
    public  int quickSelect(int[] arr, int low, int high, int k) {


         // find the partition
        int partition = partition(arr, low, high);

        // if partition value is equal to the kth position,
        // return value at k.
        if (partition == k - 1)
            return arr[partition];

        // if partition value is less than kth position,
        // search right side of the array.
        else if (partition > k - 1)
             return quickSelect(arr, low, partition - 1, k);


        // if partition value is more than kth position,
        // search left side of the array.
        else
           return quickSelect(arr, partition + 1, high, k);
        // if (left == right) return arr[left]; // Base case

        // int pivotIndex = partition(arr, left, right); // Partition the array

        // if (pivotIndex == k) return arr[pivotIndex]; // Found the k-th smallest element
        // else if (pivotIndex > k) return quickSelect(arr, left, pivotIndex - 1, k); // Search left
        // else return quickSelect(arr, pivotIndex + 1, right, k); // Search right
    }


 // Lomuto Partition Scheme (chooses last element as pivot)
    private  int partition(int[] arr, int low, int high) {
        // int pivot = arr[right]; 
        // int i = left; // Index for smaller elements

        // for (int j = left; j < right; j++) {
        //     if (arr[j] < pivot) { // Move smaller elements to the left
        //         swap(arr, i, j);
        //         i++;
        //     }
        // }
        // swap(arr, i, right); // Place pivot in its correct position
        // return i;


        int pivot = arr[high], pivotloc = low;
        for (int i = low; i <= high; i++) {
            // inserting elements of less value
            // to the left of the pivot location
            if (arr[i] > pivot) {
                int temp = arr[i];
                arr[i] = arr[pivotloc];
                arr[pivotloc] = temp;
                pivotloc++;
            }
        }

        // swapping pivot to the final pivot location
        int temp = arr[high];
        arr[high] = arr[pivotloc];
        arr[pivotloc] = temp;

        return pivotloc;
    }


    private void swap(int[] arr, int left, int right){

        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }
}