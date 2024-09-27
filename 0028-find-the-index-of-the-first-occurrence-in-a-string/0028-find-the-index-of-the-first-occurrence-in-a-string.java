class Solution {
    public int strStr(String haystack, String needle) {

        int l=0,r=0,stl=haystack.length(),nl=needle.length();

        // while(l <= stl && r < nl){

        // }

        //brute force approach

        for(int i=0;i< stl;i++){

         if(stl-i >= nl){

                for(int j=0;j<nl;j++){
                if( haystack.charAt(i+j)==needle.charAt(j)){

                    if(j == nl-1)
                    return i;
                    continue;
                }else{
                    break;
                }
            }
         }else{
            break;
         }
            
        }
        
        return -1;
    }
}