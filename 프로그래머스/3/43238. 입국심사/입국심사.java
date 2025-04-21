class Solution {
    public long solution(int n, int[] times) {
        
        long start=0;
        long end=1000000000000000000L;
        
        long answer=end;
        while(start<=end){
            long mid=(start+end)/2;
            
            long tmp=0;
            for(int i=0;i<times.length;i++){
                tmp+=mid/times[i];
                if(tmp>=n) {
                    break;
                }
            }
            if(tmp>=n){
                answer=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return answer;
    }
}