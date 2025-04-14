import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> lst=new ArrayList<>();
        
        lst.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1])
                continue;
            else
                lst.add(arr[i]);
        }
        
        answer=new int[lst.size()];
        for(int i=0;i<lst.size();i++){
            answer[i]=(lst.get(i));
        }
        
        return answer;
    }
}