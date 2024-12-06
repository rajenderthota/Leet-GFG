class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
    int n=nums1.length,swap[]=new int[n],keep[]=new int[n];;
    //intial state 
    keep[0]=0;swap[0]=1;
    for(int i=1;i<n;i++){
        //put default/infine value at ith index
        keep[i]=swap[i]=Integer.MAX_VALUE;
        if(nums1[i] > nums1[i-1] && nums2[i] > nums2[i-1]){
            keep[i]=keep[i-1];
            swap[i]=swap[i-1]+1;
        }
        if(nums1[i] > nums2[i-1] && nums2[i] > nums1[i-1]){
            keep[i]=Math.min(keep[i],swap[i-1]);
            swap[i]=Math.min(swap[i], keep[i-1]+1);
        }
    }      
    return Math.min(keep[n-1],swap[n-1]);
    }
}