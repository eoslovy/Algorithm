import java.util.*;
import java.io.*;

class Fish implements Comparable<Fish>{
    int x;
    int y;
    int distance;
    
    Fish(int x,int y,int distance){
        this.x=x;
        this.y=y;
        this.distance=distance;
    }
    
    @Override
    public int compareTo(Fish o){
        if (this.distance!=o.distance) {
            return this.distance-o.distance;
        } else if (this.x!=o.x) {
            return this.x-o.x;
        } else {
            return this.y-o.y;
        }
    }
}

public class Main
{
    private static int[] dx={0,0,1,-1};
    private static int[] dy={1,-1,0,0};
    private static int[] shark;
    private static int n,size,ing,ans;
    private static int[][] graph,visited;
    private static PriorityQueue<Fish> pq;
    private static Queue<int[]> q;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		
		graph=new int[n][n];
		shark=new int[2];
		size=2;
		ing=0;
		
		for(int i=0;i<n;i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0;j<n;j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
                if(graph[i][j]==9){
                    shark[0]=i;
                    shark[1]=j;
                }
		    }
		}
		
// 		System.out.println(Arrays.deepToString(graph));
        
        ans=0;
        while(true){
            cal();
            if(pq.size()==0)
                break;
            eat();
            
            // for(int i=0;i<n;i++){
            //     System.out.println(Arrays.toString(graph[i]));
            // }
            // System.out.println();
        }
        
        System.out.println(ans);
	}
	
	private static void cal(){
	    pq=new PriorityQueue<>();
	    q=new LinkedList<>();
	    visited=new int[n][n];
	    q.offer(new int[]{shark[0],shark[1],0});
	    visited[shark[0]][shark[1]]=1;
	    
	    while(!q.isEmpty()){
	        int[] now=q.poll();
	        int x=now[0];
	        int y=now[1];
	        int dist=now[2];
	        
	        for(int i=0;i<4;i++){
	            int nx=x+dx[i];
	            int ny=y+dy[i];
	            if(0<=nx&&nx<n&&0<=ny&&ny<n&&visited[nx][ny]==0){
	                if(graph[nx][ny]<=size){
	                    visited[nx][ny]=1;
	                    q.offer(new int[]{nx,ny,dist+1});
	                    if(graph[nx][ny]>0&&graph[nx][ny]<size){
	                        pq.offer(new Fish(nx,ny,dist+1));
	                    }
	                }
	            }
	        }
	    }
	}
	
	private static void eat(){
	    Fish tmp=pq.poll();
	    int x=tmp.x;
	    int y=tmp.y;
	    graph[shark[0]][shark[1]]=0;
	    graph[x][y]=9;
	    shark[0]=x;
	    shark[1]=y;
	    ans+=tmp.distance;
	    ing++;
	    if(ing>=size){
            ing=0;
            size++;
        }
	}
}
