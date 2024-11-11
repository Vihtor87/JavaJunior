import java.lang.reflect.Method;

public class Main {

    /**
     * Используя Reflection API, напишите программу, которая выводит на экран все методы класса String.
     */

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");

        Method[] str = clazz.getDeclaredMethods();
        for (Method method : str) {
            System.out.println(method.getName());
        }
    }
}