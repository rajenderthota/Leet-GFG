class ProductOfNumbers {

    private List<Integer> prefixProduct;
    private int lastZeroIndex; // Tracks the last index where zero was added

    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
        prefixProduct.add(1); // Dummy value to handle division correctly
        lastZeroIndex = -1;
    }

    public void add(int num) {
        if (num == 0) {
            prefixProduct.clear();
            prefixProduct.add(1); // Reset with dummy value
            lastZeroIndex = prefixProduct.size() - 1; // Mark zero position
        } else {
            prefixProduct.add(prefixProduct.get(prefixProduct.size() - 1) * num);
        }
    }


    public int getProduct(int k) {
        int n = prefixProduct.size();
        // FIX: Check if a zero was encountered in the last k elements
        if (n - k <= lastZeroIndex) {
            return 0; // If a zero is within range, return 0
        }
        return prefixProduct.get(n - 1) / prefixProduct.get(n - k - 1);
    }


    public int getProduct1(int k) {
        int n = prefixProduct.size();
        if (n - k - 1 <= lastZeroIndex) {
            return 0; // If within range of a zero, product must be zero
        }
        return prefixProduct.get(n - 1) / prefixProduct.get(n - k - 1);
    }

}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */