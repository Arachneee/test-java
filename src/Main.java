import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class Main {
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,1,2};
        // int[] -> IntStream -> Stream<Integer> -> Integer[]
        Integer[] integers = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        // Integer[] -> Stream<Integer> -> IntStream -> int[]
        int[] ints = Arrays.stream(integers).mapToInt(i->i).toArray();
        // Integer[] -> Stream<Integer> ->List<Integer>
        List<Integer> integerList = Arrays.stream(integers).collect(Collectors.toList());
        // int[] -> IntStream -> Stream<Integer> -> List<Integer>        collect 는 Stream<Integer>에만 쓸 수 있다.
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> list1 = IntStream.of(arr).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(arr).boxed().toList();   //java 1.6 이후 부터는 .toList() 가능
        // List<Integer> -> Stream<Integer> -> IntStream -> int[]
        int[] intArray = list.stream().mapToInt(i->i).toArray();
        int[] intArray2 = list.stream().mapToInt(Integer::intValue).toArray();
        // List<Integer> -> Integer[]
        Integer[] integers1 = list.toArray(Integer[]::new);

        // 정렬 모음
        Arrays.sort(arr); // int[] 기본정렬만 가능. primitive 타입은 Comparator 사용 불가능.
        // int[] -> IntStream -> Stream<Integer> -> 내림차순정렬 -> IntStream -> int[]
        int[] arrReverse = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(i->i).toArray();
        // Integer[] 는 역순도 바로 정렬 가능
        Arrays.sort(integers,Collections.reverseOrder());
        Arrays.sort(integers,Comparator.reverseOrder());
        Arrays.sort(integers,(a,b)->{return b-a;});
        // List 정렬
        // java1.8이전
        Collections.sort(integerList);
        Collections.sort(integerList,Collections.reverseOrder());
        Collections.sort(integerList,Comparator.reverseOrder());
        Collections.sort(integerList, (a,b)->{return b-a;});
        // java1.8이후 List 메소드 sort
        integerList.sort(Comparator.naturalOrder());
        integerList.sort(Collections.reverseOrder());
        integerList.sort(Comparator.reverseOrder());
        integerList.sort((a,b)->{return b-a;});
        //뒤집기
        Collections.reverse(integerList);


        String str = "OsdF ZbAd eKg";
        String[] strArray = str.split(" ");

        // String -> char[]
        char[] charArray = str.toCharArray();
        // String -> IntStream -> Stream<Character> -> List<Charater>
        List<Character> charlist = str.chars().mapToObj(i->(char)i).collect(Collectors.toList());

        // String[] -> List<String>
        List<String> strList = Arrays.asList(strArray);
        //List<String> -> String[]
        String[] strArray1 = strList.toArray(new String[0]); // size를 0으로 초기화하는 것이 속도에 유리

        // String[] -> Stream<String>
        Stream<String> strStream = Stream.of(strArray);

        // List<String> -> Stream<String>
        Stream<String> strStream1 = strList.stream();

        // Stream<String> -> String
        String str1 = strStream1.collect(Collectors.joining());
        //정렬
        // 시간 빠른 순서
        String strsorted = Stream.of(str.split("")).sorted().collect(Collectors.joining());
        String strsorted1 = str.chars().sorted().mapToObj(i->(char)i).map(String::valueOf).collect(Collectors.joining());
        String strsorted2 = str.chars().sorted().collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append).toString();

        //프로그래머스 test
        Solution s = new Solution();
        System.out.println(s.solution("one4seveneight"));
    }
}