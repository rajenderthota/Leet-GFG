class Solution {


//two pointer technique

public int strStr(String haystack, String needle) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();

        if (needleLength == 0) {
            return 0;
        }

        // Two pointers: one for haystack and one for needle
        int i = 0; // Pointer for haystack
        int j = 0; // Pointer for needle

        while (i < haystackLength) {
            // If characters match, move both pointers
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                // If j has reached the end of needle, we found the match
                if (j == needleLength) {
                    return i - j; // The start of the match
                }
            } else {
                // If there's a mismatch, reset j and adjust i
                i = i - j + 1; // Move i back to the next character after the mismatch
                j = 0;         // Reset j to start of needle
            }
        }

        // If no match is found, return -1
        return -1;
    }



    //brueforce implementation
    public int strStr1(String haystack, String needle) {

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