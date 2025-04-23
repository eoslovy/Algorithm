import java.util.*;
class Solution {
    static int n,m;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int[][] visited;
    static Queue<int[]> q;
    public int solution(int[][] maps) {
        n=maps.length;
        m=maps[0].length;
        
        visited = new int[n][m];
        q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited[0][0]=1;
        
        bfs(maps);
        
        if(visited[n-1][m-1]==0)
            return -1;
        return visited[n-1][m-1];
    }
    public void bfs(int[][] maps){
        while(!q.isEmpty()){
            int[] asd=q.poll();
            int x=asd[0];
            int y=asd[1];
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(0<=nx&&nx<n&&0<=ny&&ny<m){
                    if(maps[nx][ny]==1&&visited[nx][ny]==0){
                        visited[nx][ny]=visited[x][y]+1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }           
    }
}