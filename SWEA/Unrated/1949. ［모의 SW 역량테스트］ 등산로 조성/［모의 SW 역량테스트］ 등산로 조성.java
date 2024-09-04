import java.io.*;
import java.util.*;

class Map {
	int x;
	int y;

	public Map(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

public class Solution {

	private static int n, k, ans;
	private static List<Map> lst;
	private static int[][] graph;
	private static int[] dx = { 0, 0, 1, -1 };
	private static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			graph = new int[n][n];
			lst = new ArrayList<>();
			ans = 0;

			int max_height = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
					max_height = Math.max(max_height, graph[i][j]);
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (graph[i][j] == max_height)
						lst.add(new Map(i, j));
				}
			}

			for (int i = 0; i < lst.size(); i++) {
				for (int j = 1; j <= k; j++) {
					for (int l = 0; l < n; l++) {
						for (int m = 0; m < n; m++) {
							graph[l][m] -= j;
							bfs(lst.get(i).x, lst.get(i).y);
							graph[l][m] += j;
						}
					}
				}
			}

			System.out.printf("#%d %d\n", tc, ans);
		}
	}

	private static void bfs(int a, int b) {
		Queue<Map> queue = new ArrayDeque<>();
		queue.add(new Map(a, b));
		int[][] visited = new int[n][n];
		visited[a][b] = 1;
		while (!queue.isEmpty()) {
			Map map = queue.poll();
			int x = map.x;
			int y = map.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < n && graph[x][y] > graph[nx][ny]) {
					queue.add(new Map(nx, ny));
					visited[nx][ny] = visited[x][y] + 1;
				}
			}
		}

		int[][] visited1 = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] != 0)
					visited1[i][j] = -1;
			}
		}
		visited1[a][b] = 0;

		queue.add(new Map(a, b));
		while (!queue.isEmpty()) {
			Map map = queue.poll();
			int x = map.x;
			int y = map.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < n && graph[x][y] < graph[nx][ny]) {
					if (visited1[nx][ny] == 0 && nx != a && ny != b) {
						queue.add(new Map(nx, ny));
						visited1[nx][ny] = visited1[x][y] + 1;
					}
				}
			}
		}

		int tmp = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tmp = Math.max(tmp, visited[i][j]);
			}
		}

		int tmp1 = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tmp1 = Math.max(tmp1, visited1[i][j]);
			}
		}

		ans = Math.max(ans, tmp + tmp1);
	}
}