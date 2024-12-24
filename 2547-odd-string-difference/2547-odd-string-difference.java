class Solution {
    public String oddString(String[] words) {
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