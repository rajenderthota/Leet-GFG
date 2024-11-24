class Solution {
    public String addBinary(String a, String b) {
        
        //get the integer value in binary form 
        // Integer x=Integer.parseInt(a,2);
        // Integer y=Integer.parseInt(b,2);
        // Integer sum=x+y;
        // return Integer.toBinaryString(sum);


         StringBuilder result = new StringBuilder();
        int carry = 0;

        // Pointers for the two strings starting from the end
        int i = a.length() - 1;
        int j = b.length() - 1;

        // Loop until all bits are processed or carry is not zero
        while (i >= 0 || j >= 0 || carry > 0) {
            int bitA = (i >= 0) ? a.charAt(i) - '0' : 0; // Get bit from a, or 0 if exhausted
            int bitB = (j >= 0) ? b.charAt(j) - '0' : 0; // Get bit from b, or 0 if exhausted

            // Calculate sum of bits and carry
            int sum = bitA + bitB + carry;

            // Update carry for the next iteration
            carry = sum / 2;

            // Append the least significant bit of sum to the result
            result.append(sum % 2);

            // Move pointers to the left
            i--;
            j--;
        }

        // Reverse the result to get the correct binary string
        return result.reverse().toString();

    }
}