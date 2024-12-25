class Solution {
    public int alternatingSubarray(int[] nums) {

        int result=0,n=nums.length, prev=0 ;

        // for(int i=1;i<n;i++){
        //         if( (nums[i]-nums[i-1] == 1) || nums[i] -nums[i-1] == -1){
        //                 if(prev == -1 && nums[i]-nums[i-1] == -1)
        //                 break;
        //                 result++;
        //                 prev=nums[i]-nums[i-1];
        //         }
        // }

       
        for(int i=0;i<n-1;i++){
                int currentMax=0;
                 boolean bf=false;
                prev=nums[i+1]-nums[i];
                if( prev == 1 )
                currentMax++;
                else
                continue;

                for(int j=i+2;j<n;j++){
                    int curdif= nums[j] - nums[j-1];
                   
                    if(prev == -1){
                            if(curdif == -1){
                                if(Math.abs(curdif) > 1)
                                bf=true;
                                break;
                            }else if ((Math.abs(curdif) > 1) || Math.abs(curdif) < 1){
                                bf=true;
                                break;
                            }
                           
                            currentMax++;
                    }else{
                        if(curdif == 1){
                             if(Math.abs(curdif) > 1)
                                bf=true;
                                break;
                            }else if ( (Math.abs(curdif) > 1) || Math.abs(curdif) < 1){
                                bf=true;
                                break;
                            }
                            currentMax++;
                    }
                    prev=curdif;
                }
                if(bf){
                    // result =0;
                    result=Math.max(result,currentMax);
                    // break;
                }
            result=Math.max(currentMax,result);
        }
        return result > 0? result+1:-1;
    }
}