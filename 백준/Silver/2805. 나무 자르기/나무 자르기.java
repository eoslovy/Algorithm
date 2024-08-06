import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        input = br.readLine();
        st = new StringTokenizer(input);

        Long[] lst = new Long[n];
        for (int i = 0; i < n; i++) {
            lst[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(lst);

        long start = 0;
        long end = lst[n - 1];
        long mid;
        while (start < end) {
            mid = (start + end) / 2;
            long sum = 0;

            for (int i = n - 1; i >= 0; i--) {
                long length = lst[i];
                if (length - mid > 0) {
                    sum += (length - mid);
                }
                else break;
            }

            if (sum < m)
                end = mid;
            else
                start = mid + 1;
        }
        System.out.println(start - 1);
    }
}
