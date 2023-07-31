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
        // int[] -> IntStream -> Stream<Integer> -> List<Integer>   (collect 는 Stream<Integer>에만 쓸 수 있다.)
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
        // 부분 배열
        int[] subArray = Arrays.copyOfRange(intArray,2,4);
        List<Integer> subList = integerList.subList(2,4);
        List<Integer> subList1 = integerList.stream().collect(Collectors.collectingAndThen(Collectors.toList(),i->i.stream().skip(2).limit(4-2))).toList();

        String str = "OsdF ZbAd eKg";

        String[] strArray = str.split(" ");

        // String -> char[]
        char[] charArray = str.toCharArray();
        // String -> IntStream -> Stream<Character> -> List<Character>
        List<Character> charlist = str.chars().mapToObj(i->(char)i).collect(Collectors.toList());

        // String[] -> List<String>
        List<String> strList = Arrays.asList(strArray);
        //List<String> -> String[]
        String[] strArray1 = strList.toArray(new String[0]); // size 를 0으로 초기화하는 것이 속도에 유리
        String[] strArray2 = strList.toArray(String[]::new);


        // String[] -> Stream<String>
        Stream<String> strStream = Stream.of(strArray);
        Stream<String> strStream1 = Arrays.stream(strArray);

        // List<String> -> Stream<String>
        Stream<String> strStream2 = strList.stream();

        // Stream<String> -> String
        String str1 = strStream1.collect(Collectors.joining(", ","{","}"));

        //정렬
        // 시간 빠른 순서
        String strsorted = Stream.of(str.split("")).sorted().collect(Collectors.joining());
        String strsorted1 = str.chars().sorted().mapToObj(i->(char)i).map(String::valueOf).collect(Collectors.joining());
        String strsorted2 = str.chars().sorted().collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append).toString();

        // String[] 정렬
        Arrays.sort(strArray, Comparator.reverseOrder());
        String[] strings1 = Arrays.stream(strArray).sorted().toArray(String[]::new);

        //프로그래머스 test
        Solution s = new Solution();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};

        int[] strings = {2, 1, 2, 6, 2, 4, 3, 3};
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        String steee = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        System.out.println(s.solution("AAAAAA"));
    }
}