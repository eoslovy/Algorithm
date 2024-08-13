import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr[] = new ArrayList[n + 1];

        int[] indegree = new int[n + 1];
        indegree[0] = 0;
        for (int i = 1; i <= n; i++)
            arr[i] = new ArrayList<>(); //각 노드에서 갈 수 있는 자식 노드들 저장

        int parentCnt[] = new int[n + 1]; // 각 노드가 몇 개의 부모 노드를 가지고 있는지 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from].add(to); // from 노드에서 to 노드로 가는 간선 추가
            parentCnt[to]++; // to 노드로 들어오는 간선 개수 증가
        }

        Queue<Integer> que = new LinkedList<>(); // 위상정렬 큐

        for (int i = 1; i <= n; i++)
            if (parentCnt[i] == 0) // 부모 노드가 없는 노드 찾기
                que.add(i); // 큐에 먼저 넣음
        int answer[] = new int[n + 1]; // 정답 저장할 배열
        int hak = 1;
        while (!que.isEmpty()) {
            int size = que.size(); // 같은 indegree에 있는 노드들 한번에 처리하기 위한 조건
            while (size-- != 0) {
                int now = que.poll(); // 큐에서 노드 하나 꺼내서 저장함
                answer[now] = hak; // 답에 저장함
                for (int child : arr[now]) // 현재 노드와 연결된 자식 노드들 탐색
                    if (--parentCnt[child] == 0) // 자식 노드의 parentCnt 값 감소시키기
                        que.add(child); // 0이면 큐에 넣어줌
            }
            hak++; // 다음 학기
        }
        for (int i = 1; i <= n; i++)
            System.out.print(answer[i] + " ");
    }
}