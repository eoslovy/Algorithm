import java.util.*;
class Solution {
    public int solution(String name) {
        int length = name.length();
        
        int cnt=0;
        for(int i=0;i<length;i++){
            if(name.charAt(i)=='A'){
                continue;
            }
            if(name.charAt(i)-'A'<'Z'-name.charAt(i)+1){
                cnt+=name.charAt(i)-'A';
            }
            else{
                cnt+='Z'-name.charAt(i)+1;
            }
        }
        
        int move = length - 1;

        for (int i = 0; i < length; i++) {
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }

            move = Math.min(move, (i * 2) + length - next);
            move = Math.min(move, (length - next) * 2 + i);
        }
        
        
        
        return cnt+move;
    }
}