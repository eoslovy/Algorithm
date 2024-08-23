import java.io.*;
import java.util.*;

public class Solution {
	private static int dir;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			String[][] graph = new String[h][w];
			int x = 0, y = 0;
			String tmp;
			String[] arr = new String[w];
			for (int i = 0; i < h; i++) {
				tmp = br.readLine();
				arr = tmp.split("");
				for (int j = 0; j < w; j++) {
					graph[i][j] = arr[j];
					if (graph[i][j].equals("^") || graph[i][j].equals("v") || graph[i][j].equals("<")
							|| graph[i][j].equals(">")) {
						x = i;
						y = j;
						if (graph[i][j].equals(">"))
							dir = 0;
						else if (graph[i][j].equals("<"))
							dir = 1;
						else if (graph[i][j].equals("v"))
							dir = 2;
						else if (graph[i][j].equals("^"))
							dir = 3;
					}
				}
			}

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			tmp = br.readLine();
			String[] lst = new String[n];
			lst = tmp.split("");

			for (int i = 0; i < n; i++) {
				if (lst[i].equals("U")) {
					dir = 3;
					if (0 <= x - 1 && x - 1 < h && 0 <= y && y < w && graph[x - 1][y].equals(".")) {
						graph[x][y] = ".";
						x = x - 1;
					}
					graph[x][y] = "^";
				} else if (lst[i].equals("D")) {
					dir = 2;
					if (0 <= x + 1 && x + 1 < h && 0 <= y && y < w && graph[x + 1][y].equals(".")) {
						graph[x][y] = ".";
						x = x + 1;
					}
					graph[x][y] = "v";
				} else if (lst[i].equals("L")) {
					dir = 1;
					if (0 <= x && x < h && 0 <= y - 1 && y - 1 < w && graph[x][y - 1].equals(".")) {
						graph[x][y] = ".";
						y = y - 1;
					}
					graph[x][y] = "<";
				} else if (lst[i].equals("R")) {
					dir = 0;
					if (0 <= x && x < h && 0 <= y + 1 && y + 1 < w && graph[x][y + 1].equals(".")) {
						graph[x][y] = ".";
						y = y + 1;
					}
					graph[x][y] = ">";
				} else if (lst[i].equals("S")) {
					int tmp_x = x;
					int tmp_y = y;
					int flag = 0;
					if (dir == 0) {
						while (0 <= tmp_y && tmp_y < w && flag == 0) {
							if (graph[tmp_x][tmp_y].equals("#"))
								break;
							if (graph[tmp_x][tmp_y].equals("*")) {
								graph[tmp_x][tmp_y] = ".";
								flag = 1;
							}
							tmp_y++;
						}
					} else if (dir == 1) {
						while (0 <= tmp_y && tmp_y < w && flag == 0) {
							if (graph[tmp_x][tmp_y].equals("#"))
								break;
							if (graph[tmp_x][tmp_y].equals("*")) {
								graph[tmp_x][tmp_y] = ".";
								flag = 1;
							}
							tmp_y--;
						}
					} else if (dir == 2) {
						while (0 <= tmp_x && tmp_x < h && flag == 0) {
							if (graph[tmp_x][tmp_y].equals("#"))
								break;
							if (graph[tmp_x][tmp_y].equals("*")) {
								graph[tmp_x][tmp_y] = ".";
								flag = 1;
							}
							tmp_x++;
						}
					} else if (dir == 3) {
						while (0 <= tmp_x && tmp_x < h && flag == 0) {
							if (graph[tmp_x][tmp_y].equals("#"))
								break;
							if (graph[tmp_x][tmp_y].equals("*")) {
								graph[tmp_x][tmp_y] = ".";
								flag = 1;
							}
							tmp_x--;
						}
					}
				}

			}
			System.out.printf("#%d ", tc);
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(graph[i][j]);
				}
				System.out.println();
			}
		}
	}

}