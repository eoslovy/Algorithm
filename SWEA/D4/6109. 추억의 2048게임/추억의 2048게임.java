import java.util.*;
import java.io.*;

public class Solution {
	private static int n;
	private static String s;
	private static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			s = st.nextToken();

			graph = new int[n][n];
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n; k++) {
					graph[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			if (s.equals("up")) {
				delete0();
				move();
			} else if (s.equals("left")) {
				rotate();
				delete0();
				move();
				rotate();
				rotate();
				rotate();
			} else if (s.equals("down")) {
				rotate();
				rotate();
				delete0();
				move();
				rotate();
				rotate();
			} else if (s.equals("right")) {
				rotate();
				rotate();
				rotate();
				delete0();
				move();
				rotate();
			}

			System.out.printf("#%d\n", i);
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					System.out.print(graph[j][k] + " ");
				}
				System.out.println();
			}

		}
	}

	private static void delete0() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][j] == 0) {
					int cnt = 0;
					int tmp = 0;
					while (i+cnt<n) {
						if (graph[i + cnt][j] != 0) {
							tmp = graph[i + cnt][j];
							graph[i][j] = tmp;
							graph[i + cnt][j] = 0;
							break;
						}
						cnt++;
					}
				}
			}
		}
	}

	private static void move() {
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][j] == graph[i + 1][j]) {
					graph[i][j] += graph[i + 1][j];
					graph[i + 1][j] = 0;
					delete0();
				}
			}
		}
	}

	private static void rotate() {
		int[][] copy = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy[j][n - 1 - i] = graph[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graph[i][j] = copy[i][j];
			}
		}
	}
}