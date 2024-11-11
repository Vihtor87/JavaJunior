import java.io.*;

/**
 * Реализуйте сериализацию и десериализацию класса Person в файл.
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person person1 = new Person();
        serialObject(person1);
        Person person2 = deserialObject("Person");
        System.out.println(person2.getClass().getName());
    }

    public static void serialObject(Object obj) throws IOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream(obj.getClass().getName());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(obj);
            System.out.println("Объект сериализован");
        }
    }

    public static Person deserialObject(String str) throws IOException, ClassNotFoundException {
        try(FileInputStream fileInputStream = new FileInputStream(str)) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                System.out.println("Объект десериализован");
                return (Person)objectInputStream.readObject();
            }
        }
    }
}