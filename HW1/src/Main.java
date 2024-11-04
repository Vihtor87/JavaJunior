import java.util.Arrays;
import java.util.List;

public class Main {

    /**
     * Напишите программу, которая использует Stream API для обработки списка чисел.
     * Программа должна вывести на экран среднее значение всех четных чисел в списке.
     */
    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 6, 8, 9, 10);
        List<Integer> list2 = Arrays.asList(1, 3, 3, 5, 7, 9, 9, 11);

        averageInArr(list1);
        averageInArr(list2);

    }

    public static void averageInArr(List<Integer> list) {
        double res = list.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .average().orElse(0);
        System.out.println("Среднее значение всех чётных чисел: " + res);
    }
}