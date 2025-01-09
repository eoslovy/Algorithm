import java.util.*;
import java.io.*;

public class Main
{
    public static int n,m,ans;
    public static int[] graph,visited;
    public static List<int[]> ladder,snake;
    public static Queue<int[]> q;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        graph=new int[101];
        visited=new int[101];
        ladder=new ArrayList<>();
        snake=new ArrayList<>();
        q=new LinkedList<>();
        ans=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            ladder.add(new int[]{x,y});
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            snake.add(new int[]{x,y});
        }

        q.add(new int[]{1,0});
        solve();
        System.out.println(ans);
    }

    public static void solve(){
        while(!q.isEmpty()){
            int[] qwe=q.poll();
            int now=qwe[0];
            int cnt=qwe[1];
            visited[now]=1;

            if(now==100){
                ans=Math.min(ans,cnt);
                return;
            }
            
            // System.out.printf("%d %d\n",now,cnt);

            for(int i=6;i>=0;i--){
                int next=now+i;
                if(next<=100){
                    int flag=0;
                    for(int j=0;j<n;j++){
                        int[] asd=ladder.get(j);
                        if(next==asd[0]&&visited[next]==0){
                            q.add(new int[]{asd[1],cnt+1});
                            flag=1;
                            break;
                        }
                    }
        
                    for(int j=0;j<m;j++){
                        int[] asd=snake.get(j);
                        if(next==asd[0]&&visited[next]==0){
                            q.add(new int[]{asd[1],cnt+1});
                            flag=-1;
                            break;
                        }
                    }
                    if(flag==0&&visited[next]==0)
                        q.add(new int[]{next,cnt+1});
                }
            }
        }
    }
}
