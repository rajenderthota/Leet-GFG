class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        
        int n = derived.length;

        // Check for original[0] = 0
        if (isValid(derived, 0)) {
            return true;
        }

        // Check for original[0] = 1
        if (isValid(derived, 1)) {
            return true;
        }

        return false;
    }

    private boolean isValid(int[] derived, int firstValue) {
        int n = derived.length;
        int[] original = new int[n];
        original[0] = firstValue;

        // Construct the rest of the original array
        for (int i = 0; i < n - 1; i++) {
            original[i + 1] = derived[i] ^ original[i];
        }

        // Check the cyclic condition
        return (original[n - 1] ^ original[0]) == derived[n - 1];
    }
}