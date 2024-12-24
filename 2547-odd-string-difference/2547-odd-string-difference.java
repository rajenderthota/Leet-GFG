class Solution {


public String oddString(String []words){
    // Helper function to calculate the difference array for a word
        Function<String, List<Integer>> diff = word -> {
            List<Integer> differences = new ArrayList<>();
            for (int j = 1; j < word.length(); j++) {
                differences.add(word.charAt(j) - word.charAt(j - 1));
            }
            return differences;
        };

        // Sort the words based on their difference array
        Arrays.sort(words, (a, b) -> {
            List<Integer> diffA = diff.apply(a);
            List<Integer> diffB = diff.apply(b);
            for (int i = 0; i < Math.min(diffA.size(), diffB.size()); i++) {
                if (!diffA.get(i).equals(diffB.get(i))) {
                    return diffA.get(i) - diffB.get(i);
                }
            }
            return diffA.size() - diffB.size();
        });

        // Check the first two and the last word to find the odd one
        return !diff.apply(words[0]).equals(diff.apply(words[1])) ? words[0] : words[words.length - 1];
    
}



public String oddString2(String []words){
     Map<List<Integer>, List<String>> map = new HashMap<>();
        
        for (String word : words) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 1; i < word.length(); i++) {
                temp.add(word.charAt(i) - word.charAt(i - 1));
            }
            map.putIfAbsent(temp, new ArrayList<>());
            map.get(temp).add(word);
        }
        
        for (Map.Entry<List<Integer>, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                return entry.getValue().get(0);
            }
        }
        
        return words[0]; // this state will not occur
}


    public String oddString1(String[] words) {
        int n=words.length, m= words[0].length(),row=0;
        int dif[][]=new int[n][m];
        HashMap<String,String[]> difMap=new HashMap<>();

        for(String word:words){
            int col=0;
            StringBuilder sb=new StringBuilder();
            for(int i=m-1;i>0;i--){
                int d=getAlphabetPosition(word.charAt(i))-getAlphabetPosition(word.charAt(i-1));
                 dif[row][col]= d ;
                 sb.append(d+"$");
                 col++;     
            }
            String key=sb.toString();
            if(difMap.containsKey(key)){
                // return word;
                int updateValue=Integer.parseInt(difMap.get(key)[0])+1;
                String upstr=Integer.toString(updateValue);
                String value[]=difMap.get(key);
                value[0]=upstr;
                value[1]=word;
                difMap.put(key,value);
            }else{
                String val[]={"1",word};
                difMap.put(key,val);
            }
            row++;
        }


//  for (Map.Entry<String, String[]> entry : difMap.entrySet()) {
//  System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue()[0] +" -"+ entry.getValue()[1]);
//     int noOfOccurence=Integer.parseInt(entry.getValue()[0]);

//     // if(noOfOccurence == 1)
//     // return entry.getValue()[1];
//  }

 for (Map.Entry<String, String[]> entry : difMap.entrySet()) {
//  System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue()[0] +" -"+ entry.getValue()[1]);
    int noOfOccurence=Integer.parseInt(entry.getValue()[0]);

    if(noOfOccurence == 1)
    return entry.getValue()[1];
 }
    

    return "";

    }


       public static int getAlphabetPosition(char ch) {
        return ch - 'a'; 
        }
}