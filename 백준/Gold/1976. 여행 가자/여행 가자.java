import java.util.*;
import java.io.*;

public class Main
{
    private static int[] parent;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int m=Integer.parseInt(st.nextToken());
		
		parent=new int[n];
		
		for(int i=0;i<n;i++){
		    parent[i]=i;
		}
		
		for(int i=0;i<n;i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0;j<n;j++){
		        int connected=Integer.parseInt(st.nextToken());
		        if(connected==1)
		            union(i,j);
		    }
		}
		
		int[] plan=new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++){
		    plan[i]=Integer.parseInt(st.nextToken())-1;
		}
		

		
		int flag=0;
		int root=find(plan[0]);
		for(int i=1;i<m;i++){
		    if(find(plan[i])!=root){
		        flag=1;
		        break;
		    }
		}
		
		if(flag==0)
		    System.out.println("YES");
		else
		    System.out.println("NO");
        
	}

    static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
	
	static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}