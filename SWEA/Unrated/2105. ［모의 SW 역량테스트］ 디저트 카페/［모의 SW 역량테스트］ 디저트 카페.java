import java.io.*;
import java.util.*;

public class Solution {
	private static int[][] graph;
	private static int[] dx = { 1, 1, -1, -1 };
	private static int[] dy = { 1, -1, -1, 1 };
	private static int n;
	private static int ans;
	private static int dir;
	private static List<Integer> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());

			graph = new int[n][n];
			ans = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int result = -1;
			for (int i = 0; i < n - 1; i++) { // 가로
				for (int j = 1; j < n - 1; j++) { // 세로
					for (int k = 1; k < n; k++) { //오른쪽 대각선 개수
						for (int l = 1; l < n; l++) { // 왼쪽 대각선 개수
							if (0 <= j - l && k + j < n && i + k + l < n) { // 그래프 안에서만 있게 하는 조건
								if (solve(i, j, k, l, k, l)) {
									result = Math.max(result, 2 * (k + l));
								}
							}
						}
					}
				}
			}
			System.out.printf("#%d %d\n", tc, result);
		}
	}

	private static boolean solve(int x, int y, int cnt1, int cnt2, int cnt3, int cnt4) {
		dir = 0;
		q = new ArrayList<>();
		while (cnt1 != 0) { // 오른쪽 아래
			cnt1--;
			q.add(graph[x][y]);
			x = x + dx[dir];
			y = y + dy[dir];
		}
		dir++;
		while (cnt2 != 0) { // 왼쪽 아래
			cnt2--;
			q.add(graph[x][y]);
			x = x + dx[dir];
			y = y + dy[dir];
		}
		dir++;
		while (cnt3 != 0) { // 왼쪽 위
			cnt3--;
			q.add(graph[x][y]);
			x = x + dx[dir];
			y = y + dy[dir];
		}
		dir++;
		while (cnt4 != 0) { // 오른쪽 위
			cnt4--;
			q.add(graph[x][y]);
			x = x + dx[dir];
			y = y + dy[dir];
		}

		int flag = 0;
		for (int i = 0; i < q.size(); i++) {
			for (int j = i + 1; j < q.size(); j++) {
				if (q.get(i) == q.get(j))
					flag = 1;
			}
		}

		if (flag == 0) {
			int tmp = 0;
			for (int i = 0; i < q.size(); i++) {
				tmp += q.get(i);
			}
			ans = Math.max(ans, tmp);
			return true;
		}
		return false;
	}
}