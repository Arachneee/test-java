import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public int[] solution(int[] answers) {
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;

        int[] answer1 = {1,2,3,4,5};
        int[] answer2 = {2,1,2,3,2,4,2,5};
        int[] answer3 = {3,3,1,1,2,2,4,4,5,5};

        int a=0;
        int b=0;
        int c=0;

        for(int answer: answers)
        {
            if (answer == answer1[a++%5])
                score1++;
            if (answer == answer2[b++%8])
                score2++;
            if (answer == answer3[c++%10])
                score3++;
        }

        int max_ = Math.max(Math.max(score1,score2),score3);

        Map<Integer,Integer> map = new HashMap<>();

        map.put(1,score1);
        map.put(2,score2);
        map.put(3,score3);

        return map.entrySet().stream().filter(e->e.getValue()==max_).mapToInt(Map.Entry::getKey).toArray();
    }
}