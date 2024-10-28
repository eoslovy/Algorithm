import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int t, n, m;
	private static int[] arr1, arr2;
	private static List<Integer> lst1, lst2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr1 = new int[n];
		lst1 = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		arr2 = new int[m];
		lst2 = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr1[j];
				lst1.add(sum);
			}
		}

		for (int i = 0; i < m; i++) {
			int sum = 0;
			for (int j = i; j < m; j++) {
				sum += arr2[j];
				lst2.add(sum);
			}
		}

		Collections.sort(lst1);
		Collections.sort(lst2);

		long sum = 0;
		for (int x : lst1) {
			int front = 0;
			int end = lst2.size() - 1;
			int mid = 0;
			while (front <= end) {
				mid = (front + end) / 2;
				if (lst2.get(mid) + x >= t) {
					end = mid - 1;
				} else {
					front = mid + 1;
				}
			}
			int first = front;

			front = 0;
			end = lst2.size() - 1;
			while (front <= end) {
				mid = (front + end) / 2;
				if (lst2.get(mid) + x > t) {
					end = mid - 1;
				} else {
					front = mid + 1;
				}
			}
			int second = front;
			sum += second - first;
		}

		System.out.println(sum);
	}
}