import java.util.*;
class Solution {
    static int answer;
    static int[] lst;
    public int solution(int[] numbers, int target) {
        answer=0;
        lst=new int[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            lst[i]=numbers[i];
        }
        dfs(0,target,0);
        return answer;
    }
    
    public void dfs(int length, int target, int result){
        if(length==lst.length){
            if(result==target){
                answer++;
            }
            return;
        }
        dfs(length+1,target,result+lst[length]);
        
        dfs(length+1,target,result-lst[length]);
        
        return;
    }
}