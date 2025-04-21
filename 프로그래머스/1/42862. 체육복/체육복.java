class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] students=new int[n+1];
        
        for(int i=0;i<lost.length;i++){
            students[lost[i]-1]--;
        }
        
        for(int i=0;i<reserve.length;i++){
            students[reserve[i]-1]++;
        }
        
        for(int i=0;i<n-1;i++){
            if(students[i]==-1&&students[i+1]==1){
                students[i]++;
                students[i+1]--;
            }
            else if(students[i]==1&&students[i+1]==-1){
                students[i]--;
                students[i+1]++;
            }
        }
        
        for(int i=0;i<n;i++){
            if(students[i]>=0){
                answer++;
            }
        }
        
        return answer;
    }
}