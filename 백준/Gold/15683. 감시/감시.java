import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Coor {
	int x;
	int y;

	public Coor(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}

public class Main {
	private static int n, m, cnt, ans;
	private static int[][] graph;
	private static List<Coor> lst;
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	private static int[][] cctv = { {}, { 1 }, { 1, 3 }, { 0, 1 }, { 0, 1, 3 }, { 0, 1, 2, 3 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n][m];
		lst = new ArrayList<>();
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (1 <= graph[i][j] && graph[i][j] <= 5) {
					lst.add(new Coor(i, j));
				}
			}
		}
		cnt = lst.size();
		dfs(0, new int[cnt]);
		System.out.println(ans);
	}

	private static void dfs(int n, int[] asd) {
		if (n == cnt) {
			ans = Math.min(ans, cal(asd));
			return;
		}
		asd[n] = 0;
		dfs(n + 1, asd);
		asd[n] = 1;
		dfs(n + 1, asd);
		asd[n] = 2;
		dfs(n + 1, asd);
		asd[n] = 3;
		dfs(n + 1, asd);
	}

	private static int cal(int[] tmp) {
		int[][] visited = new int[n][m];

		// 이제 4 방향 회전하면서 체크하면 될 듯!!
		for (int i = 0; i < cnt; i++) {
			int x = lst.get(i).getX();
			int y = lst.get(i).getY();
			int rot = tmp[i];
			int type = graph[x][y];

			for (int dir : cctv[type]) {
				dir = (dir + rot) % 4;
				int nx = x;
				int ny = y;
				while (true) {
					nx = nx + dx[dir];
					ny = ny + dy[dir];
					if (0 > nx || nx >= n)
						break;
					if (0 > ny || ny >= m)
						break;
					if (graph[nx][ny] == 6)
						break;
					visited[nx][ny] = 1;
				}
			}
		}

		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == 0 && visited[i][j] == 0)
					res++;
			}
		}
		return res;
	}
}