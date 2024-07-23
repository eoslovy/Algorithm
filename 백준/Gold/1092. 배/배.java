import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String input1 = br.readLine();
		StringTokenizer st1 = new StringTokenizer(input1, " ");
		Integer[] crane = new Integer[n];

		for (int i = 0; i < n; i++)
			crane[i] = Integer.parseInt(st1.nextToken());

		int m = Integer.parseInt(br.readLine());
		Integer[] box = new Integer[m];

		String input2 = br.readLine();
		StringTokenizer st2 = new StringTokenizer(input2, " ");
		for (int i = 0; i < m; i++)
			box[i] = Integer.parseInt(st2.nextToken());

		Arrays.sort(crane, Collections.reverseOrder());
		Arrays.sort(box, Collections.reverseOrder());

//        System.out.println(Arrays.toString(crane));
//        System.out.println(Arrays.toString(box));

		int[] craneInt = Arrays.stream(crane).mapToInt(Integer::intValue).toArray();
		int[] boxInt = Arrays.stream(box).mapToInt(Integer::intValue).toArray();

		int cnt = 0;
		int tmp = 0;
		int[] visited = new int[m];
		while (Arrays.stream(visited).sum() != m) {
			tmp = 0;
			int a = Arrays.stream(visited).sum();
			for (int i = 0; i < m; i++) {
				if (visited[i] == 0 && craneInt[tmp] >= boxInt[i]) {
					visited[i] = 1;
					tmp++;
				}
				if (tmp == n)
					break;
			}
			cnt++;
			int b = Arrays.stream(visited).sum();
			if (a == b) {
				System.out.println(-1);
				System.exit(0);
			}

		}
		System.out.println(cnt);
	}
}