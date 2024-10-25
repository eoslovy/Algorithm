import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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

//		System.out.println(Arrays.toString(visited1));
//		System.out.println(Arrays.toString(visited2));

		for (int i = 100; i >= 0; i--) {
			if (visited1[i] > 0 && visited2[i] > 0) {
				maxValue = i;
				break;
			}
		}

		List<Integer> lst = new ArrayList<>();
//        int cnt=0;
		while (true) {
//            if(cnt>10)
//                break;
//            cnt++;
//            if (maxIdx1 >= a || maxIdx2 >= b)
//                break;
			int idx1 = -1;
			int idx2 = -1;
			int tmpMaxValue = maxValue;
			int tmpMaxIdx1 = maxIdx1;
			int tmpMaxIdx2 = maxIdx2;
//			System.out.printf("%d %d %d\n", maxValue, maxIdx1, maxIdx2);
//			System.out.println(Arrays.toString(visited1));
//			System.out.println(Arrays.toString(visited2));

			int asd1 = 0;
			for (int i = maxIdx1; i < a; i++) {
				if (n[i] == maxValue && visited1[n[i]] > 0) {
//				if (n[i] == maxValue) {
					maxIdx1 = i + 1;
					visited1[n[i]]--;
//					idx1 = i;
					asd1 = 1;
					break;
				}
			}

			int asd2 = 0;
			for (int i = maxIdx2; i < b; i++) {
				if (m[i] == maxValue && visited2[m[i]] > 0) {
//				if (m[i] == maxValue) {
					maxIdx2 = i + 1;
					visited2[m[i]]--;
//					idx2 = i;
					asd2 = 1;
					break;
				}
			}
//			System.out.printf("%d %d %d %d %d\n", maxIdx1, maxIdx2, asd1, asd2, maxValue);

			if (asd1 == 1 && asd2 == 1) {
				lst.add(maxValue);
//				maxIdx1 = idx1 + 1;
//				maxIdx2 = idx2 + 1;
//				visited1[maxValue]--;
//				visited2[maxValue]--;
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
//				System.out.println("max0이라 break");
				break;
			}

			if (tmpMaxValue == maxValue && tmpMaxIdx1 == maxIdx1 && tmpMaxIdx2 == maxIdx2) {
//				System.out.println("겹쳐서 break");
				break;
			}
		}

		System.out.println(lst.size());
		for (int x : lst) {
			System.out.printf("%d ", x);
		}
	}

}
//10
//9 8 7 6 5 1 2 3 4 5
//8
//1 3 5 7 9 6 5 4
//
//4 -> 3
//9 6 5 4 -> 9 6 5