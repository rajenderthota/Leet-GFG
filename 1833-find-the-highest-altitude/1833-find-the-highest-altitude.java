class Solution {
    public int largestAltitude(int[] gain) {

        int highest_altitue=0,n=gain.length,currentMax=0;
        for(int i=0;i<n;i++){
            currentMax+=gain[i];
            highest_altitue=Math.max(highest_altitue,currentMax);
        }
        return highest_altitue;
    }
}