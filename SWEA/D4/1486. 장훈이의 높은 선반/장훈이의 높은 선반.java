import java.util.*;
import java.io.*;

public class Solution {
	private static int n, b, count;
	private static int[] height;
	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			height = new int[n];
			ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				height[j] = Integer.parseInt(st.nextToken());
			}

//			System.out.println(Arrays.toString(height));

			for (count = 1; count <= n; count++) {
				combi(0, 0, 0);
			}

			System.out.printf("#%d %d\n", i, ans - b);
		}
	}

	private static void combi(int cnt, int start, int res) {
		if (cnt == count) {
//			System.out.printf("%d %d\n", cnt, res);
			if (res >= b)
				ans = Math.min(ans, res);
			return;
		}
		for (int i = start; i < n; i++) {
			combi(cnt + 1, i + 1, res += height[i]);
			res-=height[i];
		}
	}

}