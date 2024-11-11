import java.util.*;
import java.io.*;
public class Main {
    private static int a, b;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static int[][] graph1, graph2, visited, visited_fire, visited_run;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        graph1 = new int[a][b];
        graph2 = new int[a][b];
        visited_fire = new int[a][b];
        visited_run = new int[a][b];
        visited = new int[a][b];
        
        int[] fire;
        int[] jihoon;
        
        fire = new int[2];
        jihoon = new int[2];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<a;i++){
            String tmp = br.readLine();
            for(int j=0;j< b;j++){
                if(tmp.charAt(j)=='#'){
                    graph1[i][j]=-1;
                    graph2[i][j]=-1;
                }
                else if(tmp.charAt(j)=='J'){
                    graph1[i][j]=1;
                    graph2[i][j]=1;
                    jihoon[0]=i;
                    jihoon[1]=j;
                    visited_run[i][j]=1;
                    if(i==0||i==a-1||j==0||j==b-1){
                        System.out.println(1);
                        return;
                    }
                }
                else if(tmp.charAt(j)=='F'){
                    graph1[i][j]=2;  
                    graph2[i][j]=2; 
                    fire[0]=i;
                    fire[1]=j;
                    visited_fire[i][j]=1;
                    q.add(new int[]{fire[0],fire[1]});
                }
                else if(tmp.charAt(j)=='.'){
                    graph1[i][j]=0; 
                    graph2[i][j]=0; 
                }
            }
        }
        
        // System.out.println(Arrays.deepToString(graph1));
        
        while(!q.isEmpty()){
            int[] tmp = new int[2];
            tmp = q.poll();
            int x=tmp[0];
            int y=tmp[1];
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(0<=nx&&nx<a&&0<=ny&&ny<b){
                    if((graph1[nx][ny]==0||graph1[nx][ny]==1)&&visited_fire[nx][ny]==0){
                        visited_fire[nx][ny]=visited_fire[x][y]+1;
                        // graph[nx][ny]=2;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        
        q.add(new int[]{jihoon[0],jihoon[1]});
        while(!q.isEmpty()){
            int[] tmp = new int[2];
            tmp = q.poll();
            int x=tmp[0];
            int y=tmp[1];
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(0<=nx&&nx<a&&0<=ny&&ny<b){
                    if(graph2[nx][ny]==0&&visited_run[nx][ny]==0){
                        visited_run[nx][ny]=visited_run[x][y]+1;
                        graph2[nx][ny]=1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                if(i==0||i==a-1||j==0||j==b-1){
                    if(graph1[i][j]==0&&visited_run[i][j]!=0){
                        if(visited_fire[i][j]==0 || visited_fire[i][j]>visited_run[i][j]){
                            ans=Math.min(ans, visited_run[i][j]);
                        }
                    }
                }
            }
        }
        if(ans!=Integer.MAX_VALUE)
            System.out.println(ans);
        else
            System.out.println("IMPOSSIBLE");
        // System.out.println(Arrays.deepToString(graph1));
        // System.out.println(Arrays.deepToString(visited_run));
        // System.out.println(Arrays.deepToString(visited_fire));
        
    }
}