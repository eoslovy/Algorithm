import java.io.*;
import java.util.*;

public class Main {
    private static int n, k, p, x;
    private static int[][] graph =
            {{0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
                    {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
                    {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
                    {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
                    {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
                    {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
                    {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
                    {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
                    {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
                    {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            int tmp = 0;
            int tmp_x = x;
            int tmp_i = i;
            for (int j = 0; j < k; j++) {
                tmp += graph[tmp_i % 10][tmp_x % 10];
                if (tmp > p)
                    break;
                tmp_x /= 10;
                tmp_i /= 10;
            }
            if (tmp <= p)
                ans++;
        }
        System.out.println(ans - 1);
    }

}