import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int n, ans;
	private static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		String cry = br.readLine();
		visited = new int[n];
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			if (cry.charAt(i) == '#')
				visited[i] = 1;
		}

		for (int i = 1; i <= n; i++) {
			solve(i);
		}

		System.out.println(ans);
	}

	private static void solve(int day) {
		int[] tmp = new int[n];
		for (int i = 0; i < n; i++) {
			tmp[i] = visited[i];
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int flag = 0;
			for (int j = i; j < n; j += day) {
				if (tmp[j] == 1) {
					tmp[j] = 0;
					flag = 1;
				} else {
					break;
				}
			}
			if (flag == 1)
				cnt++;
		}

		if (check(tmp)) {
			ans = Math.min(ans, cnt);
		}
	}

	private static boolean check(int[] asd) {
		for (int i = 0; i < n; i++) {
			if (asd[i] == 1)
				return false;
		}
		return true;
	}

}