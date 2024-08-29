import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    private static int n, cnt, ans;
    private static int[][] graph;
    private static int[][] stairs;
    private static int[][] people;
    private static int[][] time;
    private static List<int[]> allChoices;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            graph = new int[n][n];

            cnt = 0;
            ans = Integer.MAX_VALUE; // 매 테스트 케이스마다 ans 초기화

            int st_tmp = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                    if (graph[i][j] == 1) {
                        cnt++;
                    }
                }
            }

            time = new int[cnt][2];
            stairs = new int[2][3];
            people = new int[cnt][2];

            int pp_tmp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] == 1) {
                        people[pp_tmp][0] = i;
                        people[pp_tmp][1] = j;
                        pp_tmp++;
                    } else if (graph[i][j] > 1) {
                        stairs[st_tmp][0] = i;
                        stairs[st_tmp][1] = j;
                        stairs[st_tmp++][2] = graph[i][j];
                    }
                }
            }

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < cnt; j++) {
                    time[j][i] = (Math.abs(stairs[i][0] - people[j][0]) + Math.abs(stairs[i][1] - people[j][1]));
                }
            }

            allChoices = new ArrayList<>();
            choose(new int[cnt], 0);

            for (int[] choice : allChoices) {
                int tmp_time = calculateTime(choice);
                ans = Math.min(ans, tmp_time);
            }

            System.out.printf("#%d %d\n", tc, ans + 1);
        }
    }

    // 사람들의 계단 선택을 위한 모든 경우의 수 생성
    private static void choose(int[] selected, int depth) {
        if (depth == cnt) {
            allChoices.add(selected.clone());
            return;
        }

        for (int i = 0; i < 2; i++) {
            selected[depth] = i;
            choose(selected, depth + 1);
        }
    }

    // 각 선택에 따른 최종 시간 계산
    private static int calculateTime(int[] choice) {
        List<Integer> stair1Times = new ArrayList<>();
        List<Integer> stair2Times = new ArrayList<>();

        for (int i = 0; i < choice.length; i++) {
            if (choice[i] == 0) {
                stair1Times.add(time[i][0]);
            } else {
                stair2Times.add(time[i][1]);
            }
        }

        int stair1EndTime = getEndTime(stair1Times, stairs[0][2]);
        int stair2EndTime = getEndTime(stair2Times, stairs[1][2]);

        return Math.max(stair1EndTime, stair2EndTime);
    }

    // 큐를 이용해 각 계단에서 내려가는 사람들의 시간을 계산
    private static int getEndTime(List<Integer> times, int stairLength) {
        Collections.sort(times);
        Queue<Integer> stairQueue = new LinkedList<>();
        int currentTime = 0;

        for (int startTime : times) {
            // 현재 계단에서 내려간 사람의 시간을 반영하고 새로 들어갈 수 있게 함
            if (stairQueue.size() == 3) {
                currentTime = stairQueue.poll();
            }

            currentTime = Math.max(currentTime, startTime);
            stairQueue.offer(currentTime + stairLength); // 계단에 진입 후 내려가기 시작
        }

        // 마지막 사람이 계단을 내려간 시간을 반환
        while (!stairQueue.isEmpty()) {
            currentTime = stairQueue.poll();
        }

        return currentTime;
    }
}