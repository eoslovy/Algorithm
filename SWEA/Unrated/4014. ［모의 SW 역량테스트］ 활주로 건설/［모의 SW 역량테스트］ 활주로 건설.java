import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			int[][] graph = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int ans = 0;
			for (int i = 0; i < n; i++) {
				int start = 0;
				int end = 1;
				int flag = 0;
				int[] visited = new int[n];
//				visited[start] = 1;
//				visited[end] = 1;
				while (true) {
					if (end >= n) {
						break;
					}
					if (graph[i][start] == graph[i][end]) {
						end++;
//						System.out.printf("%d %d %d %d\n", i, start, end, flag);
//						System.out.println("----------asd-----------");
						if (end == n) {
							break;
						}
					}
//					if (end > n - 1) {
//						System.out.println(i);
//						System.out.println("걸림 ㅅㄱ용ㅋㅋㅋㅋ");
//						break;
//					}그  ㅅㅂend++해놓고 마지막에 다른 경우 flag =1해줘야하는 코드 작성해라 ㅅㅂ 밥먹고!!

					else if (graph[i][start] != graph[i][end]) {
						if (end + x > n && graph[i][start] > graph[i][end]) {
//							System.out.println(i);
//							System.out.println("zzzz");
							flag = 1;
							break;
						}
						start = end - 1;
//						System.out.printf("%d %d %d\n", i, graph[i][start], graph[i][end]);
//						System.out.println("체크체크");
						if (graph[i][start] + 1 == graph[i][end]) {
							for (int j = start; j >= Math.max(0, start - x + 1); j--) {
//								System.out.printf("%d %d %d %d\n", i, start, end, flag);
//								System.out.printf("%d %d %d %d\n", i, graph[i][end], graph[i][j], flag);
//								System.out.println("asdasddsadasd");
								if (end - x < 0)
									flag = 1;
								if (graph[i][end - 1] != graph[i][j] || visited[j] == 1)
									flag = 1;
							}
							if (flag == 0) {
								for (int j = start; j >= Math.max(0, start - x+1); j--) {
									visited[j] = 1;
								}
							}
						} else if (graph[i][start] - 1 == graph[i][end]) {
							for (int j = end; j < Math.min(n, end + x); j++) {
//								System.out.printf("%d %d %d %d\n", i, start, end, flag);
//								System.out.printf("%d %d %d %d\n", i, graph[i][end], graph[i][j], flag);
//								System.out.println("wqeeqwwqeeqw");
								if (end + x - 1 > n - 1)
									flag = 1;
								if (graph[i][end] != graph[i][j])
									flag = 1;
							}
							if (flag == 0) {
								for (int j = end; j < Math.min(n, end + x); j++) {
									visited[j] = 1;
								}
							}
						} else {
							flag = 1;
						}
//						if (Math.abs(graph[i][start] - graph[i][end]) == 1) {
//							for (int j = end; j < Math.min(n, end + x); j++) {
//								if (end + x > n - 1)
//									flag = 1;
//								if (graph[i][end] != graph[i][j])
//									flag = 1;
//							}
//						}
//						System.out.printf("%d %d %d %d\n", i, start, end, flag);
//						System.out.println("------------------------");
						if (flag == 1)
							break;
//						if (graph[i][start] > graph[i][end]) {
						start += 1;
						end += 1;
//						}
//						System.out.printf("%d %d %d %d\n", i, start, end, flag);
//						if (end + x > n - 1) {
//							break;
//						}
					}
				}
				if (flag == 0) {
					ans++;
//					System.out.println(i);
//					System.out.println("ans증가 ㅋㅋ");
				}
			}

			int[][] tmpGraph = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					tmpGraph[i][j] = graph[j][i];
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					graph[i][j] = tmpGraph[i][j];
				}
			}

			for (int i = 0; i < n; i++) {
				int start = 0;
				int end = 1;
				int flag = 0;
				int[] visited = new int[n];
//				visited[start] = 1;
//				visited[end] = 1;
				while (true) {
					if (end >= n) {
						break;
					}
					if (graph[i][start] == graph[i][end]) {
						end++;
//						System.out.printf("%d %d %d %d\n", i, start, end, flag);
//						System.out.println("----------asd-----------");
						if (end == n) {
							break;
						}
					}
//					if (end > n - 1) {
//						System.out.println(i);
//						System.out.println("걸림 ㅅㄱ용ㅋㅋㅋㅋ");
//						break;
//					}그  ㅅㅂend++해놓고 마지막에 다른 경우 flag =1해줘야하는 코드 작성해라 ㅅㅂ 밥먹고!!

					else if (graph[i][start] != graph[i][end]) {
						if (end + x > n && graph[i][start] > graph[i][end]) {
//							System.out.println(i);
//							System.out.println("zzzz");
							flag = 1;
							break;
						}
						start = end - 1;
//						System.out.printf("%d %d %d\n", i, graph[i][start], graph[i][end]);
//						System.out.println("체크체크");
						if (graph[i][start] + 1 == graph[i][end]) {
							for (int j = start; j >= Math.max(0, start - x + 1); j--) {
//								System.out.printf("%d %d %d %d\n", i, start, end, flag);
//								System.out.printf("%d %d %d %d\n", i, graph[i][end], graph[i][j], flag);
//								System.out.println("asdasddsadasd");
								if (end - x < 0)
									flag = 1;
								if (graph[i][end - 1] != graph[i][j] || visited[j] == 1)
									flag = 1;
							}
							if (flag == 0) {
								for (int j = start; j >= Math.max(0, start - x+1); j--) {
									visited[j] = 1;
								}
							}
						} else if (graph[i][start] - 1 == graph[i][end]) {
							for (int j = end; j < Math.min(n, end + x); j++) {
//								System.out.printf("%d %d %d %d\n", i, start, end, flag);
//								System.out.printf("%d %d %d %d\n", i, graph[i][end], graph[i][j], flag);
//								System.out.println("wqeeqwwqeeqw");
								if (end + x - 1 > n - 1)
									flag = 1;
								if (graph[i][end] != graph[i][j])
									flag = 1;
							}
							if (flag == 0) {
								for (int j = end; j < Math.min(n, end + x); j++) {
									visited[j] = 1;
								}
							}
						} else {
							flag = 1;
						}
//						if (Math.abs(graph[i][start] - graph[i][end]) == 1) {
//							for (int j = end; j < Math.min(n, end + x); j++) {
//								if (end + x > n - 1)
//									flag = 1;
//								if (graph[i][end] != graph[i][j])
//									flag = 1;
//							}
//						}
//						System.out.printf("%d %d %d %d\n", i, start, end, flag);
//						System.out.println("------------------------");
						if (flag == 1)
							break;
//						if (graph[i][start] > graph[i][end]) {
						start += 1;
						end += 1;
//						}
//						System.out.printf("%d %d %d %d\n", i, start, end, flag);
//						if (end + x > n - 1) {
//							break;
//						}
					}
				}
				if (flag == 0) {
					ans++;
//					System.out.println(i);
//					System.out.println("ans증가 ㅋㅋz");
				}
			}
			System.out.printf("#%d %d\n", tc, ans);

		}
	}

}