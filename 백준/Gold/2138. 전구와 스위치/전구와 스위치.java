import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[] arr0, arr1, arr2;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr0 = new int[n + 2];
        arr1 = new int[n + 2];
        arr2 = new int[n + 2];

        String input = br.readLine();
        for (int i = 1; i < n + 1; i++) {
            arr0[i] = Integer.parseInt(String.valueOf(input.charAt(i - 1)));
            arr1[i] = arr0[i];
        }

        input = br.readLine();
        for (int i = 1; i < n + 1; i++) {
            arr2[i] = Integer.parseInt(String.valueOf(input.charAt(i - 1)));
        }

        int cnt0 = 0; // 첫 번째 안바꾼 경우
        for (int i = 2; i <= n; i++) {
            if (arr0[i - 1] != arr2[i - 1]) {
                change(i, arr0);
                cnt0++;
            }
        }

        int cnt1 = 1;
        change(1, arr1); // 첫 번째 바꾼 우
        for (int i = 2; i <= n; i++) {
            if (arr1[i - 1] != arr2[i - 1]) {
                change(i, arr1);
                cnt1++;
            }
        }

        int ans = -1;
        if (arr0[n] == arr2[n]) {
            if (arr1[n] == arr2[n]) {
                ans = Math.min(cnt0, cnt1);
            } else
                ans = cnt0;
        } else {
            if (arr1[n] == arr2[n])
                ans = cnt1;
        }

        System.out.println(ans);
    }

    private static void change(int x, int arr[]) {
        for (int i = x - 1; i <= x + 1; i++) {
            if (arr[i] == 0)
                arr[i] = 1;
            else
                arr[i] = 0;
        }
    }
}