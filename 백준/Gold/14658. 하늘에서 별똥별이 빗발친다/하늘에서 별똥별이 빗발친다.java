import java.io.*;
import java.util.*;

public class Main
{
    private static int n,m,l,k;
    private static int[][] star;
    private static List<Integer> coorX,coorY;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		l=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		star=new int[k][2];
		coorX=new ArrayList<>();
		coorY=new ArrayList<>();
	    for(int i=0;i<k;i++){
	        st = new StringTokenizer(br.readLine());
	        star[i][0]=Integer.parseInt(st.nextToken());
	        star[i][1]=Integer.parseInt(st.nextToken());
	        coorX.add(star[i][0]);
	        coorY.add(star[i][1]);
	    }
	    Collections.sort(coorX);
	    Collections.sort(coorY);
	    
	    int ans=0;
        for(int i=0;i<k;i++){
            int x=coorX.get(i);
            for(int j=0;j<k;j++){
                int y=coorY.get(j);
                int cnt=0;
                for(int a=0;a<k;a++){
    	            if(x<=star[a][0]&&star[a][0]<=x+l){
    	                if(y<=star[a][1]&&star[a][1]<=y+l){
    	                    cnt++;
    	                }
    	            }
	            }
	            ans=Math.max(ans,cnt);
            }
        }
	    System.out.println(k-ans);
	}
}