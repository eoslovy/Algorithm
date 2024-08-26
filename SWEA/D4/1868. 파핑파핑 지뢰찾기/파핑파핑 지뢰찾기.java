import java.io.*;
import java.util.*;

class Node {
	private int x;
	private int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}

public class Solution {
	private static String[][] arr;
	private static int[][] visited;
	private static int n;
	private static int[] dx = { 0, 0, 1, -1, 1, 1, -1, -1 };
	private static int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };
	private static Queue<Node> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());

			String str = new String();
			arr = new String[n][n];
			visited = new int[n][n];

			for (int i = 0; i < n; i++) {
//				st = new StringTokenizer(br.readLine());
				int cnt = 0;
				str = br.readLine();
				for (int j = 0; j < n; j++) {
					char tmp = str.charAt(cnt++);
					arr[i][j] = String.valueOf(tmp);
					if (arr[i][j].equals("*"))
						visited[i][j] = -1;
				}
			}
//			System.out.println(Arrays.deepToString(arr));

			int ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j] == 0 && arr[i][j].equals(".")) {
						if (isSafe(i, j)) {
							queue.add(new Node(i, j));
							check();
							ans++;
						}
					}
				}

			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j] == 0 && arr[i][j].equals(".")) {
						ans++;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, ans);
		}

	}

	private static void check() {
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.getX();
			int y = node.getY();
			visited[x][y] = 1;

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < n && visited[nx][ny] == 0) {
					if (isSafe(nx, ny)) {
						queue.add(new Node(nx, ny));
					}
					visited[nx][ny] = 1;
				}
			}
		}
	}

	private static boolean isSafe(int x, int y) {
		for (int i = 0; i < 8; i++) { // 8방향 확인
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < n && arr[nx][ny].equals("*")) {
				return false;
			}
		}
		return true;
	}
}