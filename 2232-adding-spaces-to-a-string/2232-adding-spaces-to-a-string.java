class Solution {
    public String addSpaces(String s, int[] spaces) {

        StringBuilder sb=new StringBuilder();
        int slen=s.length();
        int indxCount=0,splen=spaces.length;;
        
        for(int i=0;i<slen;i++){
            if(indxCount < splen && i == spaces[indxCount] ){
                sb.append(" ");
                indxCount++;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
        
    }
}