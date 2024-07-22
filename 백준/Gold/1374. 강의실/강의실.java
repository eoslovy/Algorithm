import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] time = new int[n][2];

        for (int i = 0; i < n; i++) {
            int num;

            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, " ");

            num = Integer.parseInt(st.nextToken());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, (o1, o2) -> o1[0] - o2[0]);

        int[][] endTime = Arrays.copyOf(time, n);
        Arrays.sort(endTime, (o1, o2) -> o1[1] - o2[1]);

//		System.out.println(Arrays.deepToString(time));
//        System.out.println(Arrays.deepToString(endTime));

        int result=Integer.MIN_VALUE;

        int start=0;
        int end=0;
        int cnt=0;
        while (start < n) {
            if (time[start][0] < endTime[end][1]) {
//                System.out.printf("%d %d asd\n", time[start][0],endTime[end][1]);
                cnt++;
                start++;
            } else {
//                System.out.printf("%d %d\n", time[start][0],endTime[end][1]);
                cnt--;
                end++;
            }
            result = Math.max(result, cnt);
        }

        System.out.println(result);
    }
}

