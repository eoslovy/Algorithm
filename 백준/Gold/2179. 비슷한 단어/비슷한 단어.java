import java.util.*;
import java.io.*;

public class Main
{
    private static int n,cnt,ans;
    private static String s,t;
    private static ArrayList<String> lst,original;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		lst=new ArrayList<>();
		original=new ArrayList<>();

		for(int i=0;i<n;i++){
            lst.add(br.readLine());
            original.add(lst.get(i));
		}

        
        // Collections.sort(lst);
        
        // System.out.println(lst);
        
        ans=0;
        for(int i=0;i<n-1;i++){
            String tmp1=lst.get(i);
            for(int j=i+1;j<n;j++){
                cnt=0;
                String tmp2=lst.get(j);
                for(int a=0;a<Math.min(tmp1.length(),tmp2.length());a++){
                    if(tmp1.charAt(a)==tmp2.charAt(a))
                        cnt++;
                    else
                        break;
                }
                if(ans<cnt){
                    s=tmp1;
                    t=tmp2;
                    ans=cnt;
                }
            }
        }
        
        System.out.println(s);
        System.out.println(t);
        
        // for(int i=0;i<n;i++){
        //     if(original.get(i).equals(s)||original.get(i).equals(t))
        //         System.out.println(original.get(i));
        // }
	}
}
