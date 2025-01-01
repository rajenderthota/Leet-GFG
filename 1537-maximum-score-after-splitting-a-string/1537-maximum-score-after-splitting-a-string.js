/**
 * @param {string} s
 * @return {number}
 */
var maxScore = function(str) {
     var maximumSum = 0;
 
    // To store the total ones
    var totalOnes = 0;
 
    // Count the total numbers of ones
    // in string str
    str.split('').forEach(c => {
         
        if(c == '1')
            totalOnes++;
    });
 
    // To store the count of zeros and
    // ones while traversing string
    var zero = 0, ones = 0;
    var n=str.length-1;
 
    // Iterate the given string and
    // update the maximum sum
    for (var i = 0; i<n; i++) {
 
        if (str[i] == '0') {
            zero++;
        }
        else {
            ones++;
        }
 
        // Update the maximum Sum
        maximumSum
            = Math.max(
                maximumSum,
                zero + (totalOnes - ones));
    }
 
    return maximumSum;
};