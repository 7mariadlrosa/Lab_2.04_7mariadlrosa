import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonListTest {
    Person person1;
    Person person2;
    Person person3;
    Person person4;
    PersonList people;

    @BeforeEach
    void init() {
        people = new PersonList();
        person1 = new Person("María Fernández", 31, "Programmer");
        person2 = new Person("Jaime de la rosa", 32, "Cibersecurity");
        person3 = new Person("Ignacio Fernández", 23, "Bank worker");
        person4 = new Person("Laura de la Rosa", 23, "Teacher");
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);

    }

    @Test
    void findByName_nameExactlyMatches_OK() {
        assertEquals(person1, people.findByName("Laura de la Rosa"));

    }

    @Test
    void findByName_nameWithoutAccent_throwsException() {
        assertThrows(UnsupportedOperationException.class, () -> people.findByName("Laura de la Rosa"));

    }

    @Test
    void findByName_emptyList_throwsException() {
        people.removeAll();
        assertThrows(UnsupportedOperationException.class, () -> people.findByName("Laura de la Rosa"));
    }

    @Test
    void findByName_nameMultipleTimes_returnsFirst() {
        person4.setName("Laura de la Rosa");
        assertEquals(person1.getId(), people.findByName("Laura de la Rosa").getId());
    }

}