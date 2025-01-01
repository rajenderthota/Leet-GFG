public class Solution {
    public int MaxScore(string str) {
        int maximumSum = 0;
 
    // To store the total ones 
    int totalOnes = 0;
 
    // Count the total numbers of ones 
    // in string str 
    for(int i = 0; i < str.Length; i++)
    {
       if (str[i] == '1')
       {
           totalOnes++;
       }
    }
     
    // To store the count of zeros and 
    // ones while traversing string 
    int zero = 0, ones = 0,n=str.Length-1;
 
    // Iterate the given string and 
    // update the maximum sum 
    for(int i = 0; i <n ; i++)
    {
       if (str[i] == '0')
       {
           zero++;
       }
       else
       {
           ones++;
       }
        
       // Update the maximum Sum 
       maximumSum = Math.Max(maximumSum, zero + 
                                   (totalOnes - 
                                    ones));
    }
    return maximumSum;
    }
}