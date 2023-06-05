import java.util.*;
class Solution {
    public int solution(String s) {
        Map<String,Integer> numberMap = new HashMap<>();

        numberMap.put("zero",0);
        numberMap.put("one",1);
        numberMap.put("two",2);
        numberMap.put("three",3);
        numberMap.put("four",4);
        numberMap.put("five",5);
        numberMap.put("six",6);
        numberMap.put("seven",7);
        numberMap.put("eight",8);
        numberMap.put("nine",9);

        int answer = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++)
        {
            char now = s.charAt(i);

            if (now>='0' && now<='9')
            {
            answer *= 10;
            answer += now-'0';
            }
            else
            {
                sb.append(now);
            }
            if ((!sb.isEmpty()) && (numberMap.keySet().contains(sb.toString())))
            {
                answer *= 10;
                answer += numberMap.get(sb.toString());
                sb = new StringBuilder();
            }
        }
        return answer;

    }
}