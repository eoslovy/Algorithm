import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n=Integer.parseInt(st.nextToken());
	    int m=Integer.parseInt(st.nextToken());
	    
	    HashMap<String,String> h=new HashMap<>();
	    for(int i=0;i<n;i++){
	        st = new StringTokenizer(br.readLine());
	        h.put(st.nextToken(),st.nextToken());
	    }
        
        String[] input=new String[m];
        for(int i=0;i<m;i++){
            input[i]=br.readLine();
        }
        
        for(int i=0;i<m;i++){
            System.out.println(h.get(input[i]));
        }
	}
}
