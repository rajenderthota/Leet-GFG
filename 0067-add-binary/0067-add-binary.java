class Solution {


public String addBinary(String a,String b){
         StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        
        // Loop through both strings from end to start
        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0'; // Add bit from a
            if (j >= 0) sum += b.charAt(j--) - '0'; // Add bit from b
            // Prepend the calculated bit to the result string
            result.insert(0, sum % 2); // Use insert to prepend
            carry = sum / 2; // Determine new carry
        }
        
        return result.toString(); // No need to reverse
}

    public String testAddBinary(String a, String b) {
        
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