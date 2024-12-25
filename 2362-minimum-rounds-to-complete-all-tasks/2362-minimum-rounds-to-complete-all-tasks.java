class Solution {
    public int minimumRounds(int[] tasks) {

        int resp=0;
        Map<Integer,Integer> tasksCountMap=new HashMap<>();

        for(int task:tasks){
            tasksCountMap.put(task,tasksCountMap.getOrDefault(task,0)+1);
        }

        for(int count:tasksCountMap.values()){

                if( count == 1)
                return -1;

                resp+= Math.ceil(count/3.0);
        }
        
        return resp;
    }
}