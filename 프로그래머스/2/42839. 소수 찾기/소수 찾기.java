import java.util.*;
class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    int answer;
    public int solution(String numbers) {
        answer=0;
        int count=numbers.length();
        int[] num=new int[count];

        visited = new boolean[count];
        for(int i=1;i<count+1;i++){
            perm(numbers,"",0,i);
        }
        
        for (int asd : set) {
            answer++;
        }
        
        
        return answer;
    }
    
    public void perm(String numbers, String now, int cnt, int tmp){
        if(cnt==tmp){
            int num=Integer.parseInt(now);
            int flag=0;
            for(int i=1;i<num;i++){
                if(num%i==0){
                    flag++;
                }
                if(flag>1){
                    break;
                }
            }
            if(flag==1){
                set.add(num);
            }
        }
        
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i]=true;
                perm(numbers,now+String.valueOf(numbers.charAt(i)),cnt+1,tmp);
                visited[i]=false;
            }
        }
        
        
    }
}