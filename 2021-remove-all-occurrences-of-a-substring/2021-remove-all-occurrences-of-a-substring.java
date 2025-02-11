class Solution {
    public String removeOccurrences(String s, String part) {
        
        return removeSubString(s,part);
    }

    String removeSubString(String s, String part){


        if(!s.contains(part)){
            return s;
        }
       return removeSubString(s.replaceFirst(part, ""),part);

    }
}