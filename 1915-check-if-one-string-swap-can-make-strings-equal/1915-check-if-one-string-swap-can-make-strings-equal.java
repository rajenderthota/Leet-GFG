class Solution {


   public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        int n = s1.length();
        int first = -1, second = -1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2) return false;
                if (first == -1) {
                    first = i;
                } else {
                    second = i;
                }
            }
        }

        return count == 2 && s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first);
    }

    public boolean areAlmostEqual_hasmap(String s1, String s2) {

        HashMap<Character,Integer> s1Set=new HashMap<>();
        HashMap<Character,Integer> s2Set=new HashMap<>();

        for(Character ch:s1.toCharArray()){
            s1Set.put(ch,s1Set.getOrDefault(ch,0)+1);
        }

         for(Character ch:s2.toCharArray()){
            s2Set.put(ch,s2Set.getOrDefault(ch,0)+1);
        }
       
        for(Character ch:s1Set.keySet()){
            if(!(s2Set.containsKey(ch) && s1Set.get(ch) == s2Set.get(ch)) )
            return false;
        }
        // return true;

        int n=s1.length();
        int count=0;
        for(int i=0;i<n;i++){
            if(s1.charAt(i) != s2.charAt(i))
            count++;
        }
        // s1Set.retainAll(s2Set);

        return (count ==0 || count == 2)? true: false;
    }
}