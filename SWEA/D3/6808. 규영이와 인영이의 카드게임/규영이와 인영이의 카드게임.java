import java.util.*;
import java.io.*;

public class Solution {
	private static List<int[]> lst;
	private static boolean[] check;
	private static int[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int i = 1; i < t + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int[] first = new int[9];
			int[] flag = new int[18];
			for (int j = 0; j < 9; j++) {
				first[j] = Integer.parseInt(st.nextToken());
				flag[first[j] - 1] = 1;
			}

			int tmp = 0;
			input = new int[9];
			for (int j = 0; j < 18; j++) {
				if (flag[j] != 1)
					input[tmp++] = j + 1;
			}

			lst = new ArrayList<>();
			check = new boolean[9];

			perm(new int[9], 0);

			int result1 = 0;
			int result2 = 0;
//			System.out.println(lst.size());

			for (int[] perms : lst) {
				tmp = cal(perms, first);
				if (tmp < 0)
					result1++;
				else if (tmp > 0)
					result2++;
			}

			System.out.printf("#%d %d %d\n", i, result1, result2);
		}
	}

	private static int cal(int[] a, int[] b) {
		int result = 0;
		for (int i = 0; i < 9; i++) {
			if (a[i] < b[i]) {
				result -= (a[i] + b[i]);
			} else {
				result += (a[i] + b[i]);
			}
//			if (result >= 86 || result <= -86)
//				break;
		}
		if (result > 0)
			return 1;
		else if (result < 0)
			return -1;
		else
			return 0;
	}

	private static void perm(int[] a, int cnt) {
		if (cnt == 9) {
			lst.add(Arrays.copyOf(a, a.length));
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (check[i])
				continue;
			a[cnt] = input[i];
			cnt++;
			check[i] = true;
//			System.out.println(a);
//			System.out.println(cnt);

			perm(a, cnt);
			cnt--;
			check[i] = false;
		}
	}
}