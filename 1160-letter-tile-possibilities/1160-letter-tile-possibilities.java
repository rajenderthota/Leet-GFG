class Solution {

    public int numTilePossibilities(String tiles) {
        // Set to store unique sequences
        Set<String> result = new HashSet<>();
        // Array to store the frequency of each letter in tiles
        int[] freq = new int[26];
        
        // Fill the frequency array
        for (char c : tiles.toCharArray()) {
            freq[c - 'A']++;
        }
        
        // Start backtracking
        backtrack(freq, "", result);
        return result.size();
    }

    private void backtrack(int[] freq, String current, Set<String> result) {
        // If current sequence is not empty, add it to result
        if (!current.isEmpty()) {
            result.add(current);
        }

        // Explore all letters
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                // Make the choice: choose the current letter
                freq[i]--; // reduce the frequency of the chosen letter
                backtrack(freq, current + (char) (i + 'A'), result); // explore with the new sequence
                freq[i]++; // Undo the choice: restore the frequency of the letter
            }
        }
    }
    public int numTilePossibilities1(String tiles) {
        
             Set<String> result = new HashSet<>();
        backtrack(tiles, "", result);
        return result.size();
    }

    private void backtrack(String tiles, String current, Set<String> result) {
        if (!current.isEmpty()) {
            result.add(current);  // Add current sequence to the result set
        }
        
        for (int i = 0; i < tiles.length(); i++) {
            // To avoid reusing the same tile in the same recursion level, skip if the tile has been used already
            if (i > 0 && tiles.charAt(i) == tiles.charAt(i - 1)) continue;
            
            // Make the choice: add tile[i] to the current sequence
            backtrack(tiles.substring(0, i) + tiles.substring(i + 1), current + tiles.charAt(i), result);
        }
    }



    public ArrayList<String> possibleWords(int[] arr) {
        // code here
        ArrayList<String> res= new ArrayList<>();
        String[] padMap={"","","abc","def","ghi","jkl","mno","pqrs","tuv",
            "wxyz"
        };
        StringBuilder prefix=new StringBuilder();
        possibleWordsRec(arr,0,prefix,padMap,res);
        
        return res;
    }
    
    static void possibleWordsRec(int arr[], int index, StringBuilder prefix,
    String[] padMap, ArrayList<String> res){
        
        if( index == arr.length){
            res.add(prefix.toString());
            return;
        }
        
        int digit = arr[index];
        
        if( digit < 2 || digit > 9){
            possibleWordsRec(arr,index+1,prefix,padMap,res);
            return;
        }
        
        //please all possible letters for this digit
        for(char ch:padMap[digit].toCharArray()){
            prefix.append(ch);
            possibleWordsRec(arr,index+1,prefix,padMap,res);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
}