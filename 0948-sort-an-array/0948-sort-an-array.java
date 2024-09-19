class Solution {
    public int[] sortArray(int[] nums) {
        
        // Arrays.sort(nums);

        //selection sort
        // int l=nums.length;
        // for(int i=0;i<l;i++){
        //     for(int j=i+1;j<l;j++){
        //         if(nums[i] > nums[j]){
        //             int temp=nums[i];
        //             nums[i]=nums[j];
        //             nums[j]=temp;
        //         }
        //     }
        // }
        // return nums;

        //merge sort implementation 


    return mergeSort(nums,0,nums.length-1);

    }



    public static int[] mergeSort(int arr[],int left, int right){


        if(left < right){

            //find middle of the element
            int middle= left+ (right-left)/2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle+1,right);
            merge(arr, left, middle,right);

        }

        return arr;

    }


    public static void merge(int arr[], int left, int middle, int right){

        //construct two auxilary arrays

        int n1=middle-left+1, n2=right-middle;

        //define and initiaze two auxilary arrays

        int []l=new int[n1];
        int []r=new int[n2];

        //initialize/populate left and right arrays

        for(int i=0;i<n1;i++){
            l[i]=arr[left+i];
        }

        for(int i=0;i<n2;i++){
            r[i]=arr[middle+1+i];
        }

        int i=0,j=0,k=left;

        while(i< n1 && j < n2){


            if(l[i] < r[j]){
                arr[k]=l[i];
                i++;k++;
            }else{
                arr[k]=r[j];
                j++;k++;
            }

        }


        while(i < n1){
            arr[k]=l[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k]=r[j];
            j++;k++;
        }
        // return arr;
    }



}