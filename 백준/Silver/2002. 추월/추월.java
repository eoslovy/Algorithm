import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n=Integer.parseInt(st.nextToken());
	    
	    Map<String,Integer> h1=new HashMap<>();
	    
	    for(int i=0;i<n;i++){
	        String car=br.readLine();
	        h1.put(car,i);
	    }
	    
	    int ans=0;
	    for(int i=0;i<n;i++){
	        String car=br.readLine();
	        
	        for(String key:h1.keySet()){
	            if(h1.get(car)>h1.get(key)){
	                ans++;
	                break;
	            }
	        }
	        h1.remove(car);
	    }
	    System.out.println(ans);
	}
}
