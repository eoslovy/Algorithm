import java.io.*;
import java.util.*;

public class Main
{
    public static int n,m;
    public static int[][] graph,right,left,dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		graph=new int[n][m];
		left=new int[n][m];
		right=new int[n][m];
		dp=new int[n][m];
		for(int i=0;i<n;i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0;j<m;j++){
		        graph[i][j]=Integer.parseInt(st.nextToken());
		    }
		}
		
// 		System.out.println(Arrays.deepToString(graph));
        
        dp[0][0]=graph[0][0];
        for(int i=1;i<m;i++){
            dp[0][i]=dp[0][i-1]+graph[0][i];
        }
        
        for(int i=1;i<n;i++){
            left[i][0]=dp[i-1][0]+graph[i][0];
            for(int j=1;j<m;j++){
                left[i][j]=Math.max(left[i][j-1],dp[i-1][j])+graph[i][j];
            }
            
            right[i][m-1]=dp[i-1][m-1]+graph[i][m-1];
            for(int j=m-2;j>=0;j--){
                right[i][j]=Math.max(right[i][j+1],dp[i-1][j])+graph[i][j];
            }
            
            for(int j=0;j<m;j++){
                dp[i][j]=Math.max(left[i][j],right[i][j]);
            }
        }
        System.out.println(dp[n-1][m-1]);
	}
}