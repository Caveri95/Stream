import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List <Integer> list = new ArrayList<>();
        list.add(1);
        list.add(53);
        list.add(8);
        list.add(12);
        list.add(87);
        list.add(806);
        list.add(2);
        list.add(999);
        list.add(4);
        list.add(556);
        list.add(444);

        List <Integer> nullList = new ArrayList<>();

        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("tree");
        strings.add("four");
        strings.add("queque");
        strings.add("WRONG");
        strings.add("all");

        findMinMax(list.stream(), Integer::compareTo, (x, y) -> System.out.println("Минимальный элемент - "
                + x + ", максимальный элемент -  " + y));

        evenNumbersCount(list);
    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.sorted(order).collect(Collectors.toList());

        if (list.size() == 0) {
            minMaxConsumer.accept(null, null);

        } else {
            T minValue = list.get(0);
            T maxValue = list.get(list.size() - 1);
            minMaxConsumer.accept(minValue, maxValue);
        }
    }
    public static void evenNumbersCount(List<Integer> list) {
        System.out.println(list.stream()
                .filter(x -> x % 2 == 0)
                .count());
    }
}