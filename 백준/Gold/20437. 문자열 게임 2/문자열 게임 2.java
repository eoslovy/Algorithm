import java.io.*;
import java.util.*;

public class Main {
    private static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= t; tc++) {
            String str = br.readLine();
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            int ans1 = Integer.MAX_VALUE;
            int ans2 = Integer.MIN_VALUE;

            int len = str.length();
            char[] arr = new char[len];

            for (int i = 0; i < len; i++) {
                arr[i] = str.charAt(i);
            }

            int[] alphabet = new int[26];
            for (int i = 0; i < str.length(); i++) {
                alphabet[arr[i] - 'a']++;
            }

            for (int i = 0; i < len; i++) {
                if (alphabet[arr[i] - 'a'] < k)
                    continue;
                int cnt = 1;
                for (int j = i + 1; j < len; j++) {
                    if (arr[j] == arr[i]) {
                        cnt++;
                    }
                    if (cnt == k) {
                        int length = j - i + 1;
                        ans1 = Math.min(ans1, length);
                        ans2 = Math.max(ans2, length);
                        break;
                    }
                }
            }
            if (k == 1) {
                System.out.println("1 1");
            } else if (ans1 == Integer.MAX_VALUE || ans2 == Integer.MIN_VALUE)
                System.out.println("-1");
            else
                System.out.printf("%d %d\n", ans1, ans2);
        }
    }
}