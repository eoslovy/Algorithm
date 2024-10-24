import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int n, m;
	private static int[] arr, res, visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		res = new int[m];
		visited = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		solve(0);

	}

	private static void solve(int cnt) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}

		int tmp = -1;
		for (int i = 0; i < n; i++) {
			if (visited[i] == 0 && arr[i] != tmp) {
				visited[i] = 1;
				res[cnt] = arr[i];
				tmp = arr[i];
				solve(cnt + 1);
				visited[i] = 0;
			}
		}
	}

}