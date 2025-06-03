import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int[][] graph = new int[n+1][n+1];
        
        for(int[] wire:wires){
            int a=wire[0];
            int b=wire[1];
            graph[a][b]=1;
            graph[b][a]=1; 
        }
        
        for(int[] wire: wires){
            int a=wire[0];
            int b=wire[1];
            
            graph[a][b]=0;
            graph[b][a]=0;
            
            int cntA=bfs(a,graph,n);
            int cntB=n-cntA;
            
            answer=Math.min(answer, Math.abs(cntA-cntB));
            
            graph[a][b]=1;
            graph[b][a]=1;
        }
        return answer;
    }
    
    static int bfs(int start, int[][] graph, int n){
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n+1];
        q.add(start);
        visited[start]=1;
        int cnt=1;
        
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<n+1;i++){
                if(visited[i]==0&&graph[now][i]==1){
                    q.add(i);
                    visited[i]=1;
                    cnt++;
                }
            }
        }
        return cnt;
    
    }

}