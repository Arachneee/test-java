import java.util.*;

class Solution {
    public int solution(String name) {
        int result = 0;
        int n = name.length();

        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            result += Math.min(c - 'A','Z' - c + 1);
        }

        int min = n - 1;

        for (int i = 0; i < n; i++) {
            if(name.charAt(i) != 'A' && i < n - 1 && name.charAt(i + 1) == 'A') {
                int next = i + 1;

                while (next < n && name.charAt(next) == 'A') {
                    next += 1;
                }

//                if (next == n) {
//
//                }
//                System.out.println( i + " " + next);
                min = Math.min(min, Math.min(i * 2 + n - next, (n - next) * 2 + i));
            }
        }

        if (result == 0) {
            return 0;
        }

        if (min == n*2) {
            result += n - 1;
        } else {
            result += min;
        }

        return result;
    }
}