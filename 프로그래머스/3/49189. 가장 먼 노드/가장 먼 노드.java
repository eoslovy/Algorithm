import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] e:edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        boolean[] visited=new boolean[n+1];
        int[] distance=new int[n+1];
        Queue<Integer> q=new LinkedList<>();
        
        q.add(1);
        visited[1]=true;
        
        while(!q.isEmpty()){
            int current=q.poll();
            for(int next:graph.get(current)){
                if(!visited[next]){
                    visited[next]=true;
                    distance[next]=distance[current]+1;
                    q.add(next);
                }
            }
        }
        
        int max=0;
        for(int d:distance){
            max=Math.max(max,d);
        }
        
        int answer=0;
        for(int d:distance){
            if(d==max){
                answer++;
            }
        }
        return answer;
    }
}