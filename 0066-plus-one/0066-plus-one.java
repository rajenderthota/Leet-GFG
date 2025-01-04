class Solution {
    public int[] plusOne(int[] digits) {
        
        int n=digits.length;
        boolean b=false;
        for(int i=n-1;i>=0;i--){
            if(digits[i] < 9){
                digits[i]+=1;
                // return digits;
                b=true;
                break;
            }else{
                digits[i]=0;
            }
        }

        if(b)
        return digits;
        else{
            int result[]=new int[n+1];
  result[0]=1;
    return result;
        }

      
    }
}