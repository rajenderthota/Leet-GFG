class Solution {

    public int[] finalPrices(int[] prices){

        int n = prices.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Find the discount for previous items
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                result[index] = prices[index] - prices[i];
            }
            // Push the current index onto the stack
            stack.push(i);
        }

        // For remaining items in the stack, no discount applies
        while (!stack.isEmpty()) {
            int index = stack.pop();
            result[index] = prices[index];
        }

        return result;

    }
    public int[] finalPrices1(int[] prices) {

        //brute force solution
        int n=prices.length, result[]=new int[n];
        for(int i=0;i<n;i++){
                int temp=prices[i];
                for(int j=i+1;j<n;j++){

                    if(temp >= prices[j]){
                        temp=temp-prices[j];
                        break;
                    }
                }

                result[i]=temp;
        }
        
        return result;
    }
}