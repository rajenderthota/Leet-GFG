class Solution {
public:
    int maxScore(string str) {


         int maximumSum = 0;
 
    // To store the total ones
    int totalOnes;
 
    // Count the total numbers of ones
    // in string str
    totalOnes = count(str.begin(),
                      str.end(), '1');
 
    // To store the count of zeros and
    // ones while traversing string
    int zero = 0, ones = 0,n=str.length()-1;


 
    // Iterate the given string and
    // update the maximum sum
    for (int i = 0; i<n; i++) {
 
        if (str[i] == '0') {
            zero++;
        }
        else {
            ones++;
        }
 
        // Update the maximum Sum
        maximumSum
            = max(
                maximumSum,
                zero + (totalOnes - ones));
    }
 
    return maximumSum;
        
    }
};