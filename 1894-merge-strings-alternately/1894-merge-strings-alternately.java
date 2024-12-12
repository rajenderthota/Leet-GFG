class Solution {
    public String mergeAlternately(String word1, String word2) {

        int left=0,right=0, n = word1.length(), m = word2.length();
        StringBuilder sb=new StringBuilder();
        while ( left < n && right < m ){

            // if( left % 2 == 0 ){
                sb.append(word1.charAt(left)+""+word2.charAt(right)+"");
                left++;right++;
            // }else{

            // }
        }

        if(left < n){
            sb.append(word1.substring(left,n));
        }

        // System.out.println(right);

        if(right < m ){
            sb.append(word2.substring(right,m));
        }
        
        return sb.toString();
    }
}