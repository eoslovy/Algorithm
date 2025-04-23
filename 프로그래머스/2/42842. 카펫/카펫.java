import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int x=0;
        int y=1;
        while(x<=yellow){
            x++;
            if(yellow%x!=0)
                continue;
            y=yellow/x;
            
            int bx=x*2+4;
            int by=y*2;
            
            if(bx+by==brown){
                int xx=Math.max(x+2,y+2);
                int yy=Math.min(x+2,y+2);
                return new int[]{xx,yy};
            }
        }
        return answer;
    }
}