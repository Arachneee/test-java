import java.util.*;


class Solution {
    public int solution(String dartResult) {
        Stack<Integer> scores = new Stack<>();

        char[] dartArray = dartResult.toCharArray();
        int i = 0;
        while(i<dartResult.length())
        {
            char now = dartArray[i];
            if(now >= '2' && now <='9')
            {
                scores.push(now-'0');
                i += 1;
                continue;
            }

            if(now == '1' && dartArray[i+1] == '0')
            {
                scores.push(10);
                i += 2;
                continue;
            }

            if(now == '1')
            {
                scores.push(1);
                i += 1;
                continue;
            }

            if(now == '0')
            {
                scores.push(0);
                i += 1;
                continue;
            }

            if(now == 'S')
            {
                i += 1;
                continue;
            }

            if(now == 'D')
            {
                int n = scores.pop();
                scores.push(n*n);
                i += 1;
                continue;
            }

            if(now == 'T')
            {
                int n = scores.pop();
                scores.push(n*n*n);
                i += 1;
                continue;
            }

            if(now == '*')
            {
                int n = scores.pop();
                if(!scores.isEmpty())
                {
                    int n_1 = scores.pop();
                    scores.push(n_1*2);
                }
                scores.push(n*2);
                i += 1;
                continue;
            }

            if(now == '#')
            {
                int n = scores.pop();
                scores.push(n*(-1));
                i+=1;
                continue;
            }
        }
        int result = 0;
        for(int x:scores)
        {
            result += x;
        }
        return result;
    }
}