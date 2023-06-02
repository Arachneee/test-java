import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class Main {
    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        List<Character> answerlist = s.chars().mapToObj(i->(char)i).sorted(Collections.reverseOrder()).collect(Collectors.toList());
        for(char c:answerlist)
            answer.append(c);

        return

        //return answer.toString();
    }
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,1,2};
        Arrays.sort(arr); // int[] 바로 정렬 가능
        // int[] -> IntStream -> Stream<Integer> -> List<Integer>        collect 는 Integer에만 쓸 수 있다.
        List<Integer> list = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
        //List<Integer> list = Arrays.stream(arr).boxed().sorted().toList();   java 1.6 이후 부터는 .toList() 가능

        String str = "Zbcd efg";
        String[] strArray = str.split(" ");
        //String -> char[]
        char[] charArray = str.toCharArray();
        //String -> IntStream -> Stream<Character> -> List<Charater>
        List<Character> charlist = str.chars().mapToObj(i->(char)i).sorted(Collections.reverseOrder()).collect(Collectors.toList());

        //String[] -> List<String>
        List<String> strList = Arrays.asList(strArray);

        //String -> String[] -> Stream<String>
        Stream<String> strStream = Stream.of(strArray);
        Stream.of(str.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
    }
}