import java.util.*;
import java.io.*;

public class Main
{
    private static int n,l,r;
    private static int[] dx={0,0,-1,1};
    private static int[] dy={1,-1,0,0};
    private static int[][] graph,visited,already;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		l=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		
		graph=new int[n][n];
		for(int i=0;i<n;i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0;j<n;j++){
		        graph[i][j]=Integer.parseInt(st.nextToken());
		    }
		}
		
// 		System.out.println(Arrays.deepToString(graph));
		
		Queue<int[]> q=new LinkedList<>();
		List<int[]> lst;
		int ans=0;
		while(true){
		    int flag=0;
		    already=new int[n][n]; //밑에서 연산 끝낸 애들
    		for(int i=0;i<n;i++){
    		    for(int j=0;j<n;j++){
    		        if(already[i][j]==1)
    		            continue;
    		        lst=new ArrayList<>(); //연합된 애들 담아놓는 곳
    		        int tmp=0;
    		      //  visited=new int[n][n]; //계산 돌릴 때 마다 초기화해주기
    		        q.add(new int[] {i,j});
    		        lst.add(new int[] {i,j});
    		        already[i][j]=1;
    		        while(!q.isEmpty()){
    		            int[] foo = q.poll();
    		            int x=foo[0];
    		            int y=foo[1];
    		        
        		        for(int k=0;k<4;k++){
        		            int nx=x+dx[k];
        		            int ny=y+dy[k];
        		            if(0<=nx&&nx<n&&0<=ny&&ny<n){
        		                if(already[nx][ny]==0){
            		                int dif=Math.abs(graph[x][y]-graph[nx][ny]);
            		                if(l<=dif&&dif<=r){
                		                already[nx][ny]=1;
                		                q.add(new int[] {nx,ny});
                		                lst.add(new int[] {nx,ny});
                		                flag=1;
            		                }
        		                }
        		            }
        		        }
    		        }
    		        
    		        int cnt=lst.size();
    		        if(cnt!=1){
        		        for(int a=0;a<cnt;a++){
        		            int[] asd=lst.get(a);
        		            int x=asd[0];
        		            int y=asd[1];
        		            tmp+=graph[x][y];
        		        }
        		        
        		        for(int a=0;a<cnt;a++){
        		            int[] asd=lst.get(a);
        		            int x=asd[0];
        		            int y=asd[1];
        		            graph[x][y]=tmp/cnt;
        		            already[x][y]=1;
        		        }
    		        }
    		    }
    		}
    		
    // 		for(int i=0;i<n;i++){
    // 		    System.out.println(Arrays.toString(visited[i]));
    // 		  //  System.out.println(Arrays.toString(graph[i]));
    // 		}
    // 		for(int i=0;i<n;i++){
    // 		  //  System.out.println(Arrays.toString(visited[i]));
    // 		    System.out.println(Arrays.toString(graph[i]));
    // 		}
    		
    // 		System.out.println(tmp/cnt);
    		if(flag==0)
    		    break;
    		ans++;
		}
		
		System.out.println(ans);
	}
}