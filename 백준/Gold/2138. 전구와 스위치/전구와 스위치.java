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

        int cnt0 = 0;
        for (int i = 2; i < n + 1; i++) {
            if (arr0[i - 1] == arr2[i - 1])
                continue;
            else {
                change0(i);
                cnt0++;
            }
        }

        int cnt1 = 1;
        change1(1);
        for (int i = 2; i < n + 1; i++) {
            if (arr1[i - 1] == arr2[i - 1])
                continue;
            else {
                change1(i);
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

    private static void change0(int x) {
        if (arr0[x - 1] == 0)
            arr0[x - 1] = 1;
        else if (arr0[x - 1] == 1)
            arr0[x - 1] = 0;

        if (arr0[x] == 0)
            arr0[x] = 1;
        else if (arr0[x] == 1)
            arr0[x] = 0;

        if (arr0[x + 1] == 0)
            arr0[x + 1] = 1;
        else if (arr0[x + 1] == 1)
            arr0[x + 1] = 0;
    }

    private static void change1(int x) {
        if (arr1[x - 1] == 0)
            arr1[x - 1] = 1;
        else if (arr1[x - 1] == 1)
            arr1[x - 1] = 0;

        if (arr1[x] == 0)
            arr1[x] = 1;
        else if (arr1[x] == 1)
            arr1[x] = 0;

        if (arr1[x + 1] == 0)
            arr1[x + 1] = 1;
        else if (arr1[x + 1] == 1)
            arr1[x + 1] = 0;
    }
}