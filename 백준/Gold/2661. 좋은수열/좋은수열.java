import java.util.*;
import java.io.*;

public class Main {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        n = Integer.parseInt(st.nextToken());

        backtracking("");
    }

    public static void backtracking(String str) {
        if (str.length() == n) {
            System.out.println(str);
            System.exit(0);
        } else {
            for (int i = 1; i < 4; i++) {
                if (check(str + i)) {
                    backtracking(str + i);
                }
            }
        }
    }

    public static boolean check(String str) {
        int length = str.length();
        for (int len = 1; len <= length / 2; len++) {
            String com1 = str.substring(length - 2 * len, length - len);
            String com2 = str.substring(length - len);
//				System.out.println("com1: " + com1);
//				System.out.println("com2: " + com2);
            if (com1.equals(com2)) {
                return false;
            }
        }
        return true;
    }
}
