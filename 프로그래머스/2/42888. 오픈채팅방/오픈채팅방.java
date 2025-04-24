import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[][] behavior = new String[record.length][3];
        
        int cnt=0;
        int total=0;
        for(int i=0;i<record.length;i++){
            String[] str=record[i].split(" ");
            for(int j=0;j<str.length;j++){
                behavior[cnt][j]=str[j];
            }
            if(!behavior[cnt][0].equals("Change"))
                total++;
            cnt++;
        }
        
        Map<String,String> map=new HashMap<>();
        for(int i=0;i<record.length;i++){
            if(!map.containsKey(behavior[i][1])&&!behavior[i][0].equals("Leave"))
                map.put(behavior[i][1], behavior[i][2]);
            else if(map.containsKey(behavior[i][1])&&behavior[i][0].equals("Enter"))
                map.put(behavior[i][1], behavior[i][2]);
            else if(behavior[i][0].equals("Change"))
                map.put(behavior[i][1], behavior[i][2]);
        }
        
        String[] answer=new String[total];
        int asd=0;
        for(int i=0;i<record.length;i++){
            String tmp="";
            if(behavior[i][0].equals("Enter")){
                tmp+=map.get(behavior[i][1]);
                tmp+="님이 들어왔습니다.";
            }
            else if(behavior[i][0].equals("Leave")){
                tmp=map.get(behavior[i][1]);
                tmp+="님이 나갔습니다.";
            }
            else
                continue;
            answer[asd++]=tmp;
        }
        
        return answer;
    }
}