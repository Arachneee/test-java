import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Main {
    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        List<Character> answerlist = s.chars().mapToObj(i->(char)i).sorted(Collections.reverseOrder()).collect(Collectors.toList());
        for(char c:answerlist)
            answer.append(c);

        return Stream.of(s.split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());

        //return answer.toString();
    }
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,1,2};
        List<Integer> list = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());

        System.out.println(list.toString());

//        int N = arr.length;
//        int[] answer = Arrays.stream(arr).distinct().toArray();
//        System.out.println(Arrays.toString(answer));
//
//        Stack<Integer> stack = new Stack<>();
//
//
//
//
//        System.out.println(solution("Zbcdefg"));
    }
}