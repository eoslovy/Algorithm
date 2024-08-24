import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] dp = new int[10001];
            int[] result = new int[10001];

            result[0] = 0;
            dp[0] = 0;

            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            dp[4] = 1;
            dp[5] = 1;

            dp[6] = 2;
            dp[7] = 1;
            dp[8] = 2;
            dp[9] = 2;
            dp[10] = 2;
            dp[11] = 2;


            if (n >= 12) {
                for (int i = 12; i <= n; i++) {
                    dp[i] = dp[i - 6] + 1;
                }
            }

            for (int i = 0; i < n; i++) {
                result[i + 1] = dp[i + 1] + result[i];
            }

//            System.out.println(Arrays.toString(dp));
//            System.out.println(Arrays.toString(result));
            System.out.println(result[n]);
        }


    }
}
