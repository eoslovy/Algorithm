import java.util.*;
import java.io.*;

public class Main {
    static int t, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            k = Integer.parseInt(br.readLine());
            PriorityQueue<Long> file = new PriorityQueue<>();
            String input = br.readLine();
            st = new StringTokenizer(input, " ");
            for (int j = 0; j < k; j++) {
                file.add(Long.parseLong(st.nextToken()));
            }

            long result = 0;
            while (file.size() > 1) {
                long file1 = file.poll();
                long file2 = file.poll();
                long sum = file1 + file2;
                result += sum;
                file.add(sum);
            }
            System.out.println(result);
        }
    }
}
