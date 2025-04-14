import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer=new int[commands.length];
        int size=0;
        for(int i=0;i<commands.length;i++){
            int start=commands[i][0];
            int end=commands[i][1];
            int index=commands[i][2];
            
            int[] tmp=new int[end-start+1];
            int cnt=0;
            for(int j=start-1;j<end;j++){
                tmp[cnt++]=array[j];
            }
            Arrays.sort(tmp);
            answer[size++]=tmp[index-1];
        }
        return answer;
    }
}