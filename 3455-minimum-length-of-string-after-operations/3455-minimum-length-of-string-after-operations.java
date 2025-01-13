class Solution {

        public int minimumLength(String s) {

            int charr[]=new int[26];
            for(char ch:s.toCharArray()){
                charr[ch-'a']++;
            }
            int res=0;

            for(int cnt:charr){

                if(cnt <=2 ){
                    res+=cnt;
                }else{
                    if( cnt % 2 == 1)
                    res++;
                    else
                    res+=2;
                }

                
            }

            return res;
        }
    public int minimumLength1(String s) {
         int left = 0;
        int right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            char currentChar = s.charAt(left);
            // Move the left pointer to the right while characters match
            while (left <= right && s.charAt(left) == currentChar) {
                left++;
            }
            // Move the right pointer to the left while characters match
            while (left <= right && s.charAt(right) == currentChar) {
                right--;
            }
        }

        return right - left + 1;
    }
}