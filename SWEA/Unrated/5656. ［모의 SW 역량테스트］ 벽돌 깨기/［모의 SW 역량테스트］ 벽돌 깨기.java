import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Block {
	int x;
	int y;

	public Block(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Solution {
	private static int n, w, h, ans;
	private static int[][] graph, tmpGraph;
	private static int[] dx = { 0, 0, 1, -1 };
	private static int[] dy = { 1, -1, 0, 0 };
	private static ArrayList<ArrayList<Integer>> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			graph = new int[h][w];
			tmpGraph = new int[h][w];
			ans = Integer.MAX_VALUE;
			list = new ArrayList<>();

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			perm(0, new int[n]);

			for (ArrayList<Integer> sequence : list) {
				copy();
				for (int col : sequence) {
					shoot(col);
					arrange();
				}
				ans = Math.min(ans, cal());
			}

			System.out.printf("#%d %d\n", tc, ans);
		}

	}

	private static void shoot(int col) {
		Queue<Block> q = new LinkedList<>();

		for (int i = 0; i < h; i++) {
			if (tmpGraph[i][col] != 0) {
				q.add(new Block(i, col));
				break;
			}
		}

		while (!q.isEmpty()) {
			Block block = q.poll();
			int x = block.x;
			int y = block.y;
			int power = tmpGraph[x][y];
			tmpGraph[x][y] = 0;

			for (int dir = 0; dir < 4; dir++) {
				for (int step = 1; step < power; step++) {
					int nx = x + dx[dir] * step;
					int ny = y + dy[dir] * step;
					if (nx >= 0 && nx < h && ny >= 0 && ny < w && tmpGraph[nx][ny] > 0) {
						q.add(new Block(nx, ny));
					}
				}
			}
		}
	}

	private static void arrange() {
		ArrayList<Integer> lst;
		for (int i = 0; i < w; i++) {
			lst = new ArrayList<>();
			for (int j = 0; j < h; j++) {
				if (tmpGraph[j][i] != 0) {
					lst.add(tmpGraph[j][i]);
					tmpGraph[j][i] = 0;
				}
			}
			int tmp = 0;
			for (int j = h - lst.size(); j < h; j++) {
				tmpGraph[j][i] = lst.get(tmp++);
			}
		}
	}

	private static void copy() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				tmpGraph[i][j] = graph[i][j];
			}
		}
	}

	private static int cal() {
		int cnt = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (tmpGraph[i][j] != 0)
					cnt++;
			}
		}
		return cnt;
	}

	private static void perm(int x, int[] arr) {
		if (x == n) {
			ArrayList<Integer> tmp = new ArrayList<>();
			for (int i = 0; i < x; i++) {
				tmp.add(arr[i]);
			}
			list.add(tmp);
			return;
		}

		for (int i = 0; i < w; i++) {
			arr[x] = i;
			perm(x + 1, arr);
		}
		return;
	}

}