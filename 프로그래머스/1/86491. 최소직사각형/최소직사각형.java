import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int maxA = 0;
        int maxB = 0;

        for(int i=0;i<sizes.length;i++){
            int a = Math.max(sizes[i][0], sizes[i][1]);
            int b = Math.min(sizes[i][0], sizes[i][1]);
            maxA = Math.max(maxA, a);
            maxB = Math.max(maxB, b);
        }

        return maxA * maxB;
    }
}