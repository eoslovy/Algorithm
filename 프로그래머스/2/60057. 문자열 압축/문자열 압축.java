import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        int cnt=1;
        while(cnt<=s.length()/2){
            int size=s.length()/cnt+1;
            String[] str=new String[size];
            int tmpcnt=0;
            for(int i=0;i<s.length();i+=cnt){
                String tmp="";
                for(int j=i;j<Math.min(i+cnt,s.length());j++){
                    tmp+=s.charAt(j);
                }
                str[tmpcnt]=tmp;
                tmpcnt++;
            }

            int asd=s.length();
            int result=1;
            for(int i=0;i<str.length;i+=result){
                result=1;
                for(int j=i+1;j<str.length;j++){
                    if(str[i].equals(str[j]))
                        result++;
                    else
                        break;
                }
                if(result!=1){
                    asd-=cnt*(result-1);
                    asd+=String.valueOf(result).length();
                }
            }
            answer=Math.min(asd, answer);
            cnt++;
        }
        
        
        return answer;
    }
}