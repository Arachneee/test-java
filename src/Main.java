import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class Main {
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,1,2};
        Arrays.sort(arr); // int[] 바로 정렬 가능
        // int[] -> IntStream -> Stream<Integer> -> List<Integer>        collect 는 Integer에만 쓸 수 있다.
        List<Integer> list = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
        //List<Integer> list = Arrays.stream(arr).boxed().sorted().toList();   java 1.6 이후 부터는 .toList() 가능

        //List<Integer> -> Stream<Integer> -> IntStream -> int[]
        int[] arr1 = list.stream().mapToInt(i->i).toArray();
        //int[] arr1 = list.stream().mapToInt(Integer::intValue).toArray();

        String str = "Zbcd efg";
        String[] strArray = str.split(" ");
        //String -> char[]
        char[] charArray = str.toCharArray();
        //String -> IntStream -> Stream<Character> -> List<Charater>
        List<Character> charlist = str.chars().mapToObj(i->(char)i).sorted(Collections.reverseOrder()).collect(Collectors.toList());

        //String[] -> List<String>
        List<String> strList = Arrays.asList(strArray);

        //String[] -> Stream<String>
        Stream<String> strStream = Stream.of(strArray);
        //List<String> -> Stream<String>
        Stream<String> strStream1 = strList.stream();

        //Stream<String> -> String
        String str1 = strStream.collect(Collectors.joining());

        System.out.println(str1);
    }
}