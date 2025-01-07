import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n=Integer.parseInt(st.nextToken());
	    
	    Map<String,Integer> h=new HashMap<>();
	    List<String> lst=new ArrayList<>();
	    for(int i=0;i<n;i++){
	        String key=br.readLine();
	        if(h.containsKey(key)){
	            int value=h.get(key);
	            h.replace(key,value+1);
	        }
	        else{
	            h.put(key,1);
	        }
	    }
        
        int max=0;
        for(String key:h.keySet()){
            max=Math.max(max,h.get(key));
        }
        
        for(String key:h.keySet()){
            if(h.get(key)==max){
                lst.add(key);
            }
        }
        Collections.sort(lst);
        
        System.out.println(lst.get(0));
	}
}
