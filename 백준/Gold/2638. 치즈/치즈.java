import java.util.*;
import java.io.*;
public class Main {
    private static int n,m, num, ans;
    private static int nx[] = {0,0,1,-1};
    private static int ny[] = {1,-1,0,0};
    private static int[][] visited, visited2;
    private static int[][] graph;
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        graph = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        ans=0;
        while(true){
            if(foo()==0)
                break;
            visited = new int[n][m];
            visited2 = new int[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(i==0 || j==0){
                        if(visited2[i][j]==0)
                            bfs(i, j);
                    }
                }
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(graph[i][j]==0)
                        continue;
                    else{
                        int cnt=0;
                        for(int k=0; k<4; k++){
                            int dx = i + nx[k];
                            int dy = j + ny[k];
                            if(0 <= dx && dx < n && 0 <= dy && dy < m){
                                if(graph[dx][dy]==0 && visited2[dx][dy]!=0)
                                    cnt++;
                            }
                        }
                        if(cnt>=2)
                            visited[i][j] = 1;
                    }
                }
            }
            // for(int i=0;i<n;i++){
            //     System.out.println(Arrays.toString(visited[i]));
            // }
//            System.out.println();
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(visited[i][j]==1)
                        graph[i][j]=0;
                }
            }
            ans++;
        }

        System.out.println(ans);
    }

    private static int foo(){
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(graph[i][j]==1)
                    cnt++;
            }
        }
        return cnt;
    }

    private static void bfs(int a, int b){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a,b});
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int x=tmp[0];
            int y=tmp[1];
            visited2[x][y]=1;
            for(int i=0;i<4;i++){
                int dx = x+nx[i];
                int dy = y+ny[i];
                if(0 <= dx && dx < n && 0 <= dy && dy < m&&visited2[dx][dy]==0&&graph[dx][dy]==0){
                    visited2[dx][dy]=visited2[x][y]+1;
                    q.add(new int[]{dx,dy});
                }
            }
        }
    }
}