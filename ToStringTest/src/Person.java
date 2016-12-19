/**
 * Created by afischer on 13/12/2016.
 */

    public class Person {

        private static boolean printAge = false;
        private static boolean printFirstnameFirst = false;
        private String firstname = null;
        private String lastname = null;
        private int age = 0;

        public static boolean isPrintAge() {
            return Person.printAge;
        }

        public static void setPrintAge(boolean printAge) {
            Person.printAge = printAge;
        }

        public static boolean isPrintFirstnameFirst() {
            return Person.printFirstnameFirst;
        }

        public static void setPrintFirstnameFirst(boolean printFirstnameFirst) {
            Person.printFirstnameFirst = printFirstnameFirst;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String toString() {

            String retVal = "";
            if (Person.printFirstnameFirst) {
                retVal = this.firstname + " " + this.lastname;
            }
            else {
                retVal = this.lastname + ", " + this.firstname;
            }
            if (Person.printAge) {
                retVal += ", " + this.age + " Jahre";
            }
            return retVal;
        }
    }



