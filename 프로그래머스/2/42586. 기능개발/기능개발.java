import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q=new LinkedList<>();
        Queue<Integer> sp=new LinkedList<>();
        
        for(int i=0;i<progresses.length;i++){
            q.add(progresses[i]);
            sp.add(speeds[i]);
        }
        List<Integer> lst=new ArrayList<>();
        
        while(!q.isEmpty()){
            int idx=q.poll();
            int speed=sp.poll();
            int day=0;
                
            while(true){
                day++;
                idx+=speed;
                if(idx>=100)
                    break;
            }
            
            int cnt=1;
            while(!q.isEmpty()){
                if(q.peek()+sp.peek()*day>=100){
                    cnt++;
                    q.poll();
                    sp.poll();
                }
                else
                    break;
            }
            lst.add(cnt);
        }
        int[] answer=new int[lst.size()];
        
        for(int i=0;i<lst.size();i++){
            answer[i]=lst.get(i);
        }
        
        return answer;
    }
}