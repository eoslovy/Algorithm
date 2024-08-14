import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc < 11; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			String input = br.readLine();

			Stack<String> stack = new Stack<>();

			for (int i = 0; i < n; i++) {
				if (stack.isEmpty()) {
					stack.push(String.valueOf(input.charAt(i)));
					continue;
				} else {
					String compare = stack.peek();
					if (compare.equals("(") && String.valueOf(input.charAt(i)).equals(")"))
						stack.pop();
					else if (compare.equals("{") && String.valueOf(input.charAt(i)).equals("}"))
						stack.pop();
					else if (compare.equals("[") && String.valueOf(input.charAt(i)).equals("]"))
						stack.pop();
					else if (compare.equals("<") && String.valueOf(input.charAt(i)).equals(">"))
						stack.pop();
					else
						stack.push(String.valueOf(input.charAt(i)));
				}
			}
			if (stack.isEmpty())
				System.out.printf("#%d 1\n", tc);
			else
				System.out.printf("#%d 0\n", tc);
		}
		
	}
}