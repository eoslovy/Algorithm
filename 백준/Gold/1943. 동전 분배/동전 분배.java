import java.io.*;
import java.util.*;

public class Main
{
    public static int n,total;
    public static int[] coins,dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc=0;tc<3;tc++){
		    st = new StringTokenizer(br.readLine());
    		n=Integer.parseInt(st.nextToken());
    		coins=new int[100001];
    		
    		total=0;
    		for(int i=0;i<n;i++){
    		    st = new StringTokenizer(br.readLine());
    		    int price=Integer.parseInt(st.nextToken());
    		    int count=Integer.parseInt(st.nextToken());
    		    coins[price]=count;
    		    total+=price*count;
    		}
            
            if(total%2==1){
                System.out.println(0);
                continue;
            }
            
            int mid=total/2;
    		dp=new int[mid+1];
            dp[0]=1;
            
            for(int i=0;i<=mid;i++){
                if(coins[i]>0){
                    int price=i;
                    int cnt=coins[i];
                    for(int j=mid;j>=price;j--){
                        for(int k=1;k<=cnt&&j>=k*price;k++){
                            if(dp[j-price*k]==1){
                                dp[j]=1;
                            }
                        }
                    }
                    // System.out.println(Arrays.toString(dp));
                }
            }
            System.out.println(dp[mid]);
		}
	}
}