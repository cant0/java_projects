import java.util.Comparator;
import java.util.Arrays;

class Person {
    String firstName;
    String lastName;
    int age;

    Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", Wiek: " + age;
    }
}

public class PersonSorter {
    public static void main(String[] args) {
        Person[] people = {
                new Person("Jan", "Kowalski", 30),
                new Person("Anna", "Nowak", 25),
                new Person("Piotr", "Zieliński", 35)
        };

        System.out.println("Przed sortowaniem:");
        printArray(people);

        System.out.println("\nSortowanie wg imienia:");
        sort(people, Comparator.comparing(person -> person.firstName));
        printArray(people);

        System.out.println("\nSortowanie wg nazwiska:");
        sort(people, Comparator.comparing(person -> person.lastName));
        printArray(people);

        System.out.println("\nSortowanie wg wieku:");
        sort(people, Comparator.comparing(person -> person.age));
        printArray(people);
    }

    static void printArray(Person[] array) {
        for (Person person : array) {
            System.out.println(person);
        }
    }

    static void sort(Person[] array, Comparator<Person> comparator) {
        Arrays.sort(array, comparator);
    }
}
