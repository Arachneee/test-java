import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] count = new int[n+1];
        Arrays.fill(count,1);

        for (int i = 1; i <= n ; i++) {
            if (Arrays.stream(reserve).boxed().collect(Collectors.toList()).contains(i)) {
                count[i] += 1;
            }
            if (Arrays.stream(lost).boxed().collect(Collectors.toList()).contains(i)) {
                count[i] -= 1;
            }
        }

        for (int i = 1; i<n; i++) {
            if (count[i] == 0) {
                if (count[i-1] == 2) {
                    count[i] = 1;
                    count[i-1] = 1;
                } else if (count[i+1] == 2) {
                    count[i] = 1;
                    count[i+1] = 1;
                }
            }
        }
        if (count[n] == 0 && count[n-1] == 2) {
            count[n] = 1;
            count[n-1] = 1;
        }

        return (int) Arrays.stream(count).skip(1).filter(i->i>0).count();
    }
}