import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int a, b, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		ans = Integer.MAX_VALUE;
		dfs(b, 0);
		System.out.println(ans + 1);
	}

	private static void dfs(int x, int cnt) {
		if (x == a) {
			ans = Math.min(ans, cnt);
			return;
		}

		if (x % 10 == 1)
			dfs((x - 1) / 10, cnt + 1);

		else if (x > a && x % 2 == 0)
			dfs(x / 2, cnt + 1);

		else
			ans = -2;
	}

}