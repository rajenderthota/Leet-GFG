class Solution {
    public int[] finalPrices(int[] prices) {

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