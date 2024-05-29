import java.util.*;
import java.time.Instant;
import java.util.Date;
import java.sql.Timestamp;

public class Person {
    String name;
    int age;
    List<String> hobbies;
    //Date timestamp;
    Timestamp timestamp;

    public Person(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = new ArrayList<>(hobbies);
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ", Hobbies: " + hobbies + ", Timestamp: " + timestamp +")";
    }

    public String getName(){
        return this.name;
    }

    public int compareTo(Person otherPerson) {
        return this.name.compareTo(otherPerson.getName());
    }

}
