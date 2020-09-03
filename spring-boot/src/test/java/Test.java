import com.hujingli.batch.bean.Person;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huh20
 * @since
 */
public class Test {


    public static void main(String[] args) {
        Map<Person, Object> map = new ConcurrentHashMap<>();
        Person person = new Person();
        person.setFirstName("name");
        person.setLastName("my");

        map.put(person, "true");

        Person person1 = new Person();
        person1.setLastName("your");
        person1.setFirstName("name");

        map.put(person1, "true");

        person.setFirstName("hello");

        System.out.println(map.get(person));
    }
}
