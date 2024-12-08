class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {

        HashSet<Integer> bannedSet=new HashSet<>();
        int len=banned.length,sum=0,count=0;
        for(int i=0;i<len;i++){
            bannedSet.add(banned[i]);
        }

        for(int i=1;i<=n;i++){
            if( !bannedSet.contains(i)){
                if(sum+i <= maxSum){
                    sum=sum+i;
                    count++;
                }
            }

           /*  if (bannedSet.contains(i)) {
                // Skip banned numbers
                continue;
            }

            if (sum + i > maxSum) {
                // If adding the current number exceeds maxSum, stop
                break;
            }

            // Otherwise, add the number to the sum and increment the count
            sum += i;
            count++;
            */
        }
       return count; 
    }
}