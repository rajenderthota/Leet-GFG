class Solution {


 public int maxScore(String s) {

        // Initialize total score for the first partition

        int totalScore = 0;

        // If the first character is '0', increase the score by 1

        if (s.charAt(0) == '0') {

            totalScore++;

        }

        // Calculate initial score for '1's in the string, skipping the first character

        for (int i = 1; i < s.length(); ++i) {

            if (s.charAt(i) == '1') {

                totalScore++;

            }

        }

        // The best score is initially set to the score from the initial partition

        int maxScore = totalScore;

      

        // Iterate through the string to find partitions and track the highest score

        for (int i = 1; i < s.length() - 1; ++i) {

            // If the current character is '0', increase the total score

            // If it is '1', decrease the total score

            totalScore += (s.charAt(i) == '0') ? 1 : -1;

            // Update the maximum score if the current total score is greater

            maxScore = Math.max(maxScore, totalScore);

        }

        // Return the highest score found amongst all possible partitions

        return maxScore;

    }


    public int maxScore1(String s) {
        
        // length of the string
        int n=s.length(),zeros=0,ones=0,totalOnes=0,maxScore=0;

        //count total no of ones in giben string

        for(int i=0;i<n;i++){
            if(s.charAt(i) == '1'){
                totalOnes++;
            }
        }

        //find maximum score after splitting a string

        for(int i=0;i<n-1;i++){
                if( s.charAt(i) == '0'){
                    zeros++;
                }else{
                    ones++;
                }

                maxScore=Math.max(maxScore, zeros+(totalOnes-ones));
        }

        return maxScore;
    }
}