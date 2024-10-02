import java.util.*;

import java.io.*;

class Boo {
	int cnt;
	int mainX;
	int mainY;
	int subX1;
	int subY1;
	int subX2;
	int subY2;

	public Boo(int cnt, int mainX, int mainY, int subX1, int subY1, int subX2, int subY2) {
		super();
		this.cnt = cnt;
		this.mainX = mainX;
		this.mainY = mainY;
		this.subX1 = subX1;
		this.subY1 = subY1;
		this.subX2 = subX2;
		this.subY2 = subY2;
	}
}

public class Main {
	private static int n, m;
	private static int result, tmpCnt;
	private static int[][] graph;
	private static int[][] visited;
	private static int[] nx1 = { -1, 0, 1, 0 };
	private static int[] ny1 = { 0, 1, 0, -1 };
	private static int[] nx2 = { 0, 1, 0, -1 };
	private static int[] ny2 = { 1, 0, -1, 0 };
	private static ArrayList<Boo> boo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n][m];
		visited = new int[n][m];
		boo = new ArrayList<>();
		result = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (n < 2 || m < 2)
			System.out.println(0);

		else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					solve(i, j);
				}
			}
			visited = new int[n][m];
			cal(0, 0);

			System.out.println(result);
		}
	}

	private static void solve(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int dx1 = nx1[i] + x;
			int dy1 = ny1[i] + y;
			int dx2 = nx2[i] + x;
			int dy2 = ny2[i] + y;
			if (check(dx1, dy1) && check(dx2, dy2)) {
				int tmp = 2 * graph[x][y] + graph[dx1][dy1] + graph[dx2][dy2];
				boo.add(new Boo(tmp, x, y, dx1, dy1, dx2, dy2));
			}
		}
	}

	private static boolean check(int x, int y) {
		if (0 <= x && x < n && 0 <= y && y < m) {
			return true;
		}
		return false;
	}

	private static void cal(int x, int res) {
		if (x == boo.size()) {
			result = Math.max(result, res);
			return;
		}
		if (visited[boo.get(x).mainX][boo.get(x).mainY] == 0 && visited[boo.get(x).subX1][boo.get(x).subY1] == 0
				&& visited[boo.get(x).subX2][boo.get(x).subY2] == 0) {
			visited[boo.get(x).mainX][boo.get(x).mainY] = 1;
			visited[boo.get(x).subX1][boo.get(x).subY1] = 1;
			visited[boo.get(x).subX2][boo.get(x).subY2] = 1;
			cal(x + 1, res + boo.get(x).cnt);
			visited[boo.get(x).mainX][boo.get(x).mainY] = 0;
			visited[boo.get(x).subX1][boo.get(x).subY1] = 0;
			visited[boo.get(x).subX2][boo.get(x).subY2] = 0;
			cal(x + 1, res);
		} else {
			cal(x + 1, res);
		}
	}
}