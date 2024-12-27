class Solution {
    public int maxScoreSightseeingPair(int[] values) {
         // Initialize the answer to 0. This will hold the maximum score.

        int maxScore = 0;

      

        // Initialize the maximum value seen so far, which is the value at the 0th index 

        // plus its index (because for the first element, index is 0, so it's just the value).

        int maxValueWithIndex = values[0];


        // Iterate over the array starting from the 1st index since we've already considered the 0th index.

        for (int j = 1; j < values.length; ++j) {

            // Update maxScore with the maximum of the current maxScore and 

            // the score of the current sightseeing spot combined with the previous maximum.

            // This score is computed as the value of the current element plus its 'value' score (values[j])

            // subtracted by its distance from the start (j) plus the maxValueWithIndex.

            maxScore = Math.max(maxScore, values[j] - j + maxValueWithIndex);

          

            // Update the maxValueWithIndex to be the maximum of the current maxValueWithIndex and

            // the 'value' score of current element added to its index (values[j] + j).

            // This accounts for the fact that as we move right, our index increases,

            // which decreases our score, so we need to keep track of the element

            // which will contribute the most to the score including the index.

            maxValueWithIndex = Math.max(maxValueWithIndex, values[j] + j);

        }


        // Return the maximum score found.

        return maxScore;
    }
}