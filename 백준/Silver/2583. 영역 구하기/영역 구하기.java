import java.io.*;
import java.util.*;

class Node {
	int x;
	int y;

	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + "]";
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}

public class Main {
	private static int M, N, K;
	private static int[][] graph;
	private static int[][] visited;
	private static Queue<Node> lst;
	private static int[] dx = { 0, 0, 1, -1 };
	private static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		graph = new int[M][N];
		visited = new int[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int first_x = Integer.parseInt(st.nextToken());
			int first_y = Integer.parseInt(st.nextToken());
			int second_x = Integer.parseInt(st.nextToken());
			int second_y = Integer.parseInt(st.nextToken());
			for (int j = first_x; j < second_x; j++) {
				for (int k = first_y; k < second_y; k++) {
					graph[k][j] = 1;
				}
			}
		}

		lst = new ArrayDeque<>();
		ArrayList<Integer> ans = new ArrayList<>();
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (graph[i][j] == 0 && visited[i][j] == 0) {
					lst.add(new Node(i, j));
					ans.add(bfs());
					cnt++;
				}
			}
		}

		int[] result = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++) {
			result[i] = ans.get(i);
		}
		Arrays.sort(result);

		System.out.println(cnt);
//		System.out.println(Arrays.toString(result));
		for (int i = 0; i < ans.size(); i++) {
			System.out.printf("%d ", result[i]);
		}
	}

	private static int bfs() {
		int tmp = 0;
		while (!lst.isEmpty()) {
			Node node = lst.poll();
			int x = node.x;
			int y = node.y;
			visited[x][y] = 1;
			tmp++;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < M && 0 <= ny && ny < N) {
					if (graph[nx][ny] == 0 && visited[nx][ny] == 0) {
						lst.add(new Node(nx, ny));
						visited[nx][ny] = 1;
					}
				}
			}
		}
		return tmp;
	}

}