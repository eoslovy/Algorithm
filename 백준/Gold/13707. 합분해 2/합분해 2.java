import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int k;
    public static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        dp = new int[n + 1][k + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i][1] = 1;
        }
        for (int j = 1; j < k + 1; j++) {
            dp[1][j] = j;
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 2; j < k + 1; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
            }
        }
        System.out.println(dp[n][k] % 1000000000);
//		System.out.println(Arrays.deepToString(dp));
    }
}