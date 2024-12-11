import java.util.*;
import java.io.*;

public class Main
{
    private static int r,c;
    private static int[] dx={-1,0,1};
    private static int[] dy={1,1,1};
    private static int[][] graph,visited;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		
		graph=new int[r][c];
		visited = new int[r][c];
		for(int i=0;i<r;i++){
		    String tmp = br.readLine();
		    for(int j=0;j<c;j++){
		        if(tmp.charAt(j)=='.')
		            graph[i][j]=0;
		        else
		            graph[i][j]=1;
		    }
		}
		
// 		System.out.println(Arrays.deepToString(graph));
        
        int ans=0;
        for(int i=0;i<r;i++){
            if(dfs(i,0)==1)
                ans++;
        }
        
        System.out.println(ans);

	}
	
	private static int dfs(int x, int y){
	    if(y==c-1)
	        return 1;
	    
	    for(int i=0;i<3;i++){
	        int nx=x+dx[i];
	        int ny=y+dy[i];
	        if(0<=nx&&nx<r&&0<=ny&&ny<c&&visited[nx][ny]==0&&graph[nx][ny]==0){
	            visited[nx][ny]=1;
	            if(dfs(nx,ny)==1)
	                return 1;
	        }
	    }
	    return 0;
	}
}