import java.util.*;
import java.io.*;

public class Solution {
    private static int n, l;
    private static int[][] jaeryo;
    private static int[][] tmp;
    private static List<Integer> lst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            jaeryo = new int[n][2];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                jaeryo[j][0] = Integer.parseInt(st.nextToken());
                jaeryo[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(jaeryo, (o1, o2) -> o1[0] - o2[0]);
//			System.out.println(Arrays.deepToString(jaeryo));

            int cnt = n;
            int result = -99999;
            for (int j = 0; j < n; j++) {
                int[] asd = new int[n];
                for (int k = n - cnt; k < n; k++) {
                    asd[k] = 1;
                }
                do {
                    int cal = 0;
                    int cal2 = 0;
                    for (int a = 0; a < n; a++) {
                        if (asd[a] == 1) {
                            cal += jaeryo[a][0];
                            cal2 += jaeryo[a][1];
                        }
                    }
                    if (cal2 <= l) {
                        result = Math.max(result, cal);
                    }
                } while (np(asd));
                cnt--;
            }
            System.out.printf("#%d %d\n", i, result);
        }
    }


    private static boolean np(int[] p) {
        int n = p.length;
        // step1) 꼭대기 찾기
        int i = n - 1;
        while (i > 0 && p[i - 1] >= p[i])
            --i;
        if (i == 0)
            return false;
        // step2) 꼭대기 앞 교환위치에 교환할 값(i-1 위치 값보다 큰 값 중 가장 작은 값) 자리 찾기
        int j = n - 1;
        while (p[i - 1] >= p[j])
            --j;
        // step3) 두 위치의 수 교환
        swap(p, i - 1, j);

        // step4) 꼭대기부터 맨 뒤까지 오름차순의 형태로 만듦
        int k = n - 1;
        while (i < k) {
            swap(p, i++, k--);
        }
        return true;
    }

    private static void swap(int[] p, int i, int j) {
        int tmp = p[i];
        p[i] = p[j];
        p[j] = tmp;
    }
}