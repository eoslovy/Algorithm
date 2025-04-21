class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int depth=triangle.length;
        int[][] graph=new int[depth][depth];
        graph[0][0]=triangle[0][0];
        
        for(int i=1;i<depth;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    graph[i][j]=triangle[i][j]+graph[i-1][j];
                }
                else if(j==i){
                    graph[i][j]=triangle[i][j]+graph[i-1][j-1];
                }
                else{
                    graph[i][j]=triangle[i][j]+Math.max(graph[i-1][j],graph[i-1][j-1]);
                }
            }
        }
        
        for(int i=0;i<depth;i++){
            answer=Math.max(answer,graph[depth-1][i]);
        }
        
        return answer;
    }
}