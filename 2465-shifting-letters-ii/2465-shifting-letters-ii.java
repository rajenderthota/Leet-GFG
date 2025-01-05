class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
         int stringLength = s.length();

        // Difference array to hold the net shift values after performing all shift operations.

        int[] netShifts = new int[stringLength + 1];


        // Iterate over each shift operation and update the difference array accordingly.

        for (int[] shift : shifts) {

            int direction = (shift[2] == 0) ? -1 : 1;  // If the shift is left, make it negative.

            netShifts[shift[0]] += direction;          // Apply the shift to the start index.

            netShifts[shift[1] + 1] -= direction;      // Negate the shift after the end index.

        }


        // Apply the accumulated shifts to get the actual shift values.

        for (int i = 1; i <= stringLength; ++i) {

            netShifts[i] += netShifts[i - 1];

        }


        // Construct the result string after applying the shift to each character.

        StringBuilder resultStringBuilder = new StringBuilder();

        for (int i = 0; i < stringLength; ++i) {

            // Calculate the new character by shifting the current character accordingly.

            // The mod operation keeps the result within the range of the alphabet, 

            // and the addition of 26 before mod ensures the number is positive.

            int shiftedIndex = (s.charAt(i) - 'a' + netShifts[i] % 26 + 26) % 26;

            resultStringBuilder.append((char) ('a' + shiftedIndex));

        }

        // Convert the StringBuilder to a String and return the result.

        return resultStringBuilder.toString();
    }
}