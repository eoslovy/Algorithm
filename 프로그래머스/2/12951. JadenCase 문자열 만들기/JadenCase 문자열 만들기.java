class Solution {
    public String solution(String s) {
        String answer = "";
        
        for(int i=0;i<s.length();i++){
            if(i==0){
                char tmp=s.charAt(i);
                if('a'<=tmp&&tmp<='z')
                    tmp-=32;
                answer+=tmp;
            }
            else if(s.charAt(i-1)==' '){
                char tmp=s.charAt(i);
                if('a'<=s.charAt(i)&&tmp<='z')
                    tmp-=32;
                answer+=tmp;
            }
            else{
                char tmp=s.charAt(i);
                if('A'<=tmp&&tmp<='Z')
                    tmp+=32;
                answer+=tmp;
            }
        }
        
        return answer;
    }
}