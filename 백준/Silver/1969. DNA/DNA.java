import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        sc.nextLine();

        char[][] str=new char[n][m];
        String[] arr_str=new String[n];

        for(int i=0;i<n;i++) {
            arr_str[i]=sc.nextLine();
        }
        Arrays.sort(arr_str);

        for(int i=0;i<n;i++) {
            String tmp=arr_str[i];
            for(int j=0;j<m;j++) {
                str[i][j]=tmp.charAt(j);
            }
        }

        int[][] visited = new int[n][m];
        char[] DNA = new char[m];
        for(int i=0;i<m;i++) {
            int[] cnt = new int[4];
            for(int j=0;j<n;j++) {
                if (str[j][i]=='A')
                    cnt[0]++;
                else if(str[j][i]=='C')
                    cnt[1]++;
                else if(str[j][i]=='G')
                    cnt[2]++;
                else if(str[j][i]=='T')
                    cnt[3]++;
            }
            int res = Integer.MIN_VALUE;
            for(int j=0;j<4;j++){
                res=Math.max(res,cnt[j]);
            }
            if (res==cnt[0])
                DNA[i]='A';
            else if (res==cnt[1])
                DNA[i]='C';
            else if (res==cnt[2])
                DNA[i]='G';
            else if (res==cnt[3])
                DNA[i]='T';
        }

        int answer=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(str[i][j]!=DNA[j])
                    answer++;
            }
        }

        System.out.println(DNA);
        System.out.print(answer);

        sc.close();
    }
}
