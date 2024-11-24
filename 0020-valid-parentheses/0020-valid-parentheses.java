class Solution {
    public boolean isValid(String s) {

        Stack paranthesesStack=new Stack();
        Map<Character,Character> pMap=new HashMap<>();

        pMap.put(')','(');
        pMap.put(']','[');
        pMap.put('}','{');
        // pMap.put('','');

        for(Character parantheses:s.toCharArray()){

            if(pMap.containsKey(parantheses) && !paranthesesStack.empty() && paranthesesStack.peek() ==pMap.get(parantheses) ){
                paranthesesStack.pop();
            }else{
                paranthesesStack.push(parantheses);
            }
        }

    return paranthesesStack.empty();
        
    }
}