import java.io.*;
import java.util.*;

class Rain implements Comparable<Rain> {
	int height;
	int index;

	public Rain(int height, int index) {
		super();
		this.height = height;
		this.index = index;
	}

	@Override
	public int compareTo(Rain o) {
		return o.height - this.height;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[] visited = new int[w];
		int[] real = new int[w];
		int ans = 0;
		List<Rain> lst = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < w; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			lst.add(new Rain(tmp, i));
			real[i] = tmp;
		}

		Collections.sort(lst);

		int tmp = 0;
		int high, low, start, end;
		while (tmp < w - 1) {
			int cnt = 0;
			high = lst.get(tmp).height;
			start = lst.get(tmp).index;

			low = lst.get(tmp + 1).height;
			end = lst.get(tmp + 1).index;

			tmp++;
			if (Math.abs(start - end) == 1)
				continue;

			if (start < end) {
				for (int i = start + 1; i <= end; i++) {
					if (visited[i] == 0) {
						if (low - real[i] > 0)
							cnt += low - real[i];
						visited[i] = 1;
					}
				}
			} else {
				for (int i = end + 1; i <= start; i++) {
					if (visited[i] == 0) {
						if (low - real[i] > 0)
							cnt += low - real[i];
						visited[i] = 1;
					}
				}
			}
			ans += cnt;
		}
		System.out.println(ans);
	}

}