import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int K = Integer.parseInt(st.nextToken()); // 선택할 학생 수
		int[] abilities = new int[N]; // 학생들의 능력 값 배열

		// 학생들의 능력 값 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			abilities[i] = Integer.parseInt(st.nextToken());
		}

		// AND 연산 최댓값을 구하기 위한 비트 마스크 탐색
		int result = 0;

		// 가장 높은 비트 (30번째 비트)부터 차례로 내려가면서 확인
		for (int bit = 30; bit >= 0; bit--) {
			int mask = result | (1 << bit); // 현재 비트를 켠 상태로 가정
			int count = 0;

			// 현재 비트가 켜진 학생 수를 세기
			for (int ability : abilities) {
				if ((ability & mask) == mask) {
					count++;
				}
			}

			// K명 이상의 학생이 현재 비트가 켜진 상태로 가능하다면 그 비트를 유지
			if (count >= K) {
				result = mask; // 그 비트를 유지
			}
		}

		System.out.println(result); // 최종 결과 출력
	}

}