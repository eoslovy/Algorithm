class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String tmp="";
        String result="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='0'&&s.charAt(i)!='1'&&s.charAt(i)!='2'&&s.charAt(i)!='3'&&s.charAt(i)!='4'&&
              s.charAt(i)!='5'&&s.charAt(i)!='6'&&s.charAt(i)!='7'&&s.charAt(i)!='8'&&s.charAt(i)!='9'){
                tmp+=s.charAt(i);
            }
            if(tmp.equals("zero")){
                result+='0';
                tmp="";
            }
            else if(tmp.equals("one")){
                result+='1';
                tmp="";
            }
            else if(tmp.equals("two")){
                result+='2';
                tmp="";
            }
            else if(tmp.equals("three")){
                result+='3';
                tmp="";
            }
            else if(tmp.equals("four")){
                result+='4';
                tmp="";
            }
            else if(tmp.equals("five")){
                result+='5';
                tmp="";
            }
            else if(tmp.equals("six")){
                result+='6';
                tmp="";
            }
            else if(tmp.equals("seven")){
                result+='7';
                tmp="";
            }
            else if(tmp.equals("eight")){
                result+='8';
                tmp="";
            }
            else if(tmp.equals("nine")){
                result+='9';
                tmp="";
            }
            if(s.charAt(i)=='0'||s.charAt(i)=='1'||s.charAt(i)=='2'||s.charAt(i)=='3'||s.charAt(i)=='4'||
              s.charAt(i)=='5'||s.charAt(i)=='6'||s.charAt(i)=='7'||s.charAt(i)=='8'||s.charAt(i)=='9'){
                result+=s.charAt(i);
            }
        }
        System.out.println(result);
        
        int len = result.length();
        for(int i=0;i<len;i++){
            answer*=10;
            answer+=(result.charAt(i) - '0');
        }
        return answer;
    }
}