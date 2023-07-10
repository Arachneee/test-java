import static java.util.stream.Collectors.*;

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<Character, List<String>> arr = Arrays.stream(phone_book).sorted().collect(groupingBy(i -> i.charAt(0)));
        // System.out.println(Arrays.toString(phone_book));
        int n = phone_book.length;

        for (Character c : arr.keySet()) {
            List<String> nowList = arr.get(c);
            int len = nowList.size();
            for (int i = 0; i < n; i++){
                String now = nowList.get(i);
                for (int j = i + 1; j < n; j++) {
                    String next = nowList.get(j);
                    if (next.indexOf(now) == 0)
                        return false;
                }
            }
        }

        return true;
    }
}