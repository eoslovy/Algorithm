import java.io.*;
import java.util.*;

public class Solution {
    private static long n;
    private static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Long.parseLong(st.nextToken());
            ans = 0;
            while (n != 2) {
                long tmp = (long) Math.sqrt(n);
                if (tmp * tmp == n) {
                    n = tmp;
                    ans++;
                } else {
                    long next = (tmp + 1) * (tmp + 1);
                    ans += next - n;
                    n = next;
                }
            }
            System.out.printf("#%d %d\n", i, ans);
        }
    }
}