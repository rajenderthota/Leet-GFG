class Solution {
    public boolean checkPowersOfThree(int n) {
        
    while (n > 0) {
            int remainder = n % 3;
            if (remainder == 2) return false; // If a digit is 2, we can't represent it using distinct powers of 3
            n /= 3;
        }
        return true;
    }
}