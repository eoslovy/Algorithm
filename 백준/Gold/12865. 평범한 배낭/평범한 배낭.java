import java.util.*;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] dp = new int[k + 1];
		int[] weight = new int[n];
		int[] value = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			// 뒤에서 앞으로 무게 갱신 (한 물건을 여러 번 넣지 않기 위해 뒤에서 순회)
			for (int j = k; j >= weight[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
			}
		}

		System.out.println(dp[k]);
	}
}