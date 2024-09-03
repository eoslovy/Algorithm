import java.io.*;
import java.util.*;

public class Main {
	private static String a, b;
	private static List<Character> deque;
	private static List<Character> lst;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		a = br.readLine();
		b = br.readLine();

		deque = new ArrayList<>();
		lst = new ArrayList<>();
		for (int i = 0; i < a.length(); i++) {
			deque.add(a.charAt(i));
		}

		for (int i = 0; i < b.length(); i++) {
			lst.add(b.charAt(i));
		}

		dfs(b.length());
		System.out.println("0");
	}

	private static void dfs(int cnt) {
		int flag = 0;
		if (cnt == a.length()) {
			for (int i = 0; i < cnt; i++) {
				if (lst.get(i) != deque.get(i)) {
					flag = 1;
				}
			}
			if (flag == 0) {
				System.out.println("1");
				System.exit(0);
			} else
				return;
		}

		if (lst.get(lst.size() - 1) == 'A') {
			lst.remove(lst.size() - 1);
			dfs(cnt - 1);
			lst.add('A');
		}

		if (lst.get(0) == 'B') {
			Collections.reverse(lst);
			lst.remove(lst.size() - 1);
			dfs(cnt - 1);
			lst.add('B');
			Collections.reverse(lst);
		}

	}
}