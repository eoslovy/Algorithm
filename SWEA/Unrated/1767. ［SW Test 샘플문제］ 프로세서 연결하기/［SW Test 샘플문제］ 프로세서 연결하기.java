import java.io.*;
import java.util.*;

class Core {
	int x;
	int y;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Core(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	private static int n, cnt, maxCore, minLine;
	private static int[][] graph;
	private static List<Core> lst;
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			graph = new int[n][n];
			lst = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
					if (graph[i][j] == 1 && i != 0 && i != n - 1 && j != 0 && j != n - 1) {
						lst.add(new Core(i, j));
					}
				}
			}
			maxCore = 0;
			minLine = Integer.MAX_VALUE;
			cnt = lst.size();
			dfs(0, 0, 0);

			System.out.printf("#%d %d\n", tc, minLine);

		}
	}

	private static void dfs(int depth, int coreCnt, int lineCnt) {
		if (depth == cnt) {
			if (coreCnt > maxCore) {
				maxCore = coreCnt;
				minLine = lineCnt;
			} else if (coreCnt == maxCore) {
				minLine = Math.min(minLine, lineCnt);
			}
			return;
		}

		int x = lst.get(depth).getX();
		int y = lst.get(depth).getY();

		for (int dir = 0; dir < 4; dir++) {
			int nx = x;
			int ny = y;
			int count = 0;

			while (true) {
				nx += dx[dir];
				ny += dy[dir];
//				System.out.println(dir);
//				System.out.println(nx);
//				System.out.println(ny);
				if (nx < 0 || nx >= n)
					break;

				if (ny < 0 || ny >= n)
					break;

				if (graph[nx][ny] != 0) { // 뭔갈 만난거임
//					System.out.println("!!!!");
//					System.out.println(nx);
//					System.out.println(ny);
					count = 0;
					break;
				}
				count++;
			}

			if (count == 0) {
				continue;
			}
//			System.out.println("------------------------");


			// 전선 연결
			nx = x;
			ny = y;
			for (int i = 0; i < count; i++) {
				nx += dx[dir];
				ny += dy[dir];
				graph[nx][ny] = 2;
			}
//			System.out.println("연결");
//			for(int i=0;i<n;i++)
//				System.out.println(Arrays.toString(graph[i]));

			dfs(depth + 1, coreCnt + 1, lineCnt + count);

			// 전선 제거
			nx = x;
			ny = y;
			for (int i = 0; i < count; i++) {
				nx += dx[dir];
				ny += dy[dir];
				graph[nx][ny] = 0;
			}
//			System.out.println("제거");
//			for(int i=0;i<n;i++)
//				System.out.println(Arrays.toString(graph[i]));
		}

		dfs(depth + 1, coreCnt, lineCnt);
	}
}