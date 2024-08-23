import java.io.*;
import java.util.*;

public class Solution {
	private static int n, company_x, company_y, home_x, home_y, x, y;
	private static int[][] coor;
	private static boolean[] visited;
	private static int[] asd;
	private static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			result = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			company_x = Integer.parseInt(st.nextToken());
			company_y = Integer.parseInt(st.nextToken());
			home_x = Integer.parseInt(st.nextToken());
			home_y = Integer.parseInt(st.nextToken());
			x = company_x;
			y = company_y;
			visited = new boolean[n];
			asd = new int[n];

			coor = new int[n][2];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 2; j++) {
					coor[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0, 0);
			System.out.printf("#%d %d\n", tc, result);
		}
	}

	private static void dfs(int cnt, int ans) {
		if (cnt == n) {
			ans += Math.abs(x - home_x) + Math.abs(y - home_y);
			result = Math.min(result, ans);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			int tmp = Math.abs(x - coor[i][0]) + Math.abs(y - coor[i][1]);
			int tmp_x = x;
			int tmp_y = y;
			x = coor[i][0];
			y = coor[i][1];
			visited[i] = true;
			asd[cnt] = coor[i][0];

			dfs(cnt + 1, ans + tmp);
			visited[i] = false;
			x = tmp_x;
			y = tmp_y;
		}
	}
}