class Solution {
    public int scoreOfString(String s) {
        int sl=s.length();
        int absScore=0;
        for(int i=0;i<sl-1;i++){

            absScore+=Math.abs( (int) s.charAt(i)- (int) s.charAt(i+1) );
        }

      return absScore;
    }
}