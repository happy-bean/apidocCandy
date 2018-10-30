package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wgt
 * @date 2018-10-29
 * @description
 **/
public class test {

    public static void main(String[] args) {

        List<Person> persons = getPersons();

        List<Person> result = persons.parallelStream()
                .sorted(Comparator.comparing((Person p) -> p.getName()
                        ).reversed().thenComparing(Person::getAge).reversed()).collect(Collectors.toList());

        for(Person p: result) {
            System.out.println(p.getName()+" "+p.getAge());
        }

    }

    public static List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("大明", 24));
        persons.add(new Person("大明", 78));
        persons.add(new Person("二明", 23));
        persons.add(new Person("二明", 23));
        persons.add(new Person("大明", 23));
        persons.add(new Person("小明", 24));
        persons.add(new Person("小明", 23));
        return persons;
    }
}
