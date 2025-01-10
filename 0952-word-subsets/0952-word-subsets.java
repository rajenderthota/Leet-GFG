class Solution {

    public List<String> wordSubsets(String[] words1, String[] words2){
         // Create a frequency map for the maximum required count of each character in words2
    int[] maxFreq = new int[26];
    for (String word : words2) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
            maxFreq[ch - 'a'] = Math.max(maxFreq[ch - 'a'], freq[ch - 'a']);
        }
    }

    // Filter words1 based on the maximum frequency requirement
    List<String> result = new ArrayList<>();
    for (String word : words1) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        boolean isUniversal = true;
        for (int i = 0; i < 26; i++) {
            if (freq[i] < maxFreq[i]) {
                isUniversal = false;
                break;
            }
        }
        if (isUniversal) {
            result.add(word);
        }
    }

    return result;
    }
    public List<String> wordSubsets1(String[] words1, String[] words2) {

        // len of words1
        int n=words1.length;
        // HashMap<Character, Integer> []words1Map=new HashMap<>(n);


        // for(int i=0;i<n;i++){
        //     String word=words1[i];
        //     Char []chars=word.toCharArray();
        //     HashMap<Character, Integer> charMap= new HashMap<>();
        //     for(char ch:chars){
        //         charMap.put(ch,charMap.getOrDefault(ch,0)+1);
        //     }   
        //     words1Map[i]=charMap;
        // } 

        List<String> result=new ArrayList<>();


        // for(int i=0;i<n;i++){
            
        //     HashMap<Character, Integer> chMap=words1Map[i];

        //     for(String str:words2){
        //         boolean flag=true;
        //         Char []chs=str.toCharArray();

        //                 for(char c:chs){
        //                     if(!chMap.containsKey(c)){
        //                         flag=false;
        //                         break;
        //                     }
        //                 }

        //                 if(flag)
        //                 result.add(words1[i]);

        //     }

        // }
        
        return result;
    }
}