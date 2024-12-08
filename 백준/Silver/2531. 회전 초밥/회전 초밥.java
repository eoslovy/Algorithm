import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		
		int[] graph=new int[2*n];
		int[] visited=new int[d+1];
		
		for(int i=0;i<n;i++){
		    st=new StringTokenizer(br.readLine());
		    graph[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=n;i<2*n;i++){
		    graph[i]=graph[i-n];
		}
		
// 		System.out.println(Arrays.toString(graph));
		
		int start=0;
		int end=k-1;
		int[] tmp=new int[k];
		int cnt=0;
        for(int i=0;i<k;i++){
            tmp[i]=graph[i];
            if(visited[graph[i]]==0)
                cnt++;
            visited[graph[i]]++;
        }
		
		int result=0;
		while(true){
            int out=graph[start];
            visited[out]--;
            if(visited[out]==0)
                cnt--;

		    start++;
		    end++;
            if(end>=2*n)
                break;
		    
		    int in=graph[end];
		    if(visited[in]==0)
		        cnt++;
		    visited[in]++;
		    
		    if(visited[c]==0)
		        result=Math.max(result, cnt+1);
		    else
		        result=Math.max(result,cnt);
		}
		System.out.println(result);
	}
}