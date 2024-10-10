import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int height = graph[i][1];

            while (!stack.isEmpty() && stack.peek() > height) {
                stack.pop();
                ans++;
            }

            if (stack.isEmpty() || stack.peek() < height) {
                stack.push(height);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.pop() > 0) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}