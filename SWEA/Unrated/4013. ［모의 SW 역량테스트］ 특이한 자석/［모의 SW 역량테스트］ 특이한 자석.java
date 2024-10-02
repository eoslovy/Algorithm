import java.util.*;

public class Solution {
    static int[][] graph;

    // 시계 방향 회전
    public static void soon(int x) {
        int tmp = graph[x][7];
        for (int i = 6; i >= 0; i--) {
            graph[x][i + 1] = graph[x][i];
        }
        graph[x][0] = tmp;
    }

    // 반시계 방향 회전
    public static void yeok(int x) {
        int tmp = graph[x][0];
        for (int i = 0; i < 7; i++) {
            graph[x][i] = graph[x][i + 1];
        }
        graph[x][7] = tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 0; tc < t; tc++) {
            int k = sc.nextInt();
            graph = new int[4][8];


            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 8; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }


            int[][] order = new int[k][2];
            for (int i = 0; i < k; i++) {
                order[i][0] = sc.nextInt() - 1;
                order[i][1] = sc.nextInt();
            }

            int[] cal = new int[6];
            for (int i = 0; i < k; i++) {
                int a = order[i][0];
                int b = order[i][1];

                cal[0] = graph[0][2];
                cal[1] = graph[1][6];
                cal[2] = graph[1][2];
                cal[3] = graph[2][6];
                cal[4] = graph[2][2];
                cal[5] = graph[3][6];

                if (a == 0) {
                    if (b == 1) {
                        if (cal[0] == cal[1]) {
                            soon(0);
                        } else {
                            if (cal[2] == cal[3]) {
                                soon(0);
                                yeok(1);
                            } else {
                                if (cal[4] == cal[5]) {
                                    soon(0);
                                    yeok(1);
                                    soon(2);
                                } else {
                                    soon(0);
                                    yeok(1);
                                    soon(2);
                                    yeok(3);
                                }
                            }
                        }
                    } else if (b == -1) {
                        if (cal[0] == cal[1]) {
                            yeok(0);
                        } else {
                            if (cal[2] == cal[3]) {
                                yeok(0);
                                soon(1);
                            } else {
                                if (cal[4] == cal[5]) {
                                    yeok(0);
                                    soon(1);
                                    yeok(2);
                                } else {
                                    yeok(0);
                                    soon(1);
                                    yeok(2);
                                    soon(3);
                                }
                            }
                        }
                    }
                } else if (a == 1) {
                    if (b == 1) {
                        if (cal[1] == cal[0]) {
                            if (cal[2] == cal[3]) {
                                soon(1);
                            } else {
                                if (cal[4] == cal[5]) {
                                    soon(1);
                                    yeok(2);
                                } else {
                                    soon(1);
                                    yeok(2);
                                    soon(3);
                                }
                            }
                        } else {
                            if (cal[2] == cal[3]) {
                                yeok(0);
                                soon(1);
                            } else {
                                if (cal[4] == cal[5]) {
                                    yeok(0);
                                    soon(1);
                                    yeok(2);
                                } else {
                                    yeok(0);
                                    soon(1);
                                    yeok(2);
                                    soon(3);
                                }
                            }
                        }
                    } else if (b == -1) {
                        if (cal[1] == cal[0]) {
                            if (cal[2] == cal[3]) {
                                yeok(1);
                            } else {
                                if (cal[4] == cal[5]) {
                                    yeok(1);
                                    soon(2);
                                } else {
                                    yeok(1);
                                    soon(2);
                                    yeok(3);
                                }
                            }
                        } else {
                            if (cal[2] == cal[3]) {
                                soon(0);
                                yeok(1);
                            } else {
                                if (cal[4] == cal[5]) {
                                    soon(0);
                                    yeok(1);
                                    soon(2);
                                } else {
                                    soon(0);
                                    yeok(1);
                                    soon(2);
                                    yeok(3);
                                }
                            }
                        }
                    }
                } else if (a == 2) {
                    if (b == 1) {
                        if (cal[4] == cal[5]) {
                            if (cal[2] == cal[3]) {
                                soon(2);
                            } else {
                                if (cal[1] == cal[0]) {
                                    soon(2);
                                    yeok(1);
                                } else {
                                    soon(2);
                                    yeok(1);
                                    soon(0);
                                }
                            }
                        } else {
                            if (cal[2] == cal[3]) {
                                yeok(3);
                                soon(2);
                            } else {
                                if (cal[1] == cal[0]) {
                                    yeok(3);
                                    soon(2);
                                    yeok(1);
                                } else {
                                    yeok(3);
                                    soon(2);
                                    yeok(1);
                                    soon(0);
                                }
                            }
                        }
                    } else if (b == -1) {
                        if (cal[4] == cal[5]) {
                            if (cal[2] == cal[3]) {
                                yeok(2);
                            } else {
                                if (cal[1] == cal[0]) {
                                    yeok(2);
                                    soon(1);
                                } else {
                                    yeok(2);
                                    soon(1);
                                    yeok(0);
                                }
                            }
                        } else {
                            if (cal[2] == cal[3]) {
                                soon(3);
                                yeok(2);
                            } else {
                                if (cal[1] == cal[0]) {
                                    soon(3);
                                    yeok(2);
                                    soon(1);
                                } else {
                                    soon(3);
                                    yeok(2);
                                    soon(1);
                                    yeok(0);
                                }
                            }
                        }
                    }
                } else if (a == 3) {
                    if (b == 1) {
                        if (cal[4] == cal[5]) {
                            soon(3);
                        } else {
                            if (cal[2] == cal[3]) {
                                soon(3);
                                yeok(2);
                            } else {
                                if (cal[1] == cal[0]) {
                                    soon(3);
                                    yeok(2);
                                    soon(1);
                                } else {
                                    soon(3);
                                    yeok(2);
                                    soon(1);
                                    yeok(0);
                                }
                            }
                        }
                    } else if (b == -1) {
                        if (cal[4] == cal[5]) {
                            yeok(3);
                        } else {
                            if (cal[2] == cal[3]) {
                                yeok(3);
                                soon(2);
                            } else {
                                if (cal[1] == cal[0]) {
                                    yeok(3);
                                    soon(2);
                                    yeok(1);
                                } else {
                                    yeok(3);
                                    soon(2);
                                    yeok(1);
                                    soon(0);
                                }
                            }
                        }
                    }
                }
            }


            int cnt = 0;
            if (graph[0][0] == 1) cnt += 1;
            if (graph[1][0] == 1) cnt += 2;
            if (graph[2][0] == 1) cnt += 4;
            if (graph[3][0] == 1) cnt += 8;

            System.out.println("#" + (tc + 1) + " " + cnt);
        }

        sc.close();
    }
}
