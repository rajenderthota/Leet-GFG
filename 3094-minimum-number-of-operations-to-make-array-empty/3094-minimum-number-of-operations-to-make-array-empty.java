class Solution {


 public int minOperations(int[] nums) {
  Map<Integer, Integer> count = new HashMap<>();
        int res = 0;

        // Count the occurrences of each number
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Process the counts
        for (int c : count.values()) {
            if (c == 1) {
                return -1; // If a number occurs only once, return -1
            }
            res += Math.ceil(c / 3.0); // Calculate the number of operations
        }

        return res;

 }


    public int minOperations1(int[] nums) {

        int n = nums.length;
        Map<Integer, Integer> numCountMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int currentItem = nums[i];
            if (numCountMap.containsKey(currentItem)) {
                numCountMap.put(currentItem, numCountMap.get(currentItem) + 1);
            } else {
                numCountMap.put(currentItem, 1);
            }
        }

        // for (Map.Entry<Integer,Integer> entry : numCountMap.entrySet()) {

        // }
         int leastCount = Integer.MAX_VALUE;

        for (int count : numCountMap.values()) {

            if (count > 1 && count < leastCount) {

                leastCount = count;

            }

        }
        
        //leastCount == Integer.MAX_VALUE not infine
        if(leastCount != Integer.MAX_VALUE)
        for (Integer key : numCountMap.keySet()) {
        	
        	int count=numCountMap.get(key);
        	if (count > 1 ) {
        		int remaining=numCountMap.get(key)-leastCount;
//        		if(remaining >=1)
        		numCountMap.put(key, remaining);
//        		else
//        			numCountMap.remove(key);	
        	}
        	
        }
        
        
        int count = 0;
        for (Integer num : numCountMap.keySet()) {
        	
        	if(numCountMap.get(num) >= 1) {
        		 if ((num % 2 == 0) || (num % 3 == 0)) {
                     if ((num % 2 == 0) && (num % 3 == 0)) {
                         count += num / 3;
                     } else {
                         count += num / 2;
                     }

                     continue;
                 }

                 else {
                     String partitionCount = stringPartition(num + "", 2, 3);

                     if (partitionCount.equals("-1"))
                         return -1;

                     count += Integer.parseInt(partitionCount.split("$")[0]) + Integer.parseInt(partitionCount.split("$")[1])
                             + 1;

                 }
        	}

           

        }
        // for (Integer count : numCountMap.values()) {

        // if((count % 2 == 0 ) ||( count % 3 == 0))
        // continue;

        // }
        return count;
    }

    static String stringPartition(String s, int a, int b) {
        int i;
        // code here
        int n = s.length();
        // if length is 1 not possible
        if (n == 1) {
            return "-1";
        } else {
            // Checking if number formed bt S[0] and
            // S[1->n-1] is divisible
            int a1 = s.charAt(0) - '0';
            int a2 = s.charAt(1) - '0';
            int multiplier = 10;
            for (i = 2; i < n; i++) {
                a2 = a2 * multiplier + (s.charAt(i) - '0');
            }
            i = 1;
            if (a1 % a == 0 && a2 % b == 0) {
                String k1 = "";
                for (i = 0; i < s.charAt(0); i++)
                    k1 += '1';
                String k2 = "";
                for (int j = 1; j < n; j++)
                    k2 += s.charAt(j);
                return k1 + "$" + k2; // return the numbers
                // formed as String
            }

            // from here by using sliding window technique
            // we will iterate and check for every i that if
            // the two current numbers formed are divisible
            // if yes return else form the two new numbers
            // for next iteration using sliding window
            // technique
            int q1 = 10;
            int q2 = 1;
            for (i = 1; i < n - 1; i++)
                q2 *= 10;
            i = 1;
            while (i < n - 1) {
                char x = s.charAt(i);
                int ad = x - '0';
                a1 = a1 * q1 + ad;
                a2 = a2 - q2 * ad;
                if (a1 % a == 0 && a2 % b == 0) {
                    String k1 = "";
                    String k2 = "";
                    for (int j = 0; j < i + 1; j++)
                        k1 += s.charAt(j);
                    for (int j = i + 1; j < n; j++)
                        k2 += s.charAt(j);
                    return k1 + "$" + k2;
                }
                q2 /= 10;
                i++;
            }
        }
        return "-1";
    }
}