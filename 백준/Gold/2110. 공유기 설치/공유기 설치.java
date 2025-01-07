import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n=Integer.parseInt(st.nextToken());
	    int c=Integer.parseInt(st.nextToken());
	    
	    int[] home=new int[n];
	    List<Integer>lst=new ArrayList<>();
	    
	    for(int i=0;i<n;i++){
	        st = new StringTokenizer(br.readLine());
	        home[i]=Integer.parseInt(st.nextToken());
	    }
	    
	    Arrays.sort(home);
	   
        int start=1;
        int end=home[n-1]-home[0];
        int result=-1;
        while(true){
            if(start>end)
                break;
            int mid=(start+end)/2;
            int now=home[0];
            int cnt=1;
            
            for(int i=0;i<n;i++){
                if(home[i]-mid>=now){
                    cnt++;
                    now=home[i];
                }
            }
            
            if(cnt>=c){
                start=mid+1;
                result=mid;
            }
            else{
                end=mid-1;
            }
        }
	    System.out.println(result);
	}
}
