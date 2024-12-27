class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        //find max candies 
        int n=candies.length,max=candies[0];
        for(int i=0;i<n;i++){
            if(max < candies[i]){
                max=candies[i];
            }
        }
        List<Boolean> result=new ArrayList<>();
        for(int i=0;i<n;i++){
                if(candies[i]+extraCandies >= max)
                    result.add(true);
                else
                    result.add(false);
        }
    return result;
    }
}