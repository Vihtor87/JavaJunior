import java.io.Serializable;

/**
 * Создайте класс Person с полями name и age.
 */
public class Person implements Serializable {

    public String name;
    public int age;

    public Person() {
        this.name = "Name";
        this.age = 21;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
