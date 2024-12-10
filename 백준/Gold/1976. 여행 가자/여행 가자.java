import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int m=Integer.parseInt(st.nextToken());
		
		int[][] graph=new int[n][n];
		for(int i=0;i<n;i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0;j<n;j++){
		        graph[i][j]=Integer.parseInt(st.nextToken());
		    }
		}
		
		int[] plan=new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++){
		    plan[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n;i++){
		    graph[i][i]=1;
		}
		
		for(int k=0;k<n;k++){
		    for(int i=0;i<n;i++){
		        for(int j=0;j<n;j++){
		            if(graph[i][k]==1&&graph[k][j]==1){
		                graph[i][j]=1;
		            }
		        }
		    }
		}
		
		int flag=0;
		for(int i=0;i<m-1;i++){
		    if(graph[plan[i]-1][plan[i+1]-1]==0){
		        flag=1;
		        break;
		    }
		}
		
// 		for(int i=0;i<n;i++){
// 		    System.out.println(Arrays.toString(graph[i]));
// 		}
		
		if(flag==0)
		    System.out.println("YES");
		else
		    System.out.println("NO");

	}
}