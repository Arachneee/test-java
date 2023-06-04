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
        Arrays.sort(arr); // int[] 기본정렬만 가능. primitive타입은 Comparator사용 불가능.
        // int[] -> IntStream -> Stream<Interger> -> 정렬 -> IntStream -> int[]
        int[] arrReverse = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(i->i).toArray();

        // int[] -> IntStream -> Stream<Integer> -> Integer[]
        Integer[] integers = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        // Interger[] 는 역순도 바로 정렬 가능
        Arrays.sort(integers,(a,b)->{return b-a;});
        Arrays.sort(integers,Collections.reverseOrder());
        // Integer[] -> Stream<Integer> -> IntStream -> int[]
        int[] ints = Arrays.stream(integers).mapToInt(i->i).toArray();
        // Integer[] -> Stream<Integer> ->List<Integer>
        List<Integer> integerList = Arrays.stream(integers).collect(Collectors.toList());
        //List 정렬
        Collections.sort(integerList, (a,b)->{return b-a;});
        Collections.sort(integerList,Collections.reverseOrder());
        integerList.sort((a,b)->{return b-a;});
        integerList.sort(Comparator.naturalOrder());
        integerList.sort(Comparator.reverseOrder());


        // int[] -> IntStream -> Stream<Integer> -> List<Integer>        collect 는 Stream<Integer>에만 쓸 수 있다.
        List<Integer> list = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
        List<Integer> list1 = IntStream.of(arr).boxed().sorted().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(arr).boxed().sorted().toList();   //java 1.6 이후 부터는 .toList() 가능


        // List<Integer> -> Stream<Integer> -> IntStream -> int[]
        int[] intArray = list.stream().mapToInt(i->i).toArray();
        int[] intArray2 = list.stream().mapToInt(Integer::intValue).toArray();

        // List<Integer> -> Stream<Integer> -> Integer[]
        Integer[] integers1 = list.stream().toArray(Integer[]::new);


        String str = "OsdF ZbAd eKg";
        String[] strArray = str.split(" ");

        // String -> char[]
        char[] charArray = str.toCharArray();
        // String -> IntStream -> Stream<Character> -> List<Charater>
        List<Character> charlist = str.chars().mapToObj(i->(char)i).sorted(Collections.reverseOrder()).collect(Collectors.toList());

        // String[] -> List<String>
        List<String> strList = Arrays.asList(strArray);

        // String[] -> Stream<String>
        Stream<String> strStream = Stream.of(strArray);
        // List<String> -> Stream<String>
        Stream<String> strStream1 = strList.stream();

        // Stream<String> -> String
        String str1 = strStream.collect(Collectors.joining());

        System.out.println(str1);
    }
}