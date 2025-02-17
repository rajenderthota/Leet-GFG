class Solution {
    public int numTilePossibilities(String tiles) {
        
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