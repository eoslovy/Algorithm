import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			int tmp = i;
			while (tmp % 5 == 0) {
				cnt++;
				tmp /= 5;
			}
		}
		System.out.println(cnt);
	}
}