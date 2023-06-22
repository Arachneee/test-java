import java.util.*;

class Solution
{
    public int solution(String s)
    {
        char[] strs = s.toCharArray();

        int n = s.length();

        Stack<Character> stack = new Stack<>();

        int i = 0;

        while(true) {
            if (i == n)
                break;
            if (stack.isEmpty())
                stack.push(strs[i++]);
            else if (stack.peek() == (strs[i])) {
                stack.pop();
                i++;
            } else {
                stack.push(strs[i++]);
            }
        }

        if (stack.size() == 0)
            return 1;
        else
            return 0;
    }
}