import java.io.*;
import java.util.*;

public class Solution {
    private static int n, m, c, ans, tmp_ans;
    private static int[][] graph;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n - m; j++) {
                    int tmp_1 = cal(i, j);
                    for (int k = i; k < n; k++) {
                        if (k == i) {
                            for (int l = j + m; l <= n - m; l++) {
                                int tmp_2 = cal(k, l);
                                ans = Math.max(ans, tmp_1 + tmp_2);
                            }
                        } else {
                            for (int l = 0; l <= n - m; l++) {
                                int tmp_2 = cal(k, l);
                                ans = Math.max(ans, tmp_1 + tmp_2);
                            }
                        }
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, ans);
        }
    }

    private static int cal(int x, int y) {
        arr = new int[m];
        int totalHoney = 0;

        for (int i = 0; i < m; i++) {
            arr[i] = graph[x][y + i];
            totalHoney += arr[i];
        }

        if (totalHoney > c) {
            tmp_ans = Integer.MIN_VALUE;
            subset(0, 0, 0);
        } else {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += arr[i] * arr[i];
            }
            return sum;
        }

        return tmp_ans;
    }

    private static void subset(int idx, int sum, int squareSum) {
        if (sum > c) return;
        if (idx == m) {
            tmp_ans = Math.max(tmp_ans, squareSum);
            return;
        }

        subset(idx + 1, sum + arr[idx], squareSum + arr[idx] * arr[idx]);
        subset(idx + 1, sum, squareSum);
    }
}