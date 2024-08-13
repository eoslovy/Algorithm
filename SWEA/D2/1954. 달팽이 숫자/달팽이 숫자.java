import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int test_case = 1; test_case < t + 1; test_case++) {
			int n = sc.nextInt();

			int[][] graph = new int[n + 2][n + 2];
			for (int i = 0; i < n + 2; i++) {
				for (int j = 0; j < n + 2; j++) {
					graph[i][j] = -1;
				}
			}

			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					graph[i][j] = 0;
				}
			}

			int cnt = 1;
			int x = 1, y = 1;
			int flag = 0;
			while (cnt <= n * n) {
				graph[x][y] = cnt++;
				if (flag % 4 == 0) {
					if (graph[x][y + 1] == -1 || graph[x][y + 1] != 0) {
						flag += 1;
						x++;
					}
					else
						y++;
				} else if (flag % 4 == 1) {
					if (graph[x + 1][y] == -1 || graph[x + 1][y] != 0) {
						flag += 1;
						y--;
					}
					else
						x++;
				} else if (flag % 4 == 2) {
					if (graph[x][y - 1] == -1 || graph[x][y - 1] != 0) {
						flag += 1;
						x--;
					}
					else
						y--;
				} else if (flag % 4 == 3) {
					if (graph[x - 1][y] == -1 || graph[x - 1][y] != 0) {
						flag += 1;
						y++;
					}
					else
						x--;
				}
			}

			System.out.printf("#%d\n", test_case);
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					System.out.printf("%d ", graph[i][j]);
				}
				System.out.println();
			}
		}
	}
}