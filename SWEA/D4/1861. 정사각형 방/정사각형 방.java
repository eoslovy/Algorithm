import java.util.*;
import java.io.*;

public class Solution {
	private static int n, num;
	private static int[][] graph;
	private static int[][] ans;
	private static int[] dx = { 0, 0, 1, -1 };
	private static int[] dy = { 1, -1, 0, 0 };
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			max = 0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());

			graph = new int[n][n];
			ans = new int[n][n];
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n; k++) {
					graph[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dfs(i, j, 1);
					ans[i][j] = max;
					max = 0;
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (ans[i][j] == max) {
						if (graph[i][j] < num) {
							max = ans[i][j];
							num = graph[i][j];
						}
					}
					if (ans[i][j] > max) {
						max = ans[i][j];
						num = graph[i][j];
					}
				}
			}

			System.out.printf("#%d %d %d\n", tc, num, max);
		}
	}

	private static void dfs(int x, int y, int cnt) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < n) {
				if (graph[nx][ny] == graph[x][y] + 1) {
					dfs(nx, ny, cnt + 1);
				}
			}
		}
		max = Math.max(max, cnt);
	}
}