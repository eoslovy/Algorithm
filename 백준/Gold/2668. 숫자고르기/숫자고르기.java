import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		int[] visited = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
//		System.out.println(Arrays.toString(arr));

		for (int i = 1; i <= n; i++) {
			int next = i;
			int tmp = n + 1;
			int cnt = 0;
			int flag = 0;
			while (true) {
				if (i == tmp)
					break;
				tmp = arr[next];
				next = tmp;
				cnt++;
				if (cnt > n) {
					flag = 1;
					break;
				}
			}
			if (flag == 0)
				visited[i] = 1;
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (visited[i] == 1)
				ans++;
		}
		System.out.println(ans);
		for (int i = 1; i <= n; i++) {
			if (visited[i] == 1)
				System.out.println(i);
		}
	}

}