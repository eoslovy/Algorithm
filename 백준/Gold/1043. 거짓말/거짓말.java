import java.util.*;
import java.io.*;
public class Main {
    private static int n,m, num, ans;
    private static int[] visited;
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        visited = new int[n+1];

        st = new StringTokenizer(br.readLine());
        num=Integer.parseInt(st.nextToken());
        for(int i=0;i<num;i++){
            visited[Integer.parseInt(st.nextToken())]=1;
        }

        List<int[]> lst = new ArrayList<>();
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            num=Integer.parseInt(st.nextToken());
            int[] party = new int[num];
            for(int j=0;j<num;j++){
                party[j]=Integer.parseInt(st.nextToken());
            }
            lst.add(party);
        }

        // for(int i=0;i<lst.size();i++){
        //     System.out.println(Arrays.toString(lst.get(i)));
        // }        
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                int flag=0;
                for(int x : lst.get(j)){
                    if(visited[x]==1)
                        flag=1;
                }
                if(flag==1){
                    for(int x : lst.get(j)){
                        visited[x]=1;
                        // System.out.println(x);
                    }
                    // System.out.println(Arrays.toString(visited));
                    // System.out.println("----------------");
                }
            }
        }
        // System.out.println(Arrays.toString(visited));
        
        for(int[] x : lst){
            int flag=0;
            for(int i=0;i<x.length;i++){
                if(visited[x[i]]==1){
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                ans++;
            
        }

        System.out.println(ans);


    }
}