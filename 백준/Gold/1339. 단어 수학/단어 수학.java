import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		String[] str = new String[n];

		for (int i = 0; i < n; i++) {
			str[i] = br.readLine();
		}

//		System.out.println(Arrays.toString(str));

		int max_str = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max_str = Math.max(max_str, str[i].length());
		}

//		System.out.println(max_str);
		String[][] arr = new String[n][max_str];

		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = 0; j < max_str - str[i].length(); j++) {
				arr[i][j] = "0";
			}
			for (int j = max_str - str[i].length(); j < max_str; j++) {
				char tmp = str[i].charAt(cnt++);
				arr[i][j] = String.valueOf(tmp);
			}
		}
//		System.out.println(Arrays.deepToString(arr));

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < max_str; j++) {

			}
		}

		String[] alphabet = new String[10];
		alphabet[0] = "0";
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < max_str; j++) {
				int flag = 0;
				if (!arr[i][j].equals("0")) {
					if (alphabet[0].equals("0")) {
						alphabet[0] = arr[i][j];
						cnt++;
					} else {
						for (int k = 0; k < cnt; k++) {
							if (alphabet[k].equals(arr[i][j])) {
								flag = 1;
							}
						}
						if (flag == 0) {
							alphabet[cnt++] = arr[i][j];
						}
					}
				}
			}
		}
//		System.out.println(Arrays.toString(alphabet));
		// alphabet에 쓰이는 알파벳들 넣음

		// 알파벳들 우선순위 정해주고
		int value = 1;
		for (int i = 0; i < max_str - 1; i++) {
			value = value * 10;
		}
//		System.out.println(value);

		int[] num = new int[10];
		for (int j = 0; j < max_str; j++) {
			for (int i = 0; i < n; i++) {
				if (arr[i][j].equals("0") && j != 9)
					continue;
				for (int k = 0; k < cnt; k++) {
					if (alphabet[k].equals(arr[i][j])) {
						num[k] += value;
					}
				}
			}
			value /= 10;
		}

//		System.out.println(Arrays.toString(alphabet));
//		System.out.println(Arrays.toString(num));

		// 숫자대로 넣어주면 됨
		int[] asd = new int[10];

		for (int i = 0; i < 10; i++) {
			asd[i] = num[i];
		}

		int count = 9;
		int[] real = new int[10];
		int[] visited = new int[10];
		for (int i = 0; i < cnt; i++) {
			int compare = Integer.MIN_VALUE;
			for (int j = 0; j < cnt; j++) {
				compare = Math.max(compare, num[j]);
//				System.out.println(compare);
			}
			for (int j = 0; j < cnt; j++) {
				if (compare == num[j] && real[j] == 0 && visited[j] == 0) {
					real[j] = count--;
					visited[j] = 1;
					num[j] = 0;
//					System.out.println(Arrays.toString(real));
				}
			}
		}
//		System.out.println(Arrays.toString(real));

		// 이제 숫자대로 넣어주기
		int ans = 0;
		for (int i = 0; i < cnt; i++) {
			ans += asd[i] * real[i];
//			System.out.printf("%d %d %d\n", ans, num[i], real[i]);
		}
		System.out.println(ans);

	}
}