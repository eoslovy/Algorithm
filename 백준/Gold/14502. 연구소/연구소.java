import java.io.*;
import java.util.*;

public class Main
{
    public static int n,m,ans;
    public static int[][] graph,visited;
    public static int[] dx={0,0,1,-1};
    public static int[] dy={1,-1,0,0};
    public static List<int[]> q;
    public static Queue<int[]> lst;
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    
        graph=new int[n][m];
        q=new ArrayList<>();
        lst=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
                // visited[i][j]=1;
                if(graph[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        
        ans=0;
        dfs(0);
        
        System.out.println(ans);
	}
	
	public static int[][] copy1(){
	    int[][] copyGraph=new int[n][m];
	    for(int i=0;i<n;i++){
	        for(int j=0;j<m;j++){
	            copyGraph[i][j]=graph[i][j];
	        }
	    }
	    return copyGraph;
	}
	
	public static int[][] copy2(){
	    int[][] copyVisited=new int[n][m];
	    for(int i=0;i<n;i++){
	        for(int j=0;j<m;j++){
	            copyVisited[i][j]=visited[i][j];
	        }
	    }
	    return copyVisited;
	}
	
	public static Queue<int[]> copy3(){
	    Queue<int[]> copyQ=new LinkedList<>();
	    for(int i=0;i<q.size();i++){
	        int[] asd=q.get(i);
	        copyQ.add(new int[] {asd[0],asd[1]});
	    }
	    return copyQ;
	}
	
    public static void dfs(int cnt){
        if(cnt==3){
            int[][] copyGraph=copy1();
            Queue<int[]> copyQ=copy3();
            bfs(copyGraph,copyQ);
            return;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(graph[i][j]==0){
                    graph[i][j]=1;
                    dfs(cnt+1);
                    graph[i][j]=0;
                }
            }
        }
    }
	
	public static void bfs(int[][] copygraph,Queue<int[]> copyq){
	    while(!copyq.isEmpty()){
	        int[] now=copyq.poll();
	        int x=now[0];
	        int y=now[1];
	        for(int i=0;i<4;i++){
	            int nx=x+dx[i];
	            int ny=y+dy[i];
	            if(0<=nx&&nx<n&&0<=ny&&ny<m&&copygraph[nx][ny]==0){
	                copygraph[nx][ny]=2;
	                copyq.add(new int[]{nx,ny});
	            }
	        }
	    }
	    ans=Math.max(ans,solve(copygraph));
	}
	
	public static int solve(int[][] asd){
	    int cnt=0;
	    for(int i=0;i<n;i++){
	        for(int j=0;j<m;j++){
	            if(asd[i][j]==0)
	                cnt++;
	        }
	    }
	    return cnt;
	}
}