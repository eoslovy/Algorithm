import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int totalDuration = N * L + 5 * (N - 1);
        int[] visited = new int[3701];
        int tmp = 0;

       
        for (int i = 0; i < N; i++) {
            tmp += L;
            for (int j = 0; j < 5 && tmp < 3701; j++) {
                visited[tmp++] = 1;
            }
        }

        int[] call = new int[3701];
        tmp = 0;
        while (tmp < 3701) {
            call[tmp] = 1;
            tmp += D;
        }

        for (int i = 0; i < 3701; i++) {
            if (call[i] == 1 && visited[i] == 1) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(totalDuration + (D - (totalDuration % D)));
    }
}