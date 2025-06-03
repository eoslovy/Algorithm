import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] wire:wires){
            int a=wire[0];
            int b=wire[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for(int[] wire: wires){
            int a=wire[0];
            int b=wire[1];
            
            graph.get(a).remove((Integer)b);
            graph.get(b).remove((Integer)a);
            
            int cntA=bfs(a,graph,n);
            int cntB=n-cntA;
            
            answer=Math.min(answer, Math.abs(cntA-cntB));
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return answer;
    }
    
    static int bfs(int start, List<List<Integer>> graph, int n){
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n+1];
        q.add(start);
        visited[start]=1;
        int cnt=1;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next: graph.get(now)){
                if(visited[next]==0){
                    q.add(next);
                    visited[next]=1;
                    cnt++;
                }
            }
            
        }
        return cnt;
    }
}