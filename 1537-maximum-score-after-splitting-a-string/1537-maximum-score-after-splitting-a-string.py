class Solution(object):
    def maxScore(self, str):
        """
        :type s: str
        :rtype: int
        """
        maximumSum = 0
 
    # To store the total ones
 
    # Count the total numbers of ones
    # in str
        totalOnes = 0
        for i in str:
            if i == '1':
                totalOnes += 1
 
    # To store the count of zeros and
    # ones while traversing string
        zero = 0
        ones = 0
 
    # Iterate the given and
    # update the maximum sum
        i = 0
        while i < (len(str)-1):
 
            if (str[i] == '0'):
                zero += 1
            else:
                ones += 1
 
        # Update the maximum Sum
            maximumSum= max(maximumSum,zero + (totalOnes - ones))
            i += 1
 
        return maximumSum
        