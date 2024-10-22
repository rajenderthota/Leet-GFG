class Solution {
    public String minRemoveToMakeValid(String s) {

        StringBuilder sb=new StringBuilder();
        StringBuilder rc=new StringBuilder();
        for(Character ch:s.toCharArray()){

            if(ch == '(' || ch == ')'){
                if(sb.length() == 0 && ch == ')'){
                    rc.append(ch);
                }
                if(sb.length() > 0 && ch == ')'){
                    // sb.remove('(');

                    int index = sb.indexOf("(");
                    sb.deleteCharAt(index);

                }else if(ch == '('){
                    // rc.append(ch);
                    sb.append('(');
                }

            }   


        }

        System.out.println(rc);
        System.out.println(sb);

        if(sb.length() > 0){
            String sbStr=sb.toString();
            for(Character ch:sbStr.toCharArray()){
                System.out.println(ch);
                if(ch == ')')
                s=  s.replaceFirst("\\"+ch+"","");//s = s.substring(0, s.length() - 1) + "";
               else{
                 int lastIndex = s.lastIndexOf(ch);
                 if(lastIndex != -1)
                s = s.substring(0, lastIndex) + "" + s.substring(lastIndex + 1);
               }
                //  s=  s.replaceFirst("\\"+ch+"","");//s = s.substring(1) + "";
            // s=s.replaceFirst("\\"+ch+"","");
              
            }
        }

        if(rc.length() > 0){
            String rcStr=rc.toString();
            for(Character ch:rcStr.toCharArray()){
                System.out.println(ch);
                if(ch == '(')
               s=  s.replaceFirst("\\"+ch+"","");
               else
                s=  s.replaceFirst("\\"+ch+"","");//s = s.substring(0, s.length() - 1);
            }
        }
    
        // System.out.println(sb);
        // System.out.println(rc);

      
        
        return s;
    }
}