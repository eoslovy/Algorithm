import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int sum=0;
        int cnt=scoville.length;
        for(int i=0;i<cnt;i++){
            pq.offer(scoville[i]);
            sum+=scoville[i];
        }

        while(pq.peek()<K){
            if(pq.size()<2)
                return -1;
            int a=pq.poll();
            int b=pq.poll();
            
            int c=a+2*b;
            pq.offer(c);
            answer++;
        }
        
        return answer;
    }
}