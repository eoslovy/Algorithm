import java.util.*;
class Solution {
    static int[][] graph;
    static int[][] visited;
    public int solution(int m, int n, int[][] puddles) {
        graph = new int[n][m];
        visited = new int[n][m];
        
        for(int[] asd:puddles){
            visited[asd[1]-1][asd[0]-1]=1;
        }
        
        for(int i=0;i<n;i++){
            if(visited[i][0]==1)
                break;
            graph[i][0]=1;
        }
        for(int j=0;j<m;j++){
            if(visited[0][j]==1)
                break;
            graph[0][j]=1;
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(visited[i][j]==1)
                    continue;
                graph[i][j]=(graph[i-1][j]+graph[i][j-1])%1000000007;
            }
        }
        return (graph[n-1][m-1]%1000000007);
    }
}