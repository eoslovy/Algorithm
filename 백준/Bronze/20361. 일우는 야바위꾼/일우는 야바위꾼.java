import java.util.*;
import java.io.*;

public class Main {
	private static int n, x, k;
	private static int[] snack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		snack = new int[n + 1];
		snack[x] = 1;

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			change(first, second);
		}

		for (int i = 1; i < n + 1; i++) {
			if (snack[i] == 1) {
				System.out.printf("%d", i);
			}
		}
	}

	private static void change(int a, int b) {
		int tmp = snack[a];
		snack[a] = snack[b];
		snack[b] = tmp;
	}
}