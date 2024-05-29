import java.util.*;
import java.time.Instant;
import java.sql.Timestamp;

/**
 * Represents a person in the social network.
 */
public class Person {
    String name;
    int age;
    List<String> hobbies;
    Timestamp timestamp;

    /**
     * Constructor for creating a Person object.
     *
     * @param name    The name of the person.
     * @param age     The age of the person.
     * @param hobbies The list of hobbies of the person.
     */
    public Person(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = new ArrayList<>(hobbies);
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    /**
     * Returns the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Compares this person's name with another person's name for sorting purposes.
     *
     * @param otherPerson The other person to compare with.
     * @return A negative integer, zero, or a positive integer as this person's name is less than, equal to, or greater
     *         than the specified person's name.
     */
    public int compareTo(Person otherPerson) {
        return this.name.compareTo(otherPerson.getName());
    }

    /**
     * Returns a string representation of the person.
     *
     * @return A string representation of the person.
     */
    @Override
    public String toString() {
        return name + " (Age: " + age + ", Hobbies: " + hobbies + ", Timestamp: " + timestamp + ")";
    }
}
