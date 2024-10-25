import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static int a, b;
	private static int[] n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] visited1 = new int[101];
		int[] visited2 = new int[101];

		a = Integer.parseInt(st.nextToken());
		n = new int[a];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			n[i] = Integer.parseInt(st.nextToken());
			visited1[n[i]]++;
		}

		st = new StringTokenizer(br.readLine());
		b = Integer.parseInt(st.nextToken());
		m = new int[b];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < b; i++) {
			m[i] = Integer.parseInt(st.nextToken());
			visited2[m[i]]++;
		}
		int maxValue = 0;
		int maxIdx1 = 0;
		int maxIdx2 = 0;

		for (int i = 100; i >= 0; i--) {
			if (visited1[i] > 0 && visited2[i] > 0) {
				maxValue = i;
				break;
			}
		}

		List<Integer> lst = new ArrayList<>();
		while (true) {
			int asd1 = 0;
			for (int i = maxIdx1; i < a; i++) {
				if (n[i] == maxValue && visited1[n[i]] > 0) {
					maxIdx1 = i + 1;
					visited1[n[i]]--;
					asd1 = 1;
					break;
				}
			}

			int asd2 = 0;
			for (int i = maxIdx2; i < b; i++) {
				if (m[i] == maxValue && visited2[m[i]] > 0) {
					maxIdx2 = i + 1;
					visited2[m[i]]--;
					asd2 = 1;
					break;
				}
			}

			if (asd1 == 1 && asd2 == 1) {
				lst.add(maxValue);
			} else if (asd1 == 0 && asd2 == 0)
				break;

			maxValue = 0;
			for (int i = 100; i >= 0; i--) {
				if (visited1[i] > 0 && visited2[i] > 0) {
					maxValue = i;
					int flag1 = 0;
					for (int j = maxIdx1; j < a; j++) {
						if (n[j] == maxValue) {
							flag1 = 1;
							break;
						}
					}
					int flag2 = 0;
					for (int j = maxIdx2; j < b; j++) {
						if (m[j] == maxValue) {
							flag2 = 1;
							break;
						}
					}
					if (flag1 == 1 && flag2 == 1)
						break;
				}
			}

			if (maxValue == 0) {
				break;
			}
		}

		System.out.println(lst.size());
		for (int x : lst) {
			System.out.printf("%d ", x);
		}
	}

}