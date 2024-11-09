import java.util.*;
import java.io.*;
public class Main {
    private static int n, a, b;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        arr = new int[n];

        a--;
        b--;
        Arrays.fill(arr, 1);

        if (a + b > n - 1) {
            System.out.println(-1);
        } else {
            if (a == 0) {
                if (b == 0) {
                    for (int i = 0; i < n; i++) {
                        System.out.printf("%d ", arr[i]);
                    }
                } else {
                    arr[0] = b + 1;
                    int tmp_b = b;
                    for (int i = n - b; i < n; i++) {
                        arr[i] = tmp_b--;
                    }
                    for (int i = 0; i < n; i++) {
                        System.out.printf("%d ", arr[i]);
                    }
                }
            } else if (b == 0) {
                int tmp_a = a + 1;
                for (int i = n - 1; i >= n - a; i--) {
                    arr[i] = tmp_a--;
                }
                for (int i = 0; i < n; i++) {
                    System.out.printf("%d ", arr[i]);
                }
            } else {
                int cnt = 1;
                int tmp_a = a;
                if(a>b){
                    tmp_a++;

                for (int i = n - 1; i > n - 1 - b; i--) {
                    arr[i] = cnt++;
                }
                for (int i = n - 1 - b; i > n - 1 - b - a; i--) {
                    arr[i] = tmp_a--;
                }
                }
                else{
                    for (int i = n - 1; i >= n - 1 - b; i--) {
                    arr[i] = cnt++;
                }
                for (int i = n - 1 - b-1; i > n - 1 - b - a-1; i--) {
                    arr[i] = tmp_a--;
                }
                }
                
                // for (int i = 0; i < n; i++) {
                //     System.out.printf("%d ", arr[i]);
                // }
                // System.out.println();
             
                // for (int i = n - 1 - b; i > n - 1 - b - a; i--) {
                //     arr[i] = tmp_a--;
                // }

                for (int i = 0; i < n; i++) {
                    System.out.printf("%d ", arr[i]);
                }
            }
        }
    }
}
