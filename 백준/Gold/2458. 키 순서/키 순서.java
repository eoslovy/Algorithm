import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int n, m;
	private static int[][] arr;
	private static int[][] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];
		cnt = new int[n + 1][2];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = -1;
		}

		for (int i = 1; i <= n; i++) {
			int[] visited1 = new int[n + 1];
			int[] visited2 = new int[n + 1];
			dfs1(i, visited1);
			dfs2(i, visited2);
		}

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (cnt[i][0] + cnt[i][1] == n - 1) {
				ans++;
			}
		}
		System.out.println(ans);
	}

	private static void dfs1(int x, int[] visited) {
		visited[x] = 1;
		for (int i = 1; i <= n; i++) {
			if (arr[x][i] == 1 && visited[i] == 0) {
				cnt[i][1]++;
				dfs1(i, visited);
			}
		}
	}

	private static void dfs2(int x, int[] visited) {
		visited[x] = 1;
		for (int i = 1; i <= n; i++) {
			if (arr[x][i] == -1 && visited[i] == 0) {
				cnt[i][0]++;
				dfs2(i, visited);
			}
		}
	}
}