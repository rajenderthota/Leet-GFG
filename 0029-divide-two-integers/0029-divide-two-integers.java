class Solution {
    public int divide(int dividend, int divisor) {
       // Handle overflow edge case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean negative = (dividend < 0) != (divisor < 0);

        // Convert both numbers to their absolute values
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int quotient = 0;

        // Use bit manipulation to calculate the quotient
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            int multiple = 1;

            // Double the divisor until it's larger than the dividend
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Subtract the largest multiple of divisor and increase quotient
            absDividend -= tempDivisor;
            quotient += multiple;
        }

        // Apply the sign
        return negative ? -quotient : quotient;
        }
    
}