import java.util.Collections;

/**
 * Created by afischer on 13/12/2016.
 */
public class ToStringT {

    public static void main(String[] args) {

        Person[] persons = new Person[3];
        persons[0] = new Person();
        persons[1] = new Person();
        persons[2] = new Person();

        persons[0].setAge(21);
        persons[0].setFirstname("Andreas");
        persons[0].setLastname("Pries");

        persons[1].setAge(26);
        persons[1].setFirstname("Sebastian");
        persons[1].setLastname("Würkner");

        persons[2].setAge(20);
        persons[2].setFirstname("Stefan");
        persons[2].setLastname("Kiesel");

        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }

        Person.setPrintFirstnameFirst(true);

        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }

        Person.setPrintAge(true);

        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }
    }

}
