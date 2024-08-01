import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        int a, b;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph[a - 1][b - 1] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        int[] time = new int[l];
        char[] turn = new char[l];
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            turn[i] = st.nextToken().charAt(0);
        }

        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{0, 0});

        int flag = 0;
        int cnt = 0;
        int tmp = 0;
        int result = 1;
        boolean end = false;
        while (!snake.isEmpty()) {
            if (!end && cnt == time[tmp]) {
                if (turn[tmp] == 'D')
                    flag += 1;
                else if (turn[tmp] == 'L')
                    flag += 3;
                if (tmp + 1 != l)
                    tmp++;
                else
                    end = true;
            }
            int x, y;
            x = snake.peek()[0];
            y = snake.peek()[1];
//            System.out.printf("%d %d %d\n", x, y, tmp);
            if (flag % 4 == 0) {//동
                for (int[] pos : snake) {
                    if (Arrays.equals(pos, new int[]{x, y + 1})) {
                        System.out.println(result);
                        return;
                    }
                }
                if (y + 1 < n) {
                    result++;
                    if (graph[x][y + 1] != 1) {//사과를 먹지 않은 경우
                        snake.addFirst(new int[]{x, y + 1});//첫번째 그래프 위치 바꿔줌
                        snake.removeLast();//꼬리도 따라오게
                    } else {//사과를 먹은 경우
                        graph[x][y + 1] = 0;
                        snake.addFirst(new int[]{x, y + 1});//맨 앞에 추가
                    }
                } else break;
            } else if (flag % 4 == 1) {//남
                for (int[] pos : snake) {
                    if (Arrays.equals(pos, new int[]{x + 1, y})) {
                        System.out.println(result);
                        return;
                    }
                }
                if (x + 1 < n) {
                    result++;
                    if (graph[x + 1][y] != 1) {//사과를 먹지 않은 경우
                        snake.addFirst(new int[]{x + 1, y});//첫번째 그래프 위치 바꿔줌
                        snake.removeLast();//꼬리도 따라오게
                    } else {//사과를 먹은 경우
                        graph[x + 1][y] = 0;
                        snake.addFirst(new int[]{x + 1, y});//맨 앞에 추가
                    }
                } else break;
            } else if (flag % 4 == 2) {//서
                for (int[] pos : snake) {
                    if (Arrays.equals(pos, new int[]{x, y - 1})) {
                        System.out.println(result);
                        return;
                    }
                }
                if (y - 1 >= 0) {
                    result++;
                    if (graph[x][y - 1] != 1) {//사과를 먹지 않은 경우
                        snake.addFirst(new int[]{x, y - 1});//첫번째 그래프 위치 바꿔줌
                        snake.removeLast();//꼬리도 따라오게
                    } else {//사과를 먹은 경우
                        graph[x][y - 1] = 0;
                        snake.addFirst(new int[]{x, y - 1});//맨 앞에 추가
                    }
                } else break;
            } else if (flag % 4 == 3) {//북
                for (int[] pos : snake) {
                    if (Arrays.equals(pos, new int[]{x - 1, y})) {
                        System.out.println(result);
                        return;
                    }
                }
                if (x - 1 >= 0) {
                    result++;
                    if (graph[x - 1][y] != 1) {//사과를 먹지 않은 경우
                        snake.addFirst(new int[]{x - 1, y});//첫번째 그래프 위치 바꿔줌
                        snake.removeLast();//꼬리도 따라오게
                    } else {//사과를 먹은 경우
                        graph[x - 1][y] = 0;
                        snake.addFirst(new int[]{x - 1, y});//맨 앞에 추가
                    }
                } else break;
            }
            cnt++;
        }
        System.out.println(result);

    }
}
