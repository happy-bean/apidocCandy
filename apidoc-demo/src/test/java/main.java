import java.util.Objects;

/**
 * @author wgt
 * @date 2018-11-22
 * @description
 **/
public class main {

    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        System.out.println("a == b:" + (a == b));

        Person p1 = new Person(8, "tom");
        Person p2 = new Person(7, "jerry");
        Person p3 = new Person(7, "jerry");
        System.out.println("p1==p2:" + (p1 == p2));
        System.out.println("p1.equals(p2):" + p1.equals(p2));
        System.out.println("p2==p3:" + (p2 == p3));
        System.out.println("p2.equals(p3):" + p2.equals(p3));
    }
}

class Person {

    private int age;

    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(age, name);
    }
}
