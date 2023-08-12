import java.util.*;

class Solution {
    public int[] solution(int n, int[] info) {
        int[] result = new int[11];
        int maxGap = 0;

        for (int i = 0; i < (1 << 12); i++) {
            int apeech = 0;
            int lion = 0;

            int arrowCnt = 0;

            int[] arr = new int[11];

            for (int j = 0; j < 11; j++) {
                if ((i & (1 << j)) != 0) {
                    if (arrowCnt + info[j] + 1 <= n) {
                        arrowCnt += info[j] + 1;
                        lion += 10 - j;
                        arr[j] = info[j] + 1;
                    } else if (info[j] != 0) {
                        apeech += 10 - j;
                    }
                } else if (info[j] != 0) {
                    apeech += 10 - j;
                }

            }

            arr[10] += n - arrowCnt;

            if (apeech < lion && maxGap <= lion - apeech) {
                result = arr.clone();
                maxGap = lion - apeech;
            }

        }

        if (maxGap == 0) {
            return new int[] {-1};
        }

        return result;
    }
}