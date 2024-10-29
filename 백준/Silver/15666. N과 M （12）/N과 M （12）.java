import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int n, m, ans;
	private static int[] arr;
	private static List<Integer> lst;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		lst = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		lst.add(arr[0]);
		int cnt = 0;
		for (int i = 1; i < n; i++) {
			if (lst.get(cnt) != arr[i]) {
				lst.add(arr[i]);
				cnt++;
			}
		}

		solve(0, new int[m]);

	}

	private static void solve(int cnt, int[] res) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				System.out.printf("%d ", res[i]);
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < lst.size(); i++) {
			if (cnt != 0 && res[cnt - 1] > lst.get(i))
				continue;
			res[cnt] = lst.get(i);
			solve(cnt + 1, res);
		}
	}

}