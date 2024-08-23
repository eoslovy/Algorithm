import java.util.*;
import java.io.*;

public class Main {
	private static int n, k;
	private static int[] lst;
	private static int[] robot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		lst = new int[2 * n];
		for (int i = 0; i < 2 * n; i++) {
			lst[i] = Integer.parseInt(st.nextToken());
		}
		robot = new int[n];
		int ans = 0;
		while (true) {
			if (!cal())
				break;
			move();
			for (int i = n - 2; i >= 0; i--) {
				robot[i + 1] = robot[i];
			}
			robot[0] = 0;
			robot[n - 1] = 0;
			for (int i = n - 2; i >= 0; i--) {
				if (robot[i] == 1 && robot[i + 1] == 0 && lst[i + 1] >= 1) {
					robot[i + 1] = 1;
					robot[i] = 0;
					lst[i + 1] -= 1;
				}
			}
			if (lst[0] >= 1) {
				robot[0] = 1;
				lst[0]--;
			}
			ans++;
		}
//		System.out.println(Arrays.toString(lst));
		System.out.println(ans);
	}

	private static void move() {
		int tmp = lst[2 * n - 1];
		for (int i = 2 * n - 2; i >= 0; i--) {
			lst[i + 1] = lst[i];
		}
		lst[0] = tmp;
	}

	private static boolean cal() {
		int cnt = 0;
		for (int i = 0; i < 2 * n; i++) {
			if (lst[i] == 0)
				cnt++;
			if (cnt == k)
				return false;
		}
		return true;
	}
}