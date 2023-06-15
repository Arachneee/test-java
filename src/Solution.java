import java.util.Stack;
import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int n = board.length;

        List<Stack> dallList = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            Stack<Integer> stack = new Stack<>();
            dallList.add(stack);
        }

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int dall = board[i][j];
                if (dall != 0) {
                    dallList.get(j).push(dall);
                }
            }
        }

        Stack<Integer> result = new Stack<>();
        int answer = 0;
        for (int move:moves) {
            Stack<Integer> nowStack = dallList.get(move-1);
            if (!nowStack.isEmpty()) {
                int now = nowStack.pop();
                if (!result.isEmpty() && result.peek() == now) {
                    result.pop();
                    answer += 2;
                } else {
                    result.push(now);
                }
            }
        }
        return answer;
    }
}