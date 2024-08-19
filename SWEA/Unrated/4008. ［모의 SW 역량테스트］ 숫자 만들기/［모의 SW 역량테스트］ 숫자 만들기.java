
import java.util.*;
import java.io.*;

public class Solution {
	private static int[] sachic;
	private static int[] num;
	private static int n;
	private static List<Integer> result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			n = Integer.parseInt(br.readLine());
			sachic = new int[4];
			num = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				sachic[j] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				num[j] = Integer.parseInt(st.nextToken());
			}

			result = new ArrayList<>();
			cal(num[0], 1);

			if (!result.isEmpty()) {
				int min = result.get(0);
				int max = result.get(0);

				for (int res : result) {
					min = Math.min(res, min);
					max = Math.max(res, max);
				}

				System.out.printf("#%d %d\n", i, max - min);
			}
		}
	}

	private static void cal(int ans, int cnt) {
		if (cnt == n) {
			result.add(ans);
//			System.out.println(ans);
			return;
		}

		if (sachic[0] != 0) {
			sachic[0] -= 1;
			cal(ans + num[cnt], cnt + 1);
			sachic[0] += 1;
		}
		if (sachic[1] != 0) {
			sachic[1] -= 1;
			cal(ans - num[cnt], cnt + 1);
			sachic[1] += 1;
		}
		if (sachic[2] != 0) {
			sachic[2] -= 1;
			cal(ans * num[cnt], cnt + 1);
			sachic[2] += 1;
		}
		if (sachic[3] != 0) {
			sachic[3] -= 1;
			if (num[cnt] == 0)
				return;
			cal(ans / num[cnt], cnt + 1);
			sachic[3] += 1;
		}

	}
}
