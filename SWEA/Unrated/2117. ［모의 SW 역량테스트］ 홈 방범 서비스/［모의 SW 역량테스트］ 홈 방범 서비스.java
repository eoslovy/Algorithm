import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Coor {
	int x;
	int y;

	public Coor(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

public class Solution {
	private static int n, m, ans;
	private static List<Coor> lst;
	private static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			graph = new int[n][n];
			lst = new ArrayList<>();
			ans = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
					if (graph[i][j] == 1)
						lst.add(new Coor(i, j));
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dfs(i, j);
				}
			}

			System.out.printf("#%d %d\n", tc, ans);
		}
	}

	private static void dfs(int x, int y) {
		int max_price = m * lst.size();
		for (int i = 1; i < 2 * n; i++) {
			int cost = i * i + (i - 1) * (i - 1);
			int cnt = 0;

			for (int j = 0; j < lst.size(); j++) {
				if (Math.abs(x - lst.get(j).x) + Math.abs(y - lst.get(j).y) < i) {
					cnt++;
				}
			}
			if ((m * cnt) - cost >= 0) {
				ans = Math.max(ans, cnt);
//				System.out.printf("%d %d %d %d\n", ans, i, x, y);
			}
		}
	}

}