import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int[] arr, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		res = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0)
				res[cnt] = arr[i];
			else {
				res[n - 1 - cnt] = arr[i];
				cnt++;
			}
		}
//		System.out.println(Arrays.toString(res));

		int ans = 0;
		for (int i = 0; i < n - 1; i++) {
			ans += res[i] * res[i + 1];
		}
		ans += res[0] * res[n - 1];

		System.out.println(ans);
		for (int i = 0; i < n; i++) {
			System.out.printf("%d ", res[i]);
		}
	}

}