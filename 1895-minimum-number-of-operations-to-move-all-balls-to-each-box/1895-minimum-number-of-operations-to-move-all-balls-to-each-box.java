class Solution {
    public int[] minOperations(String boxes) {

        // length of the given array
        int n=boxes.length();
        int operations=0,count=0;
        int ans[]=new int[n];

        for(int i=0;i<n;i++){
            ans[i]=operations;
            count+= boxes.charAt(i) - '0';
            operations+=count;

        }
        operations=0;count=0;

        for(int i=n-1;i>=0;i--){
            ans[i]+=operations;
            count+= boxes.charAt(i) -'0';
            operations+=count;
        }

        return ans;
    }
}